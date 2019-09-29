package bootstrap;

import com.spring.services.OwnerService;
import com.spring.services.VetService;
import com.spring.services.map.OwnerServiceMap;
import com.spring.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
