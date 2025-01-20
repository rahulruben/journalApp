package com.rahulruben.journalApp.controller;

import com.rahulruben.journalApp.entity.JournalEntry;
import com.rahulruben.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntityController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAllEntries();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry) {
        entry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(entry);
        return entry;
    }

    @GetMapping("{id}")
    public JournalEntry getEntryById(@PathVariable ObjectId id) {
        return journalEntryService.getEntryById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public boolean deleteEntryById(@PathVariable ObjectId id) {
        journalEntryService.deleteEntry(id);
        return true;
    }

    @PutMapping("{id}")
    public JournalEntry updateEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry entry) {
        JournalEntry oldEntry = journalEntryService.getEntryById(id).orElse(null);
        if (oldEntry != null) {
            oldEntry.setTitle(entry.getTitle() != null && entry.getTitle() != "" ? entry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(entry.getContent() != null && entry.getContent() != "" ? entry.getContent() : oldEntry.getContent());

        }
        journalEntryService.saveEntry(oldEntry);
        return oldEntry;
    }
}
