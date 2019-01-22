import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class KategorieService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/dto/kategories/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/kategories').pipe(
      map((response: any) => {
        return response._embedded.kategories;
      })
    );
  }

  delete(kategorie) {
    return this.http.delete('/api/kategories/' + kategorie.id);
  }

  update(kategories) {
    return this.http.put('/api/dto/kategories/' + kategories.id, kategories);
  }

  create(kategories) {
    return this.http.post('/api/dto/kategories', kategories);
  }

}

