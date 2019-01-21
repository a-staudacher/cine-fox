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
            userRepository.save(usr_andreas);

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





            //----------Reviews-----------
            Review review1 = new Review();
            review1.setReviewText("Beschter Film allerzeitn oida");
            review1.setSerie(null);
            review1.setUser(null);
            reviewRepository.save(review1);

            Review review2 = new Review();
            review2.setReviewText("Könnte besser sein ");
            review2.setSerie(null);
            review2.setUser(null);
            reviewRepository.save(review2);

            Review review3 = new Review();
            review3.setReviewText("Der film war gut nur die anderen Kinobesucher sind zu laut gewesen");
            review3.setSerie(null);
            review3.setUser(null);
            reviewRepository.save(review3);

            Review review4 = new Review();
            review4.setReviewText("Der Film ist für den Inhalt nicht mal 1 Cent wert");
            review4.setSerie(null);
            review4.setUser(null);
            reviewRepository.save(review4);

            Review review5 = new Review();
            review5.setReviewText("Hab schon besseres gesehen");
            review5.setSerie(null);
            review5.setUser(null);
            reviewRepository.save(review5);

            Review review6 = new Review();
            review6.setReviewText("Diesen Film kann ich nur weiterempfehlen");
            review6.setSerie(null);
            review6.setUser(null);
            reviewRepository.save(review6);

            Review review7 = new Review();
            review7.setReviewText("Noch eine Fortsetzung nach die niemand gefragt hat");
            review7.setSerie(null);
            review7.setUser(null);
            reviewRepository.save(review7);

            Review review8 = new Review();
            review8.setReviewText("Der Sitz war unbeguem, aber sonst war der Film nicht schlecht");
            review8.setSerie(null);
            review8.setUser(null);
            reviewRepository.save(review8);

            Review review9 = new Review();
            review9.setReviewText("Mein Popcorn war versalzen");
            review9.setSerie(null);
            review9.setUser(null);
            reviewRepository.save(review9);

            Review review10 = new Review();
            review10.setReviewText("Also für Blinde ist dieser Film nicht zu empfehlen");
            review10.setSerie(null);
            review10.setUser(null);
            reviewRepository.save(review10);

            Review review11 = new Review();
            review11.setReviewText("Ich hätte mir die Ohren zu halten sollen bei diesem Film");
            review11.setSerie(null);
            review11.setUser(null);
            reviewRepository.save(review11);

            Review review12 = new Review();
            review12.setReviewText("Seit wann sind Hunde im Kino erlaubt");
            review12.setSerie(null);
            review12.setUser(null);
            reviewRepository.save(review12);

            Review review13 = new Review();
            review13.setReviewText("Ich glaub das ist alles erfunden");
            review13.setSerie(null);
            review13.setUser(null);
            reviewRepository.save(review13);

            Review review14 = new Review();
            review14.setReviewText("Toller Film, wenn man entspannen will");
            review14.setSerie(null);
            review14.setUser(null);
            reviewRepository.save(review14);

            //----------Favourites-----------

            //----------Serien Rating-----------

                        //-----Serie 1-------
            Serien_Rating rating1 = new Serien_Rating();
            rating1.setRating(2);
            rating1.setSerie(null);
            rating1.setUser(null);
            serien_ratingRepository.save(rating1);

            Serien_Rating rating2 = new Serien_Rating();
            rating2.setRating(5);
            rating2.setSerie(null);
            rating2.setUser(null);
            serien_ratingRepository.save(rating2);

            Serien_Rating rating3 = new Serien_Rating();
            rating3.setRating(4);
            rating3.setSerie(null);
            rating3.setUser(null);
            serien_ratingRepository.save(rating3);

            //-----Serie 2-------
            Serien_Rating rating4 = new Serien_Rating();
            rating4.setRating(1);
            rating4.setSerie(null);
            rating4.setUser(null);
            serien_ratingRepository.save(rating4);

            Serien_Rating rating5 = new Serien_Rating();
            rating5.setRating(3);
            rating5.setSerie(null);
            rating5.setUser(null);
            serien_ratingRepository.save(rating5);

            Serien_Rating rating6 = new Serien_Rating();
            rating6.setRating(5);
            rating6.setSerie(null);
            rating6.setUser(null);
            serien_ratingRepository.save(rating6);

            //-----Serie 3-------
            Serien_Rating rating7 = new Serien_Rating();
            rating7.setRating(5);
            rating7.setSerie(null);
            rating7.setUser(null);
            serien_ratingRepository.save(rating7);

            Serien_Rating rating8 = new Serien_Rating();
            rating8.setRating(5);
            rating8.setSerie(null);
            rating8.setUser(null);
            serien_ratingRepository.save(rating8);

            Serien_Rating rating9 = new Serien_Rating();
            rating9.setRating(5);
            rating9.setSerie(null);
            rating9.setUser(null);
            serien_ratingRepository.save(rating9);

            //-----Serie 4-------
            Serien_Rating rating10 = new Serien_Rating();
            rating10.setRating(2);
            rating10.setSerie(null);
            rating10.setUser(null);
            serien_ratingRepository.save(rating10);

            Serien_Rating rating11 = new Serien_Rating();
            rating11.setRating(4);
            rating11.setSerie(null);
            rating11.setUser(null);
            serien_ratingRepository.save(rating11);

            Serien_Rating rating12 = new Serien_Rating();
            rating12.setRating(1);
            rating12.setSerie(null);
            rating12.setUser(null);
            serien_ratingRepository.save(rating12);

            //-----Serie 5-------
            Serien_Rating rating13 = new Serien_Rating();
            rating13.setRating(3);
            rating13.setSerie(null);
            rating13.setUser(null);
            serien_ratingRepository.save(rating13);

            Serien_Rating rating14 = new Serien_Rating();
            rating14.setRating(1);
            rating14.setSerie(null);
            rating14.setUser(null);
            serien_ratingRepository.save(rating14);

            Serien_Rating rating15 = new Serien_Rating();
            rating15.setRating(5);
            rating15.setSerie(null);
            rating15.setUser(null);
            serien_ratingRepository.save(rating15);





            //----------------Movies/Filme-------------------------

            Serie movie1 = new Serie();
            movie1.setName("Tarzan the Ape Man");
            movie1.setHersteller(null);
            movie1.setReleaseDate(new Date());
            movie1.setKategorie(null);
            movie1.setReviews(null);
            movie1.setFav_users(null);
            movie1.setTrailer("undefined");
            serieRepository.save(movie1);


            Serie movie2 = new Serie();
            movie2.setName("Attack of the 50 ft. Woman");
            movie2.setHersteller(null);
            movie2.setReleaseDate(new Date());
            movie2.setKategorie(null);
            movie2.setReviews(null);
            movie2.setFav_users(null);
            movie2.setTrailer("undefined");
            serieRepository.save(movie2);


            Serie movie3 = new Serie();
            movie3.setName("Betrayed Woman");
            movie3.setHersteller(null);
            movie3.setReleaseDate(new Date());
            movie3.setKategorie(null);
            movie3.setReviews(null);
            movie3.setFav_users(null);
            movie3.setTrailer("undefined");
            serieRepository.save(movie3);


            Serie movie4 = new Serie();
            movie4.setName("Carmen");
            movie4.setHersteller(null);
            movie4.setReleaseDate(new Date());
            movie4.setKategorie(null);
            movie4.setReviews(null);
            movie4.setFav_users(null);
            movie4.setTrailer("undefined");
            serieRepository.save(movie4);


            Serie movie5 = new Serie();
            movie5.setName("The Circus Girl");
            movie5.setHersteller(null);
            movie5.setReleaseDate(new Date());
            movie5.setKategorie(null);
            movie5.setReviews(null);
            movie5.setFav_users(null);
            movie5.setTrailer("undefined");
            serieRepository.save(movie5);


            Serie movie6 = new Serie();
            movie6.setName("The Clubs Baby");
            movie6.setHersteller(null);
            movie6.setReleaseDate(new Date());
            movie6.setKategorie(null);
            movie6.setReviews(null);
            movie6.setFav_users(null);
            movie6.setTrailer("undefined");
            serieRepository.save(movie6);


            Serie movie7 = new Serie();
            movie7.setName("The Cocaine Friends");
            movie7.setHersteller(null);
            movie7.setReleaseDate(new Date());
            movie7.setKategorie(null);
            movie7.setReviews(null);
            movie7.setFav_users(null);
            movie7.setTrailer("undefined");
            serieRepository.save(movie7);


            Serie movie8 = new Serie();
            movie8.setName("An Arizona Cowboy 1");
            movie8.setHersteller(null);
            movie8.setReleaseDate(new Date());
            movie8.setKategorie(null);
            movie8.setReviews(null);
            movie8.setFav_users(null);
            movie8.setTrailer("undefined");
            serieRepository.save(movie8);


            Serie movie9 = new Serie();
            movie9.setName("An Arizona Cowboy 2");
            movie9.setHersteller(null);
            movie9.setReleaseDate(new Date());
            movie9.setKategorie(null);
            movie9.setReviews(null);
            movie9.setFav_users(null);
            movie9.setTrailer("undefined");
            serieRepository.save(movie9);


            Serie movie10 = new Serie();
            movie10.setName("An Arizona Cowboy 3");
            movie10.setHersteller(null);
            movie10.setReleaseDate(new Date());
            movie10.setKategorie(null);
            movie10.setReviews(null);
            movie10.setFav_users(null);
            movie10.setTrailer("undefined");
            serieRepository.save(movie10);


            Serie movie11 = new Serie();
            movie11.setName("Creature from the Black Lagoon");
            movie11.setHersteller(null);
            movie11.setReleaseDate(new Date());
            movie11.setKategorie(null);
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





            //----------Genres-----------
            Genre genre0 = new Genre();
            genre0.setName("Anime");
            genreRepository.save(genre0);

            Set<Serie> movie1Genre = new HashSet<>();
            Genre genre1 = new Genre();
            movie1Genre.add(movie1);
            genre1.setSeries(movie1Genre);
            Set<Serie> movie24Genre = new HashSet<>();
            movie24Genre.add(movie24);
            genre1.setSeries(movie24Genre);
            Set<Serie> movie26Genre = new HashSet<>();
            movie26Genre.add(movie26);
            genre1.setSeries(movie26Genre);
            Set<Serie> movie44Genre = new HashSet<>();
            movie44Genre.add(movie44);
            genre1.setSeries(movie44Genre);
            Set<Serie> movie45Genre = new HashSet<>();
            movie45Genre.add(movie45);
            genre1.setSeries(movie45Genre);
            Set<Serie> movie51Genre = new HashSet<>();
            movie51Genre.add(movie51);
            genre1.setSeries(movie51Genre);
            Set<Serie> movie52Genre = new HashSet<>();
            movie52Genre.add(movie52);
            genre1.setSeries(movie52Genre);
            Set<Serie> movie58Genre = new HashSet<>();
            movie58Genre.add(movie58);
            genre1.setSeries(movie58Genre);
            genre1.setName("Action");
            genreRepository.save(genre1);

            Set<Serie> movie29Genre = new HashSet<>();
            Genre genre2 = new Genre();
            movie29Genre.add(movie29);
            genre2.setSeries(movie29Genre);
            Set<Serie> movie34Genre = new HashSet<>();
            movie34Genre.add(movie34);
            genre2.setSeries(movie34Genre);
            Set<Serie> movie39Genre = new HashSet<>();
            movie39Genre.add(movie39);
            genre2.setSeries(movie39Genre);
            Set<Serie> movie54Genre = new HashSet<>();
            movie54Genre.add(movie54);
            genre2.setSeries(movie54Genre);
            genre2.setName("Adventure");
            genreRepository.save(genre2);

            Set<Serie> movie20Genre = new HashSet<>();
            Genre genre3 = new Genre();
            movie20Genre.add(movie20);
            genre3.setSeries(movie20Genre);
            genre3.setName("Comedy");
            genreRepository.save(genre3);

            Set<Serie> movie23Genre = new HashSet<>();
            Genre genre4 = new Genre();
            Set<Serie> movie7Genre = new HashSet<>();
            movie7Genre.add(movie7);
            genre4.setSeries(movie7Genre);
            Set<Serie> movie19Genre = new HashSet<>();
            movie19Genre.add(movie19);
            genre4.setSeries(movie19Genre);
            movie23Genre.add(movie23);
            genre4.setSeries(movie23Genre);
            movie24Genre.add(movie24);
            genre4.setSeries(movie24Genre);
            Set<Serie> movie25Genre = new HashSet<>();
            movie25Genre.add(movie25);
            genre4.setSeries(movie25Genre);
            genre4.setName("Crime");
            genreRepository.save(genre4);

            Set<Serie> movie3Genre = new HashSet<>();
            Genre genre5 = new Genre();
            movie3Genre.add(movie3);
            genre5.setSeries(movie3Genre);
            Set<Serie> movie5Genre = new HashSet<>();
            movie5Genre.add(movie5);
            genre5.setSeries(movie5Genre);
            Set<Serie> movie6Genre = new HashSet<>();
            movie6Genre.add(movie6);
            genre5.setSeries(movie6Genre);
            Set<Serie> movie18Genre = new HashSet<>();
            movie18Genre.add(movie18);
            genre5.setSeries(movie18Genre);
            movie29Genre.add(movie29);
            genre5.setSeries(movie29Genre);
            Set<Serie> movie55Genre = new HashSet<>();
            movie55Genre.add(movie55);
            genre5.setSeries(movie55Genre);
            Set<Serie> movie56Genre = new HashSet<>();
            movie56Genre.add(movie56);
            genre5.setSeries(movie56Genre);
            genre5.setName("Drama");
            genreRepository.save(genre5);

            Set<Serie> movie33Genre = new HashSet<>();
            Genre genre6 = new Genre();
            movie33Genre.add(movie33);
            genre6.setSeries(movie33Genre);
            Set<Serie> movie37Genre = new HashSet<>();
            movie37Genre.add(movie37);
            genre6.setSeries(movie37Genre);
            Set<Serie> movie38Genre = new HashSet<>();
            movie38Genre.add(movie38);
            genre6.setSeries(movie38Genre);
            Set<Serie> movie41Genre = new HashSet<>();
            movie41Genre.add(movie41);
            genre6.setSeries(movie41Genre);
            genre6.setName("Fantasy");
            genreRepository.save(genre6);

            Set<Serie> movie28Genre = new HashSet<>();
            Genre genre7 = new Genre();
            movie28Genre.add(movie28);
            genre7.setSeries(movie28Genre);
            movie54Genre.add(movie54);
            genre7.setSeries(movie54Genre);
            movie55Genre.add(movie55);
            genre7.setSeries(movie55Genre);
            Set<Serie> movie57Genre = new HashSet<>();
            movie57Genre.add(movie57);
            genre7.setSeries(movie57Genre);
            genre7.setName("Historical");
            genreRepository.save(genre7);

            Set<Serie> movie2Genre = new HashSet<>();
            Genre genre8 = new Genre();
            movie2Genre.add(movie2);
            genre8.setSeries(movie2Genre);
            movie6Genre.add(movie6);
            genre8.setSeries(movie6Genre);
            Set<Serie> movie11Genre = new HashSet<>();
            movie11Genre.add(movie11);
            genre8.setSeries(movie11Genre);
            Set<Serie> movie16Genre = new HashSet<>();
            movie16Genre.add(movie16);
            genre8.setSeries(movie16Genre);
            Set<Serie> movie17Genre = new HashSet<>();
            movie17Genre.add(movie17);
            genre8.setSeries(movie17Genre);
            Set<Serie> movie21Genre = new HashSet<>();
            movie21Genre.add(movie21);
            genre8.setSeries(movie21Genre);
            Set<Serie> movie27Genre = new HashSet<>();
            movie27Genre.add(movie27);
            genre8.setSeries(movie27Genre);
            Set<Serie> movie35Genre = new HashSet<>();
            movie35Genre.add(movie35);
            genre8.setSeries(movie35Genre);
            movie37Genre.add(movie37);
            genre8.setSeries(movie37Genre);
            Set<Serie> movie40Genre = new HashSet<>();
            movie40Genre.add(movie40);
            genre8.setSeries(movie40Genre);
            movie44Genre.add(movie44);
            genre8.setSeries(movie44Genre);
            Set<Serie> movie48Genre = new HashSet<>();
            movie48Genre.add(movie48);
            genre8.setSeries(movie48Genre);
            Set<Serie> movie50Genre = new HashSet<>();
            movie50Genre.add(movie50);
            genre8.setSeries(movie50Genre);
            Set<Serie> movie59Genre = new HashSet<>();
            movie59Genre.add(movie59);
            genre8.setSeries(movie59Genre);
            genre8.setName("Horror");
            genreRepository.save(genre8);

            Genre genre9 = new Genre();
            movie3Genre.add(movie3);
            genre9.setSeries(movie3Genre);
            movie7Genre.add(movie7);
            genre9.setSeries(movie7Genre);
            movie16Genre.add(movie16);
            genre9.setSeries(movie16Genre);
            movie17Genre.add(movie17);
            genre9.setSeries(movie17Genre);
            Set<Serie> movie32Genre = new HashSet<>();
            movie32Genre.add(movie32);
            genre9.setSeries(movie32Genre);
            Set<Serie> movie36Genre = new HashSet<>();
            movie36Genre.add(movie36);
            genre9.setSeries(movie36Genre);
            Set<Serie> movie46Genre = new HashSet<>();
            movie46Genre.add(movie46);
            genre9.setSeries(movie46Genre);
            genre9.setName("Mystery");
            genreRepository.save(genre9);

            Set<Serie> movie4Genre = new HashSet<>();
            Genre genre10 = new Genre();
            movie4Genre.add(movie4);
            genre10.setSeries(movie4Genre);
            movie5Genre.add(movie5);
            genre10.setSeries(movie5Genre);
            Set<Serie> movie13Genre = new HashSet<>();
            movie13Genre.add(movie13);
            genre10.setSeries(movie13Genre);
            movie18Genre.add(movie18);
            genre10.setSeries(movie18Genre);
            movie19Genre.add(movie19);
            genre10.setSeries(movie19Genre);
            movie23Genre.add(movie23);
            genre10.setSeries(movie23Genre);
            movie26Genre.add(movie26);
            genre10.setSeries(movie26Genre);
            movie32Genre.add(movie32);
            genre10.setSeries(movie32Genre);
            Set<Serie> movie43Genre = new HashSet<>();
            movie43Genre.add(movie43);
            genre10.setSeries(movie43Genre);
            movie46Genre.add(movie46);
            genre10.setSeries(movie46Genre);
            movie51Genre.add(movie51);
            genre10.setSeries(movie51Genre);
            movie56Genre.add(movie56);
            genre10.setSeries(movie56Genre);
            movie59Genre.add(movie59);
            genre10.setSeries(movie59Genre);
            genre10.setName("Romance");
            genreRepository.save(genre10);

            Genre genre11 = new Genre();
            movie2Genre.add(movie2);
            genre11.setSeries(movie2Genre);
            Set<Serie> movie12Genre = new HashSet<>();
            movie12Genre.add(movie12);
            genre11.setSeries(movie12Genre);
            Set<Serie> movie14Genre = new HashSet<>();
            movie14Genre.add(movie14);
            genre11.setSeries(movie14Genre);
            Set<Serie> movie15Genre = new HashSet<>();
            movie15Genre.add(movie15);
            genre11.setSeries(movie15Genre);
            movie27Genre.add(movie27);
            genre11.setSeries(movie27Genre);
            movie38Genre.add(movie38);
            genre11.setSeries(movie38Genre);
            movie41Genre.add(movie41);
            genre11.setSeries(movie41Genre);
            Set<Serie> movie42Genre = new HashSet<>();
            movie42Genre.add(movie42);
            genre11.setSeries(movie42Genre);
            movie45Genre.add(movie45);
            genre11.setSeries(movie45Genre);
            movie50Genre.add(movie50);
            genre11.setSeries(movie50Genre);
            movie52Genre.add(movie52);
            genre11.setSeries(movie52Genre);
            movie58Genre.add(movie58);
            genre11.setSeries(movie58Genre);
            Set<Serie> movie60Genre = new HashSet<>();
            movie60Genre.add(movie60);
            genre11.setSeries(movie60Genre);
            genre11.setName("Science fiction");
            genreRepository.save(genre11);

            Set<Serie> movie8Genre = new HashSet<>();
            Genre genre12 = new Genre();
            movie8Genre.add(movie8);
            genre12.setSeries(movie8Genre);
            Set<Serie> movie9Genre = new HashSet<>();
            movie9Genre.add(movie9);
            genre11.setSeries(movie9Genre);
            Set<Serie> movie10Genre = new HashSet<>();
            movie10Genre.add(movie10);
            genre11.setSeries(movie10Genre);
            movie60Genre.add(movie60);
            genre11.setSeries(movie60Genre);
            genre12.setName("Thriller");
            genreRepository.save(genre12);

            Set<Serie> movie22Genre = new HashSet<>();
            Genre genre13 = new Genre();
            movie22Genre.add(movie22);
            genre13.setSeries(movie22Genre);
            Set<Serie> movie30Genre = new HashSet<>();
            movie30Genre.add(movie30);
            genre13.setSeries(movie30Genre);
            Set<Serie> movie31Genre = new HashSet<>();
            movie31Genre.add(movie31);
            genre13.setSeries(movie31Genre);
            movie34Genre.add(movie34);
            genre13.setSeries(movie34Genre);
            movie39Genre.add(movie39);
            genre13.setSeries(movie39Genre);
            Set<Serie> movie47Genre = new HashSet<>();
            movie47Genre.add(movie47);
            genre13.setSeries(movie47Genre);
            Set<Serie> movie49Genre = new HashSet<>();
            movie49Genre.add(movie49);
            genre13.setSeries(movie49Genre);
            Set<Serie> movie53Genre = new HashSet<>();
            movie53Genre.add(movie53);
            genre13.setSeries(movie53Genre);
            genre13.setName("Western");
            genreRepository.save(genre13);





            //----------------Pictures Movies---------------

            Media picture1 = new Media();
            picture1.setContentType("image/jpeg");
            picture1.originalFileName("");
            picture1.size((long)2);
            picture1.setSavedAt("p1.jpg");
            picture1.setSerie(movie1);
            mediaRepository.save(picture1);

            Media picture2 = new Media();
            picture2.setContentType("image/jpeg");
            picture2.originalFileName("");
            picture2.size((long)2);
            picture2.setSavedAt("p2.jpg");
            picture2.setSerie(movie2);
            mediaRepository.save(picture2);

            Media picture3 = new Media();
            picture3.setContentType("image/jpeg");
            picture3.originalFileName("");
            picture3.size((long)2);
            picture3.setSavedAt("p3.jpg");
            picture3.setSerie(movie3);
            mediaRepository.save(picture3);

            Media picture4 = new Media();
            picture4.setContentType("image/jpeg");
            picture4.originalFileName("");
            picture4.size((long)2);
            picture4.setSavedAt("p4.jpg");
            picture4.setSerie(movie4);
            mediaRepository.save(picture4);

            Media picture5 = new Media();
            picture5.setContentType("image/jpeg");
            picture5.originalFileName("");
            picture5.size((long)2);
            picture5.setSavedAt("p5.jpg");
            picture5.setSerie(movie5);
            mediaRepository.save(picture5);

            Media picture6 = new Media();
            picture6.setContentType("image/jpeg");
            picture6.originalFileName("");
            picture6.size((long)2);
            picture6.setSavedAt("p6.jpg");
            picture6.setSerie(movie6);
            mediaRepository.save(picture6);

            Media picture7 = new Media();
            picture7.setContentType("image/jpeg");
            picture7.originalFileName("");
            picture7.size((long)2);
            picture7.setSavedAt("p7.jpg");
            picture7.setSerie(movie7);
            mediaRepository.save(picture7);

            Media picture8 = new Media();
            picture8.setContentType("image/jpeg");
            picture8.originalFileName("");
            picture8.size((long)2);
            picture8.setSavedAt("p8.jpg");
            picture8.setSerie(movie8);
            mediaRepository.save(picture8);

            Media picture9 = new Media();
            picture9.setContentType("image/jpeg");
            picture9.originalFileName("");
            picture9.size((long)2);
            picture9.setSavedAt("p9.jpg");
            picture9.setSerie(movie9);
            mediaRepository.save(picture9);

            Media picture10 = new Media();
            picture10.setContentType("image/jpeg");
            picture10.originalFileName("");
            picture10.size((long)2);
            picture10.setSavedAt("p10.jpg");
            picture10.setSerie(movie10);
            mediaRepository.save(picture10);

            Media picture11 = new Media();
            picture11.setContentType("image/jpeg");
            picture11.originalFileName("");
            picture11.size((long)2);
            picture11.setSavedAt("p11.jpg");
            picture11.setSerie(movie11);
            mediaRepository.save(picture11);

            Media picture12 = new Media();
            picture12.setContentType("image/jpeg");
            picture12.originalFileName("");
            picture12.size((long)2);
            picture12.setSavedAt("p12.jpg");
            picture12.setSerie(movie12);
            mediaRepository.save(picture12);

            Media picture13 = new Media();
            picture13.setContentType("image/jpeg");
            picture13.originalFileName("");
            picture13.size((long)2);
            picture13.setSavedAt("p13.jpg");
            picture13.setSerie(movie13);
            mediaRepository.save(picture13);

            Media picture14 = new Media();
            picture14.setContentType("image/jpeg");
            picture14.originalFileName("");
            picture14.size((long)2);
            picture14.setSavedAt("p14.jpg");
            picture14.setSerie(movie14);
            mediaRepository.save(picture14);

            Media picture15 = new Media();
            picture15.setContentType("image/jpeg");
            picture15.originalFileName("");
            picture15.size((long)2);
            picture15.setSavedAt("p15.jpg");
            picture15.setSerie(movie15);
            mediaRepository.save(picture15);

            Media picture16 = new Media();
            picture16.setContentType("image/jpeg");
            picture16.originalFileName("");
            picture16.size((long)2);
            picture16.setSavedAt("p16.jpg");
            picture16.setSerie(movie16);
            mediaRepository.save(picture16);

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
            mediaRepository.save(picture60);




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
