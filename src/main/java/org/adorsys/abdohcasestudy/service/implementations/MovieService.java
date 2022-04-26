package org.adorsys.abdohcasestudy.service.implementations;

import lombok.AllArgsConstructor;
import org.adorsys.abdohcasestudy.dto.MovieDto;
import org.adorsys.abdohcasestudy.entity.Movie;
import org.adorsys.abdohcasestudy.exception.MovieNotFoundException;
import org.adorsys.abdohcasestudy.repository.MovieRepo;
import org.adorsys.abdohcasestudy.service.interfaces.IMovieService;
import org.adorsys.abdohcasestudy.service.mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService implements IMovieService {

    private final MovieRepo movieRepo;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> getAll() {
        return movieRepo.findAll()
                .stream()
                .map(movieMapper::toDto)
                .toList();
    }

    @Override
    public void add(MovieDto movieDto) {
        movieRepo.save(movieMapper.toEntity(movieDto));
    }

    @Override
    public void update(MovieDto movieDto) {
        Movie movie = movieRepo.findById(movieDto.getId())
                .orElseThrow(() -> new MovieNotFoundException(String.format("movie with id %s was not found", movieDto.getId())));
        movie.setRelease(movieDto.getRelease());
        movie.setStars(movieDto.getStars());
        movie.setTitle(movie.getTitle());
        movieRepo.save(movie);
    }


    @Override
    public MovieDto getByTitle(String title) {
        var  movie =movieRepo.findByTitle(title)
                .orElseThrow(() -> new MovieNotFoundException(String.format("movie with title %s was not found", title)));
        return movieMapper.toDto(movie);
    }

    @Override
    public void deleteById(Long id) {
        movieRepo.deleteById(id);
    }
}
