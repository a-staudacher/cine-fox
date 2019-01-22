import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class FavoriteService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/dto/favorites/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/favorites').pipe(
      map((response: any) => {
        return response._embedded.favorites;
      })
    );
  }

  delete(favorite) {
    return this.http.delete('/api/favorites/' + favorite.id);
  }

  update(favorites) {
    return this.http.put('/api/dto/favorites/' + favorites.id, favorites);
  }

  create(favorites) {
    return this.http.post('/api/dto/favorites', favorites);
  }

}

