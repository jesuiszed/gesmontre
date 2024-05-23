package ma.xproce.gestionmontre.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class montre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message ="nom Non Entrer")
    private String nom;
    @NotBlank(message ="description Non Entrer")
    private String description;
    @Min(value=100)
    private double price;

    @ManyToOne
    private categorie categorie;
    @OneToMany (mappedBy = "montre",fetch =FetchType.LAZY )//Pour eviter de charger tous les catégorie en mémoire
    private List<OrderDetail> orderDetails = new ArrayList<>();


}
