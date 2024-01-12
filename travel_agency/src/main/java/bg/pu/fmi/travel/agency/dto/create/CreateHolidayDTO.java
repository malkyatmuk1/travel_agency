package bg.pu.fmi.travel.agency.Dto.create;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateHolidayDTO {
    private Long location;

    private String title;

    private LocalDate startDate;

    private Integer duration;

    private String price;

    private Integer freeSlots;
}
