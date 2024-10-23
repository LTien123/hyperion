package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.request.CreateNewBlogCategoryRequest;
import com.fanci.Hyperion_be.dto.response.BlogCategoryResponse;
import com.fanci.Hyperion_be.entity.BlogCategory;
import com.fanci.Hyperion_be.mapper.BlogCategoryMapper;
import com.fanci.Hyperion_be.repository.BlogCategoryRepository;
import com.fanci.Hyperion_be.service.BlogCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogCategoryServiceImpl implements BlogCategoryService {
    private final BlogCategoryRepository blogCategoryRepository;
    private final BlogCategoryMapper blogCategoryMapper;

    @Override
    public Set<BlogCategoryResponse> findAllBlogCategories() {
        return blogCategoryRepository.findAll().stream().map(blogCategoryMapper::toBlogCategoryResponse).collect(Collectors.toSet());
    }

    @Override
    public BlogCategoryResponse addNewBlogCategory(CreateNewBlogCategoryRequest request) {
        BlogCategory blogCategory = blogCategoryMapper.toBlogCategory(request);
        return blogCategoryMapper.toBlogCategoryResponse(blogCategoryRepository.save(blogCategory));

    }
}
