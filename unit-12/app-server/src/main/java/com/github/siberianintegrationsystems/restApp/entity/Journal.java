package com.github.siberianintegrationsystems.restApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Journal {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private Long defaultPageSize;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDefaultPageSize() {
        return defaultPageSize;
    }

    public void setDefaultPageSize(Long defaultPageSize) {
        this.defaultPageSize = defaultPageSize;
    }
}
