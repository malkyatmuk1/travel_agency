package bg.pu.fmi.travel.agency.service.impl;

import bg.pu.fmi.travel.agency.Dto.create.CreateReservationDTO;
import bg.pu.fmi.travel.agency.Dto.response.ResponseReservationDTO;
import bg.pu.fmi.travel.agency.Dto.update.UpdateReservationDTO;
import bg.pu.fmi.travel.agency.entity.Reservation;
import bg.pu.fmi.travel.agency.mapper.ReservationMapper;
import bg.pu.fmi.travel.agency.repository.ReservationRepository;
import bg.pu.fmi.travel.agency.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationImplService
    implements IReservationService {
    @Autowired
    private ReservationRepository repository;

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public ResponseReservationDTO create(CreateReservationDTO reservationDTO) {
        Reservation reservationResponse = repository.save(reservationMapper.mapCreateDtoToEntity(reservationDTO));
        return reservationMapper.mapEntityToResponseReservationDTO(reservationResponse);
    }

    @Override
    public Boolean delete(Long reservationId) {
        return repository.removeById(reservationId) > 0;
    }

    @Override
    public List<ResponseReservationDTO> getAllReservations() {

        List<ResponseReservationDTO> listResponse = new ArrayList<>();
        List<Reservation> reservationList = repository.findAll();
        for (Reservation reservation : reservationList) {
            listResponse.add(reservationMapper.mapEntityToResponseReservationDTO(reservation));
        }
        return listResponse;
    }

    @Override
    public ResponseReservationDTO getReservation(Long reservationId) {
        Reservation reservation = repository.getById(reservationId);
        return reservationMapper.mapEntityToResponseReservationDTO(reservation);
    }

    @Override
    public ResponseReservationDTO updateReservation(UpdateReservationDTO updateReservationDTO) {
        return reservationMapper.mapEntityToResponseReservationDTO(
            repository.save(reservationMapper.mapUpdateDtoToEntity(updateReservationDTO)));
    }
}
