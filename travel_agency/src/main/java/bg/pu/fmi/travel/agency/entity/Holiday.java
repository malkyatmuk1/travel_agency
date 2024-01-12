package bg.pu.fmi.travel.agency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "DURATION")
    private Integer duration;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "FREE_SLOTS")
    private Integer freeSlots;

}
