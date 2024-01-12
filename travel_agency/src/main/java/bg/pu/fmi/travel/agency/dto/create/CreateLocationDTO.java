package bg.pu.fmi.travel.agency.Dto.create;

import lombok.Data;

@Data
public class CreateLocationDTO {
    private String street;

    private String number;

    private String city;

    private String country;

    private String imageUrl;
}
