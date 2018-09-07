import { MaterializeModule } from 'angular2-materialize';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MaterialApoioComponent } from './material-apoio/material-apoio.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { ROUTES } from './app.routing';
import { DefesaComponent } from './defesa/defesa.component';

@NgModule({
  declarations: [
    AppComponent,
    MaterialApoioComponent,
    HomeComponent,
    DefesaComponent
  ],
  imports: [
    BrowserModule,
    MaterializeModule, 
    RouterModule.forRoot(ROUTES)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
