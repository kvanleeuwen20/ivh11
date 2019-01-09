package kvl.school.ivh11.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Data
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cinema implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String location;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Screen> screens;
}
