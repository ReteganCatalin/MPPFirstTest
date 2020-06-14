package ro.ubb.movieapp.core.service;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.movieapp.core.model.Actor;
import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.core.repository.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * author: radu
 */

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Movie> getMoviesByYear(int year, boolean lessThan) {
        List<Movie> movies;
        if(lessThan==true)
        {
            movies=movieRepository.findByYearEqualsLessThan(year);
        }
        else
        {
            movies=movieRepository.findByYearEqualsAndAfter(year);
        }
        return movies;
    }

    @Override
    public List<Movie> getMoviesWithActorsByYear(int year, boolean lessThan) {
        if(lessThan==true)
        {
            return movieRepository.findByYearWithActorsEqualsLessThan(year);
        }
        else
        {
            return movieRepository.findByYearWithActorsEqualsAndAfter(year);
        }
    }

    @Override
    @Transactional
    public void deleteActor(Long movieId, Long actorId) {
        Optional<Movie> movieOptional =
                movieRepository.findUpdated(movieId);
        movieOptional.ifPresent(
                elem -> {
                            Actor actor=elem.getActors().stream().filter(filtering->filtering.getID()==actorId).findFirst().get();
                            elem.getActors().remove(actor);

                });
    }
}
