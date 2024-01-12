package bg.pu.fmi.travel.agency.service.impl;

import bg.pu.fmi.travel.agency.Dto.create.CreateLocationDTO;
import bg.pu.fmi.travel.agency.repository.HolidayRepository;
import bg.pu.fmi.travel.agency.repository.LocationRepository;
import bg.pu.fmi.travel.agency.Dto.response.ResponseLocationDTO;
import bg.pu.fmi.travel.agency.Dto.update.UpdateLocationDTO;
import bg.pu.fmi.travel.agency.entity.Location;
import bg.pu.fmi.travel.agency.mapper.LocationMapper;
import bg.pu.fmi.travel.agency.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationImplService
    implements ILocationService {

    @Autowired
    private LocationRepository repository;

    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public ResponseLocationDTO create(CreateLocationDTO locationDTO) {
        Location locationResponse = repository.save(locationMapper.mapCreateDtoToEntity(locationDTO));
        return locationMapper.mapEntityToResponseLocationDTO(locationResponse);
    }

    @Override
    public Boolean delete(Long locationId) {
        // delete the location if there is no holiday. It will be good to add a message to inform the user!
        // if we want to delete it, we need to delete the holiday first!
        if (holidayRepository.findHolidayByLocation_Id(locationId)
            .size() == 0) {
            return repository.removeById(locationId) > 0;
        }
        return false;
    }

    @Override
    public List<ResponseLocationDTO> getAllLocations() {
        List<ResponseLocationDTO> listResponse = new ArrayList<>();
        List<Location> locationList = repository.findAll();
        for (Location location : locationList) {
            listResponse.add(locationMapper.mapEntityToResponseLocationDTO(location));
        }
        return listResponse;
    }

    @Override
    public ResponseLocationDTO getLocation(Long locationId) {
        Location location = repository.getById(locationId);
        return locationMapper.mapEntityToResponseLocationDTO(location);
    }

    @Override
    public ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO) {
        return locationMapper.mapEntityToResponseLocationDTO(
            repository.save(locationMapper.mapUpdateDtoToEntity(updateLocationDTO)));
    }
}
