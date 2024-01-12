package bg.pu.fmi.travel.agency.controller;

import bg.pu.fmi.travel.agency.Dto.create.CreateReservationDTO;
import bg.pu.fmi.travel.agency.Dto.response.ResponseReservationDTO;
import bg.pu.fmi.travel.agency.service.IReservationService;
import bg.pu.fmi.travel.agency.Dto.update.UpdateReservationDTO;
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
public class ReservationController {

    @Autowired
    private IReservationService service;

    @RequestMapping(method = RequestMethod.POST, value = "/reservations")
    public ResponseEntity<ResponseReservationDTO> createReservation(
        @RequestBody CreateReservationDTO createReservationDTO) {
        return new ResponseEntity<>(service.create(createReservationDTO), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/reservations/{reservationId}")
    public ResponseEntity<Boolean> deleteReservation(@PathVariable Long reservationId) {
        Boolean isDeleted = service.delete(reservationId);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservations")
    public ResponseEntity<List<ResponseReservationDTO>> getAllReservations() {
        return new ResponseEntity<>(service.getAllReservations(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservations/{reservationId}")
    public ResponseEntity<ResponseReservationDTO> getReservation(@PathVariable Long reservationId) {
        return new ResponseEntity<>(service.getReservation(reservationId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/reservations")
    public ResponseEntity<ResponseReservationDTO> updateReservation(
        @RequestBody UpdateReservationDTO updateReservationDTO) {
        return new ResponseEntity<>(service.updateReservation(updateReservationDTO), HttpStatus.OK);
    }
}
