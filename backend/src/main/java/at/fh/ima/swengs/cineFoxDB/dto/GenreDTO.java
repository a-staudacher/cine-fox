package at.fh.ima.swengs.cineFoxDB.dto;

import at.fh.ima.swengs.cineFoxDB.model.*;

import java.util.Date;
import java.util.Set;

public class GenreDTO {

    private Long id;
    private String name;
    private Set<Serie> series;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Serie> getSeries() {
        return series;
    }

    public void setSeries(Set<Serie> series) {
        this.series = series;
    }
}
