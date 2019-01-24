import { Component, ElementRef, forwardRef, OnInit } from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from '@angular/forms';
import {FileItem, FileUploader, ParsedResponseHeaders} from 'ng2-file-upload';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {MediaService} from '../service/media.service';
import {MovieService} from '../service/movie.service';
import {Genre} from '../api/genre';

export interface IMedia {
  id?: number;
  originalFileName?: string;
  contentType?: string;
  size?: number;
  movie?: any;
}

@Component({
  selector: 'app-landingpage',
  templateUrl: './landingpage.component.html',
  styleUrls: ['./landingpage.component.scss']
})
export class LandingpageComponent implements OnInit {

  movieForm;
 /* moviename = 'Tarzan the Ape Man';*/
  resourceUrl = 'api/medias';
  movies = [];
  test7 = {url: ''};
  moviePictures = [];
  joinedMovies = [];
  genremovies;

  medias: IMedia[];

  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router, private mediasService: MediaService,
              private movieService: MovieService) { }

  ngOnInit() {
    declare var reload_js;
    reload_js();
    this.mediasService.getAll()
      .subscribe((medias: any) => {
      this.medias = medias;
      // this.initPreviews();
    });

    this.movieService.getAll()
      .subscribe((movies) => {
        this.movies = movies;

        /*alert('got movies' + this.movies.length);
        this.moviesInit = true;*/
        this.initPreviews();
        /*this.movies.forEach((movie) => {
          this.http.get(movie._links.genres.href).subscribe()
          this.joinedMovies.push({movie: movie, genres: });
        });*/
      });


    this.http.get('/api/media/1', {responseType:
        'blob'}).subscribe((blob: Blob) => {
      const fileURL = URL.createObjectURL(blob);
      this.test7.url = fileURL;
    });
  }

 /* getUrl(movieid) {
    return this.moviePictures.filter({movieID: movie.id} === media.movie.url);
    // suchst den Eintrag der die movieID hat, und von diesem gibst du die URL zurück.
  }*/

  initPreviews() {
    alert(JSON.stringify(this.movies[0]));
    this.movies.forEach((movie, index) => {
      if(movie.pictures[0])
      {
      this.http.get('/api/media/' + movie.pictures[0].id, {responseType:
          'blob'}).subscribe((blob: Blob) => {
        const fileURL = URL.createObjectURL(blob);
        this.moviePictures.push({movie: movie, url: fileURL})
      });
      }
    });
  }

  addFav(movId) {
    alert('Add mov to fav ' + movId);
  }

  arrayOne(n, avg = 0) {
    if (n.length > 0) {
      for (var i = 0; i < n.length; i++) {
        avg = avg + n[i].rating;
      }
      avg = avg / n.length;
    }
    return Array(Math.floor(avg));
  }
}
