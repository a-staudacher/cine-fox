import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CharakterService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get('/api/charakters').pipe(map((response: any) => {
      return response._embedded.movies;
    }));
  }
}
