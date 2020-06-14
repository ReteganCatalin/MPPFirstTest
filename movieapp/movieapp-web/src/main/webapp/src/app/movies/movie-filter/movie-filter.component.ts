import {Component, OnInit} from '@angular/core';
import {MovieService} from '../shared/movie.service';
import {Location} from '@angular/common';
import {Actor, Movie} from '../shared/movie.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-movie-new',
  templateUrl: './movie-filter.component.html',
  styleUrls: ['./movie-filter.component.css']
})
export class MovieFilterComponent implements OnInit {

  errorMessage: string;
  showActors: boolean;
  movies: Array<Movie>;
  selectedMovie: Movie;

  constructor(private movieService: MovieService,
              private location: Location,
              private router: Router
  ) {
  }

  ngOnInit(): void {
  }

  filterMovies(year: string, before: boolean, after: boolean) {
    let lessThan = false;
    this.showActors = false;
    if (before === true) {
      lessThan = true;
    }
    this.movieService.filterMovies(year, lessThan).subscribe(
      movies => this.movies = movies,
      error => this.errorMessage = <any>error
    );

  }

  filterMoviesCast(year: string, before: boolean, after: boolean) {
    let lessThan = false;
    this.showActors = true;
    if (before === true) {
      lessThan = true;
    }
    this.movieService.filterMoviesWithActors(year, lessThan).subscribe(
      movies => this.movies = movies,
      error => this.errorMessage = <any>error
    );

  }
  deleteActor(movie: Movie, actor: Actor) {
    console.log('deleting movie: ', movie, actor);

    this.movieService.deleteActor(movie.id, actor.id)
      .subscribe(_ => {
        console.log('movie deleted');

       // Movie change=this.movies.filter(s => s.title !== movie.title |)

      });
  }
}

