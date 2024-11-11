package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.request.CreateNewOrderRequest;
import com.fanci.Hyperion_be.dto.response.OrderResponse;
import com.fanci.Hyperion_be.entity.Orders;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponse toOrderResponse(Orders orders);

    Orders toOrder(CreateNewOrderRequest request);

}
