import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {getNameText} from '@angular/compiler-cli/src/ngcc/src/utils';

@Injectable({
  providedIn: 'root'
})
export class CharaktersService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get('/api/charakters').pipe(map((response: any) => {
      return response._embedded.charakters;
    }));
  }
}
