package vn.edu.vnuk.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.vnuk.ecommerce.exception.category.CategoryNotFoundException;
import vn.edu.vnuk.ecommerce.exception.item.ItemNotFoundException;
import vn.edu.vnuk.ecommerce.model.Category;
import vn.edu.vnuk.ecommerce.model.Item;
import vn.edu.vnuk.ecommerce.service.user.CategoryService;
import vn.edu.vnuk.ecommerce.service.user.ItemService;

@Controller
public class ViewController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        model.addAttribute("items", itemService.getAll(new PageRequest(0, 20)));
        model.addAttribute("itemsBestBuy", itemService.getAll(new PageRequest(0, 9)));
        return "home";
    }

    @GetMapping(value = "/items")
    public String items() {
        return "items";
    }

    @GetMapping(value = "/item/{id}")
    public String item(@PathVariable(value = "id") Long id,
                       Model model) throws ItemNotFoundException, CategoryNotFoundException {
        Item item = itemService.getOne(id);
        Category category = categoryService.getOne(item.getCategoryId());

        model.addAttribute("item", item);
        model.addAttribute("category", category);

        return "item";
    }

    @GetMapping(value = "/confirmation")
    public String confirmation() {
        return "confirmation";
    }

    @GetMapping(value = "/blogs")
    public String blogs() {
        return "blogs";
    }

    @GetMapping(value = "/blog/{id}")
    public String blog() {
        return "blog";
    }

    @GetMapping(value = "/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping(value = "/search")
    public String search() {
        return "search";
    }

    @GetMapping(value = "/admin/login")
    public String adminLogin() {
        return "admin/login";
    }

    @GetMapping(value = "/admin/home")
    public String adminHome() {
        return "admin/home";
    }

    @GetMapping(value = "/admin/blogs")
    public String adminBlogs() {
        return "admin/blogs";
    }

    @GetMapping(value = "/admin/blog/{id}")
    public String adminSingleBlog() {
        return "admin/blog-add.html";
    }


}
