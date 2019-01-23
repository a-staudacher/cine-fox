import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/dto/charakters/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/charakters').pipe(
      map((response: any) => {
        return response._embedded.charakters;
      })
    );
  }

  delete(charakter) {
    return this.http.delete('/api/charakters/' + charakter.id);
  }

  update(charakters) {
    return this.http.put('/api/dto/charakters/' + charakters.id, charakters);
  }

  create(charakters) {
    return this.http.post('/api/dto/charakters', charakters);
  }

  getBySerie(id) {
    return this.http.get('/api/charakters/search/findBySerieId?id=' + id).pipe(
      map((response: any) => {
        return response._embedded.charakters;
      })
    );
  }

}

