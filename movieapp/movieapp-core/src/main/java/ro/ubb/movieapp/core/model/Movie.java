package ro.ubb.movieapp.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * author: radu
 */

@Entity
@Table(name="movie")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true,exclude={"actors"})
@ToString(callSuper = true,exclude = {"actors"} )
@Builder
@NamedEntityGraphs({
        @NamedEntityGraph(name = "movieWithActors",
                attributeNodes = @NamedAttributeNode(value = "actors"))
})
public class Movie extends BaseEntity<Long> {
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "year")
    private int year;

    //actors
    @OneToMany(mappedBy = "movie", orphanRemoval = true,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@EqualsAndHashCode.Exclude
    //@ToString.Exclude
    private List<Actor> actors;


}
