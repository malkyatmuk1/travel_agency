package bg.pu.fmi.travel.agency.mapper;

import bg.pu.fmi.travel.agency.Dto.create.CreateLocationDTO;
import bg.pu.fmi.travel.agency.entity.Location;
import bg.pu.fmi.travel.agency.Dto.response.ResponseLocationDTO;
import bg.pu.fmi.travel.agency.Dto.update.UpdateLocationDTO;
import org.springframework.stereotype.Service;

@Service
public class LocationMapper {
    public Location mapCreateDtoToEntity(CreateLocationDTO createLocationDTO) {
        Location location = new Location();
        location.setCity(createLocationDTO.getCity());
        location.setCountry(createLocationDTO.getCountry());
        location.setStreet(createLocationDTO.getStreet());
        location.setNumber(createLocationDTO.getNumber());
        location.setImageUrl(createLocationDTO.getImageUrl());
        return location;
    }

    public Location mapUpdateDtoToEntity(UpdateLocationDTO updateLocationDTO) {
        Location location = new Location();
        location.setCity(updateLocationDTO.getCity());
        location.setCountry(updateLocationDTO.getCountry());
        location.setStreet(updateLocationDTO.getStreet());
        location.setNumber(updateLocationDTO.getNumber());
        location.setImageUrl(updateLocationDTO.getImageUrl());
        location.setId(updateLocationDTO.getId());
        return location;
    }

    public ResponseLocationDTO mapEntityToResponseLocationDTO(Location location) {
        ResponseLocationDTO responseLocationDTO = new ResponseLocationDTO();
        responseLocationDTO.setCity(location.getCity());
        responseLocationDTO.setId(location.getId());
        responseLocationDTO.setStreet(location.getStreet());
        responseLocationDTO.setCountry(location.getCountry());
        responseLocationDTO.setImageUrl(location.getImageUrl());
        responseLocationDTO.setNumber(location.getNumber());
        return responseLocationDTO;
    }
}
