/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.edu.ciclo4.reto5.service;

/**
 *
 * @author cesar
 */
import co.usa.edu.ciclo4.reto5.model.Gadget;
import co.usa.edu.ciclo4.reto5.repository.GadgetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GadgetService {
    @Autowired
    private GadgetRepository gdr;
    
    public List<Gadget> getAll() {
        return gdr.getAll();
    }

    public Optional<Gadget> getClothe(Integer id) {
        return gdr.getClothe(id);
    }

    public Gadget create(Gadget gadget) {
        if (gadget.getId() == null) {
            return gadget;
        } else {
            return gdr.create(gadget);
        }
    }

    public Gadget update(Gadget gadget) {

        if (gadget.getId() != null) {
            Optional<Gadget> dbGadget = gdr.getClothe(gadget.getId());
            if (!dbGadget.isEmpty()) {

                if (gadget.getBrand()!= null) {
                    dbGadget.get().setBrand(gadget.getBrand());
                }

                if (gadget.getCategory() != null) {
                    dbGadget.get().setCategory(gadget.getCategory());
                }

                if (gadget.getName() != null) {
                    dbGadget.get().setName(gadget.getName());
                }

                if (gadget.getDescription() != null) {
                    dbGadget.get().setDescription(gadget.getDescription());
                }

                if (gadget.getPrice() != 0.0) {
                    dbGadget.get().setPrice(gadget.getPrice());
                }

                if (gadget.getQuantity() != 0) {
                    dbGadget.get().setQuantity(gadget.getQuantity());
                }

                if (gadget.getPhotography() != null) {
                    dbGadget.get().setPhotography(gadget.getPhotography());
                }

                dbGadget.get().setAvailability(gadget.isAvailability());
                gdr.update(dbGadget.get());
                return dbGadget.get();
            } else {
                return gadget;
            }
        } else {
            return gadget;
        }
    }

    public boolean delete(Integer reference) {
        Boolean aBoolean = getClothe(reference).map(gadget -> {
            gdr.delete(gadget);
            return true;
        }).orElse(false);
        return aBoolean;
    } 
    public List<Gadget> getByPrice(double price){
        return gdr.getByPrice(price);
    }

    public List<Gadget> getByDescriptionContains(String description){
        return gdr.getByDescriptionContains(description);
    }
}
