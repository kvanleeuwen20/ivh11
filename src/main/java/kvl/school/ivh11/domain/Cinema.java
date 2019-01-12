package kvl.school.ivh11.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Size;

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
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Getter
    @Setter
    @NotNull
    private String location;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Screen> screens;
}
