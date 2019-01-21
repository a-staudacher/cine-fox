import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/dto/series/' + id).pipe(map((res: any) => {
      if (res.releaseDate) {
        res.releaseDate = new Date(res.releaseDate);
      }
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/series').pipe(
      map((response: any) => {
        return response._embedded.series;
      })
    );
  }

  delete(serie) {
    return this.http.delete('/api/series/' + serie.id);
  }

  update(serie) {
    return this.http.put('/api/dto/series/' + serie.id, serie);
  }

  create(serie) {
    return this.http.post('/api/dto/series', serie);
  }

}

