package bg.pu.fmi.travel.agency.service;

import bg.pu.fmi.travel.agency.Dto.create.CreateReservationDTO;
import bg.pu.fmi.travel.agency.Dto.response.ResponseReservationDTO;
import bg.pu.fmi.travel.agency.Dto.update.UpdateReservationDTO;

import java.util.List;

public interface IReservationService {
    ResponseReservationDTO create(CreateReservationDTO reservationDTO);

    Boolean delete(Long reservationId);

    List<ResponseReservationDTO> getAllReservations();

    ResponseReservationDTO getReservation(Long reservationId);

    ResponseReservationDTO updateReservation(UpdateReservationDTO updateReservationDTO);
}
