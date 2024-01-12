package bg.pu.fmi.travel.agency.Dto.response;

import lombok.Data;

@Data
public class ResponseLocationDTO {
    private Long id;

    private String street;

    private String city;

    private String country;

    private String imageUrl;

    private String number;
}
