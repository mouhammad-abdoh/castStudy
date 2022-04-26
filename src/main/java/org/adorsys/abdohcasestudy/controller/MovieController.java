package org.adorsys.abdohcasestudy.controller;

import lombok.AllArgsConstructor;
import org.adorsys.abdohcasestudy.dto.MovieDto;
import org.adorsys.abdohcasestudy.entity.Movie;
import org.adorsys.abdohcasestudy.service.interfaces.IMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/movie")
public class MovieController {

    private final IMovieService iMovieService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<MovieDto>> getAll(){
    return ResponseEntity.status(HttpStatus.OK).body(iMovieService.getAll());
    }

    @GetMapping(path="/{title}")
    public ResponseEntity<MovieDto> getByID(@PathVariable(value = "title") String title){
        return ResponseEntity.status(HttpStatus.OK).body(iMovieService.getByTitle(title));
    }

    @PostMapping(path ="/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> add(@RequestBody MovieDto movieDto){
        iMovieService.add(movieDto);
        return ResponseEntity.status(HttpStatus.OK).body("the movie " + movieDto.getTitle() + " has been added successfully");
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<String> edit(@RequestBody MovieDto movieDto){
        iMovieService.update(movieDto);
        return ResponseEntity.status(HttpStatus.OK).body("the movie with the ID : " + movieDto.getId() + " has been updated successfully");
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        iMovieService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(("the movie with the ID : " + id + " has been deleted successfully"));
    }
}
