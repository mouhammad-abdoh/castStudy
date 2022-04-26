package org.adorsys.abdohcasestudy.service.mapper;

import org.adorsys.abdohcasestudy.dto.MovieDto;
import org.adorsys.abdohcasestudy.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDto toDto(Movie movie){
        return MovieDto.builder().id(movie.getId()).title(movie.getTitle()).votes(movie.getVotes()).release(movie.getRelease()).stars(movie.getStars()).build();
    }

    public Movie toEntity(MovieDto movieDto){
        return Movie.builder().title(movieDto.getTitle()).votes(movieDto.getVotes()).release(movieDto.getRelease()).stars(movieDto.getStars()).build();
    }

}
