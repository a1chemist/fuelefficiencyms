package core.microservice.fuelefficiency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "core.client",
        "core.microservice.fuelefficiency",
        "io"
})
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class FuelEfficiencyMSApp {

    public static void main(String[] args) {
        System.setProperty("config.properties.file", "classpath:application.yml");
        SpringApplication.run(FuelEfficiencyMSApp.class, args);
    }

}
