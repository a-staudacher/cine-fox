import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {PersonService} from '../service/person.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Person} from '../api/person';

@Component({
  selector: 'app-person-show',
  templateUrl: './person-show.component.html',
  styleUrls: ['./person-show.component.scss']
})
export class PersonShowComponent implements OnInit {

  personShow;
  person;

  constructor(private personService: PersonService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.personShow = new FormGroup({
      'id': new FormControl(),
      'vorname': new FormControl(),
      'nachname': new FormControl(),
      'charakter': new FormControl(),
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
