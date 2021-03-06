package at.fh.ima.swengs.cineFoxDB.dto;

import at.fh.ima.swengs.cineFoxDB.model.*;

import java.util.Date;
import java.util.Set;

public class CharakterDTO {

    private long id;
    private String name;
    private Person person;
    private long serie_id;
    private String serie_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public long getSerie_id() {
        return serie_id;
    }

    public void setSerie_id(long serie_id) {
        this.serie_id = serie_id;
    }

    public String getSerie_name() {
        return serie_name;
    }

    public void setSerie_name(String serie_name) {
        this.serie_name = serie_name;
    }
}
