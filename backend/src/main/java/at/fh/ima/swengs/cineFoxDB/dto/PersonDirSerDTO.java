package at.fh.ima.swengs.cineFoxDB.dto;

import java.util.Set;

public class PersonDirSerDTO {

    private Long id;
    private Set<String> seriename;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<String> getSeriename() {
        return seriename;
    }

    public void setSeriename(Set<String> seriename) {
        this.seriename = seriename;
    }
}
