package com.local.kattalocal.kattapp.controller.v1;

import com.local.kattalocal.kattapp.model.Category;
import com.local.kattalocal.kattapp.service.CategoryService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping(value = "/v1/categories")
  public ResponseEntity<Category> getCategoryByName(@RequestParam("name") String name) {
    return ResponseEntity.ok(categoryService.findByName(name));
  }

  @GetMapping(value = "/v1/categories/subcategories")
  public ResponseEntity<List<Category>> getSubCategoriesOfCategories(
      @RequestParam("name") String name) {
    return null;
  }

}
