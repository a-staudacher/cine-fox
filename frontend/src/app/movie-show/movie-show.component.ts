import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-movie-show',
  templateUrl: './movie-show.component.html',
  styleUrls: ['./movie-show.component.scss']
})
export class MovieShowComponent implements OnInit {
  movieRateForm;

  constructor(private router: Router) { }

  ngOnInit() {
    this.movieRateForm = new FormGroup({
      'rating': new FormControl()
    });
  }

  rateMovie() { }

  editMovie()
  {
    this.router.navigate(['/movie-form']);
  }

}
