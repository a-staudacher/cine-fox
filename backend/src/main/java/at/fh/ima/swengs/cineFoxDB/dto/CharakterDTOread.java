package at.fh.ima.swengs.cineFoxDB.dto;

import at.fh.ima.swengs.cineFoxDB.model.Person;
import at.fh.ima.swengs.cineFoxDB.model.Serie;

public class CharakterDTOread {

    private long id;
    private String name;
    private Person person;

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
}
