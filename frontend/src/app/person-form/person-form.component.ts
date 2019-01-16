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
      'picture': new FormControl(),
      // 'movies': new FormControl(),
      'dayOfBirth': new FormControl()
    });
  }

  savePerson() {

    const actor = this.personForm.value;
    if (actor.id) {
      this.personService.update(actor)
        .subscribe((response) => {
          alert('updated successfully');
          this.personForm.setValue(response);
          /*if (this.shouldNavigateToList) {
            this.navigateToList();
          }*/
        });
    } else {
      this.personService.create(actor)
        .subscribe((response: any) => {
          alert('created successfully');
          /*if (this.shouldNavigateToList) {
            this.navigateToList();
          } else {
            this.router.navigate(['/person-form', response.id]);
          }*/
        });
    }
  }

  navigateToList() {
    this.router.navigate(['/person-form']);
  }

  /*setShouldNavigateToList() {
    this.shouldNavigateToList = true;
  }*/

}
