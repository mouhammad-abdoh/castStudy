package org.adorsys.abdohcasestudy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
@Getter
@Entity
@Table()
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String title;

    @Column()
    private Integer votes;

    @Column()
    private LocalDate release;

    @Column()
    private Integer stars;

    @OneToOne
    private Image image;


    @Builder
    public Movie(String title, LocalDate release, Integer votes, Integer stars) {
        this.title = title;
        this.release = release;
        this.votes = votes;
        this.stars = stars;
    }
}
