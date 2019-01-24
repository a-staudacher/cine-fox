import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {ProfileEditService} from '../service/profile-edit.service';
import {FavoriteService} from '../service/favorite.service';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.scss']
})
export class ProfileEditComponent implements OnInit {

  profileeditForm;
  shouldNavigateToList: boolean
  favorite = [];

  constructor(private profileEditService: ProfileEditService, private route: ActivatedRoute, private router: Router, private favoriteService: FavoriteService) { }

  ngOnInit() {

    this.profileeditForm = new FormGroup({
      'id': new FormControl(),
      'username': new FormControl(),
      'profilePicture': new FormControl(),
      'favorite': new FormControl()
    });

    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.profileEditService.getById(id)
        .subscribe((response) => {
          this.profileeditForm.setValue(response);
        });
    }
  }


  saveProfile() {

    const profile = this.profileeditForm.value;
    if (profile.id) {
      this.profileEditService.update(profile)
        .subscribe((response) => {
          alert('updated successfully');
          this.profileeditForm.setValue(response);
          if (this.shouldNavigateToList) {
            this.navigateToList();
          }
        });
    }
  }
  navigateToList() {
    this.router.navigate(['/profileedit-form']);
  }

  deleteFavourite() {}
}
