package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.response.OrderDetailResponse;
import com.fanci.Hyperion_be.entity.OrderDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail);
}
