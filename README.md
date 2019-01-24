# Cine-Fox
FH Joanneum SWENGS Project
This Application was built as part of a course at FH JOANNEUM Ausrtia called "Software Engineering Selective" for the bachelor in Information Management.


# Team Members:
Staudacher Andreas  
Gartner Florian  
Schmitzer Georg  
Hutter Martin  


# Workload Distribution:
Staudacher Andreas: CRUD(User,Hersteller,Kategorie,Series_Rating), Project Setup, DTOs, Controllers, Movie-Form/Movie-Show, Search-Results  
Gartner Florian: CRUD(Favourite,Review),  Sign Up/Login, Authentication   
Schmitzer Georg: CRUD(Series, Genre), Landingpage, Userprofiles, Design/Template  
Hutter Martin: CRUD(Persons,Character,Director), Person-Form/Person-Show   

# Required Software
Follwoing Software is needed to run the application.

JAVA 8 (NOT 9 or 11 !!) SDK

IntelliJ IDEA Install the Spring Boot Plugin  (ALL SPRING Plugins should be enabled)

MySQL Server + MySQLWorkbench



# Setup Instructions:
0. Clone project or download zip-folder   
1. Open backend   
2. Adapt Application Properties file – connection to MYSQL Database   
3. Run backend   
4. Open frontend  
5. In terminal run npm install  
6. NG2-File-Upload:  
	- npm i ng2-file-upload --save  
	- Hinzufügen im NgModule  
7. Webstomp-client:  
	-npm install --save webstomp-client  
8. Start frontend (ng serve)  
9. If run with Angular CLI go to URL localhost:4200 (use custom URL when run with a webserver/Chrome etc.)  
10. Type in Credentials (e.g.: admin/12345)   



# Available User Credentials (username/password):  
Username: admin; Password: 12345 -> is an Administrator  
Username: Andreas; Password: 12345 -> is an Administrator  
Username: Georg; Password: 12345 -> is normal User  
Username: Martin; Password: 12345 -> is normal User  
Username: Florian; Password: 12345 -> is normal User  



# Frontend

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.0.5.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

