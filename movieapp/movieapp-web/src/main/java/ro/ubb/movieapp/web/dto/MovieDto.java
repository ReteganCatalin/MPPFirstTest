package ro.ubb.movieapp.web.dto;

import lombok.*;
import ro.ubb.movieapp.core.model.Actor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class MovieDto extends BaseDto {
    private String title;
    private int year;

}
