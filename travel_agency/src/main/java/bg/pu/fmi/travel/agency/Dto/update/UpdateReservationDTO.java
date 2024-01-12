package bg.pu.fmi.travel.agency.Dto.update;

import lombok.Data;

@Data
public class UpdateReservationDTO {
    private Long id;

    private String contactName;

    private String phoneNumber;

    private Long holiday;
}
