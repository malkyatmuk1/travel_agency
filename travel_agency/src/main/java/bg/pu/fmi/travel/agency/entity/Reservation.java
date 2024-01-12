package bg.pu.fmi.travel.agency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTACT_NAME")
    private String contactName;

    @Column(name = "PHONE_NAME")
    private String phoneName;

    @ManyToOne
    @JoinColumn(name = "HOLIDAY_ID")
    private Holiday holiday;
}
