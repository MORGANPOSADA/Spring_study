package mx.edu.utez.asesorias.services.product;


import mx.edu.utez.asesorias.models.person.Person;
import mx.edu.utez.asesorias.models.product.Product;
import mx.edu.utez.asesorias.models.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired   //va a inyectar las dependencias
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getOne(Long id) {
        return this.repository.findById(id).get();
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Product register(Product product) {
        if (this.repository.existsById(repository.getReferenceById(Long id)))
            return null;
        return this.repository.saveAndFlush(product);
    }








}
