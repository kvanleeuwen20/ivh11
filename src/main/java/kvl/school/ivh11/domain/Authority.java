package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.abstr.DomainObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Authority extends DomainObject implements GrantedAuthority {
    @Column(name = "NAME")
    private String name;

    @Override
    public String getAuthority() {
        return getName();
    }
}
