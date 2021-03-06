/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.edu.ciclo4.reto5.controller;

/**
 *
 * @author cesar
 */

import co.usa.edu.ciclo4.reto5.model.Gadget;
import co.usa.edu.ciclo4.reto5.service.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gadget")
@CrossOrigin("*")
public class GadgetController {
    @Autowired
    private GadgetService gadgetservice;

    @GetMapping("/all")
    public List<Gadget> getAll() {
        return gadgetservice.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gadget> getClothe(@PathVariable("id") Integer id) {
        return gadgetservice.getClothe(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget create(@RequestBody Gadget gadget) {
        return gadgetservice.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget gadget) {
        return gadgetservice.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return gadgetservice.delete(id);
    }
    @GetMapping("/price/{price}")
    public List<Gadget> getByPrice(@PathVariable("price") double price){
        return gadgetservice.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Gadget> getByDescriptionContains(@PathVariable("description") String description){
        return gadgetservice.getByDescriptionContains(description);
    }
}
