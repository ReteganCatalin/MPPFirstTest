package ro.ubb.movieapp.core.repository;

import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.movieapp.core.model.Movie;

import java.util.List;
import java.util.Optional;

/**
 * author: radu
 */
public interface MovieRepository extends MovieAppRepository<Movie, Long> {


    @Query("select movie from Movie movie where movie.id=:movieID")
    @EntityGraph(value = "movieWithActors", type =
            EntityGraph.EntityGraphType.LOAD)
    Optional<Movie> findUpdated(@Param("movieID") Long movieID);

    @Query("select movie from Movie movie where movie.year>=:movieYear")
    @EntityGraph(value = "movieWithActors", type =
            EntityGraph.EntityGraphType.LOAD)
    List<Movie> findByYearWithActorsEqualsAndAfter(@Param("movieYear") int movieYear);

    @Query("select movie from Movie movie where movie.year<:movieYear")
    @EntityGraph(value = "movieWithActors", type =
            EntityGraph.EntityGraphType.LOAD)
    List<Movie> findByYearWithActorsEqualsLessThan(@Param("movieYear") int movieYear);

    @Query("select movie from Movie movie where movie.year>=:movieYear")
    List<Movie> findByYearEqualsAndAfter(@Param("movieYear") int movieYear);

    @Query("select movie from Movie movie where movie.year<:movieYear")
    List<Movie> findByYearEqualsLessThan(@Param("movieYear") int movieYear);

}
