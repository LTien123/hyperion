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

    public String deleteThumbnail(UploadThumbnail uploadThumbnail) throws IOException {
        Map<String, Object> destroyResult = cloudinary.uploader().destroy(uploadThumbnail.getThumbnailPublicId(), ObjectUtils.emptyMap());
        uploadThumbnail.setThumbnailUrl(null);
        uploadThumbnail.setThumbnailPublicId(null);
        return destroyResult.get("result").toString();
    }


}
