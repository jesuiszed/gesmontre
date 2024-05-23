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
@DiscriminatorValue("CHECK")//Pour Préciser la valeur dans la calone déscriminatoire "Table Mére"
public class Check extends Payment {
    private String bankName;
    private String bankId;
}
