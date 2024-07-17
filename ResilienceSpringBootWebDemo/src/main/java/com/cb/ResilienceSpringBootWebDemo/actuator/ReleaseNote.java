package com.cb.ResilienceSpringBootWebDemo.actuator;

import java.time.LocalDateTime;

public class ReleaseNote {
    private String version;
    private LocalDateTime date;
    private String changeLogData;

    public ReleaseNote() {
    }

    public ReleaseNote(String version, LocalDateTime date, String changeLogData) {
        this.version = version;
        this.date = date;
        this.changeLogData = changeLogData;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getChangeLogData() {
        return changeLogData;
    }

    public void setChangeLogData(String changeLogData) {
        this.changeLogData = changeLogData;
    }
}
