import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Profile} from '../api/profile';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ProfileEditService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/profile/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/profile').pipe(
      map((response: any) => {
        return response._embedded.profile;
      })
    );
  }

  delete(profile) {
    return this.http.delete('/api/profile/' + profile.id);
  }

  update(profile: Profile) {
    return this.http.put('/api/profile/' + profile.id, profile);
  }

  create(profile: Profile) {
    return this.http.post('/api/profile', profile);
  }

}

