package bg.pu.fmi.travel.agency.service.impl;

import bg.pu.fmi.travel.agency.repository.HolidayRepository;
import bg.pu.fmi.travel.agency.repository.ReservationRepository;
import bg.pu.fmi.travel.agency.Dto.create.CreateHolidayDTO;
import bg.pu.fmi.travel.agency.Dto.response.ResponseHolidayDTO;
import bg.pu.fmi.travel.agency.Dto.update.UpdateHolidayDTO;
import bg.pu.fmi.travel.agency.entity.Holiday;
import bg.pu.fmi.travel.agency.mapper.HolidayMapper;
import bg.pu.fmi.travel.agency.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HolidayImplService
    implements IHolidayService {

    @Autowired
    private HolidayRepository repository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private HolidayMapper holidayMapper;

    @Override
    public ResponseHolidayDTO create(CreateHolidayDTO holidayDTO) {
        Holiday holidayResponse = repository.save(holidayMapper.mapCreateDtoToEntity(holidayDTO));
        return holidayMapper.mapEntityToResponseHolidayDTO(holidayResponse);
    }

    @Override
    public Boolean delete(Long holidayId) {
        // delete the holiday if there is no reservation. It will be good to add a message to inform the user!
        // if we want to delete it, we need to delete the reservation first!
        Holiday holiday = repository.getById(holidayId);
        if (reservationRepository.getReservationsByHoliday_Id(holiday.getId())
            .size() == 0) {
            return repository.removeById(holidayId) > 0;
        }
        return false;
    }

    @Override
    public List<ResponseHolidayDTO> getAllHolidays() {
        List<ResponseHolidayDTO> listResponse = new ArrayList<>();
        List<Holiday> holidayList = repository.findAll();
        for (Holiday holiday : holidayList) {
            listResponse.add(holidayMapper.mapEntityToResponseHolidayDTO(holiday));
        }
        return listResponse;
    }

    @Override
    public ResponseHolidayDTO getHoliday(Long holidayId) {
        Holiday holiday = repository.getById(holidayId);
        return holidayMapper.mapEntityToResponseHolidayDTO(holiday);
    }

    @Override
    public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO) {
        return holidayMapper.mapEntityToResponseHolidayDTO(
            repository.save(holidayMapper.mapUpdateDtoToEntity(updateHolidayDTO)));
    }

    @Override
    public List<ResponseHolidayDTO> findHolidayByParameters(String location, LocalDate startDate, Integer duration) {
        List<ResponseHolidayDTO> listResponseHolidayList = new ArrayList<>();
        for (Holiday holiday : repository.findHolidaysByParameters(location, startDate, duration)) {
            listResponseHolidayList.add(holidayMapper.mapEntityToResponseHolidayDTO(holiday));
        }
        return listResponseHolidayList;
    }
}
