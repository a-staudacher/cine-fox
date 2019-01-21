import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class HerstellerService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/dto/herstellers/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/herstellers').pipe(
      map((response: any) => {
        return response._embedded.herstellers;
      })
    );
  }

  delete(hersteller) {
    return this.http.delete('/api/herstellers/' + hersteller.id);
  }

  update(herstellers) {
    return this.http.put('/api/dto/herstellers/' + herstellers.id, herstellers);
  }

  create(herstellers) {
    return this.http.post('/api/dto/herstellers', herstellers);
  }

}

