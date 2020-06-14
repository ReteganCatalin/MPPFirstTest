import {Injectable} from '@angular/core';

import {HttpClient} from '@angular/common/http';

import {Observable} from 'rxjs';
import {Movie} from './movie.model';



@Injectable()
export class MovieService {
  private moviesUrl = 'http://localhost:8081/movies';

  constructor(private httpClient: HttpClient) {
  }

  filterMovies(year: string, lessThan: boolean): Observable<Movie[]> {
    const urlFilter = `http://localhost:8081/filterMovies/year=${year}/lessThan=${lessThan}`;
    return this.httpClient
      .get<Array<Movie>>(urlFilter);
  }

  filterMoviesWithActors(year: string, lessThan: boolean): Observable<Movie[]> {
    const urlFilter = `http://localhost:8081/filterMoviesWithActors/year=${year}/lessThan=${lessThan}`;
    return this.httpClient
      .get<Array<Movie>>(urlFilter);
  }
  deleteActor(movieId: number, actorId: number): Observable<any> {
    const url = `${this.moviesUrl}/movieID=${movieId}/actorID=${actorId}`;
    return this.httpClient
      .delete(url);
  }

}
