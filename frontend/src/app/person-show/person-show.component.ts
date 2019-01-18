import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {PersonService} from '../service/person.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-person-show',
  templateUrl: './person-show.component.html',
  styleUrls: ['./person-show.component.scss']
})
export class PersonShowComponent implements OnInit {

  personShow;

  constructor(private personService: PersonService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.personShow = new FormGroup({
      'id': new FormControl(),
      'vorname': new FormControl(),
      'nachname': new FormControl(),
      'character': new FormControl(),
      'director': new FormControl(),
      'picture': new FormControl(),
      // 'movies': new FormControl(),
      'dayOfBirth': new FormControl()
    });

    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.personService.getById(id)
        .subscribe((response) => {
          this.personShow.setValue(response);
        });
    }
  }
}
