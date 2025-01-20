package com.rahulruben.journalApp.respository;

import com.rahulruben.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntityRepository extends MongoRepository<JournalEntry, ObjectId> {
}
