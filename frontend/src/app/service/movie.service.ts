import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http: HttpClient) {
  }

  getById(id: number) {
    return this.http.get('/api/dto/series/' + id.toString()).pipe(map((res: any) => {
      if (res.releaseDate) {
        res.releaseDate = new Date(res.releaseDate);
      }
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/dto/series/').pipe(
      map((response: any) => {
        return response;
      })
    );
  }

  delete(serie) {
    return this.http.delete('/api/series/' + serie.id);
  }

  update(serie) {
    return this.http.put('/api/series/' + serie.id, serie);
  }

  create(serie) {
    return this.http.post('/api/series', serie);
  }


  searchMovieByName(search) {
    return this.http.get('/api/series/search/findByNameContainingAllIgnoreCase?name=' + search).pipe(
      map((response: any) => {
        return response._embedded.series;
      })
    );
  }

}

