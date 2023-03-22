package mx.edu.utez.asesorias.models.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.asesorias.models.transaction.Transaction;

import javax.persistence.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product_name;
    private String category;
    private boolean price;
    private boolean available;



    //de product a transaction
    @OneToOne(mappedBy = "product")
    private Transaction transaction;
}
