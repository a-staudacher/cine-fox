import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
/*import {media} from '../api/medias';*/
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class MediaService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/dto/medias/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/medias').pipe(
      map((response: any) => {
        return response._embedded.medias;
      })
    );
  }

  delete(media) {
    return this.http.delete('/api/medias/' + media.id);
  }

  update(media) {
    return this.http.put('/api/dto/medias/' + media.id, media);
  }

  create(media) {
    return this.http.post('/api/dto/medias', media);
  }

}

