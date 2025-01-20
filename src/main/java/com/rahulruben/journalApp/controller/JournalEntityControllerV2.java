package com.rahulruben.journalApp.controller;

import com.rahulruben.journalApp.entity.JournalEntry;
import com.rahulruben.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntityControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    //
//    @GetMapping
//    public List<JournalEntry> getAll() {
//
//    }
//
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry) {
        journalEntryService.saveEntry(entry);
        return true;
    }
//
//    @GetMapping("{id}")
//    public JournalEntry getEntryById(@PathVariable String id) {
//
//    }
//
//    @DeleteMapping("{id}")
//    public boolean deleteEntryById(@PathVariable String id) {
//
//    }
//
//    @PutMapping("{id}")
//    public boolean updateEntryById(@PathVariable String id, @RequestBody JournalEntry entry) {
//
//    }
}
