import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http: HttpClient) {
  }

  getById(id: number) {
    return this.http.get('/api/reviews/' + id.toString()).pipe(map((res: any) => {
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/reviews/').pipe(
      map((response: any) => {
        return response;
      })
    );
  }

  getBySerie(id) {
    return this.http.get('api/reviews/search/findBySerieId?id=' + id).pipe(
      map((response: any) => {
        return response._embedded.reviews;
      })
    );
  }

  getReviewUserById(id: number) {
    return this.http.get('/api/reviews/' + id.toString() + '/user').pipe(map((res: any) => {
      return res;
    }));
  }

  create(review) {
    return this.http.post('/api/reviews', review);
  }

}

