package co.usa.edu.ciclo4.reto5;

import co.usa.edu.ciclo4.reto5.crud.GadgetCrud;
import co.usa.edu.ciclo4.reto5.crud.OrderCrud;
import co.usa.edu.ciclo4.reto5.crud.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
@Component
@SpringBootApplication
public class Reto5Application implements CommandLineRunner{
    @Autowired
    private GadgetCrud GC;
    @Autowired
    private UserCrud UC;
    @Autowired
    private OrderCrud OC;
	public static void main(String[] args) {
		SpringApplication.run(Reto5Application.class, args);
	}
    @Override
    public void run(String... args) throws Exception {
        GC.deleteAll();
        UC.deleteAll();
        OC.deleteAll();
    }
}
