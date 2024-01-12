package bg.pu.fmi.travel.agency.Dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseHolidayDTO {
    private Long id;

    private ResponseLocationDTO location;

    private String title;

    private LocalDate startDate;

    private Double price;

    private Integer freeSlots;

    private Integer duration;
}
