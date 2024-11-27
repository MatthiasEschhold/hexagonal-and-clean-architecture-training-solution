package de.arkem.clean.arc.demo.garage.order.adapter.out.db;

import de.arkem.clean.arc.demo.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.garage.order.domain.model.OrderNumber;
import de.arkem.clean.arc.demo.garage.order.domain.model.item.OrderItem;
import de.arkem.clean.arc.demo.garage.order.usecase.out.GarageOrderDbCommand;
import de.arkem.clean.arc.demo.garage.order.usecase.out.GarageOrderDbQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
class GarageOrderRepository implements GarageOrderDbCommand, GarageOrderDbQuery {
    private final GarageOrderJpaRepository jpaRepository;
    private final GarageOrderToDbEntityMapper mapper;

    public GarageOrderRepository(GarageOrderJpaRepository jpaRepository, GarageOrderToDbEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public GarageOrder save(GarageOrder garageOrder) {
        return mapper.mapToDomain(jpaRepository.save(mapper.mapToDbEntity(garageOrder)));
    }
    @Override
    public GarageOrder addOrderItem(OrderItem orderItem) {
        return null;
    }
    @Override
    public Optional<GarageOrder> findByOrderNumber(OrderNumber orderNumber) {
        return jpaRepository.findById(orderNumber.getValue()).map(mapper::mapToDomain);
    }
    @Override
    public List<GarageOrder> findAll() {
        return jpaRepository.findAll().stream().map(mapper::mapToDomain).collect(Collectors.toList());
    }
}
