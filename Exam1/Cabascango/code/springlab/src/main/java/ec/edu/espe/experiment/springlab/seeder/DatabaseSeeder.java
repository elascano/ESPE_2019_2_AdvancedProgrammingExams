package ec.edu.espe.experiment.springlab.seeder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ec.edu.espe.experiment.springlab.model.DBProduct;
import ec.edu.espe.experiment.springlab.repo.IProductRepo;

@Component
public class DatabaseSeeder implements CommandLineRunner {
 @Autowired
 private IProductRepo repoProduct;
 
 @Autowired
 public DatabaseSeeder(IProductRepo productRepo){
    this.repoProduct = productRepo;
 }
 
 @Override
 public void run(String... strings) throws Exception {
    List<DBProduct> products = new ArrayList<>();
    products.add(new DBProduct("Clavo", "Pulgada", 2, 1f));
    products.add(new DBProduct("Martillo", "Madera", 2, 1.5f));
    products.add(new DBProduct("Alambre", "2 lbs", 2, 2f));
    products.add(new DBProduct("Madera", "Pino", 2, 4.5f));
    repoProduct.saveAll(products);
 }
}