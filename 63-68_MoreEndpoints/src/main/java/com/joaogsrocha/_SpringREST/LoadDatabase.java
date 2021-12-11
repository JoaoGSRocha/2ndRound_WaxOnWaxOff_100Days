package com.joaogsrocha._SpringREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase {
    private static final Logger log =
            LoggerFactory.getLogger(LoadDatabase.class);
/*    @Bean
    CommandLineRunner initDatabase(SkinRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Skin(new Expansion(),"Item Skin 01", new BigDecimal((9.0)))));
            log.info("Preloading " + repository.save(new Skin(new Expansion(),"Item Skin 02", new BigDecimal((20.0)))));        };
    }*/

}
