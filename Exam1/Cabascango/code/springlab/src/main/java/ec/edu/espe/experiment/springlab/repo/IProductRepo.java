package ec.edu.espe.experiment.springlab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.espe.experiment.springlab.model.DBProduct;

public interface IProductRepo extends JpaRepository<DBProduct, Integer>{

}