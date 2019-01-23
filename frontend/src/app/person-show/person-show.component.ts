import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {PersonService} from '../service/person.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Person} from '../api/person';
import {CharacterService} from '../service/character.service';
import {DirectorsService} from '../service/directors.service';
import {HttpClient} from '@angular/common/http';
import {Charakter} from '../api/charakter';
import {Director} from '../api/director';
import {Serie} from '../api/serie';
import {MovieService} from '../service/movie.service';

@Component({
  selector: 'app-person-show',
  templateUrl: './person-show.component.html',
  styleUrls: ['./person-show.component.scss']
})
export class PersonShowComponent implements OnInit {

  personShow;
  person;
  movie;
  character;
  director;

  constructor(private personService: PersonService, private http: HttpClient, private route: ActivatedRoute, private router: Router,
              private characterService: CharacterService, private directorsService: DirectorsService, private movieService: MovieService) { }

  ngOnInit() {

    this.personShow = new FormGroup({
      'id': new FormControl(),
      'vorname': new FormControl(),
      'nachname': new FormControl(),
      'charakters': new FormControl(),
      'directors': new FormControl(),
      'picture': new FormControl(),
      'dayOfBirth': new FormControl()
    });

    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.personService.getById(id)
        .subscribe((response) => {
          this.person = <Person>response;
        });
    }
    if (this.person) {
      this.personShow.setValue(this.person);
    }
    }

}

