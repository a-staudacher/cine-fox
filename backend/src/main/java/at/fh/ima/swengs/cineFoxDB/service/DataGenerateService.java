package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("dataGenerateService")   // It has to be annotated with @Service.
public class DataGenerateService {


    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CharakterRepository charakterRepository;

    @Autowired
    private HerstellerRepository herstellerRepository;

    @Autowired
    private  DirectorRepository directorRepository;


    @PostConstruct()
    @Transactional
    public void initData() {
        if (serieRepository.count() == 0) {

            //---------Herstellers ------------
            Hersteller hersteller0 = new Hersteller();
            hersteller0.setBezeichnung("firma 1");
            herstellerRepository.save(hersteller0);

            Hersteller hersteller1 = new Hersteller();
            hersteller0.setBezeichnung("firma 2");
            herstellerRepository.save(hersteller1);

            Hersteller hersteller2 = new Hersteller();
            hersteller0.setBezeichnung("firma 3");
            herstellerRepository.save(hersteller2);

            Hersteller hersteller3 = new Hersteller();
            hersteller0.setBezeichnung("firma 4");
            herstellerRepository.save(hersteller3);

            Hersteller hersteller4 = new Hersteller();
            hersteller0.setBezeichnung("firma 5");
            herstellerRepository.save(hersteller4);

            //---------ReleaseDate ------------

            //---------ReleaseDate ------------


            //----------Kategories-----------
            //Kategorie null;



            //----------Genres-----------
            Genre genre0 = new Genre();
            genre0.setName("Anime");
            genreRepository.save(genre0);

            Genre genre1 = new Genre();
            genre1.setName("Action");
            genreRepository.save(genre1);

            Genre genre2 = new Genre();
            genre2.setName("Adventure");
            genreRepository.save(genre2);

            Genre genre3 = new Genre();
            genre3.setName("Comedy");
            genreRepository.save(genre3);

            Genre genre4 = new Genre();
            genre4.setName("Crime");
            genreRepository.save(genre4);

            Genre genre5 = new Genre();
            genre5.setName("Drama");
            genreRepository.save(genre5);

            Genre genre6 = new Genre();
            genre6.setName("Fantasy");
            genreRepository.save(genre6);

            Genre genre7 = new Genre();
            genre7.setName("Historical");
            genreRepository.save(genre7);

            Genre genre8 = new Genre();
            genre8.setName("Horror");
            genreRepository.save(genre8);

            Genre genre9 = new Genre();
            genre9.setName("Mystery");
            genreRepository.save(genre9);

            Genre genre10 = new Genre();
            genre10.setName("Romance");
            genreRepository.save(genre10);

            Genre genre11 = new Genre();
            genre11.setName("Science fiction");
            genreRepository.save(genre11);

            Genre genre12 = new Genre();
            genre12.setName("Thriller");
            genreRepository.save(genre12);

            Genre genre13 = new Genre();
            genre13.setName("Western");
            genreRepository.save(genre13);



            //----------Reviews-----------
            //Review null;

            //----------Favourites-----------


            //----------------Pictures Movies---------------

            /*Media picture1 = new Media();
            picture1.setContentType("image/jpeg");
            mediaRepository.save(picture1);

            Media picture2 = new Media();
            picture2.setContentType("image/jpeg");
            mediaRepository.save(picture2);

            Media picture3 = new Media();
            picture3.setContentType("image/jpeg");
            mediaRepository.save(picture3);

            Media picture4 = new Media();
            picture4.setContentType("image/jpeg");
            mediaRepository.save(picture4);

            Media picture5 = new Media();
            picture5.setContentType("image/jpeg");
            mediaRepository.save(picture5);

            Media picture6 = new Media();
            picture6.setContentType("image/jpeg");
            mediaRepository.save(picture6);

            Media picture7 = new Media();
            picture7.setContentType("image/jpeg");
            mediaRepository.save(picture7);

            Media picture8 = new Media();
            picture8.setContentType("image/jpeg");
            mediaRepository.save(picture8);

            Media picture9 = new Media();
            picture9.setContentType("image/jpeg");
            mediaRepository.save(picture9);

            Media picture10 = new Media();
            picture10.setContentType("image/jpeg");
            mediaRepository.save(picture10);

            Media picture11 = new Media();
            picture11.setContentType("image/jpeg");
            mediaRepository.save(picture11);

            Media picture12 = new Media();
            picture12.setContentType("image/jpeg");
            mediaRepository.save(picture12);

            Media picture13 = new Media();
            picture13.setContentType("image/jpeg");
            mediaRepository.save(picture13);

            Media picture14 = new Media();
            picture14.setContentType("image/jpeg");
            mediaRepository.save(picture14);

            Media picture15 = new Media();
            picture15.setContentType("image/jpeg");
            mediaRepository.save(picture15);

            Media picture16 = new Media();
            picture16.setContentType("image/jpeg");
            mediaRepository.save(picture16);

            Media picture17 = new Media();
            picture17.setContentType("image/jpeg");
            mediaRepository.save(picture17);

            Media picture18 = new Media();
            picture18.setContentType("image/jpeg");
            mediaRepository.save(picture18);

            Media picture19 = new Media();
            picture19.setContentType("image/jpeg");
            mediaRepository.save(picture19);

            Media picture20 = new Media();
            picture20.setContentType("image/jpeg");
            mediaRepository.save(picture20);

            Media picture21 = new Media();
            picture21.setContentType("image/jpeg");
            mediaRepository.save(picture21);

            Media picture22 = new Media();
            picture22.setContentType("image/jpeg");
            mediaRepository.save(picture22);

            Media picture23 = new Media();
            picture23.setContentType("image/jpeg");
            mediaRepository.save(picture23);

            Media picture24 = new Media();
            picture24.setContentType("image/jpeg");
            mediaRepository.save(picture24);

            Media picture25 = new Media();
            picture25.setContentType("image/jpeg");
            mediaRepository.save(picture25);

            Media picture26 = new Media();
            picture26.setContentType("image/jpeg");
            mediaRepository.save(picture26);

            Media picture27 = new Media();
            picture27.setContentType("image/jpeg");
            mediaRepository.save(picture27);

            Media picture28 = new Media();
            picture28.setContentType("image/jpeg");
            mediaRepository.save(picture28);

            Media picture29 = new Media();
            picture29.setContentType("image/jpeg");
            mediaRepository.save(picture29);

            Media picture30 = new Media();
            picture30.setContentType("image/jpeg");
            mediaRepository.save(picture30);

            Media picture31 = new Media();
            picture31.setContentType("image/jpeg");
            mediaRepository.save(picture31);

            Media picture32 = new Media();
            picture32.setContentType("image/jpeg");
            mediaRepository.save(picture32);

            Media picture33 = new Media();
            picture33.setContentType("image/jpeg");
            mediaRepository.save(picture33);

            Media picture34 = new Media();
            picture34.setContentType("image/jpeg");
            mediaRepository.save(picture34);

            Media picture35 = new Media();
            picture35.setContentType("image/jpeg");
            mediaRepository.save(picture35);

            Media picture36 = new Media();
            picture36.setContentType("image/jpeg");
            mediaRepository.save(picture36);

            Media picture37 = new Media();
            picture37.setContentType("image/jpeg");
            mediaRepository.save(picture37);

            Media picture38 = new Media();
            picture38.setContentType("image/jpeg");
            mediaRepository.save(picture38);

            Media picture39 = new Media();
            picture39.setContentType("image/jpeg");
            mediaRepository.save(picture39);

            Media picture40 = new Media();
            picture40.setContentType("image/jpeg");
            mediaRepository.save(picture40);

            Media picture41 = new Media();
            picture41.setContentType("image/jpeg");
            mediaRepository.save(picture41);

            Media picture42 = new Media();
            picture42.setContentType("image/jpeg");
            mediaRepository.save(picture42);

            Media picture43 = new Media();
            picture43.setContentType("image/jpeg");
            mediaRepository.save(picture43);

            Media picture44 = new Media();
            picture44.setContentType("image/jpeg");
            mediaRepository.save(picture44);

            Media picture45 = new Media();
            picture45.setContentType("image/jpeg");
            mediaRepository.save(picture45);

            Media picture46 = new Media();
            picture46.setContentType("image/jpeg");
            mediaRepository.save(picture46);

            Media picture47 = new Media();
            picture47.setContentType("image/jpeg");
            mediaRepository.save(picture47);

            Media picture48 = new Media();
            picture48.setContentType("image/jpeg");
            mediaRepository.save(picture48);

            Media picture49 = new Media();
            picture49.setContentType("image/jpeg");
            mediaRepository.save(picture49);

            Media picture50 = new Media();
            picture50.setContentType("image/jpeg");
            mediaRepository.save(picture50);

            Media picture51 = new Media();
            picture51.setContentType("image/jpeg");
            mediaRepository.save(picture51);

            Media picture52 = new Media();
            picture52.setContentType("image/jpeg");
            mediaRepository.save(picture52);

            Media picture53 = new Media();
            picture53.setContentType("image/jpeg");
            mediaRepository.save(picture53);

            Media picture54 = new Media();
            picture54.setContentType("image/jpeg");
            mediaRepository.save(picture54);

            Media picture55 = new Media();
            picture55.setContentType("image/jpeg");
            mediaRepository.save(picture55);

            Media picture56 = new Media();
            picture56.setContentType("image/jpeg");
            mediaRepository.save(picture56);

            Media picture57 = new Media();
            picture57.setContentType("image/jpeg");
            mediaRepository.save(picture57);

            Media picture58 = new Media();
            picture58.setContentType("image/jpeg");
            mediaRepository.save(picture58);

            Media picture59 = new Media();
            picture9.setContentType("image/jpeg");
            mediaRepository.save(picture59);

            Media picture60 = new Media();
            picture60.setContentType("image/jpeg");
            mediaRepository.save(picture60);




            //----------------Movies/Filme---------------

            /*Serie movie1 = new Serie();
            movie1.setName("Tarzan the Ape Man");
            Set<Media> picForMovie1 = new HashSet<Media>();
            Set<Genre> genreForMovie1 = new HashSet<Genre>();
            picForMovie1.add(picture1);
            genreForMovie1.add(genre1);
            genreForMovie1.add(genre10);
            movie1.setPictures(picForMovie1);
            movie1.setHersteller(null);
            movie1.setReleaseDate(new Date());
            movie1.setKategorie(null);
            movie1.setGenres(genreForMovie1);
            movie1.setReviews(null);
            movie1.setFav_users(null);
            movie1.setTrailer("undefined");
            serieRepository.save(movie1);


            Serie movie2 = new Serie();
            movie2.setName("Attack of the 50 ft. Woman");
            Set<Media> picForMovie2 = new HashSet<Media>();
            Set<Genre> genreForMovie2 = new HashSet<Genre>();
            picForMovie2.add(picture2);
            genreForMovie1.add(genre8);
            genreForMovie1.add(genre11);
            movie2.setPictures(picForMovie2);
            movie2.setHersteller(null);
            movie2.setReleaseDate(new Date());
            movie2.setKategorie(null);
            movie2.setGenres(genreForMovie2);
            movie2.setReviews(null);
            movie2.setFav_users(null);
            movie2.setTrailer("undefined");
            serieRepository.save(movie2);


            Serie movie3 = new Serie();
            movie3.setName("Betrayed Woman");
            Set<Media> picForMovie3 = new HashSet<Media>();
            Set<Genre> genreForMovie3 = new HashSet<Genre>();
            picForMovie1.add(picture3);
            genreForMovie1.add(genre5);
            genreForMovie1.add(genre9);
            movie3.setPictures(pciF);
            movie3.setHersteller(null);
            movie3.setReleaseDate(new Date());
            movie3.setKategorie(null);
            movie3.setGenres(genre5,genre9);
            movie3.setReviews(null);
            movie3.setFav_users(null);
            movie3.setTrailer("undefined");
            serieRepository.save(movie3);


            Serie movie4 = new Serie();
            movie4.setName("Carmen");
            movie4.setPictures(picture4);
            movie4.setHersteller(null);
            movie4.setReleaseDate(new Date());
            movie4.setKategorie(null);
            movie4.setGenres(genre10);
            movie4.setReviews(null);
            movie4.setFav_users(null);
            movie4.setTrailer("undefined");
            serieRepository.save(movie4);


            Serie movie5 = new Serie();
            movie5.setName("The Circus Girl");
            movie5.setPictures(picture5);
            movie5.setHersteller(null);
            movie5.setReleaseDate(new Date());
            movie5.setKategorie(null);
            movie5.setGenres(genre5,genre10);
            movie5.setReviews(null);
            movie5.setFav_users(null);
            movie5.setTrailer("undefined");
            serieRepository.save(movie5);


            Serie movie6 = new Serie();
            movie6.setName("The Clubs Baby");
            movie6.setPictures(picture6);
            movie6.setHersteller(null);
            movie6.setReleaseDate(new Date());
            movie6.setKategorie(null);
            movie6.setGenres(genre8,genre5);
            movie6.setReviews(null);
            movie6.setFav_users(null);
            movie6.setTrailer("undefined");
            serieRepository.save(movie6);


            Serie movie7 = new Serie();
            movie7.setName("The Cocaine Friends");
            movie7.setPictures(picture7);
            movie7.setHersteller(null);
            movie7.setReleaseDate(new Date());
            movie7.setKategorie(null);
            movie7.setGenres(genre4,genre9);
            movie7.setReviews(null);
            movie7.setFav_users(null);
            movie7.setTrailer("undefined");
            serieRepository.save(movie7);


            Serie movie8 = new Serie();
            movie8.setName("An Arizona Cowboy 1");
            movie8.setPictures(picture8);
            movie8.setHersteller(null);
            movie8.setReleaseDate(new Date());
            movie8.setKategorie(null);
            movie8.setGenres(genre12);
            movie8.setReviews(null);
            movie8.setFav_users(null);
            movie8.setTrailer("undefined");
            serieRepository.save(movie8);


            Serie movie9 = new Serie();
            movie9.setName("An Arizona Cowboy 2");
            movie9.setPictures(picture9);
            movie9.setHersteller(null);
            movie9.setReleaseDate(new Date());
            movie9.setKategorie(null);
            movie9.setGenres(genre12);
            movie9.setReviews(null);
            movie9.setFav_users(null);
            movie9.setTrailer("undefined");
            serieRepository.save(movie9);


            Serie movie10 = new Serie();
            movie10.setName("An Arizona Cowboy 3");
            movie10.setPictures(picture10);
            movie10.setHersteller(null);
            movie10.setReleaseDate(new Date());
            movie10.setKategorie(null);
            movie10.setGenres(genre12);
            movie10.setReviews(null);
            movie10.setFav_users(null);
            movie10.setTrailer("undefined");
            serieRepository.save(movie10);


            Serie movie11 = new Serie();
            movie11.setName("Creature from the Black Lagoon");
            movie11.setPictures(picture11);
            movie11.setHersteller(null);
            movie11.setReleaseDate(new Date());
            movie11.setKategorie(null);
            movie11.setGenres(genre8);
            movie11.setReviews(null);
            movie11.setFav_users(null);
            movie11.setTrailer("undefined");
            serieRepository.save(movie11);


            Serie movie12 = new Serie();
            movie12.setName("Terror from Outer Space!");
            movie12.setPictures(picture12);
            movie12.setHersteller(null);
            movie12.setReleaseDate(new Date());
            movie12.setKategorie(null);
            movie12.setGenres(genre11);
            movie12.setReviews(null);
            movie12.setFav_users(null);
            movie12.setTrailer("undefined");
            serieRepository.save(movie12);


            Serie movie13 = new Serie();
            movie13.setName("Deep Waters");
            movie13.setPictures(picture13);
            movie13.setHersteller(null);
            movie13.setReleaseDate(new Date());
            movie13.setKategorie(null);
            movie13.setGenres(genre10);
            movie13.setReviews(null);
            movie13.setFav_users(null);
            movie13.setTrailer("undefined");
            serieRepository.save(movie13);


            Serie movie14 = new Serie();
            movie14.setName("Destination Moon");
            movie14.setPictures(picture14);
            movie14.setHersteller(null);
            movie14.setReleaseDate(new Date());
            movie14.setKategorie(null);
            movie14.setGenres(genre11);
            movie14.setReviews(null);
            movie14.setFav_users(null);
            movie14.setTrailer("undefined");
            serieRepository.save(movie14);


            Serie movie15 = new Serie();
            movie15.setName("Dinosaurus!");
            movie15.setPictures(picture15);
            movie15.setHersteller(null);
            movie15.setReleaseDate(new Date());
            movie15.setKategorie(null);
            movie15.setGenres(genre11);
            movie15.setReviews(null);
            movie15.setFav_users(null);
            movie15.setTrailer("undefined");
            serieRepository.save(movie15);


            Serie movie16 = new Serie();
            movie16.setName("Dracula");
            movie16.setPictures(picture16);
            movie16.setHersteller(null);
            movie16.setReleaseDate(new Date());
            movie16.setKategorie(null);
            movie16.setGenres(genre8,genre9);
            movie16.setReviews(null);
            movie16.setFav_users(null);
            movie16.setTrailer("undefined");
            serieRepository.save(movie16);


            Serie movie17 = new Serie();
            movie17.setName("Dr. Cyclops");
            movie17.setPictures(picture17);
            movie17.setHersteller(null);
            movie17.setReleaseDate(new Date());
            movie17.setKategorie(null);
            movie17.setGenres(genre8,genre9);
            movie17.setReviews(null);
            movie17.setFav_users(null);
            movie17.setTrailer("undefined");
            serieRepository.save(movie17);


            Serie movie18 = new Serie();
            movie18.setName("Dynamite");
            movie18.setPictures(picture18);
            movie18.setHersteller(null);
            movie18.setReleaseDate(new Date());
            movie18.setKategorie(null);
            movie18.setGenres(genre5,genre10);
            movie18.setReviews(null);
            movie18.setFav_users(null);
            movie18.setTrailer("undefined");
            serieRepository.save(movie18);


            Serie movie19 = new Serie();
            movie19.setName("Fallen Angel");
            movie19.setPictures(picture19);
            movie19.setHersteller(null);
            movie19.setReleaseDate(new Date());
            movie19.setKategorie(null);
            movie19.setGenres(genre4,genre10);
            movie19.setReviews(null);
            movie19.setFav_users(null);
            movie19.setTrailer("undefined");
            serieRepository.save(movie19);


            Serie movie20 = new Serie();
            movie20.setName("Flying Down to Rio");
            movie20.setPictures(picture20);
            movie20.setHersteller(null);
            movie20.setReleaseDate(new Date());
            movie20.setKategorie(null);
            movie20.setGenres(genre3);
            movie20.setReviews(null);
            movie20.setFav_users(null);
            movie20.setTrailer("undefined");
            serieRepository.save(movie20);


            Serie movie21 = new Serie();
            movie21.setName("Frankenstein");
            movie21.setPictures(picture21);
            movie21.setHersteller(null);
            movie21.setReleaseDate(new Date());
            movie21.setKategorie(null);
            movie21.setGenres(genre8);
            movie21.setReviews(null);
            movie21.setFav_users(null);
            movie21.setTrailer("undefined");
            serieRepository.save(movie21);


            Serie movie22 = new Serie();
            movie22.setName("Ghost Riders of the West");
            movie22.setPictures(picture22);
            movie22.setHersteller(null);
            movie22.setReleaseDate(new Date());
            movie22.setKategorie(null);
            movie22.setGenres(genre13);
            movie22.setReviews(null);
            movie22.setFav_users(null);
            movie22.setTrailer("undefined");
            serieRepository.save(movie22);


            Serie movie23 = new Serie();
            movie23.setName("Girls in the Night");
            movie23.setPictures(picture23);
            movie23.setHersteller(null);
            movie23.setReleaseDate(new Date());
            movie23.setKategorie(null);
            movie23.setGenres(genre4,genre10);
            movie23.setReviews(null);
            movie23.setFav_users(null);
            movie23.setTrailer("undefined");
            serieRepository.save(movie23);


            Serie movie24 = new Serie();
            movie24.setName("Gun Crazy");
            movie24.setPictures(picture24);
            movie24.setHersteller(null);
            movie24.setReleaseDate(new Date());
            movie24.setKategorie(null);
            movie24.setGenres(genre4,genre1);
            movie24.setReviews(null);
            movie24.setFav_users(null);
            movie24.setTrailer("undefined");
            serieRepository.save(movie24);


            Serie movie25 = new Serie();
            movie25.setName("Horros of the Orient");
            movie25.setPictures(picture25);
            movie25.setHersteller(null);
            movie25.setReleaseDate(new Date());
            movie25.setKategorie(null);
            movie25.setGenres(genre4);
            movie25.setReviews(null);
            movie25.setFav_users(null);
            movie25.setTrailer("undefined");
            serieRepository.save(movie25);


            Serie movie26 = new Serie();
            movie26.setName("Hot Rod Gang");
            movie26.setPictures(picture26);
            movie26.setHersteller(null);
            movie26.setReleaseDate(new Date());
            movie26.setKategorie(null);
            movie26.setGenres(genre1,genre10);
            movie26.setReviews(null);
            movie26.setFav_users(null);
            movie26.setTrailer("undefined");
            serieRepository.save(movie26);


            Serie movie27 = new Serie();
            movie27.setName("Invasion of the Saucer-Men");
            movie27.setPictures(picture27);
            movie27.setHersteller(null);
            movie27.setReleaseDate(new Date());
            movie27.setKategorie(null);
            movie27.setGenres(genre11,genre8);
            movie27.setReviews(null);
            movie27.setFav_users(null);
            movie27.setTrailer("undefined");
            serieRepository.save(movie27);


            Serie movie28 = new Serie();
            movie28.setName("The Last Command");
            movie28.setPictures(picture28);
            movie28.setHersteller(null);
            movie28.setReleaseDate(new Date());
            movie28.setKategorie(null);
            movie28.setGenres(genre7);
            movie28.setReviews(null);
            movie28.setFav_users(null);
            movie28.setTrailer("undefined");
            serieRepository.save(movie28);


            Serie movie29 = new Serie();
            movie29.setName("Kellar");
            movie29.setPictures(picture29);
            movie29.setHersteller(null);
            movie29.setReleaseDate(new Date());
            movie29.setKategorie(null);
            movie29.setGenres(genre5,genre2);
            movie29.setReviews(null);
            movie29.setFav_users(null);
            movie29.setTrailer("undefined");
            serieRepository.save(movie29);


            Serie movie30 = new Serie();
            movie30.setName("Heart of the Klondike 1");
            movie30.setPictures(picture30);
            movie30.setHersteller(null);
            movie30.setReleaseDate(new Date());
            movie30.setKategorie(null);
            movie30.setGenres(genre13);
            movie30.setReviews(null);
            movie30.setFav_users(null);
            movie30.setTrailer("undefined");
            serieRepository.save(movie30);


            Serie movie31 = new Serie();
            movie31.setName("Heart of the Klondike 2");
            movie31.setPictures(picture31);
            movie31.setHersteller(null);
            movie31.setReleaseDate(new Date());
            movie31.setKategorie(null);
            movie31.setGenres(genre13);
            movie31.setReviews(null);
            movie31.setFav_users(null);
            movie31.setTrailer("undefined");
            serieRepository.save(movie31);


            Serie movie32 = new Serie();
            movie32.setName("La Dolce Vita");
            movie32.setPictures(picture32);
            movie32.setHersteller(null);
            movie32.setReleaseDate(new Date());
            movie32.setKategorie(null);
            movie32.setGenres(genre9,genre10);
            movie32.setReviews(null);
            movie32.setFav_users(null);
            movie32.setTrailer("undefined");
            serieRepository.save(movie32);


            Serie movie33 = new Serie();
            movie33.setName("Mission Spatiale");
            movie33.setPictures(picture33);
            movie33.setHersteller(null);
            movie33.setReleaseDate(new Date());
            movie33.setKategorie(null);
            movie33.setGenres(genre6);
            movie33.setReviews(null);
            movie33.setFav_users(null);
            movie33.setTrailer("undefined");
            serieRepository.save(movie33);


            Serie movie34 = new Serie();
            movie34.setName("The Lost Trail");
            movie34.setPictures(picture34);
            movie34.setHersteller(null);
            movie34.setReleaseDate(new Date());
            movie34.setKategorie(null);
            movie34.setGenres(genre13,genre2);
            movie34.setReviews(null);
            movie34.setFav_users(null);
            movie34.setTrailer("undefined");
            serieRepository.save(movie34);


            Serie movie35 = new Serie();
            movie35.setName("The Man Who Could");
            movie35.setPictures(picture35);
            movie35.setHersteller(null);
            movie35.setReleaseDate(new Date());
            movie35.setKategorie(null);
            movie35.setGenres(genre8);
            movie35.setReviews(null);
            movie35.setFav_users(null);
            movie35.setTrailer("undefined");
            serieRepository.save(movie35);


            Serie movie36 = new Serie();
            movie36.setName("The Man with the X-Ray Eyes");
            movie36.setPictures(picture36);
            movie36.setHersteller(null);
            movie36.setReleaseDate(new Date());
            movie36.setKategorie(null);
            movie36.setGenres(genre9);
            movie36.setReviews(null);
            movie36.setFav_users(null);
            movie36.setTrailer("undefined");
            serieRepository.save(movie36);


            Serie movie37 = new Serie();
            movie37.setName("Uhyret");
            movie37.setPictures(picture37);
            movie37.setHersteller(null);
            movie37.setReleaseDate(new Date());
            movie37.setKategorie(null);
            movie37.setGenres(genre8,genre6);
            movie37.setReviews(null);
            movie37.setFav_users(null);
            movie37.setTrailer("undefined");
            serieRepository.save(movie37);


            Serie movie38 = new Serie();
            movie38.setName("Missile Mosnters");
            movie38.setPictures(picture38);
            movie38.setHersteller(null);
            movie38.setReleaseDate(new Date());
            movie38.setKategorie(null);
            movie38.setGenres(genre6,genre11);
            movie38.setReviews(null);
            movie38.setFav_users(null);
            movie38.setTrailer("undefined");
            serieRepository.save(movie38);

            Serie movie39 = new Serie();
            movie39.setName("Money, Woman and Guns");
            movie39.setPictures(picture39);
            movie39.setHersteller(null);
            movie39.setReleaseDate(new Date());
            movie39.setKategorie(null);
            movie39.setGenres(genre13,genre2);
            movie39.setReviews(null);
            movie39.setFav_users(null);
            movie39.setTrailer("undefined");
            serieRepository.save(movie39);

            Serie movie40 = new Serie();
            movie40.setName("The Awakening");
            movie40.setPictures(picture40);
            movie40.setHersteller(null);
            movie40.setReleaseDate(new Date());
            movie40.setKategorie(null);
            movie40.setGenres(genre8);
            movie40.setReviews(null);
            movie40.setFav_users(null);
            movie40.setTrailer("undefined");
            serieRepository.save(movie40);


            Serie movie41 = new Serie();
            movie41.setName("Mutiny in Outer Space");
            movie41.setPictures(picture41);
            movie41.setHersteller(null);
            movie41.setReleaseDate(new Date());
            movie41.setKategorie(null);
            movie41.setGenres(genre6,genre11);
            movie41.setReviews(null);
            movie41.setFav_users(null);
            movie41.setTrailer("undefined");
            serieRepository.save(movie41);


            Serie movie42 = new Serie();
            movie42.setName("Plan 9 from Outer Space");
            movie42.setPictures(picture42);
            movie42.setHersteller(null);
            movie42.setReleaseDate(new Date());
            movie42.setKategorie(null);
            movie42.setGenres(genre11);
            movie42.setReviews(null);
            movie42.setFav_users(null);
            movie42.setTrailer("undefined");
            serieRepository.save(movie42);


            Serie movie43 = new Serie();
            movie43.setName("Reefer Madness");
            movie43.setPictures(picture43);
            movie43.setHersteller(null);
            movie43.setReleaseDate(new Date());
            movie43.setKategorie(null);
            movie43.setGenres(genre10);
            movie43.setReviews(null);
            movie43.setFav_users(null);
            movie43.setTrailer("undefined");
            serieRepository.save(movie43);


            Serie movie44 = new Serie();
            movie44.setName("Robot Monster");
            movie44.setPictures(picture44);
            movie44.setHersteller(null);
            movie44.setReleaseDate(new Date());
            movie44.setKategorie(null);
            movie44.setGenres(genre1,genre8);
            movie44.setReviews(null);
            movie44.setFav_users(null);
            movie44.setTrailer("undefined");
            serieRepository.save(movie44);


            Serie movie45 = new Serie();
            movie45.setName("Santo vs Marcianos");
            movie45.setPictures(picture45);
            movie45.setHersteller(null);
            movie45.setReleaseDate(new Date());
            movie45.setKategorie(null);
            movie45.setGenres(genre1,genre11);
            movie45.setReviews(null);
            movie45.setFav_users(null);
            movie45.setTrailer("undefined");
            serieRepository.save(movie45);

            Serie movie46 = new Serie();
            movie46.setName("Saturday Night");
            Set<Media> movie46Media = new HashSet<>();
            Set<Genre> movie46Genre = new HashSet<>();
            movie46Media.add(picture64);
            movie46Genre.add(genre9);
            movie46Genre.add(genre10);
            movie46.setPictures(movie46Media);
            movie46.setHersteller(null);
            movie46.setReleaseDate(new Date());
            movie46.setKategorie(null);
            movie46.setGenres(movie46Genre);
            movie46.setReviews(null);
            movie46.setFav_users(null);
            movie46.setTrailer("undefined");
            serieRepository.save(movie46);


            Serie movie47 = new Serie();
            movie47.setName("Sheriffs Reward");
            movie47.setPictures(picture47);
            movie47.setHersteller(null);
            movie47.setReleaseDate(new Date());
            movie47.setKategorie(null);
            movie47.setGenres(genre13);
            movie47.setReviews(null);
            movie47.setFav_users(null);
            movie47.setTrailer("undefined");
            serieRepository.save(movie47);


            Serie movie48 = new Serie();
            movie48.setName("She-Wolf of London");
            movie48.setPictures(picture48);
            movie48.setHersteller(null);
            movie48.setReleaseDate(new Date());
            movie48.setKategorie(null);
            movie48.setGenres(genre8);
            movie48.setReviews(null);
            movie48.setFav_users(null);
            movie48.setTrailer("undefined");
            serieRepository.save(movie48);


            Serie movie49 = new Serie();
            movie49.setName("Straight Shooter");
            movie49.setPictures(picture49);
            movie49.setHersteller(null);
            movie49.setReleaseDate(new Date());
            movie49.setKategorie(null);
            movie49.setGenres(genre13);
            movie49.setReviews(null);
            movie49.setFav_users(null);
            movie49.setTrailer("undefined");
            serieRepository.save(movie49);


            Serie movie50 = new Serie();
            movie50.setName("Tarantula!");
            movie50.setPictures(picture50);
            movie50.setHersteller(null);
            movie50.setReleaseDate(new Date());
            movie50.setKategorie(null);
            movie50.setGenres(genre8,genre11);
            movie50.setReviews(null);
            movie50.setFav_users(null);
            movie50.setTrailer("undefined");
            serieRepository.save(movie50);


            Serie movie51 = new Serie();
            movie51.setName("Tarzan goes to India");
            movie51.setPictures(picture51);
            movie51.setHersteller(null);
            movie51.setReleaseDate(new Date());
            movie51.setKategorie(null);
            movie51.setGenres(genre1,genre10);
            movie51.setReviews(null);
            movie51.setFav_users(null);
            movie51.setTrailer("undefined");
            serieRepository.save(movie51);


            Serie movie52 = new Serie();
            movie52.setName("Terror from the Year 5000");
            movie52.setPictures(picture52);
            movie52.setHersteller(null);
            movie52.setReleaseDate(new Date());
            movie52.setKategorie(null);
            movie52.setGenres(genre1,genre11);
            movie52.setReviews(null);
            movie52.setFav_users(null);
            movie52.setTrailer("undefined");
            serieRepository.save(movie52);


            Serie movie53 = new Serie();
            movie53.setName("The Real Thing in Cowboys");
            movie53.setPictures(picture53);
            movie53.setHersteller(null);
            movie53.setReleaseDate(new Date());
            movie53.setKategorie(null);
            movie53.setGenres(genre13);
            movie53.setReviews(null);
            movie53.setFav_users(null);
            movie53.setTrailer("undefined");
            serieRepository.save(movie53);


            Serie movie54 = new Serie();
            movie54.setName("Trojan Incident");
            movie54.setPictures(picture54);
            movie54.setHersteller(null);
            movie54.setReleaseDate(new Date());
            movie54.setKategorie(null);
            movie54.setGenres(genre7,genre2);
            movie54.setReviews(null);
            movie54.setFav_users(null);
            movie54.setTrailer("undefined");
            serieRepository.save(movie54);


            Serie movie55 = new Serie();
            movie55.setName("Troupe");
            movie55.setPictures(picture55);
            movie55.setHersteller(null);
            movie55.setReleaseDate(new Date());
            movie55.setKategorie(null);
            movie55.setGenres(genre7,genre5);
            movie55.setReviews(null);
            movie55.setFav_users(null);
            movie55.setTrailer("undefined");
            serieRepository.save(movie55);


            Serie movie56 = new Serie();
            movie56.setName("Viva Las Vegas");
            movie56.setPictures(picture56);
            movie56.setHersteller(null);
            movie56.setReleaseDate(new Date());
            movie56.setKategorie(null);
            movie56.setGenres(genre5,genre10);
            movie56.setReviews(null);
            movie56.setFav_users(null);
            movie56.setTrailer("undefined");
            serieRepository.save(movie56);


            Serie movie57 = new Serie();
            movie57.setName("5th Regiment Armory");
            movie57.setPictures(picture57);
            movie57.setHersteller(null);
            movie57.setReleaseDate(new Date());
            movie57.setKategorie(null);
            movie57.setGenres(genre7);
            movie57.setReviews(null);
            movie57.setFav_users(null);
            movie57.setTrailer("undefined");
            serieRepository.save(movie57);


            Serie movie58 = new Serie();
            movie58.setName("When Worlds Collide");
            movie58.setPictures(picture58);
            movie58.setHersteller(null);
            movie58.setReleaseDate(new Date());
            movie58.setKategorie(null);
            movie58.setGenres(genre1,genre11);
            movie58.setReviews(null);
            movie58.setFav_users(null);
            movie58.setTrailer("undefined");
            serieRepository.save(movie58);


            Serie movie59 = new Serie();
            movie59.setName("I walked with a Zombie");
            movie59.setPictures(picture59);
            movie59.setHersteller(null);
            movie59.setReleaseDate(new Date());
            movie59.setKategorie(null);
            movie59.setGenres(genre8,genre10);
            movie59.setReviews(null);
            movie59.setFav_users(null);
            movie59.setTrailer("undefined");
            serieRepository.save(movie59);


            Serie movie60 = new Serie();
            movie60.setName("Zombies ot the Stratosphere");
            movie60.setPictures(picture60);
            movie60.setHersteller(null);
            movie60.setReleaseDate(new Date());
            movie60.setKategorie(null);
            movie60.setGenres(genre12,genre11);
            movie60.setReviews(null);
            movie60.setFav_users(null);
            movie60.setTrailer("undefined");
            serieRepository.save(movie60);*/


//---------Charakters ------------

            Charakter char0 = new Charakter();
            char0.setName("Biggus Dickus");
            char0.setPerson(null);
            char0.setSerie(null);
            charakterRepository.save(char0);

            Charakter char1 = new Charakter();
            char1.setName("Aragorn");
            char1.setPerson(null);
            char1.setSerie(null);
            charakterRepository.save(char1);

            Charakter char2 = new Charakter();
            char2.setName("Deine Mutter");
            char2.setPerson(null);
            char2.setSerie(null);
            charakterRepository.save(char2);

            Charakter char3 = new Charakter();
            char3.setName("Son Goku");
            char3.setPerson(null);
            char3.setSerie(null);
            charakterRepository.save(char3);

            Charakter char4 = new Charakter();
            char4.setName("Darth Vaders behinderter kleiner Bruder");
            char4.setPerson(null);
            char4.setSerie(null);
            charakterRepository.save(char4);



            //---------Person ------------

            Person pers0 = new Person();
            pers0.setVorname("Martin");
            pers0.setNachname("Hutter");
            pers0.setDayOfBirth(new Date());
            pers0.setBeschreibung("Toller Schauspieler");
            Set<Charakter> charForPers0 = new HashSet<>();
            charForPers0.add(char4);
            pers0.setDirectors(null);
            char4.setPerson(pers0);
            personRepository.save(pers0);

            Person pers1 = new Person();
            pers1.setVorname("Andreas");
            pers1.setNachname("Staudacher");
            pers1.setDayOfBirth(new Date());
            pers1.setBeschreibung("Oscar-würdig");
            Set<Charakter> charForPers1 = new HashSet<>();
            charForPers1.add(char3);
            charForPers1.add(null);
            pers1.setDirectors(null);
            personRepository.save(pers1);

            Person pers2 = new Person();
            pers2.setVorname("Georg");
            pers2.setNachname("Schmitzer");
            pers2.setDayOfBirth(new Date());
            pers2.setBeschreibung("Bester Drama-Darsteller");
            Set<Charakter> charForPers2 = new HashSet<>();
            charForPers2.add(char2);
            charForPers2.add(null);
            pers2.setDirectors(null);
            personRepository.save(pers2);

            Person pers3 = new Person();
            pers3.setVorname("Florian");
            pers3.setNachname("Gartner");
            pers3.setDayOfBirth(new Date());
            pers3.setBeschreibung("Leider komplett abgewrackt");
            Set<Charakter> charForPers3 = new HashSet<>();
            charForPers3.add(char1);
            pers3.setDirectors(null);
            personRepository.save(pers3);

            Person pers4 = new Person();
            pers4.setVorname("Miriam");
            pers4.setNachname("Grainer");
            pers4.setDayOfBirth(new Date());
            pers4.setBeschreibung("Absolut super");
            Set<Charakter> charForPers4 = new HashSet<>();
            charForPers4.add(char0);
            pers4.setDirectors(null);
            personRepository.save(pers4);

        //---------Directors ------------

            Director dir0 = new Director();
            dir0.setPerson(null);
            dir0.setSerie(null);
            directorRepository.save(dir0);

            Director dir1 = new Director();
            dir1.setPerson(pers1);
            dir1.setSerie(null);
            directorRepository.save(dir1);

            Director dir2 = new Director();
            dir2.setPerson(null);
            dir2.setSerie(null);
            directorRepository.save(dir2);

            Director dir3 = new Director();
            dir3.setPerson(null);
            dir3.setSerie(null);
            directorRepository.save(dir3);

            Director dir4 = new Director();
            dir4.setPerson(null);
            dir4.setSerie(null);
            directorRepository.save(dir4);


        }

    }

}
