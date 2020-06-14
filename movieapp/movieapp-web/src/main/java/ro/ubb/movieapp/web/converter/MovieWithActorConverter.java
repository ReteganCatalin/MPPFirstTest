package ro.ubb.movieapp.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.web.dto.ActorDto;
import ro.ubb.movieapp.web.dto.MovieDto;
import ro.ubb.movieapp.web.dto.MovieWithActorsDto;

import java.util.stream.Collectors;

@Component
public class MovieWithActorConverter extends BaseConverter<Movie, MovieWithActorsDto> {
    @Override
    public Movie convertDtoToModel(MovieWithActorsDto dto) {
        Movie movie = Movie.builder()
                .title(dto.getTitle())
                .year(dto.getYear())
                //.actors(dto.getActors())
                .build();
        movie.setID(dto.getId());
        return movie;
    }

    @Override
    public MovieWithActorsDto convertModelToDto(Movie movie) {
        MovieWithActorsDto dto = MovieWithActorsDto.builder()
                .title(movie.getTitle())
                .year(movie.getYear())
                .actors(movie.getActors().stream().map(actor->ActorDto.builder()
                        .id(actor.getID())
                        .name(actor.getName())
                        .rating(actor.getRating()).build()).collect(Collectors.toList()))
                .build();
        dto.setId(movie.getID());
        return dto;
    }
}
