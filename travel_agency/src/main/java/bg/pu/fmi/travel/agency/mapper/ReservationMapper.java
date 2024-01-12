package bg.pu.fmi.travel.agency.mapper;

import bg.pu.fmi.travel.agency.Dto.create.CreateReservationDTO;
import bg.pu.fmi.travel.agency.Dto.response.ResponseReservationDTO;
import bg.pu.fmi.travel.agency.entity.Reservation;
import bg.pu.fmi.travel.agency.repository.HolidayRepository;
import bg.pu.fmi.travel.agency.Dto.update.UpdateReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper {

    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private HolidayMapper holidayMapper;

    public Reservation mapCreateDtoToEntity(CreateReservationDTO createReservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setContactName(createReservationDTO.getContactName());
        if (createReservationDTO.getHoliday() != null) {
            reservation.setHoliday(holidayRepository.getById(createReservationDTO.getHoliday()));
        }
        reservation.setPhoneName(createReservationDTO.getPhoneNumber());

        return reservation;
    }

    public Reservation mapUpdateDtoToEntity(UpdateReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        if (reservationDTO.getHoliday() != null) {
            reservation.setHoliday(holidayRepository.getById(reservationDTO.getHoliday()));
        }
        reservation.setPhoneName(reservationDTO.getPhoneNumber());
        reservation.setContactName(reservationDTO.getContactName());
        return reservation;
    }

    public ResponseReservationDTO mapEntityToResponseReservationDTO(Reservation reservation) {
        ResponseReservationDTO responseReservationDTO = new ResponseReservationDTO();
        responseReservationDTO.setContactName(reservation.getContactName());
        responseReservationDTO.setHoliday(holidayMapper.mapEntityToResponseHolidayDTO(reservation.getHoliday()));
        responseReservationDTO.setId(reservation.getId());
        responseReservationDTO.setPhoneNumber(reservation.getPhoneName());

        return responseReservationDTO;
    }
}
