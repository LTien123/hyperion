package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.ProductColorDto;
import com.fanci.Hyperion_be.dto.request.CreateNewProductColorRequest;
import com.fanci.Hyperion_be.dto.response.ProductColorResponse;
import com.fanci.Hyperion_be.entity.ProductColor;

import java.util.List;
import java.util.Set;

public interface ProductColorService {
    List<ProductColorResponse> getAllColors();

    ProductColorResponse addNewColor(CreateNewProductColorRequest request);

}
