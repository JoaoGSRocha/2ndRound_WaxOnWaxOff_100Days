package com.joaogsrocha._SpringREST.config;

import com.joaogsrocha._SpringREST.model.expansion.Expansion;
import com.joaogsrocha._SpringREST.model.skin.Skin;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class MyRepositoryRestConfigurerAdapter implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Skin.class);
        config.exposeIdsFor(Expansion.class);
    }
}
