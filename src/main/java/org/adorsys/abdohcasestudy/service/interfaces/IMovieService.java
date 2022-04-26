package org.adorsys.abdohcasestudy.service.interfaces;

import org.adorsys.abdohcasestudy.dto.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> getAll();

    void add(MovieDto movieDto);

    void update(MovieDto movieDto);

    MovieDto getByTitle(String title);

    void deleteById(Long id);
}
