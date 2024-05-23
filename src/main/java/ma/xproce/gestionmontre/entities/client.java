package ma.xproce.gestionmontre.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.xproce.gestionmontre.enums.ClientState;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message ="firstName Non Entrer")
    private String firstName;
    @NotBlank(message ="lastName Non Entrer")
    private String lastName;
    @NotBlank(message ="email Non Entrer")
    private  String email;
    @NotBlank(message ="address Non Entrer")
    private String address;
    private ClientState clientState= ClientState.New;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Order1> order1s = new ArrayList<>();

}
