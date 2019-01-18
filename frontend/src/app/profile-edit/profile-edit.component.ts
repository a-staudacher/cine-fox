import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.scss']
})
export class ProfileEditComponent implements OnInit {

  profileeditForm;
  username = 'Max Mustermann'

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.profileeditForm = new FormGroup({
      'id': new FormControl(),
      'name': new FormControl()
    });
  }


  saveProfile() {

    const actor = this.profileeditForm.value;
    if (actor.id) {
      this.profileeditService.update(actor)
        .subscribe((response) => {
          alert('updated successfully');
          this.profileeditForm.setValue(response);
          /*if (this.shouldNavigateToList) {
            this.navigateToList();
          }*/
        });
    } else {
      this.profileeditService.create(actor)
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
