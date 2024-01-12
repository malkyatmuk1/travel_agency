package bg.pu.fmi.travel.agency.service;

import bg.pu.fmi.travel.agency.Dto.create.CreateLocationDTO;
import bg.pu.fmi.travel.agency.Dto.response.ResponseLocationDTO;
import bg.pu.fmi.travel.agency.Dto.update.UpdateLocationDTO;

import java.util.List;

public interface ILocationService {
    ResponseLocationDTO create(CreateLocationDTO locationDTO);

    Boolean delete(Long locationId);

    List<ResponseLocationDTO> getAllLocations();

    ResponseLocationDTO getLocation(Long locationId);

    ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO);
}
