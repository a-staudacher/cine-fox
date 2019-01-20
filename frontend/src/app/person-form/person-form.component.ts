import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Person} from '../api/person';
import {ActivatedRoute, Router} from '@angular/router';
import {PersonService} from '../service/person.service';
import {CharakterService} from '../service/charakter.service';
import {FormBuilder, FormControl, FormGroup, Validator, Validators} from '@angular/forms';
import { DatePipe } from '@angular/common'
import {min, timestamp} from 'rxjs/operators';
import {getDay, getMonth} from 'ngx-bootstrap';
import {formatDate} from '@angular/common';
import {daysInMonth} from 'ngx-bootstrap/chronos/units/month';
import {format} from 'util';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.scss']
})
export class PersonFormComponent implements OnInit {

  personForm;
  shouldNavigateToList: boolean;
  directorOptions;
  charakterOptions;

  constructor(private personService: PersonService, private route: ActivatedRoute, private router: Router,
              private charakterService: CharakterService) { }

  ngOnInit() {

    this.personForm = new FormGroup({
      'id': new FormControl(),
      'vorname': new FormControl('', [Validators.required]),
      'nachname': new FormControl('', [Validators.required]),
      //'charakter': new FormControl(),
      //'directors': new FormControl(),
      'beschreibung': new FormControl(),
      //'picture': new FormControl([]),
      'dayOfBirth': new FormControl()
    });

    this.charakterService.getAll()
      .subscribe((charakter: any) => {
        this.charakterOptions = charakter;
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
      alert(person.vorname);
      this.personService.update(person)
        .subscribe((response) => {
          alert('updated successfully');
          this.personForm.setValue(response);
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
