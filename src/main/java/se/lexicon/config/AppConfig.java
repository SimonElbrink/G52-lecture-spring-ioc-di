package se.lexicon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//IOC
// Dependencies are stored in an Application Context
@Configuration
@ComponentScan(basePackages = "se.lexicon") // Scanning the project for Beans in given package
public class AppConfig {

}
