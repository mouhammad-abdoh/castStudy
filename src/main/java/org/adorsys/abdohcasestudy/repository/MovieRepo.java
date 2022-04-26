package org.adorsys.abdohcasestudy.repository;

import org.adorsys.abdohcasestudy.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long> {

    @Transactional
    Optional<Movie> findByTitle(String title);
}
