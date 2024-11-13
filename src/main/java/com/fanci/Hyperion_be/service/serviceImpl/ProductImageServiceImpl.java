package com.fanci.Hyperion_be.service.serviceImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fanci.Hyperion_be.dto.response.ProductImageResponse;
import com.fanci.Hyperion_be.entity.ProductDetail;
import com.fanci.Hyperion_be.entity.ProductImage;
import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.fanci.Hyperion_be.mapper.ProductImageMapper;
import com.fanci.Hyperion_be.repository.ProductImageRepository;
import com.fanci.Hyperion_be.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {
    private final Cloudinary cloudinary;

    private final ProductImageRepository productImageRepository;

    private final UploadService uploadService;


    private final ProductImageMapper productImageMapper;

    @Override
    public List<ProductImageResponse> uploadProductImagesToCloudinary(ProductDetail productDetail, List<MultipartFile> images) throws IOException {
        if (images == null || images.isEmpty()) {
            return null;
        }

        List<ProductImage> productImages = new ArrayList<>();

        // Lặp qua các hình ảnh và tải lên Cloudinary
        for (MultipartFile image : images) {
            Map<String, Object> uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
            String url = uploadResult.get("url").toString();
            String publicId = uploadResult.get("public_id").toString();

            // Tạo đối tượng ProductImage
            ProductImage productImage = ProductImage.builder()
                    .url(url)
                    .publicId(publicId)
                    .productDetail(productDetail)
                    .build();

            // Thêm vào danh sách thay vì lưu ngay
            productImages.add(productImage);
        }

        // Sử dụng saveAll để lưu tất cả các đối tượng một lần
        List<ProductImage> savedProductImages = productImageRepository.saveAll(productImages);

        // Chuyển đổi danh sách thành ProductImageResponse và trả về
        return savedProductImages.stream()
                .map(this::toProductImageResponse)
                .toList();
    }

    @Override
    public String deleteImage(Long id) throws IOException {
        var productImage = productImageRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.IMAGE_ID_NOT_FOUND));
        Map<String, Object> destroyResult = cloudinary.uploader().destroy(productImage.getPublicId(), ObjectUtils.emptyMap());
        productImageRepository.delete(productImage);
        return destroyResult.get("result").toString();
    }

    private ProductImageResponse toProductImageResponse(ProductImage productImage) {
        ProductImageResponse productImageResponse = productImageMapper.toProductImageResponse(productImage);
        productImageResponse.setProductDetailId(productImage.getProductDetail().getId());
        return productImageResponse;
    }

}
