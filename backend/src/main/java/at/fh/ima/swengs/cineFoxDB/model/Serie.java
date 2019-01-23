package at.fh.ima.swengs.cineFoxDB.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;
    private String trailer;
    private Integer anzahl;


    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Serie_has_Genre",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @ManyToOne
    private Hersteller hersteller;

    @ManyToOne
    private Kategorie kategorie;

    @OneToMany(mappedBy = "serie")
    private Set<Serien_Rating> serien_ratings;

    @OneToMany(mappedBy = "serie")
    private Set<Charakter> charakters;

    @OneToMany(mappedBy = "serie")
    private Set<Director> directors;

    // Users that have this series as favorite
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "serie_user",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> fav_users;

    @OneToMany(mappedBy = "serie")
    private Set<Review> reviews;


    @ManyToMany
    @JoinTable(name =
            "serie_media"
            ,
            joinColumns = @JoinColumn(name =
                    "serie_id"),
            inverseJoinColumns = @JoinColumn(name =
                    "media_id"))
    private Set<Media> pictures = new HashSet<>();


    @Version
    @JsonIgnore
    private long version;

    public Serie() {
    }

    public Serie(String name, String trailer, Integer anzahl, Date releaseDate) {
        this.name = name;
        this.trailer = trailer;
        this.anzahl = anzahl;
        this.releaseDate = releaseDate;
    }

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

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date release) {
        this.releaseDate = release;
    }

    public Hersteller getHersteller() {
        return hersteller;
    }

    public void setHersteller(Hersteller hersteller) {
        this.hersteller = hersteller;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }
    
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Serien_Rating> getSerien_ratings() {
        return serien_ratings;
    }

    public void setSerien_ratings(Set<Serien_Rating> serien_ratings) {
        this.serien_ratings = serien_ratings;
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

    public Set<User> getFav_users() {
        return fav_users;
    }

    public void setFav_users(Set<User> fav_users) {
        this.fav_users = fav_users;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Media> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Media> pictures) {
        this.pictures = pictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return id == serie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trailer='" + trailer + '\'' +
                ", anzahl='" + anzahl + '\'' +
                ", release='" + releaseDate + '\'' +
                ", version=" + version +
                '}';
    }
}
