import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Person} from '../api/person';
import {PersonService} from '../service/person.service';
import {MovieService} from '../service/movie.service';
import {CharacterService} from '../service/character.service';
import {HttpClient} from '@angular/common/http';
import {Series_ratingService} from '../service/series_rating.service';
import {UserService} from '../service/user.service';
import {map} from 'rxjs/operators';
import {forEach} from '@angular/router/src/utils/collection';
import {ReviewService} from '../service/review.service';

@Component({
  selector: 'app-movie-show',
  templateUrl: './movie-show.component.html',
  styleUrls: ['./movie-show.component.scss']
})
export class MovieShowComponent implements OnInit {
  movieRateForm;
  addActorForm;
  movieBild;
  movie;
  reviews = [];
  fullReviews = [];
  personOptions;
  id;
  avgRating = 0;
  ownRating = 0;
  ownRatingId = 0;
  actors = [];

  constructor(private movieService: MovieService, private router: Router, private route: ActivatedRoute,
              private characterService: CharacterService, private personService: PersonService, private http: HttpClient,
              private series_ratingService: Series_ratingService, private userService: UserService,
              private reviewService: ReviewService) { }

  ngOnInit() {
    this.movieRateForm = new FormGroup({
      'rating': new FormControl(),
      'avgRating': new FormControl()
    });
    this.addActorForm = new FormGroup({
      'name': new FormControl(),
      'person': new FormControl()
    });


    this.personService.getAll()
      .subscribe(persons => {
        this.personOptions = persons;
        //this.personOptions.push({nachname: 'Gartner'});
      });

    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.movieService.getById(this.id)
        .subscribe((response) => {
          this.movie = response;
          this.movie.serien_ratings.forEach((rating) => {
            this.avgRating = this.avgRating + rating.rating;
            this.series_ratingService.getRatingUser(rating.id).subscribe((usr) => {
              // if user current logged in
              if(this.userService.loggedInUserId === usr.id) {
                this.ownRating = rating.rating;
                this.ownRatingId = rating.id;
                this.movieRateForm.controls.rating.setValue(rating.rating);
              }
            })
          });
          this.avgRating = this.avgRating / this.movie.serien_ratings.length;
          this.movieRateForm.controls.avgRating.setValue(this.avgRating);

          //this.movie.charakters = [{name: 'Der Bettler', person: {vorname: 'Florian', nachname: 'Gartner'}}
          //, {name: 'Der Gesuchte', person: {vorname: 'Georg', nachname: 'Schmitzer'}}];

          this.http.get('/api/media/'+ this.movie.pictures[0].id, {responseType:
              'blob'}).subscribe((blob: Blob) => {
            const fileURL = URL.createObjectURL(blob);
            this.movieBild = fileURL;
          });
        });
      this.reviewService.getBySerie(this.id).subscribe((reviews: any) => {
        this.reviews = reviews;
        this.reviews.forEach((rev)=> {
          this.reviewService.getReviewUserById(rev.id).subscribe((usr) => {
            this.fullReviews.push({review: rev, user: usr});
          });
        });
      });
      this.characterService.getBySerie(this.id).subscribe(chars => {
        chars.forEach((char)=> {
          this.characterService.getById(char.id).subscribe((fullChar => {
            this.actors.push(fullChar);
          }));
        });
      });
    }
  }

  rateMovie() {
    if(this.ownRatingId === 0) {
      this.series_ratingService.create({
        rating: this.movieRateForm.value.rating,
        user: 'http://localhost:8080/users/' + this.userService.loggedInUserId,
        serie : 'http://localhost:8080/series/' + this.id
      }).subscribe((newRating: any)=>{
        this.ownRatingId = newRating.id;
        this.updateRatingView();
      });
    }
    else {
      this.series_ratingService.update({
        id: this.ownRatingId,
        rating: this.movieRateForm.value.rating,
        user: 'http://localhost:8080/users/' + this.userService.loggedInUserId,
        serie: 'http://localhost:8080/series/' + this.id
      }).subscribe(()=>{
        this.updateRatingView();
      });
    }
  }

  updateRatingView() {
    this.avgRating = 0;
    this.movieService.getById(this.id)
      .subscribe((response) => {
        this.movie = response;
        this.movie.serien_ratings.forEach((rating) => {
          this.avgRating = this.avgRating + rating.rating;
        });
        this.avgRating = this.avgRating / this.movie.serien_ratings.length;
        this.movieRateForm.controls.avgRating.setValue(this.avgRating);
      });
  }

  editMovie() {
    this.router.navigate(['/movie-form/' + this.id]);
  }

  editChar(id) {
    this.router.navigate(['/person-form/' + id]);
  }

  deleteChar(charakter) {
    this.characterService.delete(charakter).subscribe( () => {
      alert('Character deleted.');
      this.actors = this.actors.filter((char)=> {
        return char.id != charakter.id;
      })
    });
  }

  addActor() {
    this.characterService.create({
      name: this.addActorForm.value.name,
      person: 'http://localhost:8080/persons/' + this.addActorForm.value.person,
      serie: 'http://localhost:8080/series/' + this.id
      }
    ).subscribe((acc: any) => {
      this.characterService.getById(acc.id).subscribe((fullChar => {
        this.actors.push(fullChar);
      }));
    });
    // this.characterService.create(this.addActorForm.value);
  }

  postReview(reviewText) {
    this.reviewService.create({
      "reviewText": reviewText,
      user: 'http://localhost:8080/users/' + this.userService.loggedInUserId,
      serie: 'http://localhost:8080/series/' + this.id
    }).subscribe((newReview: any) => {
      this.reviewService.getReviewUserById(newReview.id).subscribe((usr) => {
        this.fullReviews.push({review: newReview, user: usr});
      });
    });
  }

}
