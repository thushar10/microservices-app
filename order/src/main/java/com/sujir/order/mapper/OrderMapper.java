package com.sujir.order.mapper;

import com.sujir.order.dto.OrderDto;
import com.sujir.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    Order mapOrderDTOToOrder(OrderDto orderDto);
    OrderDto mapOrderToOrderDto(Order order);
}
