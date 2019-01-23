import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {PersonService} from '../service/person.service';
import {MovieService} from '../service/movie.service';
import {ActivatedRoute, Router} from '@angular/router';
import {GenreService} from '../service/genre.service';
import {HerstellerService} from '../service/hersteller.service';
import {KategorieService} from '../service/kategorie.service';
import {map} from 'rxjs/operators';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-movie-form',
  templateUrl: './movie-form.component.html',
  styleUrls: ['./movie-form.component.scss']
})
export class MovieFormComponent implements OnInit {
  movieForm;
  genreOptions;
  choosenGenres;
  herstellerOptions;
  kategorieOptions;
  directorOptions;
  movie;
  genre_zwischen = [];
  movieBild;
  id;
  shouldNavigateToList: boolean;
  constructor(private personService: PersonService, private movieService: MovieService, private router: Router,
              private genreService: GenreService, private herstellerService: HerstellerService,
              private kategorieService: KategorieService, private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.movieForm = new FormGroup({
      'id': new FormControl(),
      'trailer': new FormControl(),
      'releaseDate': new FormControl(),
      'serien_ratings': new FormControl(),
      'pictures': new FormControl(),
      'name': new FormControl('',[Validators.required]),
      'genres': new FormControl('',[Validators.required]),
      'hersteller': new FormControl('',[Validators.required]),
      'kategorie': new FormControl('',[Validators.required]),
      'directors': new FormControl('',[Validators.required])
    });

    this.genreService.getAll()
      .subscribe(genre => {
        this.genreOptions = genre;
      });

    this.herstellerService.getAll()
      .subscribe(hersteller => {
        this.herstellerOptions = hersteller;
      });

    this.kategorieService.getAll()
      .subscribe(kategorien => {
        this.kategorieOptions = kategorien;
      });

    this.personService.getAll()
      .subscribe(persons => {
        this.directorOptions = persons;
      });

    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.movieService.getById(this.id)
        .subscribe((response) => {
          this.movie = response;
          this.movie.directors = this.movie.directors[0];
          this.movie.hersteller = this.movie.hersteller.id;
          this.movie.kategorie = this.movie.kategorie.id;
          alert(JSON.stringify(this.movie));
          var i = 0;
          this.movie.genres.forEach(gen => {
            this.genreService.getByName(gen).subscribe(fullGen => {
              i = i + 1;
              this.genre_zwischen.push(fullGen);
              if(this.movie.genres.length === i) {
                this.movie.genres = this.genre_zwischen;
                alert(JSON.stringify(this.genre_zwischen));
                this.movie.genres = this.movie.genres.map(ele => {
                  return ele.id;
                });
                this.movieForm.setValue(this.movie);
              }
            })
          });

          this.movieForm.setValue(this.movie);

          this.http.get('/api/media/'+ this.movie.pictures[0].id, {responseType:
              'blob'}).subscribe((blob: Blob) => {
            const fileURL = URL.createObjectURL(blob);
            this.movieBild = fileURL;
          });
        });
    }
  }

  saveMovie() {
    const movie = this.movieForm.value;
    this.choosenGenres = movie.genres.map(ele => {
      return 'http://localhost:8080/genres/'+ele;
    });
    if (movie.id) {
      this.movieService.update({
        id: movie.id,
        name: movie.name,
        kategorie: 'http://localhost:8080/kategories/' + movie.kategorie,
        genres: this.choosenGenres,
        directors: ['http://localhost:8080/directors/' + movie.directors],
        hersteller: 'http://localhost:8080/herstellers/' + movie.hersteller
      })
        .subscribe((response: any) => {
          this.router.navigate(['/movie-show', response.id]);
        });
    } else {
      this.movieService.create({
        name: movie.name,
        kategorie: 'http://localhost:8080/kategories/' + movie.kategorie,
        genres: this.choosenGenres,
        directors: ['http://localhost:8080/directors/' + movie.directors],
        hersteller: 'http://localhost:8080/herstellers/' + movie.hersteller,
        pictures: ['http://localhost:8080/medias/' + this.movieForm.value.pictures[0].id]
      })
        .subscribe((response: any) => {
            this.router.navigate(['/movie-show', response.id]);
        });
    }
  }
}
