package kvl.school.ivh11.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Data
public class Location
{
    @Size(min=1, max=25)
    private String address;
    @NotNull
    @Size(min=1, max =3)
    private String huisnr;
    @Size(min=6, max=6)
    private String zipcode;
    @Size(min=3)
    private String city;
}
