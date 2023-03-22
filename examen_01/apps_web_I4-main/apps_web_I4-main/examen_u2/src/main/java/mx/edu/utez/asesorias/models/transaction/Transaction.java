package mx.edu.utez.asesorias.models.transaction;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.asesorias.models.product.Product;
import mx.edu.utez.asesorias.models.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date Fec_compra;



    //osea necesito unir el id del usuario
    //unir el id del producto



    //de user a transaction
    //el prpoietario es transactoin

    //de user a transaction
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private User user;



    //de product a transaction


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Product product;


}
