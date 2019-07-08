package vn.edu.vnuk.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.vnuk.ecommerce.exception.account.AccountNotFoundException;
import vn.edu.vnuk.ecommerce.exception.category.CategoryIsExistException;
import vn.edu.vnuk.ecommerce.exception.category.CategoryNotFoundException;
import vn.edu.vnuk.ecommerce.exception.category.CategoryValidationException;
import vn.edu.vnuk.ecommerce.exception.common.UnauthorizedException;
import vn.edu.vnuk.ecommerce.exception.token.TokenIsExpiredException;
import vn.edu.vnuk.ecommerce.exception.token.TokenNotFoundException;
import vn.edu.vnuk.ecommerce.model.Category;
import vn.edu.vnuk.ecommerce.service.admin.AdminCategoryService;
import vn.edu.vnuk.ecommerce.service.user.CategoryService;
import vn.edu.vnuk.ecommerce.service.user.CommonService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AdminCategoryService adminCategoryService;

    @Autowired
    private CommonService commonService;

    @GetMapping(value = "/category")
    public String category() {
        return "items";
    }

    @ResponseBody
    @GetMapping(value = "/api/categories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Page<Category>> getAll(@RequestParam("keyword") String keyword,
                                       Pageable pageable) {
        return new ResponseEntity<>(categoryService.getAll(keyword, pageable), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/api/categories/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> get(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return new ResponseEntity<>(categoryService.getOne(id), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(value = "/api/categories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> create(@RequestBody Category category,
                                    @RequestParam(name = "accessToken") String accessToken,
                                    HttpServletRequest request) throws TokenIsExpiredException, AccountNotFoundException, TokenNotFoundException, UnauthorizedException, CategoryValidationException, CategoryIsExistException {
        commonService.authenticate(accessToken, request);
        return new ResponseEntity<>(adminCategoryService.create(category), HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(value = "/api/categories/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> update(@RequestBody Category category,
                                           @PathVariable("id") Long id,
                                           @RequestParam(name = "accessToken") String accessToken,
                                           HttpServletRequest request) throws TokenIsExpiredException, AccountNotFoundException, TokenNotFoundException, UnauthorizedException, CategoryIsExistException, CategoryValidationException, CategoryNotFoundException {
        commonService.authenticate(accessToken, request);
        return new ResponseEntity<>(adminCategoryService.update(id, category), HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(value = "/api/categories/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> delete(@PathVariable("id") Long id,
                                       @RequestParam(name = "accessToken") String accessToken,
                                       HttpServletRequest request) throws TokenIsExpiredException, AccountNotFoundException, TokenNotFoundException, UnauthorizedException, CategoryNotFoundException {
        commonService.authenticate(accessToken, request);
        adminCategoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
