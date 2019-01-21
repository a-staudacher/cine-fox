import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-landingpage',
  templateUrl: './landingpage.component.html',
  styleUrls: ['./landingpage.component.scss']
})
export class LandingpageComponent implements OnInit {

  landingpageForm;
  moviename = 'Tarzan the Ape Man';

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.landingpageForm = new FormGroup({
      'id': new FormControl(),
      'name': new FormControl()
    });

  }

}
