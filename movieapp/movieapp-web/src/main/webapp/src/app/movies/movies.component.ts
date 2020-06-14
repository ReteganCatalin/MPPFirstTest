import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent  {

  constructor(private router: Router) {
  }
  filterMovies() {
    this.router.navigate(["movie/filter"])
  }
}
