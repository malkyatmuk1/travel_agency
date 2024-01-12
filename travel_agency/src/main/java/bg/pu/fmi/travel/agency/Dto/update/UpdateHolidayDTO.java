package bg.pu.fmi.travel.agency.Dto.update;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateHolidayDTO {
    private Long id;

    private Long location;

    private String title;

    private LocalDate startDate;

    private Integer duration;

    private String price;

    private Integer freeSlots;
}
