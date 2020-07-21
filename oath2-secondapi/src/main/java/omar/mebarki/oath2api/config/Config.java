package omar.mebarki.oath2api.config;

import omar.mebarki.oath2api.controller.HelloController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan(basePackageClasses = {HelloController.class})
public class Config {
}
