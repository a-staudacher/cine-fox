import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {JwtModule} from '@auth0/angular-jwt';
import {LoginComponent} from './login/login.component';
import {LogoutComponent} from './logout/logout.component';
import {RatingModule} from 'ngx-bootstrap/rating';
import {NgxSelectModule} from 'ngx-select-ex';
import {BsDatepickerModule} from 'ngx-bootstrap';

import {defineLocale} from 'ngx-bootstrap/chronos';
import {deLocale} from 'ngx-bootstrap/locale';
import {ServiceWorkerModule} from '@angular/service-worker';
import {environment} from '../environments/environment';
import {ToastrModule} from 'ngx-toastr';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ErrorInterceptor} from './httpinterceptor/error.interceptor';
import { PersonFormComponent } from './person-form/person-form.component';
import { MovieFormComponent } from './movie-form/movie-form.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FootbarComponent } from './footbar/footbar.component';
import { LandingpageComponent } from './landingpage/landingpage.component';

defineLocale('de', deLocale);


export function tokenGetter() {
  return localStorage.getItem('access_token');
}

export const httpInterceptorProviders = [
  {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoutComponent,
    PersonFormComponent,
    MovieFormComponent,
    NavbarComponent,
    FootbarComponent,
    LandingpageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        whitelistedDomains: ['localhost:4200']
      }
    }),
    RatingModule.forRoot(),
    NgxSelectModule,
    BsDatepickerModule.forRoot(),
    ReactiveFormsModule,
    ServiceWorkerModule.register('ngsw-worker.js', {enabled: environment.production}),
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
