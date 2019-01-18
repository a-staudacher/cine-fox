import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Person} from '../api/person';
import {ActivatedRoute, Router} from '@angular/router';
import {PersonService} from '../service/person.service';
// import {MovieService} from '../service/movie.service';
import {FormBuilder, FormControl, FormGroup, Validator, Validators} from '@angular/forms';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.scss']
})
export class PersonFormComponent implements OnInit {

  personForm;
  shouldNavigateToList: boolean;

  constructor(private personService: PersonService, private route: ActivatedRoute, private router: Router,
              /*private movieService: MovieService*/) { }

  ngOnInit() {

    this.personForm = new FormGroup({
      'id': new FormControl(),
      'vorname': new FormControl(),
      'nachname': new FormControl(),
      'character': new FormControl(),
      'director': new FormControl(),
      'beschreibung': new FormControl(),
      'picture': new FormControl(),
      // 'movies': new FormControl(),
      'dayOfBirth': new FormControl()
    });
  }

  savePerson() {

    const person = this.personForm.value;
    if (person.id) {
      this.personService.update(person)
        .subscribe((response) => {
          alert('updated successfully');
          this.personForm.setValue(response);
          if (this.shouldNavigateToList) {
            this.navigateToPerson();
          }
        });
    } else {
      this.personService.create(person)
        .subscribe((response: any) => {
          alert('created successfully');
          if (this.shouldNavigateToList) {
            this.navigateToPerson();
          } else {
            this.router.navigate(['/person-show', response.id]);
          }
        });
    }
  }

  navigateToPerson() {
    this.router.navigate(['/person-form']);
  }

  setShouldNavigateToList() {
    this.shouldNavigateToList = true;
  }

}
