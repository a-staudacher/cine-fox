package at.fh.ima.swengs.cineFoxDB.dto;

import at.fh.ima.swengs.cineFoxDB.model.*;

import java.util.Date;
import java.util.Set;

public class SeriesDTO {

    private long id;
    private String name;
    private String trailer;
    private Date releaseDate;
    private Set<Genre> genres;
    private Hersteller hersteller;
    private Kategorie kategorie;
    private Set<Serien_Rating> serien_ratings;
    private Set<Charakter> charakters;
    private Set<Director> directors;
    private Set<Review> reviews;
    private Set<Media> pictures;

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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
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
}
