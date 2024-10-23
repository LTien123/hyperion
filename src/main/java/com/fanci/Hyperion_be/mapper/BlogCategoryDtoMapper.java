package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.BlogCategoryDto;
import com.fanci.Hyperion_be.entity.BlogCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogCategoryDtoMapper {
    BlogCategoryDto toBlogCategoryDto(BlogCategory blogCategory);
}
