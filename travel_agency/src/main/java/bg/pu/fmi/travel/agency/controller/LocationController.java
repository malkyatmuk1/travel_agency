package bg.pu.fmi.travel.agency.controller;

import bg.pu.fmi.travel.agency.Dto.create.CreateLocationDTO;
import bg.pu.fmi.travel.agency.service.ILocationService;
import bg.pu.fmi.travel.agency.Dto.response.ResponseLocationDTO;
import bg.pu.fmi.travel.agency.Dto.update.UpdateLocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private ILocationService service;

    @RequestMapping(method = RequestMethod.POST, value = "/locations")
    public ResponseEntity<ResponseLocationDTO> createLocation(@RequestBody CreateLocationDTO createLocationDTO) {
        return new ResponseEntity<>(service.create(createLocationDTO), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/locations/{locationId}")
    public ResponseEntity<Boolean> deleteLocation(@PathVariable("locationId") Long locationId) {
        Boolean isDeleted = service.delete(locationId);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/locations")
    public ResponseEntity<List<ResponseLocationDTO>> getAllLocations() {
        return new ResponseEntity<>(service.getAllLocations(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/locations/{locationId}")
    public ResponseEntity<ResponseLocationDTO> getLocation(@PathVariable Long locationId) {
        return new ResponseEntity<>(service.getLocation(locationId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/locations")
    public ResponseEntity<ResponseLocationDTO> updateLocation(@RequestBody UpdateLocationDTO updateLocationDTO) {
        return new ResponseEntity<>(service.updateLocation(updateLocationDTO), HttpStatus.OK);
    }
}
