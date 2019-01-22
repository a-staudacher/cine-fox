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

  landingpageForm;
 /* moviename = 'Tarzan the Ape Man';*/
  movies = [];
  test;
/*  moviesInit = false;
  mediaInit = false;*/

  medias: IMedia[];

  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router, private mediasService: MediaService,
              private movieService: MovieService) { }

  ngOnInit() {

    this.landingpageForm = new FormGroup({
      'id': new FormControl(),
      'name': new FormControl()
    });
    this.mediasService.getAll()
      .subscribe((medias: any) => {
      this.medias = medias;
      /*alert('got medias' + this.medias.length);
      this.mediaInit = true;*/
      //this.initPreviews();
    });

    this.movieService.getAll()
      .subscribe((movies) => {
        this.movies = movies;
        /*alert('got movies' + this.movies.length);
        this.moviesInit = true;*/
       // this.initPreviews();
      });

      this.http.get('api/medias/1', {
        responseType:
          'blob'
      }).subscribe((blob: Blob) => {
        const fileURL = URL.createObjectURL(blob);
        this.test = fileURL;
      });
  }

  initPreviews() {
  /*  if (this.mediaInit && this.moviesInit) {*/
      this.medias.forEach((media, index) => {
        if (media.id && !this.movies[index]) {
          this.http.get('api/medias' + media.id, {
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
