package ro.ubb.movieapp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movieapp.core.service.MovieService;
import ro.ubb.movieapp.web.converter.MovieConverter;
import ro.ubb.movieapp.web.converter.MovieWithActorConverter;
import ro.ubb.movieapp.web.dto.MovieDto;
import ro.ubb.movieapp.web.dto.MovieWithActorsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class AppController {

    public static final Logger log= LoggerFactory.getLogger(AppController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieConverter movieConverter;

    @Autowired
    private MovieWithActorConverter movieWithActorConverter;


    @CrossOrigin
    @RequestMapping(value = "/movies/movieID={movieID}/actorID={actorID}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteActor(@PathVariable Long movieID,@PathVariable Long actorID ){
        movieService.deleteActor(movieID,actorID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/filterMovies/year={year}/lessThan={lessThan}", method=RequestMethod.GET)
    Set<MovieDto> getFilteredMovies(@PathVariable int  year, @PathVariable boolean lessThan )
    {
        //log.trace("Method getFilteredClients entered with Path Variable: name {}"+name);
        return movieConverter
                .convertModelsToDtos(movieService.getMoviesByYear(year,lessThan));
    }

    @CrossOrigin
    @RequestMapping(value = "/filterMoviesWithActors/year={year}/lessThan={lessThan}", method= RequestMethod.GET)
    Set<MovieWithActorsDto> getFilteredMoviesWithActors(@PathVariable int  year, @PathVariable boolean lessThan)
    {
        return movieWithActorConverter
                .convertModelsToDtos(movieService.getMoviesWithActorsByYear(year,lessThan));
    }

}
