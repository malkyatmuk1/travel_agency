package bg.pu.fmi.travel.agency.repository;

import bg.pu.fmi.travel.agency.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReservationRepository
    extends JpaRepository<Reservation, Long> {

    @Modifying
    @Transactional
    @Query("delete from Reservation r where r.id = :id")
    Integer removeById(Long id);

    Reservation getById(Long id);

    List<Reservation> getReservationsByHoliday_Id(Long holidayId);

}
