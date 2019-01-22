import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Person} from '../api/person';
import {PersonService} from '../service/person.service';
import {MovieService} from '../service/movie.service';
import {CharacterService} from '../service/character.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-movie-show',
  templateUrl: './movie-show.component.html',
  styleUrls: ['./movie-show.component.scss']
})
export class MovieShowComponent implements OnInit {
  movieRateForm;
  addActorForm;
  movieBild;
  movie = {name: '', charakters: [], ratings: []};
  personOptions;
  id;

  constructor(private movieService: MovieService, private router: Router, private route: ActivatedRoute,
              private characterService: CharacterService, private personService: PersonService, private http: HttpClient) { }

  ngOnInit() {
    this.http.get('/api/media/1', {responseType:
        'blob'}).subscribe((blob: Blob) => {
      const fileURL = URL.createObjectURL(blob);
      this.movieBild = fileURL;
    });

    this.movieRateForm = new FormGroup({
      'rating': new FormControl(),
      'avgRating': new FormControl()
    });
    this.addActorForm = new FormGroup({
      'name': new FormControl(),
      'person': new FormControl()
    });


    this.personService.getAll()
      .subscribe(persons => {
        this.personOptions = persons;
        this.personOptions.push({nachname: 'Gartner'});
      });

    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.movieService.getById(this.id)
        .subscribe((response) => {
          this.movie = response;
          this.movie.charakters = [{name: 'Der Bettler', person: {vorname: 'Florian', nachname: 'Gartner'}}
          , {name: 'Der Gesuchte', person: {vorname: 'Georg', nachname: 'Schmitzer'}}];

        });
    }

    if (true) {
      this.movieRateForm.setValue({'rating': 5, 'avgRating': 2});
    }
  }

  rateMovie() {
    alert(this.movieRateForm.value.rating);
    //this.movie.ratings.push(this.movieRateForm.value.rating);
    //this.movieService.update(this.movie);
  }

  editMovie() {
    this.router.navigate(['/movie-form']);
  }

  editChar(id) {
    this.router.navigate(['/person-form/' + id]);
  }

  deleteChar(charakter) {
    this.characterService.delete(charakter);
  }

  addActor() {
    alert(this.addActorForm.value.name);
    alert(this.addActorForm.value.person);
    // this.characterService.create(this.addActorForm.value);
  }

}
