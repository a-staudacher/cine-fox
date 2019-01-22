import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {PersonService} from '../service/person.service';
import {MovieService} from '../service/movie.service';
import {Router} from '@angular/router';
import {GenreService} from '../service/genre.service';
import {HerstellerService} from '../service/hersteller.service';
import {KategorieService} from '../service/kategorie.service';

@Component({
  selector: 'app-movie-form',
  templateUrl: './movie-form.component.html',
  styleUrls: ['./movie-form.component.scss']
})
export class MovieFormComponent implements OnInit {
  movieForm;
  genreOptions;
  herstellerOptions;
  kategorieOptions;
  directorOptions;
  shouldNavigateToList: boolean;
  constructor(private personService: PersonService, private movieService: MovieService, private router: Router,
              private genreService: GenreService, private herstellerService: HerstellerService,
              private kategorieService: KategorieService) { }

  ngOnInit() {
    this.movieForm = new FormGroup({
      'picture': new FormControl(),
      'name': new FormControl(),
      'genre': new FormControl(),
      'hersteller': new FormControl(),
      'kategorie': new FormControl(),
      'director': new FormControl()
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
  }

  saveMovie() {
    const movie = this.movieForm.value;
    if (movie.id) {
      this.movieService.update(movie)
        .subscribe((response) => {
          this.movieForm.setValue(response);
          if (this.shouldNavigateToList) {
            this.navigateToList();
          }
        });
    } else {
      this.movieService.create(movie)
        .subscribe((response: any) => {
          if (this.shouldNavigateToList) {
            this.navigateToList();
          } else {
            this.router.navigate(['/movie-form', response.id]);
          }
        });
    }
  }

  navigateToList() {
    this.router.navigate(['/actor-list']);
  }

  setShouldNavigateToList() {
    this.shouldNavigateToList = true;
  }

}
