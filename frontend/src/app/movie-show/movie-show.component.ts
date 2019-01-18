import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-movie-show',
  templateUrl: './movie-show.component.html',
  styleUrls: ['./movie-show.component.scss']
})
export class MovieShowComponent implements OnInit {
  movieRateForm;

  constructor() { }

  ngOnInit() {
    this.movieRateForm = new FormGroup({
      'rating': new FormControl()
    });
  }

  rateMovie() { }

}
