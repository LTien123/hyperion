package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.response.ProductImageResponse;
import com.fanci.Hyperion_be.entity.ProductDetail;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductImageService {

    List<ProductImageResponse> uploadProductImagesToCloudinary(ProductDetail productDetail, List<MultipartFile> images) throws IOException;

    String deleteImage(Long id) throws IOException;
}
