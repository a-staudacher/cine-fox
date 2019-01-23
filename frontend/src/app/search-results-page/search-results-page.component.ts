import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PersonService} from '../service/person.service';
import {MovieService} from '../service/movie.service';

@Component({
  selector: 'app-search-results-page',
  templateUrl: './search-results-page.component.html',
  styleUrls: ['./search-results-page.component.scss']
})
export class SearchResultsPageComponent implements OnInit {
  search;
  searchResult = [];

  constructor(private router: Router, private route: ActivatedRoute, private movieService: MovieService) { }

  ngOnInit() {
    this.search = this.route.snapshot.paramMap.get('search');

    this.movieService.searchMovieByName(this.search)
      .subscribe((response) => {
        this.searchResult = response;
      });

    this.router.events.subscribe((val) => {
      this.movieService.searchMovieByName(this.search)
        .subscribe((response) => {
          this.searchResult = response;
        });
    });

  }

  searchMovies(text) {
    this.movieService.searchMovieByName(text)
      .subscribe((response) => {
        this.searchResult = response;
      });
  }

}
