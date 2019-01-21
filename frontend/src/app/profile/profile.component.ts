import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProfileEditService} from '../service/profile-edit.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  proflieForm;
  username = 'Max Mustermann'

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.proflieForm = new FormGroup({
      'id': new FormControl(),
      'name': new FormControl()
    });
  }
}
