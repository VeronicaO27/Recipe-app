package com.example.RecipeApp.service;


import com.example.RecipeApp.Repository.CategoryRepository;
import com.example.RecipeApp.dtos.CategoryDto;
import com.example.RecipeApp.entities.Category;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id: " + id + " not found"));
        return toDTO(category);
    }

    @Override
    public CategoryDto save(CategoryDto categoryDTO) {
        Category category = toEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return toDTO(savedCategory);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    // manual mapping methods
    private CategoryDto toDTO(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    private Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        return category;
    }
}


//import com.example.RecipeApp.Repository.CategoryRepository;
//import com.example.RecipeApp.dtos.CategoryDto;
//import com.example.RecipeApp.entities.Category;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class CategoryServiceImpl implements CategoryService {
//
//    private final CategoryRepository categoryRepository;
//    private final CategoryMapper categoryMapper;
//
//    @Autowired
//    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
//        this.categoryRepository = categoryRepository;
//        this.categoryMapper = categoryMapper;
//    }
//
//    @Override
//    public List<CategoryDto> findAll() {
//        return categoryRepository.findAll().stream()
//                .map(categoryMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public CategoryDto findById(Long id) {
//        Category category = categoryRepository.findById(id)
//                .orElseThrow(() -> new EntitiesNotFoundException("Category with id: " + id + " not found"));
//        return categoryMapper.toDTO(category);
//    }
//
//    @Override
//    public CategoryDto save(CategoryDto categoryDTO) {
//        Category category = categoryMapper.toEntity(categoryDTO);
//        Category savedCategory = categoryRepository.save(category);
//        return categoryMapper.toDTO(savedCategory);
//    }
//
//    @Override
//    public void delete(Long id) {
//        categoryRepository.deleteById(id);
//    }
//}
//
