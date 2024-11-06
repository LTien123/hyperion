package com.fanci.Hyperion_be.dto.request;

import com.fanci.Hyperion_be.entity.UploadThumbnail;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateSubCategoryRequest {
    private String name;
    private String description;
    private MultipartFile thumbnail;
}
