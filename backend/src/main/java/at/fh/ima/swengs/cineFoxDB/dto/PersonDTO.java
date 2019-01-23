package at.fh.ima.swengs.cineFoxDB.dto;

import at.fh.ima.swengs.cineFoxDB.model.Charakter;
import at.fh.ima.swengs.cineFoxDB.model.Director;
import at.fh.ima.swengs.cineFoxDB.model.Media;

import java.util.Date;
import java.util.Set;

public class PersonDTO {

    private Long id;
    private String vorname;
    private String nachname;
    private Date dayOfBirth;
    private String beschreibung;
    private Set<Long> directors;
    //private Set<Long> charakters;
    private Set<Media> pictures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Set<Long> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Long> directors) {
        this.directors = directors;
    }

    /*public Set<Long> getCharakters() {
        return charakters;
    }

    public void setCharakters(Set<Long> charakters) {
        this.charakters = charakters;
    }
*/
    public Set<Media> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Media> pictures) {
        this.pictures = pictures;
    }
}
