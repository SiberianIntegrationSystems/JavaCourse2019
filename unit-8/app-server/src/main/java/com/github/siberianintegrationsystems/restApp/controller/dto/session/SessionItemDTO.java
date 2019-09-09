package com.github.siberianintegrationsystems.restApp.controller.dto.session;

import com.github.siberianintegrationsystems.restApp.controller.dto.JournalItemDTO;
import java.time.LocalDateTime;

public class SessionItemDTO extends JournalItemDTO {

    public LocalDateTime insertDate;
    public int result;

    public SessionItemDTO(String id, String name, LocalDateTime insertDate, int result) {
        this.id = id;
        this.name = name;
        this.insertDate = insertDate;
        this.result = result;
    }
}
