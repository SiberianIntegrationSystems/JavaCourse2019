package com.github.siberianintegrationsystems.restApp.controller;

import com.github.siberianintegrationsystems.restApp.controller.dto.*;
import com.github.siberianintegrationsystems.restApp.service.JournalService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/journal")
public class JournalRestController {

    private final JournalService journalService;

    public JournalRestController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("{id}")
    public JournalEntityDTO getJournalEntity(@PathVariable String id){
        return new JournalEntityDTO(journalService.getJournal(id));
    }

    @PutMapping("{id}/rows")
    public JournalResultDTO getRows(@PathVariable String id,
                                    @RequestBody JournalRequestDTO req) {
        List<? extends JournalItemDTO> collect =
                journalService.getJournalRows(id, req);

        return new JournalResultDTO(collect.size(), collect);
    }
}
