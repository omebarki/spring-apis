package omar.mebarki.oath2api;

import omar.mebarki.oath2api.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = Config.class)
public class Oath2ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oath2ApiApplication.class, args);
    }

}
