package bg.pu.fmi.travel.agency.Dto.response;

import lombok.Data;

@Data
public class ResponseReservationDTO {
    private Long id;

    private String contactName;

    private String phoneNumber;

    private ResponseHolidayDTO holiday;
}
