import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../service/user.service';
import {FormBuilder, FormControl, FormGroup, Validator, Validators} from '@angular/forms';
import {UsernameValidator} from '../usernameValidator';

@Component({
  selector: 'app-registry',
  templateUrl: './registry.component.html',
  styleUrls: ['./registry.component.scss']
})
export class RegistryComponent implements OnInit {
  registryForm;
  user;

  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router,
  private usernameValidator: UsernameValidator) {}

  ngOnInit() {

    this.registryForm = new FormGroup({
      'username': new FormControl('', {asyncValidators: [this.usernameValidator.validate.bind(this.usernameValidator)],
      updateOn: 'blur'}),
      'password': new FormControl(),
    });

  }

  register() {
    this.user = this.registryForm.value;
    this.userService.create(this.user)
      .subscribe((response: any) => {
        alert('user created successfully');
        this.router.navigate(['/index', response.id]);
      });
  }
}
