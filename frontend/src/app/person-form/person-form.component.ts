import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Person} from '../api/person';
import {ActivatedRoute, Router} from '@angular/router';
import {PersonService} from '../service/person.service';
import {CharaktersService} from '../service/charakters.service';
import {FormBuilder, FormControl, FormGroup, Validator, Validators} from '@angular/forms';
import { DatePipe } from '@angular/common';
import {min, timestamp} from 'rxjs/operators';
import {getDay, getMonth} from 'ngx-bootstrap';
import {formatDate} from '@angular/common';
import {daysInMonth} from 'ngx-bootstrap/chronos/units/month';
import {format} from 'util';
import {DirectorsService} from '../service/directors.service';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.scss']
})
export class PersonFormComponent implements OnInit {

  personForm;
  shouldNavigateToList: boolean;
  directorsOptions;
  charaktersOptions;

  constructor(private personService: PersonService, private route: ActivatedRoute, private router: Router,
              private charaktersService: CharaktersService, private directorsService: DirectorsService) { }

  ngOnInit() {

    this.personForm = new FormGroup({
      'id': new FormControl(),
      'vorname': new FormControl('', [Validators.required]),
      'nachname': new FormControl('', [Validators.required]),
      'charakters': new FormControl(),
      'directors': new FormControl(),
      'beschreibung': new FormControl(),
      'pictures': new FormControl([]),
      'dayOfBirth': new FormControl()
    });

    this.charaktersService.getAll()
      .subscribe((charakters: any) => {
        this.charaktersOptions = charakters;
      });

    this.directorsService.getAll()
      .subscribe((directors: any) => {
        this.directorsOptions = directors;
      });

    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.personService.getById(id)
        .subscribe((response) => {
          this.personForm.setValue(response);
        });
    }
  }

  savePerson() {

    const person = this.personForm.value;
    if (person.id) {
      this.personService.update(person)
        .subscribe((response) => {
          alert('updated successfully');
          this.personForm.setValue(response);
          this.router.navigate(['/person-show/' + person.id]);
        });
    } else {
      this.personService.create(person)
        .subscribe((response: any) => {
          alert('created successfully');
          if (this.shouldNavigateToList) {
            this.router.navigate(['/person-show', response.id]);
          }
        });
    }
  }

  setShouldNavigateToList() {
    this.shouldNavigateToList = true;
  }

}
