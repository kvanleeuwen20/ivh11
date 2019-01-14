package kvl.school.ivh11.domain;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Size;

@Entity
@Data
@ToString(exclude = "screens")
@Table
public class Cinema
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NonNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @NonNull
    private String location;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private transient Set<Screen> screens;

    @Tolerate
    public Cinema() {

    }
}
