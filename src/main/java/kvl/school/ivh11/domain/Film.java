package kvl.school.ivh11.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
public class Film
{
    @Getter
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private int duration;

    @Getter
    @Setter
    private String description;

    @OneToMany(mappedBy = "film")
    private List<Screening> screening;

}
