import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../service/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
  }

  isLoggedIn() {
    return this.userService.isLoggedIn;
  }

  isAdmin() {
    return this.userService.isAdmin;
  }

  logout() {
    this.userService.logout();
  }

}
