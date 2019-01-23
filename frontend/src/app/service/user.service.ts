import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map, reduce} from 'rxjs/operators';
import {Router} from '@angular/router';
import {Observable, of, Subject} from 'rxjs';
import {JwtHelperService} from '@auth0/angular-jwt';
import {Person} from '../api/person';
import {forEach} from '@angular/router/src/utils/collection';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  isLoggedIn = false;
  loggedInChange: Subject<boolean> = new Subject<boolean>();
  jwtHelperService: JwtHelperService;
  loggedInUser;
  loggedInUserId;

  accessTokenLocalStorageKey = 'access_token';

  constructor(private http: HttpClient, private router: Router) {
    this.jwtHelperService = new JwtHelperService();
    const token = localStorage.getItem(this.accessTokenLocalStorageKey);
    if (token) {
      console.log('Token expiration date: '
        + this.jwtHelperService.getTokenExpirationDate(token));
      this.isLoggedIn = !this.jwtHelperService.isTokenExpired(token);
      this.loggedInUser = this.jwtHelperService.decodeToken(token).sub;
      this.getUserByUsername(this.loggedInUser).subscribe((usr: any) => {
        this.loggedInUserId = usr.id;
      })
    }
    this.loggedInChange.subscribe((value) => {
      this.isLoggedIn = value;
    });
  }

  login(user) {
    return this.http.post('/api/auth/', user, {
      'headers': new HttpHeaders({'Content-Type': 'application/json'}),
      'responseType': 'text',
      observe: 'response'
    }).pipe(map((res: any) => {
      const token = res.headers.get('Authorization').replace(/^Bearer /, '');
      localStorage.setItem(this.accessTokenLocalStorageKey, token);
      this.loggedInUser = this.jwtHelperService.decodeToken(token).sub;
      this.getUserByUsername(this.loggedInUser).subscribe((usr: any) => {
        this.loggedInUserId = usr.id;
      })
      this.loggedInChange.next(true);
      this.router.navigate(['']);
      return res;
    }));
  }

  logout() {
    localStorage.removeItem(this.accessTokenLocalStorageKey);
    this.loggedInChange.next(false);
    this.router.navigate(['']);
  }

  getAll() {
    return this.http.get('/api/dto/users');
  }

  getUserByUsername(username) {
    return this.http.get('api/users/search/findByUsername?username=' + username);
  }

  isUsernameTaken(value: string, duplicate = false): Observable<boolean> {
    return this.getAll().pipe(map((res: any) => {
      for (let usr of res) {
        if (usr.username === value) {
          duplicate = true;
        }
      }
      return duplicate;
    }));
  }

  create(user) {
    return this.http.post('/api/dto/user', user);
  }
}
