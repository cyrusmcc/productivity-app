package com.producedaily.productivityapp.journal.service;

import com.producedaily.productivityapp.journal.model.Journal;
import com.producedaily.productivityapp.journal.model.JournalEntry;
import com.producedaily.productivityapp.journal.repository.JournalEntryRepository;
import com.producedaily.productivityapp.journal.repository.JournalRepository;
import com.producedaily.productivityapp.journal.service.JournalService;
import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private UserService userService;

    @Autowired
    JournalEntryRepository jEntryRepo;

    @Autowired
    JournalRepository journalRepository;

    @Override
    public Journal findJournal(Principal principal) {
        return userService.findByUsername(principal.getName()).getJournal();
    }

    public JournalEntry findEntryById(long id) {

        JournalEntry entry = jEntryRepo.findJournalEntryById(id);

        return entry;
    }

    @Override
    public JournalEntry findEntryByDate(Principal principal) {

        User user = userService.findByUsername(principal.getName());

        String date = user.getLocalDate();

        long journalId = user.getJournal().getId();

        Journal userJournal = journalRepository.findById(journalId);

        JournalEntry journalEntry = jEntryRepo.
               findJournalEntryByJournalAndEntryDate(userJournal, date);

        // check if entry already exists with user's date, if not create new entry
        if(journalEntry == null) {

            JournalEntry newEntry = new JournalEntry();

            newEntry.setJournal(user.getJournal());

            newEntry.setEntryDate(LocalDate.now().toString());

            jEntryRepo.save(newEntry);

            return newEntry;

        } else {
            return journalEntry;
        }
    }

    @Override
    public JournalEntry findEntryByJournalAndDate(Journal journal, String userDate) {
        JournalEntry entry =
            jEntryRepo.findJournalEntryByJournalAndEntryDate(journal, userDate);

        return entry;
    }

    @Override
    public void saveEntry(JournalEntry journalEntry) {

        jEntryRepo.save(journalEntry);

    }
}
