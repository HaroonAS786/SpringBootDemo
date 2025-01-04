package com.edigest.myFisrtProject.controller;

import com.edigest.myFisrtProject.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntity> journalEntityMap = new HashMap<>();

    @GetMapping("/getEntries")
    public List<JournalEntity> getJournalEntries() {
        return new ArrayList<>(journalEntityMap.values());
    }

    @PostMapping("/createEntry")
    public Boolean createEntry(@RequestBody JournalEntity journalEntity) {
        journalEntityMap.put(journalEntity.getId(), journalEntity);
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntity getJournalEntryById(@PathVariable Long myId) {
        return journalEntityMap.get(myId);
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntity deleteJournalEntryById(@PathVariable Long myId) {
        return journalEntityMap.remove(myId);
    }

    @PutMapping("/id/{id}")
    public JournalEntity updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntity journalEntity) {
        return journalEntityMap.put(id, journalEntity);
    }

}
