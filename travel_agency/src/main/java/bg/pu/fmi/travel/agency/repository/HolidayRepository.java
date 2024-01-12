package bg.pu.fmi.travel.agency.repository;

import bg.pu.fmi.travel.agency.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface HolidayRepository
    extends JpaRepository<Holiday, Long> {

    @Modifying
    @Transactional
    @Query("delete from Holiday h where h.id = :id")
    Integer removeById(Long id);

    Holiday getById(Long id);

    @Query("SELECT holiday FROM Holiday holiday WHERE (:location IS NULL OR holiday.location.city = :location OR "
        + "holiday.location.country = :location) AND (:startDate IS NULL OR holiday.startDate = :startDate) AND "
        + "(:duration IS NULL OR holiday.duration = :duration)")
    List<Holiday> findHolidaysByParameters(@Param("location") String location, @Param("startDate") LocalDate startDate,
        @Param("duration") Integer duration);

    List<Holiday> findHolidayByLocation_Id(Long locationId);
}
