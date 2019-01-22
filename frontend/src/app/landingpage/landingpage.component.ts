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
  resourceUrl = 'api/medias';
  movies = [];

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
      this.initPreviews();
    });

    this.movieService.getAll()
      .subscribe((movies) => {
        this.movies = movies;
      });

  }

  initPreviews() {
    this.medias.forEach((media, index) => {
      if (media.id && !this.movies[index]) {
        this.http.get(`${this.resourceUrl}/${media.id}`, {
          responseType:
            'blob'
        }).subscribe((blob: Blob) => {
          const fileURL = URL.createObjectURL(blob);
          this.movies[index].url = fileURL;

          this.movies.forEach((movie, index_mov) => {
            if (movie.id === media.movie.id) {
              movie.url = fileURL;
            }
          });
        });
      }
    });
  }
}
