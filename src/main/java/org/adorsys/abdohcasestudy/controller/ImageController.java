package org.adorsys.abdohcasestudy.controller;

import lombok.AllArgsConstructor;
import org.adorsys.abdohcasestudy.entity.Image;
import org.adorsys.abdohcasestudy.entity.Movie;
import org.adorsys.abdohcasestudy.exception.MovieNotFoundException;
import org.adorsys.abdohcasestudy.repository.ImageRepo;
import org.adorsys.abdohcasestudy.repository.MovieRepo;
import org.adorsys.abdohcasestudy.service.interfaces.IMovieService;
import org.adorsys.abdohcasestudy.utility.ImageUtility;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path ="/api/v1/image")
public class ImageController {

    private final ImageRepo  imageRepo;
    private final MovieRepo movieRepo;

    @PostMapping(path = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("movie-id") Long id)
            throws IOException {
        Movie movie = movieRepo.findById(id).orElseThrow(() -> new MovieNotFoundException("not found"));
        imageRepo.save(Image.builder().movie(movie)
                .name(file.getOriginalFilename())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    @GetMapping(path = {"/{name}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

        final Optional<Image> dbImage = imageRepo.findByName(name);

        return ResponseEntity
                .ok()
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }
}
