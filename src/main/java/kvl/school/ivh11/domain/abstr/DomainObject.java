package kvl.school.ivh11.domain.Abstr;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter
@Setter
@ToString(includeFieldNames = true, of = { "id", "version" })
public abstract class DomainObject implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    @Setter(AccessLevel.NONE)
    Long version;

    @Override
    public int hashCode()
    {
        if(id != null)
            return id.hashCode();
        else
            return super.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;

        if(!(o instanceof DomainObject))
            return false;

        DomainObject other = (DomainObject) o;

        if (id == null || other.getId() == null)
            return false;

        return id.equals(other.getId());
    }
}
