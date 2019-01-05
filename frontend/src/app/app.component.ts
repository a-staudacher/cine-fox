import { Component } from '@angular/core';
import {UpdateService} from './service/update.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';
  constructor(updateService: UpdateService) {
  }
}
