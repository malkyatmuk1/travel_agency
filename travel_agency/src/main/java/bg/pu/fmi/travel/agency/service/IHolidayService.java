package bg.pu.fmi.travel.agency.service;

import bg.pu.fmi.travel.agency.Dto.create.CreateHolidayDTO;
import bg.pu.fmi.travel.agency.Dto.response.ResponseHolidayDTO;
import bg.pu.fmi.travel.agency.Dto.update.UpdateHolidayDTO;

import java.time.LocalDate;
import java.util.List;

public interface IHolidayService {

    ResponseHolidayDTO create(CreateHolidayDTO holidayDTO);

    Boolean delete(Long holidayId);

    List<ResponseHolidayDTO> getAllHolidays();

    ResponseHolidayDTO getHoliday(Long holidayId);

    ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO);

    List<ResponseHolidayDTO> findHolidayByParameters(String location, LocalDate startDate, Integer duration);
}
