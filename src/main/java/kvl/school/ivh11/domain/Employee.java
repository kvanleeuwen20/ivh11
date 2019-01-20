package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.abstr.AppUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends AppUser
{
    @NotNull
    @NonNull
    @Size(min=1, max=5)
    private int employeeNumber;

    @Tolerate
    public Employee() {
        super();
    }
}
