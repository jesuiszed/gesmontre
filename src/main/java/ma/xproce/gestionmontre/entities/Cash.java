package ma.xproce.gestionmontre.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@DiscriminatorValue("CASH")
public class Cash extends Payment {
    private Double cashTendered;

}
