package kvl.school.ivh11.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class ApiUser extends User
{
    @Getter
    @Setter
    public boolean hasApiRights;

    @Getter
    @Setter
    public String apiKey;
}
