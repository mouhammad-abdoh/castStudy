package org.adorsys.abdohcasestudy.repository;

import org.adorsys.abdohcasestudy.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ImageRepo extends JpaRepository<Image,Long> {

    @Transactional
    Optional<Image> findByName(String name);
}
