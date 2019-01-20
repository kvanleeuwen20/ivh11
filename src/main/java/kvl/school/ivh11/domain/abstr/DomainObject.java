package kvl.school.ivh11.domain.abstr;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Getter
public abstract class DomainObject
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;
}