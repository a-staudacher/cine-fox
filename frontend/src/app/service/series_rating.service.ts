import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class Series_ratingService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/serienRatings/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getRatingUser(id){
    return this.http.get('/api/serienRatings/' + id + '/user').pipe(map((res: any) => {
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/serienRatings').pipe(
      map((response: any) => {
        return response._embedded.series_ratings;
      })
    );
  }

  delete(series_rating) {
    return this.http.delete('/api/serienRatings/' + series_rating.id);
  }

  update(series_ratings) {
    return this.http.put('/api/serienRatings/' + series_ratings.id, series_ratings);
  }

  create(series_ratings) {
    return this.http.post('/api/serienRatings', series_ratings);
  }

}

