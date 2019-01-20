package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.Abstr.AppUser;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@Data
public class Employee extends AppUser
{
    @NonNull
    @Size(min=1, max=5)
    private int employeeNumber;
}
