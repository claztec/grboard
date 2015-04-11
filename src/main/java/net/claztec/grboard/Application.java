package net.claztec.grboard;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Derek Choi on 15. 4. 11.
 */

@Configurable
@EnableAutoConfiguration
@ComponentScan("net.claztec.grboard")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
