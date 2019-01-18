import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {ProfileEditService} from '../service/profile-edit.service';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.scss']
})
export class ProfileEditComponent implements OnInit {

  profileeditForm;
  username = 'Max Mustermann'

  constructor(private route: ActivatedRoute, private router: Router, private profileeditService: ProfileEditService) { }

  ngOnInit() {

    this.profileeditForm = new FormGroup({
      'id': new FormControl(),
      'name': new FormControl()
    });
  }


  saveProfile() {

    const profile = this.profileeditForm.value;
    if (profile.id) {
      this.profileeditService.update(profile)
        .subscribe((response) => {
          alert('updated successfully');
          this.profileeditForm.setValue(response);
          /*if (this.shouldNavigateToList) {
            this.navigateToList();
          }*/
        });
    } else {
      this.profileeditService.create(profile)
        .subscribe((response: any) => {
          alert('created successfully');
          /*if (this.shouldNavigateToList) {
            this.navigateToList();
          } else {
            this.router.navigate(['/profileedit-form', response.id]);
          }*/
        });
    }
  }
  navigateToList() {
    this.router.navigate(['/profileedit-form']);
  }
}
