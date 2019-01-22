import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../api/user';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ProfileEditService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/dto/user/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/user').pipe(
      map((response: any) => {
        return response._embedded.user;
      })
    );
  }

  delete(user) {
    return this.http.delete('/api/user/' + user.id);
  }

  update(user: User) {
    return this.http.put('/api/user/' + user.id, user);
  }

  create(user: User) {
    return this.http.post('/api/user', user);
  }

}

