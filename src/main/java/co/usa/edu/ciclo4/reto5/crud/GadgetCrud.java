/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.usa.edu.ciclo4.reto5.crud;

import co.usa.edu.ciclo4.reto5.model.Gadget;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author cesar
 */
public interface GadgetCrud extends MongoRepository<Gadget, Integer>{
    public List<Gadget> findByPriceLessThanEqual(double price);
    public List<Gadget> findByDescriptionContainingIgnoreCase(String description);
}
