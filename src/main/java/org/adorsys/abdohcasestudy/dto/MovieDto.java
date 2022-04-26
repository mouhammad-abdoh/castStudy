package org.adorsys.abdohcasestudy.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Builder
@Data
public class MovieDto {

    private Long id;
    private String title;
    private Integer votes;
    private LocalDate release;
    private Integer stars;
}
