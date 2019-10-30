package ec.edu.espe.experiment.springlab.dao;

import java.util.List;

import ec.edu.espe.experiment.springlab.dto.Product;
import ec.edu.espe.experiment.springlab.model.DBProduct;


public interface IProductDAO{
    public List<Product> getAll();
    public Product get(Integer id);
    public Product post(Product product);
    public Product toProduct(DBProduct dbProduct);
}