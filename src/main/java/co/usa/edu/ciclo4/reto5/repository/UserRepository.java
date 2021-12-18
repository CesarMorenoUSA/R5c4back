/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.edu.ciclo4.reto5.repository;

import co.usa.edu.ciclo4.reto5.crud.UserCrud;
import co.usa.edu.ciclo4.reto5.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private UserCrud usc;
    public List<User> getAll() {
        return (List<User>) usc.findAll();
    }

    public Optional<User> getUser(int id) {
        return usc.findById(id);
    }

    public User create(User user) {
        return usc.save(user);
    }

    public void update(User user) {
        usc.save(user);
    }

    public void delete(User user) {
        usc.delete(user);
    }
    public boolean emailExists(String email) {
        Optional<User> usuario = usc.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return usc.findByEmailAndPassword(email, password);
    }
    public List<User> getByMonthBirthDay(String month){
        return usc.findByMonthBirthtDay(month);
    }
}
