package ro.ubb.movieapp.core.model;

import lombok.*;

import javax.persistence.*;

/**
 * author: radu
 */

@Entity
@Table(name="actor")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"movie"})
@ToString(callSuper = true, exclude= {"movie"})
@Builder
public class Actor extends BaseEntity<Long> {
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name="rating")
    private int rating;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "movieid")
   // @EqualsAndHashCode.Exclude
    //@ToString.Exclude
    private  Movie movie;



}
