import { Component, ElementRef, forwardRef, OnInit } from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from '@angular/forms';
import {FileItem, FileUploader, ParsedResponseHeaders} from 'ng2-file-upload';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {MediaService} from '../service/media.service';
import {MovieService} from '../service/movie.service';


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
/*  moviesInit = false;
  mediaInit = false;*/

  medias: IMedia[];

  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router, private mediasService: MediaService,
              private movieService: MovieService) { }

  ngOnInit() {

    this.movieForm = new FormGroup({
      'id': new FormControl(),
      'name': new FormControl(),
      'trailer': new FormControl(),
      'anzahl': new FormControl(),
      'releaseDate': new FormControl(),
      'genres': new FormControl()
    });

    this.mediasService.getAll()
      .subscribe((medias: any) => {
      this.medias = medias;
      /*alert('got medias' + this.medias.length);
      this.mediaInit = true;*/
      this.initPreviews();
    });

    this.movieService.getAll()
      .subscribe((movies) => {
        this.movies = movies;
        /*alert('got movies' + this.movies.length);
        this.moviesInit = true;*/
        this.movieForm.setValue(movies[0]);
        alert('test');
        this.initPreviews();
      });

      this.http.get(`${this.resourceUrl}/${1}`, {
        responseType:
          'blob'
      }).subscribe((blob: Blob) => {
        const fileURL = URL.createObjectURL(blob);
        this.movies[0].url = fileURL;
      });
  }

  initPreviews() {
  /*  if (this.mediaInit && this.moviesInit) {*/
      this.medias.forEach((media, index) => {
        if (media.id && !this.movies[index]) {
          this.http.get(`${this.resourceUrl}/${media.id}`, {
            responseType:
              'blob'
          }).subscribe((blob: Blob) => {
            const fileURL = URL.createObjectURL(blob);
            this.movies[index].url = fileURL;

            this.movies.forEach((movie, index_mov) => {
              if (true/*movie.id === media.movie.id*/) {
                movie.url = fileURL;
              }
            });
          });
        }
      });
 /*   }*/
  }
}
