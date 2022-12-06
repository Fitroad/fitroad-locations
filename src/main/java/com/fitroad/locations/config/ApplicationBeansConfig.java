package com.fitroad.locations.config;

import com.fitroad.locations.location.persistance.LocationDatasource;
import com.fitroad.locations.location.persistance.PostgresLocationDatasource;
import com.fitroad.locations.location.persistance.StubLocationDatasource;
import com.fitroad.locations.location.service.LocationService;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeansConfig {

    @Bean
    @ConditionalOnProperty(value = "datasource.stub.enabled", havingValue = "true", matchIfMissing = true)
    public LocationDatasource stubLocationDatasource() {
        return new StubLocationDatasource();
    }

    @Bean
    @ConditionalOnProperty(value = "datasource.stub.enabled", havingValue = "false")
    public LocationDatasource postgresLocationDatasource(SessionFactory sessionFactory) {
        return new PostgresLocationDatasource(sessionFactory);
    }

    @Bean
    public LocationService locationService(LocationDatasource datasource) {
        return new LocationService(datasource);
    }
}
