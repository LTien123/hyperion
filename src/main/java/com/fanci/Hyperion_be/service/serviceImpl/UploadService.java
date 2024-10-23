package com.fanci.Hyperion_be.service.serviceImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fanci.Hyperion_be.dto.ProductDetailDto;
import com.fanci.Hyperion_be.dto.response.ProductImageResponse;
import com.fanci.Hyperion_be.entity.*;
import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.fanci.Hyperion_be.mapper.ProductColorMapper;
import com.fanci.Hyperion_be.mapper.ProductHandlebarMapper;
import com.fanci.Hyperion_be.mapper.ProductImageMapper;
import com.fanci.Hyperion_be.mapper.ProductMapper;
import com.fanci.Hyperion_be.repository.ProductColorRepository;
import com.fanci.Hyperion_be.repository.ProductHandlebarRepository;
import com.fanci.Hyperion_be.repository.ProductImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class UploadService {
    private final Cloudinary cloudinary;

    private final ProductImageRepository productImageRepository;
    private final ProductHandlebarRepository productHandlebarRepository;
    private final ProductColorRepository productColorRepository;

    private final ProductImageMapper productImageMapper;
    private final ProductMapper productMapper;
    private final ProductColorMapper productColorMapper;
    private final ProductHandlebarMapper productHandlebarMapper;

    public void uploadThumbnail(UploadThumbnail uploadThumbnail, MultipartFile file) throws IOException {
        if (file == null) {
            throw new AppException(ErrorCode.IMAGE_UPLOAD_FAILED);
        }
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        String url = uploadResult.get("url").toString();
        String publicId = uploadResult.get("public_id").toString();
        uploadThumbnail.setThumbnailUrl(url);
        uploadThumbnail.setThumbnailPublicId(publicId);
    }

    public List<ProductImageResponse> uploadProductImagesToCloudinary(ProductDetail productDetail, List<MultipartFile> images) throws IOException {
        if(images == null || images.isEmpty()){
            return null;
        }

        List<ProductImage> productImages = new ArrayList<>();
        for (MultipartFile image : images) {
            Map<String, Object> uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
            String url = uploadResult.get("url").toString();
            String publicId = uploadResult.get("public_id").toString();
            ProductImage productImage = ProductImage.builder()
                    .url(url)
                    .publicId(publicId)
                    .productDetail(productDetail)
                    .build();
            productImages.add(productImageRepository.save(productImage));

        }


        return productImages.stream().map(this::toProductImageResponse).toList();
    }

    private ProductImageResponse toProductImageResponse(ProductImage productImage) {
        ProductImageResponse productImageResponse = productImageMapper.toProductImageResponse(productImage);
       productImageResponse.setProductDetailId(productImage.getProductDetail().getId());
        return productImageResponse;
    }
}
