package at.fh.ima.swengs.cineFoxDB.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String vorname;
    private String nachname;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dayOfBirth;

    @OneToMany(mappedBy = "person")
    private Set<Charakter> charakters;

    @OneToMany(mappedBy = "person")
    private Set<Director> directors;

    @Version
    @JsonIgnore
    private long version;

    public Person() {
    }

    public Person(String vorname, String nachname, Date dayOfBirth) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.dayOfBirth = dayOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Set<Charakter> getCharakters() {
        return charakters;
    }

    public void setCharakters(Set<Charakter> charakters) {
        this.charakters = charakters;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        at.fh.ima.swengs.cineFoxDB.model.Person person = (at.fh.ima.swengs.cineFoxDB.model.Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", charakters=" + charakters +
                ", directors=" + directors +
                ", version=" + version +
                '}';
    }
}
