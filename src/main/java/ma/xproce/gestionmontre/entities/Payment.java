package ma.xproce.gestionmontre.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//utiliser une seule table "Mére"
@DiscriminatorColumn(name = "payment_type")//Pour modifier une colone qui va faire la discrimination
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date amount;
    @ManyToOne
    private Order1 order1;
}
