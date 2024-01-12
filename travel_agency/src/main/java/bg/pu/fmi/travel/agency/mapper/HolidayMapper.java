package bg.pu.fmi.travel.agency.mapper;

import bg.pu.fmi.travel.agency.entity.Holiday;
import bg.pu.fmi.travel.agency.repository.LocationRepository;
import bg.pu.fmi.travel.agency.Dto.create.CreateHolidayDTO;
import bg.pu.fmi.travel.agency.Dto.response.ResponseHolidayDTO;
import bg.pu.fmi.travel.agency.Dto.update.UpdateHolidayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HolidayMapper {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapper locationMapper;

    public Holiday mapCreateDtoToEntity(CreateHolidayDTO createHolidayDTO) {
        Holiday holiday = new Holiday();
        holiday.setDuration(createHolidayDTO.getDuration());
        holiday.setPrice(createHolidayDTO.getPrice());
        holiday.setTitle(createHolidayDTO.getTitle());
        holiday.setFreeSlots(createHolidayDTO.getFreeSlots());
        if (createHolidayDTO.getLocation() != null) {
            holiday.setLocation(locationRepository.getById(createHolidayDTO.getLocation()));
        }
        holiday.setStartDate(createHolidayDTO.getStartDate());

        return holiday;
    }

    public Holiday mapUpdateDtoToEntity(UpdateHolidayDTO updateHolidayDTO) {
        Holiday holiday = new Holiday();
        holiday.setDuration(updateHolidayDTO.getDuration());
        holiday.setPrice(updateHolidayDTO.getPrice());
        holiday.setTitle(updateHolidayDTO.getTitle());
        holiday.setFreeSlots(updateHolidayDTO.getFreeSlots());
        if (updateHolidayDTO.getLocation() != null) {
            holiday.setLocation(locationRepository.getById(updateHolidayDTO.getLocation()));
        }
        holiday.setStartDate(updateHolidayDTO.getStartDate());
        holiday.setId(updateHolidayDTO.getId());

        return holiday;
    }

    public ResponseHolidayDTO mapEntityToResponseHolidayDTO(Holiday holiday) {
        ResponseHolidayDTO responseHolidayDTO = new ResponseHolidayDTO();
        responseHolidayDTO.setDuration(holiday.getDuration());
        responseHolidayDTO.setTitle(holiday.getTitle());
        if (holiday.getLocation() != null) {
            responseHolidayDTO.setLocation(locationMapper.mapEntityToResponseLocationDTO(holiday.getLocation()));
        }

        responseHolidayDTO.setPrice(Double.parseDouble(holiday.getPrice()));
        responseHolidayDTO.setFreeSlots(holiday.getFreeSlots());
        responseHolidayDTO.setStartDate(holiday.getStartDate());
        responseHolidayDTO.setId(holiday.getId());
        return responseHolidayDTO;
    }
}
