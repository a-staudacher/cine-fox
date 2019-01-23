import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class GenreService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/dto/genres/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getByName(name) {
    return this.http.get('api/genres/search/findByName?name=' + name);
  }

  getAll() {
    return this.http.get('/api/genres').pipe(
      map((response: any) => {
        return response._embedded.genres;
      })
    );
  }

  delete(genre) {
    return this.http.delete('/api/genres/' + genre.id);
  }

  update(genres) {
    return this.http.put('/api/dto/genres/' + genres.id, genres);
  }

  create(genres) {
    return this.http.post('/api/dto/genres', genres);
  }

}

