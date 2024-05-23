package ma.xproce.gestionmontre.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.xproce.gestionmontre.enums.OrderState;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Order1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;


    private OrderState orderState = OrderState.New;
    @OneToMany(mappedBy = "order1", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails = new ArrayList<>();
    @OneToMany(mappedBy = "order1", fetch = FetchType.LAZY)
    private List<Payment> payments = new ArrayList<>();
    @ManyToOne
    private client client;
}
