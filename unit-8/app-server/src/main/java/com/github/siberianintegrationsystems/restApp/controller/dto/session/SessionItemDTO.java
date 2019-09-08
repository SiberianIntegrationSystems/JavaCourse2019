package com.github.siberianintegrationsystems.restApp.controller.dto.session;

import com.github.siberianintegrationsystems.restApp.controller.dto.JournalItemDTO;

public class SessionItemDTO extends JournalItemDTO {

    public int result;

    public SessionItemDTO(String id, String name, int result) {
        this.id = id;
        this.name = name;
        this.result = result;
    }
}
