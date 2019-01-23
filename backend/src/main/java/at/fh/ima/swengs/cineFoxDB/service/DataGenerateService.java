package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.*;
import at.fh.ima.swengs.cineFoxDB.model.User;
import at.fh.ima.swengs.cineFoxDB.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

@Service("dataGenerateService")   // It has to be annotated with @Service.
public class DataGenerateService {


    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private KategorieRepository kategorieRepository;

    @Autowired
    private HerstellerRepository herstellerRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CharakterRepository charakterRepository;

    @Autowired
    private  DirectorRepository directorRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private Serien_RatingRepository serien_ratingRepository;

    @PostConstruct()
    @Transactional
    public void initData() {
        if (serieRepository.count() == 0) {
            //---------User
            User usr_andreas = new User();
            usr_andreas.setUsername("Andreas");
            usr_andreas.setPassword(encoder.encode("12345"));
            usr_andreas.setAdmin(true);
            User usr_andreas_m = userRepository.save(usr_andreas);

            Media med_andreas = new Media();
            med_andreas.setUser(usr_andreas);
            med_andreas.setContentType("image/jpeg");
            med_andreas.setOriginalFileName("andreas_schokoSeite.jpeg");
            med_andreas.setSavedAt(med_andreas.getOriginalFileName());
            med_andreas.setSize((long)100000);
            mediaRepository.save(med_andreas);

            User usr_georg = new User();
            usr_georg.setUsername("Georg");
            usr_georg.setPassword(encoder.encode("12345"));
            usr_georg.setAdmin(false);
            userRepository.save(usr_georg);

            Media med_georg = new Media();
            med_georg.setUser(usr_georg);
            med_georg.setContentType("image/jpeg");
            med_georg.setOriginalFileName("georg_marzipanSeite.jpeg");
            med_georg.setSavedAt(med_georg.getOriginalFileName());
            med_georg.setSize((long)100000);
            mediaRepository.save(med_georg);

            User usr_martin = new User();
            usr_martin.setUsername("Martin");
            usr_martin.setPassword(encoder.encode("12345"));
            usr_martin.setAdmin(false);
            userRepository.save(usr_martin);

            Media med_martin = new Media();
            med_martin.setUser(usr_martin);
            med_martin.setContentType("image/jpeg");
            med_martin.setOriginalFileName("martin_vanilleSeite.jpeg");
            med_martin.setSavedAt(med_martin.getOriginalFileName());
            med_martin.setSize((long)100000);
            mediaRepository.save(med_martin);

            User usr_florian = new User();
            usr_florian.setUsername("Florian");
            usr_florian.setPassword(encoder.encode("12345"));
            usr_florian.setAdmin(false);
            userRepository.save(usr_florian);

            Media med_florian = new Media();
            med_florian.setUser(usr_florian);
            med_florian.setContentType("image/jpeg");
            med_florian.setOriginalFileName("florian_lakrizSeite.jpeg");
            med_florian.setSavedAt(med_florian.getOriginalFileName());
            med_florian.setSize((long)100000);
            mediaRepository.save(med_florian);

            //---------Herstellers ------------
            Hersteller her_cuyahoga;
            her_cuyahoga = new Hersteller();
            her_cuyahoga.setBezeichnung("Cuyahoga Country Association");
            herstellerRepository.save(her_cuyahoga);

            Hersteller her_jacob;
            her_jacob = new Hersteller();
            her_jacob.setBezeichnung("Jacob Litt");
            herstellerRepository.save(her_jacob);

            Hersteller her_bernhard;
            her_bernhard = new Hersteller();
            her_bernhard.setBezeichnung("Bernhard Woolder");
            herstellerRepository.save(her_bernhard);

            Hersteller her_alliedArtist;
            her_alliedArtist = new Hersteller();
            her_alliedArtist.setBezeichnung("Allied Artists");
            herstellerRepository.save(her_alliedArtist);

            Hersteller her_charles;
            her_charles = new Hersteller();
            her_charles.setBezeichnung("Charles Frohman's Production");
            herstellerRepository.save(her_charles);

            Hersteller her_20century;
            her_20century = new Hersteller();
            her_20century.setBezeichnung("20th Century-Fox");
            herstellerRepository.save(her_20century);

            Hersteller her_george;
            her_george = new Hersteller();
            her_george.setBezeichnung("George Pal");
            herstellerRepository.save(her_george);

            Hersteller her_cinema;
            her_cinema = new Hersteller();
            her_cinema.setBezeichnung("Cinema Scope");
            herstellerRepository.save(her_cinema);

            Hersteller her_gartner;
            her_gartner = new Hersteller();
            her_gartner.setBezeichnung("Gardener's Nightmares");
            herstellerRepository.save(her_gartner);

            Hersteller her_georg;
            her_georg = new Hersteller();
            her_georg.setBezeichnung("The Horrors of Georg");
            herstellerRepository.save(her_georg);

            Hersteller her_martin;
            her_martin = new Hersteller();
            her_martin.setBezeichnung("Martin's innocent Dreams");
            herstellerRepository.save(her_martin);

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


            //----------Kategories-----------
            Kategorie kat_movie;
            kat_movie = new Kategorie();
            kat_movie.setBezeichnung("Movie");
            kategorieRepository.save(kat_movie);

            Kategorie kat_series;
            kat_series = new Kategorie();
            kat_series.setBezeichnung("Series");
            kategorieRepository.save(kat_series);

            Kategorie kat_anime;
            kat_anime = new Kategorie();
            kat_anime.setBezeichnung("Anime");
            kategorieRepository.save(kat_anime);







            /*Media picture1 = new Media();
            picture1.setContentType("image/jpeg");
            mediaRepository.save(picture1);*/


            //----------------Movies/Filme-------------------------


            Serie movie1 = new Serie();
            movie1.setName("Tarzan the Ape Man");
            movie1.setHersteller(her_20century);
            movie1.setReleaseDate(new Date());
            movie1.setKategorie(kat_movie);
            movie1.setReviews(null);
            movie1.setFav_users(null);
            movie1.setTrailer("undefined");
            serieRepository.save(movie1);


            Serie movie2 = new Serie();
            movie2.setName("Attack of the 50 ft. Woman");
            movie2.setHersteller(her_alliedArtist);
            movie2.setReleaseDate(new Date());
            movie2.setKategorie(kat_anime);
            movie2.setReviews(null);
            movie2.setFav_users(null);
            movie2.setTrailer("undefined");
            serieRepository.save(movie2);


            Serie movie3 = new Serie();
            movie3.setName("Betrayed Woman");
            movie3.setHersteller(her_bernhard);
            movie3.setReleaseDate(new Date());
            movie3.setKategorie(kat_series);
            movie3.setReviews(null);
            movie3.setFav_users(null);
            movie3.setTrailer("undefined");
            serieRepository.save(movie3);


            Serie movie4 = new Serie();
            movie4.setName("Carmen");
            movie4.setHersteller(her_charles);
            movie4.setReleaseDate(new Date());
            movie4.setKategorie(kat_movie);
            movie4.setReviews(null);
            movie4.setFav_users(null);
            movie4.setTrailer("undefined");
            serieRepository.save(movie4);


            Serie movie5 = new Serie();
            movie5.setName("The Circus Girl");
            movie5.setHersteller(her_cinema);
            movie5.setReleaseDate(new Date());
            movie5.setKategorie(kat_movie);
            movie5.setReviews(null);
            movie5.setFav_users(null);
            movie5.setTrailer("undefined");
            serieRepository.save(movie5);


            Serie movie6 = new Serie();
            movie6.setName("The Clubs Baby");
            movie6.setHersteller(her_cuyahoga);
            movie6.setReleaseDate(new Date());
            movie6.setKategorie(kat_movie);
            movie6.setReviews(null);
            movie6.setFav_users(null);
            movie6.setTrailer("undefined");
            serieRepository.save(movie6);


            Serie movie7 = new Serie();
            movie7.setName("The Cocaine Friends");
            movie7.setHersteller(her_gartner);
            movie7.setReleaseDate(new Date());
            movie7.setKategorie(kat_movie);
            movie7.setReviews(null);
            movie7.setFav_users(null);
            movie7.setTrailer("undefined");
            serieRepository.save(movie7);


            Serie movie8 = new Serie();
            movie8.setName("An Arizona Cowboy 1");
            movie8.setHersteller(her_georg);
            movie8.setReleaseDate(new Date());
            movie8.setKategorie(kat_movie);
            movie8.setReviews(null);
            movie8.setFav_users(null);
            movie8.setTrailer("undefined");
            serieRepository.save(movie8);


            Serie movie9 = new Serie();
            movie9.setName("An Arizona Cowboy 2");
            movie9.setHersteller(her_george);
            movie9.setReleaseDate(new Date());
            movie9.setKategorie(kat_movie);
            movie9.setReviews(null);
            movie9.setFav_users(null);
            movie9.setTrailer("undefined");
            serieRepository.save(movie9);


            Serie movie10 = new Serie();
            movie10.setName("An Arizona Cowboy 3");
            movie10.setHersteller(her_jacob);
            movie10.setReleaseDate(new Date());
            movie10.setKategorie(kat_movie);
            movie10.setReviews(null);
            movie10.setFav_users(null);
            movie10.setTrailer("undefined");
            serieRepository.save(movie10);


            Serie movie11 = new Serie();
            movie11.setName("Creature from the Black Lagoon");
            movie11.setHersteller(her_martin);
            movie11.setReleaseDate(new Date());
            movie11.setKategorie(kat_movie);
            movie11.setReviews(null);
            movie11.setFav_users(null);
            movie11.setTrailer("undefined");
            serieRepository.save(movie11);


            Serie movie12 = new Serie();
            movie12.setName("Terror from Outer Space!");
            movie12.setHersteller(null);
            movie12.setReleaseDate(new Date());
            movie12.setKategorie(null);
            movie12.setReviews(null);
            movie12.setFav_users(null);
            movie12.setTrailer("undefined");
            serieRepository.save(movie12);


            Serie movie13 = new Serie();
            movie13.setName("Deep Waters");
            movie13.setHersteller(null);
            movie13.setReleaseDate(new Date());
            movie13.setKategorie(null);
            movie13.setReviews(null);
            movie13.setFav_users(null);
            movie13.setTrailer("undefined");
            serieRepository.save(movie13);


            Serie movie14 = new Serie();
            movie14.setName("Destination Moon");
            movie14.setHersteller(null);
            movie14.setReleaseDate(new Date());
            movie14.setKategorie(null);
            movie14.setReviews(null);
            movie14.setFav_users(null);
            movie14.setTrailer("undefined");
            serieRepository.save(movie14);


            Serie movie15 = new Serie();
            movie15.setName("Dinosaurus!");
            movie15.setHersteller(null);
            movie15.setReleaseDate(new Date());
            movie15.setKategorie(null);
            movie15.setReviews(null);
            movie15.setFav_users(null);
            movie15.setTrailer("undefined");
            serieRepository.save(movie15);


            Serie movie16 = new Serie();
            movie16.setName("Dracula");
            movie16.setHersteller(null);
            movie16.setReleaseDate(new Date());
            movie16.setKategorie(null);
            movie16.setReviews(null);
            movie16.setFav_users(null);
            movie16.setTrailer("undefined");
            serieRepository.save(movie16);


            Serie movie17 = new Serie();
            movie17.setName("Dr. Cyclops");
            movie17.setHersteller(null);
            movie17.setReleaseDate(new Date());
            movie17.setKategorie(null);
            movie17.setReviews(null);
            movie17.setFav_users(null);
            movie17.setTrailer("undefined");
            serieRepository.save(movie17);


            Serie movie18 = new Serie();
            movie18.setName("Dynamite");
            movie18.setHersteller(null);
            movie18.setReleaseDate(new Date());
            movie18.setKategorie(null);
            movie18.setReviews(null);
            movie18.setFav_users(null);
            movie18.setTrailer("undefined");
            serieRepository.save(movie18);


            Serie movie19 = new Serie();
            movie19.setName("Fallen Angel");
            movie19.setHersteller(null);
            movie19.setReleaseDate(new Date());
            movie19.setKategorie(null);
            movie19.setReviews(null);
            movie19.setFav_users(null);
            movie19.setTrailer("undefined");
            serieRepository.save(movie19);


            Serie movie20 = new Serie();
            movie20.setName("Flying Down to Rio");
            movie20.setHersteller(null);
            movie20.setReleaseDate(new Date());
            movie20.setKategorie(null);
            movie20.setReviews(null);
            movie20.setFav_users(null);
            movie20.setTrailer("undefined");
            serieRepository.save(movie20);


            Serie movie21 = new Serie();
            movie21.setName("Frankenstein");
            movie21.setHersteller(null);
            movie21.setReleaseDate(new Date());
            movie21.setKategorie(null);
            movie21.setReviews(null);
            movie21.setFav_users(null);
            movie21.setTrailer("undefined");
            serieRepository.save(movie21);


            Serie movie22 = new Serie();
            movie22.setName("Ghost Riders of the West");
            movie22.setHersteller(null);
            movie22.setReleaseDate(new Date());
            movie22.setKategorie(null);
            movie22.setReviews(null);
            movie22.setFav_users(null);
            movie22.setTrailer("undefined");
            serieRepository.save(movie22);


            Serie movie23 = new Serie();
            movie23.setName("Girls in the Night");
            movie23.setHersteller(null);
            movie23.setReleaseDate(new Date());
            movie23.setKategorie(null);
            movie23.setReviews(null);
            movie23.setFav_users(null);
            movie23.setTrailer("undefined");
            serieRepository.save(movie23);


            Serie movie24 = new Serie();
            movie24.setName("Gun Crazy");
            movie24.setHersteller(null);
            movie24.setReleaseDate(new Date());
            movie24.setKategorie(null);
            movie24.setReviews(null);
            movie24.setFav_users(null);
            movie24.setTrailer("undefined");
            serieRepository.save(movie24);


            Serie movie25 = new Serie();
            movie25.setName("Horros of the Orient");
            movie25.setHersteller(null);
            movie25.setReleaseDate(new Date());
            movie25.setKategorie(null);
            movie25.setReviews(null);
            movie25.setFav_users(null);
            movie25.setTrailer("undefined");
            serieRepository.save(movie25);


            Serie movie26 = new Serie();
            movie26.setName("Hot Rod Gang");
            movie26.setHersteller(null);
            movie26.setReleaseDate(new Date());
            movie26.setKategorie(null);
            movie26.setReviews(null);
            movie26.setFav_users(null);
            movie26.setTrailer("undefined");
            serieRepository.save(movie26);


            Serie movie27 = new Serie();
            movie27.setName("Invasion of the Saucer-Men");
            movie27.setHersteller(null);
            movie27.setReleaseDate(new Date());
            movie27.setKategorie(null);
            movie27.setReviews(null);
            movie27.setFav_users(null);
            movie27.setTrailer("undefined");
            serieRepository.save(movie27);


            Serie movie28 = new Serie();
            movie28.setName("The Last Command");
            movie28.setHersteller(null);
            movie28.setReleaseDate(new Date());
            movie28.setKategorie(null);
            movie28.setReviews(null);
            movie28.setFav_users(null);
            movie28.setTrailer("undefined");
            serieRepository.save(movie28);


            Serie movie29 = new Serie();
            movie29.setName("Kellar");
            movie29.setHersteller(null);
            movie29.setReleaseDate(new Date());
            movie29.setKategorie(null);
            movie29.setReviews(null);
            movie29.setFav_users(null);
            movie29.setTrailer("undefined");
            serieRepository.save(movie29);


            Serie movie30 = new Serie();
            movie30.setName("Heart of the Klondike 1");
            movie30.setHersteller(null);
            movie30.setReleaseDate(new Date());
            movie30.setKategorie(null);
            movie30.setReviews(null);
            movie30.setFav_users(null);
            movie30.setTrailer("undefined");
            serieRepository.save(movie30);

            Serie movie31 = new Serie();
            movie31.setName("Heart of the Klondike 2");
            movie31.setHersteller(null);
            movie31.setReleaseDate(new Date());
            movie31.setKategorie(null);
            movie31.setReviews(null);
            movie31.setFav_users(null);
            movie31.setTrailer("undefined");
            serieRepository.save(movie31);



            Serie movie32 = new Serie();
            movie32.setName("La Dolce Vita");
            movie32.setHersteller(null);
            movie32.setReleaseDate(new Date());
            movie32.setKategorie(null);
            movie32.setReviews(null);
            movie32.setFav_users(null);
            movie32.setTrailer("undefined");
            serieRepository.save(movie32);


            Serie movie33 = new Serie();
            movie33.setName("Mission Spatiale");
            movie33.setHersteller(null);
            movie33.setReleaseDate(new Date());
            movie33.setKategorie(null);
            movie33.setReviews(null);
            movie33.setFav_users(null);
            movie33.setTrailer("undefined");
            serieRepository.save(movie33);


            Serie movie34 = new Serie();
            movie34.setName("The Lost Trail");
            movie34.setHersteller(null);
            movie34.setReleaseDate(new Date());
            movie34.setKategorie(null);
            movie34.setReviews(null);
            movie34.setFav_users(null);
            movie34.setTrailer("undefined");
            serieRepository.save(movie34);


            Serie movie35 = new Serie();
            movie35.setName("The Man Who Could");
            movie35.setHersteller(null);
            movie35.setReleaseDate(new Date());
            movie35.setKategorie(null);
            movie35.setReviews(null);
            movie35.setFav_users(null);
            movie35.setTrailer("undefined");
            serieRepository.save(movie35);


            Serie movie36 = new Serie();
            movie36.setName("The Man with the X-Ray Eyes");
            movie36.setHersteller(null);
            movie36.setReleaseDate(new Date());
            movie36.setKategorie(null);
            movie36.setReviews(null);
            movie36.setFav_users(null);
            movie36.setTrailer("undefined");
            serieRepository.save(movie36);


            Serie movie37 = new Serie();
            movie37.setName("Uhyret");
            movie37.setHersteller(null);
            movie37.setReleaseDate(new Date());
            movie37.setKategorie(null);
            movie37.setReviews(null);
            movie37.setFav_users(null);
            movie37.setTrailer("undefined");
            serieRepository.save(movie37);


            Serie movie38 = new Serie();
            movie38.setName("Missile Mosnters");
            movie38.setHersteller(null);
            movie38.setReleaseDate(new Date());
            movie38.setKategorie(null);
            movie38.setReviews(null);
            movie38.setFav_users(null);
            movie38.setTrailer("undefined");
            serieRepository.save(movie38);

            Serie movie39 = new Serie();
            movie39.setName("Money, Woman and Guns");
            movie39.setHersteller(null);
            movie39.setReleaseDate(new Date());
            movie39.setKategorie(null);
            movie39.setReviews(null);
            movie39.setFav_users(null);
            movie39.setTrailer("undefined");
            serieRepository.save(movie39);

            Serie movie40 = new Serie();
            movie40.setName("The Awakening");
            movie40.setHersteller(null);
            movie40.setReleaseDate(new Date());
            movie40.setKategorie(null);
            movie40.setReviews(null);
            movie40.setFav_users(null);
            movie40.setTrailer("undefined");
            serieRepository.save(movie40);


            Serie movie41 = new Serie();
            movie41.setName("Mutiny in Outer Space");
            movie41.setHersteller(null);
            movie41.setReleaseDate(new Date());
            movie41.setKategorie(null);
            movie41.setReviews(null);
            movie41.setFav_users(null);
            movie41.setTrailer("undefined");
            serieRepository.save(movie41);


            Serie movie42 = new Serie();
            movie42.setName("Plan 9 from Outer Space");
            movie42.setHersteller(null);
            movie42.setReleaseDate(new Date());
            movie42.setKategorie(null);
            movie42.setReviews(null);
            movie42.setFav_users(null);
            movie42.setTrailer("undefined");
            serieRepository.save(movie42);


            Serie movie43 = new Serie();
            movie43.setName("Reefer Madness");
            movie43.setHersteller(null);
            movie43.setReleaseDate(new Date());
            movie43.setKategorie(null);
            movie43.setReviews(null);
            movie43.setFav_users(null);
            movie43.setTrailer("undefined");
            serieRepository.save(movie43);


            Serie movie44 = new Serie();
            movie44.setName("Robot Monster");
            movie44.setHersteller(null);
            movie44.setReleaseDate(new Date());
            movie44.setKategorie(null);
            movie44.setReviews(null);
            movie44.setFav_users(null);
            movie44.setTrailer("undefined");
            serieRepository.save(movie44);


            Serie movie45 = new Serie();
            movie45.setName("Santo vs Marcianos");
            movie45.setHersteller(null);
            movie45.setReleaseDate(new Date());
            movie45.setKategorie(null);
            movie45.setReviews(null);
            movie45.setFav_users(null);
            movie45.setTrailer("undefined");
            serieRepository.save(movie45);


            Serie movie46 = new Serie();
            movie46.setName("Saturday Night");
            movie46.setHersteller(null);
            movie46.setReleaseDate(new Date());
            movie46.setKategorie(null);
            movie46.setReviews(null);
            movie46.setFav_users(null);
            movie46.setTrailer("undefined");
            serieRepository.save(movie46);


            Serie movie47 = new Serie();
            movie47.setName("Sheriffs Reward");
            movie47.setHersteller(null);
            movie47.setReleaseDate(new Date());
            movie47.setKategorie(null);
            movie47.setReviews(null);
            movie47.setFav_users(null);
            movie47.setTrailer("undefined");
            serieRepository.save(movie47);


            Serie movie48 = new Serie();
            movie48.setName("She-Wolf of London");
            movie48.setHersteller(null);
            movie48.setReleaseDate(new Date());
            movie48.setKategorie(null);
            movie48.setReviews(null);
            movie48.setFav_users(null);
            movie48.setTrailer("undefined");
            serieRepository.save(movie48);


            Serie movie49 = new Serie();
            movie49.setName("Straight Shooter");
            movie49.setHersteller(null);
            movie49.setReleaseDate(new Date());
            movie49.setKategorie(null);
            movie49.setReviews(null);
            movie49.setFav_users(null);
            movie49.setTrailer("undefined");
            serieRepository.save(movie49);


            Serie movie50 = new Serie();
            movie50.setName("Tarantula!");
            movie50.setHersteller(null);
            movie50.setReleaseDate(new Date());
            movie50.setKategorie(null);
            movie50.setReviews(null);
            movie50.setFav_users(null);
            movie50.setTrailer("undefined");
            serieRepository.save(movie50);


            Serie movie51 = new Serie();
            movie51.setName("Tarzan goes to India");
            movie51.setHersteller(null);
            movie51.setReleaseDate(new Date());
            movie51.setKategorie(null);
            movie51.setReviews(null);
            movie51.setFav_users(null);
            movie51.setTrailer("undefined");
            serieRepository.save(movie51);


            Serie movie52 = new Serie();
            movie52.setName("Terror from the Year 5000");
            movie52.setHersteller(null);
            movie52.setReleaseDate(new Date());
            movie52.setKategorie(null);
            movie52.setReviews(null);
            movie52.setFav_users(null);
            movie52.setTrailer("undefined");
            serieRepository.save(movie52);


            Serie movie53 = new Serie();
            movie53.setName("The Real Thing in Cowboys");
            movie53.setHersteller(null);
            movie53.setReleaseDate(new Date());
            movie53.setKategorie(null);
            movie53.setReviews(null);
            movie53.setFav_users(null);
            movie53.setTrailer("undefined");
            serieRepository.save(movie53);


            Serie movie54 = new Serie();
            movie54.setName("Trojan Incident");
            movie54.setHersteller(null);
            movie54.setReleaseDate(new Date());
            movie54.setKategorie(null);
            movie54.setReviews(null);
            movie54.setFav_users(null);
            movie54.setTrailer("undefined");
            serieRepository.save(movie54);


            Serie movie55 = new Serie();
            movie55.setName("Troupe");
            movie55.setHersteller(null);
            movie55.setReleaseDate(new Date());
            movie55.setKategorie(null);
            movie55.setReviews(null);
            movie55.setFav_users(null);
            movie55.setTrailer("undefined");
            serieRepository.save(movie55);


            Serie movie56 = new Serie();
            movie56.setName("Viva Las Vegas");
            movie56.setHersteller(null);
            movie56.setReleaseDate(new Date());
            movie56.setKategorie(null);
            movie56.setReviews(null);
            movie56.setFav_users(null);
            movie56.setTrailer("undefined");
            serieRepository.save(movie56);


            Serie movie57 = new Serie();
            movie57.setName("5th Regiment Armory");
            movie57.setHersteller(null);
            movie57.setReleaseDate(new Date());
            movie57.setKategorie(null);
            movie57.setReviews(null);
            movie57.setFav_users(null);
            movie57.setTrailer("undefined");
            serieRepository.save(movie57);


            Serie movie58 = new Serie();
            movie58.setName("When Worlds Collide");
            movie58.setHersteller(null);
            movie58.setReleaseDate(new Date());
            movie58.setKategorie(null);
            movie58.setReviews(null);
            movie58.setFav_users(null);
            movie58.setTrailer("undefined");
            serieRepository.save(movie58);


            Serie movie59 = new Serie();
            movie59.setName("I walked with a Zombie");
            movie59.setHersteller(null);
            movie59.setReleaseDate(new Date());
            movie59.setKategorie(null);
            movie59.setReviews(null);
            movie59.setFav_users(null);
            movie59.setTrailer("undefined");
            serieRepository.save(movie59);


            Serie movie60 = new Serie();
            movie60.setName("Zombies ot the Stratosphere");
            movie60.setHersteller(null);
            movie60.setReleaseDate(new Date());
            movie60.setKategorie(null);
            movie60.setReviews(null);
            movie60.setFav_users(null);
            movie60.setTrailer("undefined");
            serieRepository.save(movie60);




            //----------Favourites-----------

            //-----Favorite Staudi------------
            Set<Serie> favoritenstaudi = new HashSet<>();
            favoritenstaudi.add(movie37);
            favoritenstaudi.add(movie10);
            favoritenstaudi.add(movie14);
            usr_andreas.setFavorite(favoritenstaudi);
            userRepository.save(usr_andreas);

            //-----Favorite Georg------------
            Set<Serie> favoritengeorg = new HashSet<>();
            favoritengeorg.add(movie1);
            favoritengeorg.add(movie14);
            favoritengeorg.add(movie38);
            usr_georg.setFavorite(favoritengeorg);
            userRepository.save(usr_georg);

            //-----Favorite Martin------------
            Set<Serie> favoritenmartin = new HashSet<>();
            favoritenmartin.add(movie24);
            favoritenmartin.add(movie8);
            favoritenmartin.add(movie45);
            usr_martin.setFavorite(favoritenmartin);
            userRepository.save(usr_martin);

            //-----Favorite Florian------------
            Set<Serie> favoritenflorian = new HashSet<>();
            favoritenflorian.add(movie25);
            favoritenflorian.add(movie47);
            favoritenflorian.add(movie12);
            usr_florian.setFavorite(favoritenflorian);
            userRepository.save(usr_florian);



            //----------------Pictures Movies---------------

            Media[] moviePictures = new Media[61];
            for(int i=1;i<=60;i++)
            {
                moviePictures[i] = new Media();
                moviePictures[i].setContentType("image/jpeg");
                moviePictures[i].originalFileName("");
                moviePictures[i].size((long)2);
                moviePictures[i].setSavedAt("p"+i+".jpg");
                mediaRepository.save(moviePictures[i]);
            }

            List<Set<Media>> picForMov = new ArrayList<Set<Media>>();
            picForMov.add(0,new HashSet<Media>());
            for(int j=1;j<=60;j++)
            {
                Set<Media>zwischen = new HashSet<Media>();
                zwischen.add(moviePictures[j]);
                picForMov.add(j,zwischen);
            }

            movie1.setPictures(picForMov.get(1));
            serieRepository.save(movie1);
            movie2.setPictures(picForMov.get(2));
            serieRepository.save(movie2);
            movie3.setPictures(picForMov.get(3));
            serieRepository.save(movie3);
            movie4.setPictures(picForMov.get(4));
            serieRepository.save(movie4);
            movie5.setPictures(picForMov.get(5));
            serieRepository.save(movie5);
            movie6.setPictures(picForMov.get(6));
            serieRepository.save(movie6);
            movie7.setPictures(picForMov.get(7));
            serieRepository.save(movie7);
            movie8.setPictures(picForMov.get(8));
            serieRepository.save(movie8);
            movie9.setPictures(picForMov.get(9));
            serieRepository.save(movie9);
            movie10.setPictures(picForMov.get(10));
            serieRepository.save(movie10);
            movie11.setPictures(picForMov.get(11));
            serieRepository.save(movie11);
            movie12.setPictures(picForMov.get(12));
            serieRepository.save(movie12);
            movie13.setPictures(picForMov.get(13));
            serieRepository.save(movie13);
            movie14.setPictures(picForMov.get(14));
            serieRepository.save(movie14);
            movie15.setPictures(picForMov.get(15));
            serieRepository.save(movie15);
            movie16.setPictures(picForMov.get(16));
            serieRepository.save(movie16);
            movie17.setPictures(picForMov.get(17));
            serieRepository.save(movie17);
            movie18.setPictures(picForMov.get(18));
            serieRepository.save(movie18);
            movie19.setPictures(picForMov.get(19));
            serieRepository.save(movie19);
            movie20.setPictures(picForMov.get(20));
            serieRepository.save(movie20);
            movie21.setPictures(picForMov.get(21));
            serieRepository.save(movie21);
            movie22.setPictures(picForMov.get(22));
            serieRepository.save(movie22);
            movie23.setPictures(picForMov.get(23));
            serieRepository.save(movie23);
            movie24.setPictures(picForMov.get(24));
            serieRepository.save(movie24);
            movie25.setPictures(picForMov.get(25));
            serieRepository.save(movie25);
            movie26.setPictures(picForMov.get(26));
            serieRepository.save(movie26);
            movie27.setPictures(picForMov.get(27));
            serieRepository.save(movie27);
            movie28.setPictures(picForMov.get(28));
            serieRepository.save(movie28);
            movie29.setPictures(picForMov.get(29));
            serieRepository.save(movie29);
            movie30.setPictures(picForMov.get(30));
            serieRepository.save(movie30);
            movie31.setPictures(picForMov.get(31));
            serieRepository.save(movie31);
            movie32.setPictures(picForMov.get(32));
            serieRepository.save(movie32);
            movie33.setPictures(picForMov.get(33));
            serieRepository.save(movie33);
            movie34.setPictures(picForMov.get(34));
            serieRepository.save(movie34);
            movie35.setPictures(picForMov.get(35));
            serieRepository.save(movie35);
            movie36.setPictures(picForMov.get(36));
            serieRepository.save(movie36);
            movie37.setPictures(picForMov.get(37));
            serieRepository.save(movie37);
            movie38.setPictures(picForMov.get(38));
            serieRepository.save(movie38);
            movie39.setPictures(picForMov.get(39));
            serieRepository.save(movie39);
            movie40.setPictures(picForMov.get(40));
            serieRepository.save(movie40);
            movie41.setPictures(picForMov.get(41));
            serieRepository.save(movie41);
            movie42.setPictures(picForMov.get(42));
            serieRepository.save(movie42);
            movie43.setPictures(picForMov.get(43));
            serieRepository.save(movie43);
            movie44.setPictures(picForMov.get(44));
            serieRepository.save(movie44);
            movie45.setPictures(picForMov.get(45));
            serieRepository.save(movie45);
            movie46.setPictures(picForMov.get(46));
            serieRepository.save(movie46);
            movie47.setPictures(picForMov.get(47));
            serieRepository.save(movie47);
            movie48.setPictures(picForMov.get(48));
            serieRepository.save(movie48);
            movie49.setPictures(picForMov.get(49));
            serieRepository.save(movie49);
            movie50.setPictures(picForMov.get(50));
            serieRepository.save(movie50);
            movie51.setPictures(picForMov.get(51));
            serieRepository.save(movie51);
            movie52.setPictures(picForMov.get(52));
            serieRepository.save(movie52);
            movie53.setPictures(picForMov.get(53));
            serieRepository.save(movie53);
            movie54.setPictures(picForMov.get(54));
            serieRepository.save(movie54);
            movie55.setPictures(picForMov.get(55));
            serieRepository.save(movie55);
            movie56.setPictures(picForMov.get(56));
            serieRepository.save(movie56);
            movie57.setPictures(picForMov.get(57));
            serieRepository.save(movie57);
            movie58.setPictures(picForMov.get(58));
            serieRepository.save(movie58);
            movie59.setPictures(picForMov.get(59));
            serieRepository.save(movie59);
            movie60.setPictures(picForMov.get(60));
            serieRepository.save(movie60);

            /*
            Media picture1 = new Media();
            picture1.setContentType("image/jpeg");
            picture1.originalFileName("");
            picture1.size((long)2);
            picture1.setSavedAt("p1.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<Media>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture2 = new Media();
            picture2.setContentType("image/jpeg");
            picture2.originalFileName("");
            picture2.size((long)2);
            picture2.setSavedAt("p2.jpg");

            mediaRepository.save(picture2);
            //picture1.setSerie(movie1);
            Set<Media>picForMov2 = new HashSet<>();
            picForMov2.add(picture2);
            movie1.setPictures(picForMov2);
            serieRepository.save(movie2);

            Media picture3 = new Media();
            picture3.setContentType("image/jpeg");
            picture3.originalFileName("");
            picture3.size((long)2);
            picture3.setSavedAt("p3.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture4 = new Media();
            picture4.setContentType("image/jpeg");
            picture4.originalFileName("");
            picture4.size((long)2);
            picture4.setSavedAt("p4.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture5 = new Media();
            picture5.setContentType("image/jpeg");
            picture5.originalFileName("");
            picture5.size((long)2);
            picture5.setSavedAt("p5.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture6 = new Media();
            picture6.setContentType("image/jpeg");
            picture6.originalFileName("");
            picture6.size((long)2);
            picture6.setSavedAt("p6.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture7 = new Media();
            picture7.setContentType("image/jpeg");
            picture7.originalFileName("");
            picture7.size((long)2);
            picture7.setSavedAt("p7.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture8 = new Media();
            picture8.setContentType("image/jpeg");
            picture8.originalFileName("");
            picture8.size((long)2);
            picture8.setSavedAt("p8.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture9 = new Media();
            picture9.setContentType("image/jpeg");
            picture9.originalFileName("");
            picture9.size((long)2);
            picture9.setSavedAt("p9.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture10 = new Media();
            picture10.setContentType("image/jpeg");
            picture10.originalFileName("");
            picture10.size((long)2);
            picture10.setSavedAt("p10.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture11 = new Media();
            picture11.setContentType("image/jpeg");
            picture11.originalFileName("");
            picture11.size((long)2);
            picture11.setSavedAt("p11.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture12 = new Media();
            picture12.setContentType("image/jpeg");
            picture12.originalFileName("");
            picture12.size((long)2);
            picture12.setSavedAt("p12.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);
            Media picture13 = new Media();
            picture13.setContentType("image/jpeg");
            picture13.originalFileName("");
            picture13.size((long)2);
            picture13.setSavedAt("p13.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture14 = new Media();
            picture14.setContentType("image/jpeg");
            picture14.originalFileName("");
            picture14.size((long)2);
            picture14.setSavedAt("p14.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture15 = new Media();
            picture15.setContentType("image/jpeg");
            picture15.originalFileName("");
            picture15.size((long)2);
            picture15.setSavedAt("p15.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture16 = new Media();
            picture16.setContentType("image/jpeg");
            picture16.originalFileName("");
            picture16.size((long)2);
            picture16.setSavedAt("p16.jpg");

            mediaRepository.save(picture1);
            //picture1.setSerie(movie1);
            Set<Media>picForMov1 = new HashSet<>();
            picForMov1.add(picture1);
            movie1.setPictures(picForMov1);
            serieRepository.save(movie1);

            Media picture17 = new Media();
            picture17.setContentType("image/jpeg");
            picture17.originalFileName("");
            picture17.size((long)2);
            picture17.setSavedAt("p17.jpg");
            picture17.setSerie(movie17);
            mediaRepository.save(picture17);

            Media picture18 = new Media();
            picture18.setContentType("image/jpeg");
            picture18.originalFileName("");
            picture18.size((long)2);
            picture18.setSavedAt("p18.jpg");
            picture18.setSerie(movie18);
            mediaRepository.save(picture18);

            Media picture19 = new Media();
            picture19.setContentType("image/jpeg");
            picture19.originalFileName("");
            picture19.size((long)2);
            picture19.setSavedAt("p19.jpg");
            picture19.setSerie(movie19);
            mediaRepository.save(picture19);

            Media picture20 = new Media();
            picture20.setContentType("image/jpeg");
            picture20.originalFileName("");
            picture20.size((long)2);
            picture20.setSavedAt("p20.jpg");
            picture20.setSerie(movie20);
            mediaRepository.save(picture20);

            Media picture21 = new Media();
            picture21.setContentType("image/jpeg");
            picture21.originalFileName("");
            picture21.size((long)2);
            picture21.setSavedAt("p21.jpg");
            picture21.setSerie(movie21);
            mediaRepository.save(picture21);

            Media picture22 = new Media();
            picture22.setContentType("image/jpeg");
            picture22.originalFileName("");
            picture22.size((long)2);
            picture22.setSavedAt("p22.jpg");
            picture22.setSerie(movie22);
            mediaRepository.save(picture22);

            Media picture23 = new Media();
            picture23.setContentType("image/jpeg");
            picture23.originalFileName("");
            picture23.size((long)2);
            picture23.setSavedAt("p23.jpg");
            picture23.setSerie(movie23);
            mediaRepository.save(picture23);

            Media picture24 = new Media();
            picture24.setContentType("image/jpeg");
            picture24.originalFileName("");
            picture24.size((long)2);
            picture24.setSavedAt("p24.jpg");
            picture24.setSerie(movie24);
            mediaRepository.save(picture24);

            Media picture25 = new Media();
            picture25.setContentType("image/jpeg");
            picture25.originalFileName("");
            picture25.size((long)2);
            picture25.setSavedAt("p25.jpg");
            picture25.setSerie(movie25);
            mediaRepository.save(picture25);

            Media picture26 = new Media();
            picture26.setContentType("image/jpeg");
            picture26.originalFileName("");
            picture26.size((long)2);
            picture26.setSavedAt("p26.jpg");
            picture26.setSerie(movie26);
            mediaRepository.save(picture26);

            Media picture27 = new Media();
            picture27.setContentType("image/jpeg");
            picture27.originalFileName("");
            picture27.size((long)2);
            picture27.setSavedAt("p27.jpg");
            picture27.setSerie(movie27);
            mediaRepository.save(picture27);

            Media picture28 = new Media();
            picture28.setContentType("image/jpeg");
            picture28.originalFileName("");
            picture28.size((long)2);
            picture28.setSavedAt("p28.jpg");
            picture28.setSerie(movie28);
            mediaRepository.save(picture28);

            Media picture29 = new Media();
            picture29.setContentType("image/jpeg");
            picture29.originalFileName("");
            picture29.size((long)2);
            picture29.setSavedAt("p29.jpg");
            picture29.setSerie(movie29);
            mediaRepository.save(picture29);

            Media picture30 = new Media();
            picture30.setContentType("image/jpeg");
            picture30.originalFileName("");
            picture30.size((long)2);
            picture30.setSavedAt("p30.jpg");
            picture30.setSerie(movie30);
            mediaRepository.save(picture30);

            Media picture31 = new Media();
            picture31.setContentType("image/jpeg");
            picture31.originalFileName("");
            picture31.size((long)2);
            picture31.setSavedAt("p31.jpg");
            picture31.setSerie(movie31);
            mediaRepository.save(picture31);

            Media picture32 = new Media();
            picture32.setContentType("image/jpeg");
            picture32.originalFileName("");
            picture32.size((long)2);
            picture32.setSavedAt("p32.jpg");
            picture32.setSerie(movie32);
            mediaRepository.save(picture32);

            Media picture33 = new Media();
            picture33.setContentType("image/jpeg");
            picture33.originalFileName("");
            picture33.size((long)2);
            picture33.setSavedAt("p33.jpg");
            picture33.setSerie(movie33);
            mediaRepository.save(picture33);

            Media picture34 = new Media();
            picture34.setContentType("image/jpeg");
            picture34.originalFileName("");
            picture34.size((long)2);
            picture34.setSavedAt("p34.jpg");
            picture34.setSerie(movie34);
            mediaRepository.save(picture34);

            Media picture35 = new Media();
            picture35.setContentType("image/jpeg");
            picture35.originalFileName("");
            picture35.size((long)2);
            picture35.setSavedAt("p35.jpg");
            picture35.setSerie(movie35);
            mediaRepository.save(picture35);

            Media picture36 = new Media();
            picture36.setContentType("image/jpeg");
            picture36.originalFileName("");
            picture36.size((long)2);
            picture36.setSavedAt("p36.jpg");
            picture36.setSerie(movie36);
            mediaRepository.save(picture36);

            Media picture37 = new Media();
            picture37.setContentType("image/jpeg");
            picture37.originalFileName("");
            picture37.size((long)2);
            picture37.setSavedAt("p37.jpg");
            picture37.setSerie(movie37);
            mediaRepository.save(picture37);

            Media picture38 = new Media();
            picture38.setContentType("image/jpeg");
            picture38.originalFileName("");
            picture38.size((long)2);
            picture38.setSavedAt("p38.jpg");
            picture38.setSerie(movie38);
            mediaRepository.save(picture38);

            Media picture39 = new Media();
            picture39.setContentType("image/jpeg");
            picture39.originalFileName("");
            picture39.size((long)2);
            picture39.setSavedAt("p39.jpg");
            picture39.setSerie(movie39);
            mediaRepository.save(picture39);

            Media picture40 = new Media();
            picture40.setContentType("image/jpeg");
            picture40.originalFileName("");
            picture40.size((long)2);
            picture40.setSavedAt("p40.jpg");
            picture40.setSerie(movie40);
            mediaRepository.save(picture40);

            Media picture41 = new Media();
            picture41.setContentType("image/jpeg");
            picture41.originalFileName("");
            picture41.size((long)2);
            picture41.setSavedAt("p41.jpg");
            picture41.setSerie(movie41);
            mediaRepository.save(picture41);

            Media picture42 = new Media();
            picture42.setContentType("image/jpeg");
            picture42.originalFileName("");
            picture42.size((long)2);
            picture42.setSavedAt("p42.jpg");
            picture42.setSerie(movie42);
            mediaRepository.save(picture42);

            Media picture43 = new Media();
            picture43.setContentType("image/jpeg");
            picture43.originalFileName("");
            picture43.size((long)2);
            picture43.setSavedAt("p43.jpg");
            picture43.setSerie(movie43);
            mediaRepository.save(picture43);

            Media picture44 = new Media();
            picture44.setContentType("image/jpeg");
            picture44.originalFileName("");
            picture44.size((long)2);
            picture44.setSavedAt("p44.jpg");
            picture44.setSerie(movie44);
            mediaRepository.save(picture44);

            Media picture45 = new Media();
            picture45.setContentType("image/jpeg");
            picture45.originalFileName("");
            picture45.size((long)2);
            picture45.setSavedAt("p45.jpg");
            picture45.setSerie(movie45);
            mediaRepository.save(picture45);

            Media picture46 = new Media();
            picture46.setContentType("image/jpeg");
            picture46.originalFileName("");
            picture46.size((long)2);
            picture46.setSavedAt("p46.jpg");
            picture46.setSerie(movie46);
            mediaRepository.save(picture46);

            Media picture47 = new Media();
            picture47.setContentType("image/jpeg");
            picture47.originalFileName("");
            picture47.size((long)2);
            picture47.setSavedAt("p47.jpg");
            picture47.setSerie(movie47);
            mediaRepository.save(picture47);

            Media picture48 = new Media();
            picture48.setContentType("image/jpeg");
            picture48.originalFileName("");
            picture48.size((long)2);
            picture48.setSavedAt("p48.jpg");
            picture48.setSerie(movie48);
            mediaRepository.save(picture48);

            Media picture49 = new Media();
            picture49.setContentType("image/jpeg");
            picture49.originalFileName("");
            picture49.size((long)2);
            picture49.setSavedAt("p49.jpg");
            picture49.setSerie(movie49);
            mediaRepository.save(picture49);

            Media picture50 = new Media();
            picture50.setContentType("image/jpeg");
            picture50.originalFileName("");
            picture50.size((long)2);
            picture50.setSavedAt("p50.jpg");
            picture50.setSerie(movie50);
            mediaRepository.save(picture50);

            Media picture51 = new Media();
            picture51.setContentType("image/jpeg");
            picture51.originalFileName("");
            picture51.size((long)2);
            picture51.setSavedAt("p51.jpg");
            picture51.setSerie(movie51);
            mediaRepository.save(picture51);

            Media picture52 = new Media();
            picture52.setContentType("image/jpeg");
            picture52.originalFileName("");
            picture52.size((long)2);
            picture52.setSavedAt("p52.jpg");
            picture52.setSerie(movie52);
            mediaRepository.save(picture52);

            Media picture53 = new Media();
            picture53.setContentType("image/jpeg");
            picture53.originalFileName("");
            picture53.size((long)2);
            picture53.setSavedAt("p53.jpg");
            picture53.setSerie(movie53);
            mediaRepository.save(picture53);

            Media picture54 = new Media();
            picture54.setContentType("image/jpeg");
            picture54.originalFileName("");
            picture54.size((long)2);
            picture54.setSavedAt("p54.jpg");
            picture54.setSerie(movie54);
            mediaRepository.save(picture54);

            Media picture55 = new Media();
            picture55.setContentType("image/jpeg");
            picture55.originalFileName("");
            picture55.size((long)2);
            picture55.setSavedAt("p55.jpg");
            picture55.setSerie(movie55);
            mediaRepository.save(picture55);

            Media picture56 = new Media();
            picture56.setContentType("image/jpeg");
            picture56.originalFileName("");
            picture56.size((long)2);
            picture56.setSavedAt("p56.jpg");
            picture56.setSerie(movie56);
            mediaRepository.save(picture56);

            Media picture57 = new Media();
            picture57.setContentType("image/jpeg");
            picture57.originalFileName("");
            picture57.size((long)2);
            picture57.setSavedAt("p57.jpg");
            picture57.setSerie(movie57);
            mediaRepository.save(picture57);

            Media picture58 = new Media();
            picture58.setContentType("image/jpeg");
            picture58.originalFileName("");
            picture58.size((long)2);
            picture58.setSavedAt("p58.jpg");
            picture58.setSerie(movie58);
            mediaRepository.save(picture58);

            Media picture59 = new Media();
            picture59.setContentType("image/jpeg");
            picture59.originalFileName("");
            picture59.size((long)2);
            picture59.setSavedAt("p59.jpg");
            picture59.setSerie(movie59);
            mediaRepository.save(picture59);

            Media picture60 = new Media();
            picture60.setContentType("image/jpeg");
            picture60.originalFileName("");
            picture60.size((long)2);
            picture60.setSavedAt("p60.jpg");
            picture60.setSerie(movie60);
            mediaRepository.save(picture60);*/








            //---------Person ------------

            Person pers0 = new Person();
            pers0.setVorname("Martin");
            pers0.setNachname("Hutter");
            pers0.setDayOfBirth(new Date() );
            pers0.setBeschreibung("Toller Schauspieler");
            personRepository.save(pers0);

            Person pers1 = new Person();
            pers1.setVorname("Andreas");
            pers1.setNachname("Staudacher");
            pers1.setDayOfBirth(new Date());
            pers1.setBeschreibung("Oscar-würdig");
            personRepository.save(pers1);

            Person pers2 = new Person();
            pers2.setVorname("Georg");
            pers2.setNachname("Schmitzer");
            pers2.setDayOfBirth(new Date());
            pers2.setBeschreibung("Bester Drama-Darsteller");
            personRepository.save(pers2);

            Person pers3 = new Person();
            pers3.setVorname("Florian");
            pers3.setNachname("Gartner");
            pers3.setDayOfBirth(new Date());
            pers3.setBeschreibung("Leider komplett abgewrackt");
            personRepository.save(pers3);

            Person pers4 = new Person();
            pers4.setVorname("Miriam");
            pers4.setNachname("Grainer");
            pers4.setDayOfBirth(new Date());
            pers4.setBeschreibung("Absolut super");
            personRepository.save(pers4);

        //---------Charakters ------------

            Charakter char0 = new Charakter();
            char0.setName("Biggus Dickus");
            char0.setPerson(pers4);
            char0.setSerie(movie1);
            charakterRepository.save(char0);

            Charakter char1 = new Charakter();
            char1.setName("Aragorn");
            char1.setPerson(pers3);
            char1.setSerie(movie1);
            charakterRepository.save(char1);

            Charakter char2 = new Charakter();
            char2.setName("Deine Mutter");
            char2.setPerson(pers2);
            char2.setSerie(movie1);
            charakterRepository.save(char2);

            Charakter char3 = new Charakter();
            char3.setName("Son Goku");
            char3.setPerson(pers1);
            char3.setSerie(movie2);
            charakterRepository.save(char3);

            Charakter char4 = new Charakter();
            char4.setName("Darth Vaders behinderter kleiner Bruder");
            char4.setPerson(pers0);
            char4.setSerie(movie2);
            charakterRepository.save(char4);

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


            //----------Genres-----------
            Genre genre0 = new Genre();
            genre0.setName("Anime");
            genreRepository.save(genre0);

            Genre genre1 = new Genre();
            Set<Serie> movieforGenre1 = new HashSet<>();
            movieforGenre1.add(movie1);
            movieforGenre1.add(movie24);
            movieforGenre1.add(movie26);
            movieforGenre1.add(movie44);
            movieforGenre1.add(movie45);
            movieforGenre1.add(movie51);
            movieforGenre1.add(movie52);
            movieforGenre1.add(movie58);
            genre1.setSeries(movieforGenre1);
            genre1.setName("Action");
            genreRepository.save(genre1);

            Genre genre2 = new Genre();
            Set<Serie> movieforGenre2 = new HashSet<>();
            movieforGenre2.add(movie29);
            movieforGenre2.add(movie34);
            movieforGenre2.add(movie39);
            movieforGenre2.add(movie54);
            genre2.setSeries(movieforGenre2);
            genre2.setName("Adventure");
            genreRepository.save(genre2);

            Genre genre3 = new Genre();
            Set<Serie> movieforGenre3 = new HashSet<>();
            movieforGenre3.add(movie20);
            genre3.setSeries(movieforGenre3);
            genre3.setName("Comedy");
            genreRepository.save(genre3);

            Genre genre4 = new Genre();
            Set<Serie> movieforGenre4 = new HashSet<>();
            movieforGenre4.add(movie7);
            movieforGenre4.add(movie19);
            movieforGenre4.add(movie23);
            movieforGenre4.add(movie24);
            movieforGenre4.add(movie25);
            genre4.setSeries(movieforGenre4);
            genre4.setName("Crime");
            genreRepository.save(genre4);

            Genre genre5 = new Genre();
            Set<Serie> movieforGenre5 = new HashSet<>();
            movieforGenre5.add(movie3);
            movieforGenre5.add(movie5);
            movieforGenre5.add(movie6);
            movieforGenre5.add(movie18);
            movieforGenre5.add(movie29);
            movieforGenre5.add(movie55);
            movieforGenre5.add(movie56);
            genre5.setSeries(movieforGenre5);
            genre5.setName("Drama");
            genreRepository.save(genre5);

            Genre genre6 = new Genre();
            Set<Serie> movieforGenre6 = new HashSet<>();
            movieforGenre6.add(movie33);
            movieforGenre6.add(movie37);
            movieforGenre6.add(movie38);
            movieforGenre6.add(movie41);
            genre6.setSeries(movieforGenre6);
            genre6.setName("Fantasy");
            genreRepository.save(genre6);

            Genre genre7 = new Genre();
            Set<Serie> movieforGenre7 = new HashSet<>();
            movieforGenre7.add(movie28);
            movieforGenre7.add(movie54);
            movieforGenre7.add(movie55);
            movieforGenre7.add(movie57);
            genre7.setSeries(movieforGenre7);
            genre7.setName("Historical");
            genreRepository.save(genre7);

            Genre genre8 = new Genre();
            Set<Serie> movieforGenre8 = new HashSet<>();
            movieforGenre8.add(movie2);
            movieforGenre8.add(movie6);
            movieforGenre8.add(movie11);
            movieforGenre8.add(movie16);
            movieforGenre8.add(movie17);
            movieforGenre8.add(movie21);
            movieforGenre8.add(movie27);
            movieforGenre8.add(movie35);
            movieforGenre8.add(movie37);
            movieforGenre8.add(movie40);
            movieforGenre8.add(movie44);
            movieforGenre8.add(movie48);
            movieforGenre8.add(movie50);
            movieforGenre8.add(movie59);
            genre8.setSeries(movieforGenre8);
            genre8.setName("Horror");
            genreRepository.save(genre8);

            Genre genre9 = new Genre();
            Set<Serie> movieforGenre9 = new HashSet<>();
            movieforGenre9.add(movie3);
            movieforGenre9.add(movie7);
            movieforGenre9.add(movie16);
            movieforGenre9.add(movie17);
            movieforGenre9.add(movie32);
            movieforGenre9.add(movie36);
            movieforGenre9.add(movie46);
            genre9.setSeries(movieforGenre9);
            genre9.setName("Mystery");
            genreRepository.save(genre9);

            Genre genre10 = new Genre();
            Set<Serie> movieforGenre10 = new HashSet<>();
            movieforGenre10.add(movie4);
            movieforGenre10.add(movie5);
            movieforGenre10.add(movie13);
            movieforGenre10.add(movie19);
            movieforGenre10.add(movie23);
            movieforGenre10.add(movie26);
            movieforGenre10.add(movie32);
            movieforGenre10.add(movie43);
            movieforGenre10.add(movie46);
            movieforGenre10.add(movie51);
            movieforGenre10.add(movie56);
            movieforGenre10.add(movie59);
            genre10.setSeries(movieforGenre10);
            genre10.setName("Romance");
            genreRepository.save(genre10);

            Genre genre11 = new Genre();
            Set<Serie> movieforGenre11 = new HashSet<>();
            movieforGenre11.add(movie2);
            movieforGenre11.add(movie12);
            movieforGenre11.add(movie14);
            movieforGenre11.add(movie15);
            movieforGenre11.add(movie27);
            movieforGenre11.add(movie38);
            movieforGenre11.add(movie41);
            movieforGenre11.add(movie42);
            movieforGenre11.add(movie45);
            movieforGenre11.add(movie50);
            movieforGenre11.add(movie52);
            movieforGenre11.add(movie58);
            movieforGenre11.add(movie60);
            genre11.setSeries(movieforGenre11);
            genre11.setName("Science fiction");
            genreRepository.save(genre11);

            Genre genre12 = new Genre();
            Set<Serie> movieforGenre12 = new HashSet<>();
            movieforGenre12.add(movie8);
            movieforGenre12.add(movie9);
            movieforGenre12.add(movie10);
            movieforGenre12.add(movie60);
            genre12.setSeries(movieforGenre12);
            genre12.setName("Thriller");
            genreRepository.save(genre12);

            Genre genre13 = new Genre();
            Set<Serie> movieforGenre13 = new HashSet<>();
            movieforGenre13.add(movie22);
            movieforGenre13.add(movie30);
            movieforGenre13.add(movie31);
            movieforGenre13.add(movie34);
            movieforGenre13.add(movie39);
            movieforGenre13.add(movie47);
            movieforGenre13.add(movie49);
            movieforGenre13.add(movie53);
            genre13.setSeries(movieforGenre13);
            genre13.setName("Western");
            genreRepository.save(genre13);


            //----------Reviews-----------
            Review review1 = new Review();
            review1.setReviewText("Beschter Film allerzeitn oida");
            review1.setSerie(movie1);
            review1.setUser(usr_florian);
            reviewRepository.save(review1);

            Review review2 = new Review();
            review2.setReviewText("Könnte besser sein ");
            review2.setSerie(movie2);
            review2.setUser(usr_georg);
            reviewRepository.save(review2);

            Review review3 = new Review();
            review3.setReviewText("Der film war gut nur die anderen Kinobesucher sind zu laut gewesen");
            review3.setSerie(movie1);
            review3.setUser(usr_andreas);
            reviewRepository.save(review3);

            Review review4 = new Review();
            review4.setReviewText("Der Film ist für den Inhalt nicht mal 1 Cent wert");
            review4.setSerie(movie1);
            review4.setUser(usr_martin);
            reviewRepository.save(review4);

            Review review5 = new Review();
            review5.setReviewText("Hab schon besseres gesehen");
            review5.setSerie(movie2);
            review5.setUser(usr_florian);
            reviewRepository.save(review5);

            Review review6 = new Review();
            review6.setReviewText("Diesen Film kann ich nur weiterempfehlen");
            review6.setSerie(movie2);
            review6.setUser(usr_martin);
            reviewRepository.save(review6);

            Review review7 = new Review();
            review7.setReviewText("Noch eine Fortsetzung nach die niemand gefragt hat");
            review7.setSerie(movie3);
            review7.setUser(usr_andreas);
            reviewRepository.save(review7);

            Review review8 = new Review();
            review8.setReviewText("Der Sitz war unbeguem, aber sonst war der Film nicht schlecht");
            review8.setSerie(movie3);
            review8.setUser(usr_florian);
            reviewRepository.save(review8);

            Review review9 = new Review();
            review9.setReviewText("Mein Popcorn war versalzen");
            review9.setSerie(movie3);
            review9.setUser(usr_georg);
            reviewRepository.save(review9);

            Review review10 = new Review();
            review10.setReviewText("Also für Blinde ist dieser Film nicht zu empfehlen");
            review10.setSerie(movie4);
            review10.setUser(usr_martin);
            reviewRepository.save(review10);

            Review review11 = new Review();
            review11.setReviewText("Ich hätte mir die Ohren zu halten sollen bei diesem Film");
            review11.setSerie(movie4);
            review11.setUser(usr_georg);
            reviewRepository.save(review11);

            Review review12 = new Review();
            review12.setReviewText("Seit wann sind Hunde im Kino erlaubt");
            review12.setSerie(movie4);
            review12.setUser(usr_florian);
            reviewRepository.save(review12);

            Review review13 = new Review();
            review13.setReviewText("Ich glaub das ist alles erfunden");
            review13.setSerie(movie5);
            review13.setUser(usr_florian);
            reviewRepository.save(review13);

            Review review14 = new Review();
            review14.setReviewText("Toller Film, wenn man entspannen will");
            review14.setSerie(movie6);
            review14.setUser(usr_martin);
            reviewRepository.save(review14);


            //----------Serien Rating-----------

            //-----Serie 1-------
            Serien_Rating rating1 = new Serien_Rating();
            rating1.setRating(2);
            rating1.setSerie(movie1);
            rating1.setUser(usr_andreas);
            serien_ratingRepository.save(rating1);

            Serien_Rating rating2 = new Serien_Rating();
            rating2.setRating(5);
            rating2.setSerie(movie1);
            rating2.setUser(usr_florian);
            serien_ratingRepository.save(rating2);

            Serien_Rating rating3 = new Serien_Rating();
            rating3.setRating(4);
            rating3.setSerie(movie1);
            rating3.setUser(usr_georg);
            serien_ratingRepository.save(rating3);

            //-----Serie 2-------
            Serien_Rating rating4 = new Serien_Rating();
            rating4.setRating(1);
            rating4.setSerie(movie2);
            rating4.setUser(usr_martin);
            serien_ratingRepository.save(rating4);

            Serien_Rating rating5 = new Serien_Rating();
            rating5.setRating(3);
            rating5.setSerie(movie2);
            rating5.setUser(usr_georg);
            serien_ratingRepository.save(rating5);

            Serien_Rating rating6 = new Serien_Rating();
            rating6.setRating(5);
            rating6.setSerie(movie2);
            rating6.setUser(usr_florian);
            serien_ratingRepository.save(rating6);

            //-----Serie 3-------
            Serien_Rating rating7 = new Serien_Rating();
            rating7.setRating(5);
            rating7.setSerie(movie3);
            rating7.setUser(usr_andreas);
            serien_ratingRepository.save(rating7);

            Serien_Rating rating8 = new Serien_Rating();
            rating8.setRating(5);
            rating8.setSerie(movie3);
            rating8.setUser(usr_florian);
            serien_ratingRepository.save(rating8);

            Serien_Rating rating9 = new Serien_Rating();
            rating9.setRating(5);
            rating9.setSerie(movie3);
            rating9.setUser(usr_georg);
            serien_ratingRepository.save(rating9);

            //-----Serie 4-------
            Serien_Rating rating10 = new Serien_Rating();
            rating10.setRating(2);
            rating10.setSerie(movie4);
            rating10.setUser(usr_andreas);
            serien_ratingRepository.save(rating10);

            Serien_Rating rating11 = new Serien_Rating();
            rating11.setRating(4);
            rating11.setSerie(movie4);
            rating11.setUser(usr_florian);
            serien_ratingRepository.save(rating11);

            Serien_Rating rating12 = new Serien_Rating();
            rating12.setRating(1);
            rating12.setSerie(movie4);
            rating12.setUser(usr_martin);
            serien_ratingRepository.save(rating12);

            //-----Serie 5-------
            Serien_Rating rating13 = new Serien_Rating();
            rating13.setRating(3);
            rating13.setSerie(movie5);
            rating13.setUser(usr_georg);
            serien_ratingRepository.save(rating13);

            Serien_Rating rating14 = new Serien_Rating();
            rating14.setRating(1);
            rating14.setSerie(movie5);
            rating14.setUser(usr_andreas);
            serien_ratingRepository.save(rating14);

            Serien_Rating rating15 = new Serien_Rating();
            rating15.setRating(5);
            rating15.setSerie(movie5);
            rating15.setUser(usr_martin);
            serien_ratingRepository.save(rating15);


        }

    }

}
