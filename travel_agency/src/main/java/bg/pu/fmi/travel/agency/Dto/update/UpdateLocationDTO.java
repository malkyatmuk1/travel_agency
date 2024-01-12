package bg.pu.fmi.travel.agency.Dto.update;

import lombok.Data;

@Data
public class UpdateLocationDTO {
    private Long id;

    private String street;

    private String number;

    private String city;

    private String country;

    private String imageUrl;
}
