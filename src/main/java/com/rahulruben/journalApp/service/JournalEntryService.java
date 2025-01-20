package com.rahulruben.journalApp.service;

import com.rahulruben.journalApp.entity.JournalEntry;
import com.rahulruben.journalApp.respository.JournalEntityRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntityRepository journalEntityRepository;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntityRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllEntries() {
        return journalEntityRepository.findAll();
    }

    public Optional<JournalEntry> getEntryById(ObjectId id) {
        return journalEntityRepository.findById(id);
    }

    public void deleteEntry(ObjectId id) {
        journalEntityRepository.deleteById(id);
    }
}
