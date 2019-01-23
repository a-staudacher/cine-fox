package at.fh.ima.swengs.cineFoxDB.dto;

import at.fh.ima.swengs.cineFoxDB.model.Serie;

import java.util.Set;

public class HerstellerDTO {

    private long id;
    private String bezeichnung;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

}
