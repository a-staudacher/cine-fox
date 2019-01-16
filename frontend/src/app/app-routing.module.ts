import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {AuthGuard} from './auth.guard';
import {PersonFormComponent} from './person-form/person-form.component';
import {MovieFormComponent} from './movie-form/movie-form.component';
import {LandingpageComponent} from './landingpage/landingpage.component';
import {RegistryComponent} from './registry/registry.component';
import {ImpressumComponent} from './impressum/impressum.component';
import {ProfileComponent} from './profile/profile.component';

const routes: Routes = [
  {
    path: 'person-form', component: PersonFormComponent // , canActivate: [AuthGuard]
  },
  {
    path: 'person', redirectTo: '/person-form' // , canActivate: [AuthGuard]
  },
  {
    path: 'movie-form', component: MovieFormComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: '', component: LandingpageComponent
  },
  {
    path: 'index', component: LandingpageComponent
  },
  {
    path: 'registry', component: RegistryComponent
  },
  {
    path: 'impressum', component: ImpressumComponent
  },
  {
    path: 'profile', component: ProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
