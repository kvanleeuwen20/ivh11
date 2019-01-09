package kvl.school.ivh11.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Data
public abstract class User
{
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @Getter
    @Setter
    protected String name;

    @Getter
    @Setter
    protected String email;
}
