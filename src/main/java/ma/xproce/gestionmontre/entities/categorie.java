package ma.xproce.gestionmontre.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor
@Builder
@Entity
public class categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message ="categorie Non Entrer")
    private String categorie;
@OneToMany (mappedBy = "categorie",fetch =FetchType.LAZY )
    private List<montre> montre = new ArrayList<>();


}

