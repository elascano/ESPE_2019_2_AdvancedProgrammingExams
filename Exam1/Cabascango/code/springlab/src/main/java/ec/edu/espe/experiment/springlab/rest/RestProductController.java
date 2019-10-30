package ec.edu.espe.experiment.springlab.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.experiment.springlab.dao.IProductDAO;
import ec.edu.espe.experiment.springlab.dto.Product;
import java.util.List;


@RestController
@RequestMapping("api/product")
public class RestProductController{
    @Autowired
    private IProductDAO dao;
    @GetMapping
        public  ResponseEntity<List<Product>> getAll() {
            List<Product> response = dao.getAll();
            if (response != null) {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> get(@PathVariable("id") Integer id) {
        Product response = dao.get(id);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Product> post(@RequestBody Product entity) {
        Product response = dao.post(entity);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}