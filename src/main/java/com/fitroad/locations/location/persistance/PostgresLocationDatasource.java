package com.fitroad.locations.location.persistance;

import com.fitroad.locations.location.BaseLocation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PostgresLocationDatasource implements LocationDatasource {
    private final SessionFactory sessionFactory;

    public PostgresLocationDatasource(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Mono<Boolean> save(BaseLocation location) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                session.save(location);
            } catch (HibernateException hibernateException) {
                transaction.rollback();
                throw hibernateException;
            }
            transaction.commit();
        }
        return Mono.just(true);
    }

    @Override
    public Mono<BaseLocation> getLocationByName(String name) {
        BaseLocation baseLocation;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Query<BaseLocation> query = session.createQuery("FROM locations WHERE locations.name = :name");
                query.setParameter("name", name);
                baseLocation = query.uniqueResult();
            } catch (HibernateException hibernateException) {
                transaction.rollback();
                throw hibernateException;
            }
            transaction.commit();
        }
        return Mono.justOrEmpty(baseLocation);
    }

    @Override
    public Flux<BaseLocation> getLocations() {
        return Flux.empty();
    }
}
