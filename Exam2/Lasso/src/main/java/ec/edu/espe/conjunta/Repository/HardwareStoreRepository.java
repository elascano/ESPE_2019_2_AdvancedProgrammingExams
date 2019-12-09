package ec.edu.espe.conjunta.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.conjunta.Entity.HardwareStore;

public interface HardwareStoreRepository extends JpaRepository<HardwareStore, Long>{

    List<HardwareStore> findAll();
}