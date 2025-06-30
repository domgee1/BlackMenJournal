package com.BMjournal.demo.repository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
    List<JournalEntry> findByDate(LocalDate date);
}
