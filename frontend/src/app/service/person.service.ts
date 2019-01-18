import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Person} from '../api/person';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/dto/person/' + id).pipe(map((res: any) => {
      if (res.dayOfBirth) {
        res.dayOfBirth = new Date(res.dayOfBirth);
      }
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/person').pipe(
      map((response: any) => {
        return response._embedded.persons;
      })
    );
  }

  delete(person) {
    return this.http.delete('/api/person/' + person.id);
  }

  update(person: Person) {
    return this.http.put('dto/api/person/' + person.id, person);
  }

  create(person: Person) {
    return this.http.post('/api/dto/person', person);
  }

}

