package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="Clients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @Column(name="id_client")
    private String id;

    @Column(name="name_client", nullable = false)
    private String client;

    @Column(name="number_guests", nullable = false)
    private Integer guests;

    @Column(name="number_waiters", nullable = false)
    private Integer waiters;

    @Column(name="desert", nullable = false)
    private String desert;

    @Column(name="price_guest", nullable = false)
    private double priceGuest;

    @Column(name="price_guests", nullable = false)
    private double priceGuests;

    @Column(name="price_waiters", nullable = false)
    private double priceWaiters;

    @Column(name="valor_total", nullable = false)
    private double priceTotal;
}