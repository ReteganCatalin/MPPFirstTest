import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {MoviesComponent} from './movies/movies.component';
import {MovieService} from './movies/shared/movie.service';
import {MovieFilterComponent} from './movies/movie-filter/movie-filter.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    MovieFilterComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NoopAnimationsModule,
  ],
  providers: [MovieService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
