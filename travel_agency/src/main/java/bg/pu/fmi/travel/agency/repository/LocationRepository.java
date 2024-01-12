package bg.pu.fmi.travel.agency.repository;

import bg.pu.fmi.travel.agency.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LocationRepository
    extends JpaRepository<Location, Long> {

    @Modifying
    @Transactional
    @Query("delete from Location l where l.id = :id")
    Integer removeById(Long id);

    Location getById(Long id);

}
