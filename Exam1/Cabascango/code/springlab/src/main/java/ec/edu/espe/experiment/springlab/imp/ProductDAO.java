package ec.edu.espe.experiment.springlab.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.edu.espe.experiment.springlab.dao.IProductDAO;
import ec.edu.espe.experiment.springlab.repo.IProductRepo;
import ec.edu.espe.experiment.springlab.dto.Product;
import ec.edu.espe.experiment.springlab.model.DBProduct;

//imports
@Repository
public class ProductDAO implements IProductDAO{
    
    @Autowired
    private IProductRepo repo;
    
    @Override
    public List<Product> getAll() {
    List<Product> list = new ArrayList<>();
    try {
        List<DBProduct> list_dbProduct = repo.findAll();
        if (list_dbProduct != null) {
            for (DBProduct dbProduct : list_dbProduct) {
                list.add(toProduct(dbProduct));
            }
        }
    } catch (Exception e) {
        list = new ArrayList<>();
    }
    return list;
 }

    @Override
    public Product get(Integer id) {
        Product product = null;
        try {
            Optional<DBProduct> dbProduct = repo.findById(id);
            if(dbProduct != null){
                product = toProduct(dbProduct.get());
            }
        } catch (Exception e) {
            product = null;
        }
        return product;
    }
 
    @Override
    public Product post(Product product) {
        Product response = null;
        try {
            DBProduct dbProduct = new DBProduct(product.getName(),
            product.getDescription(),
            product.getQuantity(),
            product.getPrice());
            repo.save(dbProduct);
            repo.flush();
            response = toProduct(dbProduct);
        } catch (Exception e) {
            response = null;
        }
        return response;
    }

    
}