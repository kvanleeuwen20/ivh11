package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.Abstr.AppUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Data
public class Employee extends AppUser {
    @NotNull
    @NonNull
    private int employeeNumber;
}
