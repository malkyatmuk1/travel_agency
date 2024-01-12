package bg.pu.fmi.travel.agency.Dto.create;

import lombok.Data;

@Data
public class CreateReservationDTO {
    private String contactName;

    private String phoneNumber;

    private Long holiday;

}
