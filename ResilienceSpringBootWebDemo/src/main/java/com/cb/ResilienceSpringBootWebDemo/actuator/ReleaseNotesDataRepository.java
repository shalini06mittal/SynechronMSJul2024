package com.cb.ResilienceSpringBootWebDemo.actuator;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ReleaseNotesDataRepository {
    List<ReleaseNote> releaseNoteList = new ArrayList<>();

    public ReleaseNotesDataRepository() {
        ReleaseNote r1 = new ReleaseNote("1.0", LocalDateTime.of(2023, 10, 12, 1, 10), "change Log 1");
        ReleaseNote r2 = new ReleaseNote("1.1", LocalDateTime.now(), "change Log 2");
        releaseNoteList.add(r1);
        releaseNoteList.add(r2);
    }

    public List<ReleaseNote> getReleaseNoteList() {
        return releaseNoteList;
    }

    public ReleaseNote addReleaseNote(ReleaseNote releaseNote) {
        releaseNoteList.add(releaseNote);
        return releaseNote;
    }

    public void deleteReleaseNote(String version) {
        for (int i = 0; i < releaseNoteList.size(); i++) {
            if (releaseNoteList.get(i).getVersion().equals(version)) {
                releaseNoteList.remove(releaseNoteList.get(i));
                return;
            }
        }
    }
}



