package com.producedaily.productivityapp.journal.repository;

import com.producedaily.productivityapp.journal.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

    Journal findById(long journal_id);

}
