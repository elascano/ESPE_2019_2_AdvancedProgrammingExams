package ec.edu.espe.conjunta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.espe.conjunta.Entity.HardwareStore;
import ec.edu.espe.conjunta.Repository.HardwareStoreRepository;

@Controller
@RequestMapping(value ="/api")
public class HardwareController {

    @Autowired
    private HardwareStoreRepository hardwareStoreRepository;

    @GetMapping("/all")
    public List<HardwareStore> viewData() {
        return hardwareStoreRepository.findAll();
    }

    @GetMapping("/test")
    public String viewDataD() {
        return "hardwareStoreRepository.findAll()";
    }
}