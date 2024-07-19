package dev.cb.controller;

import dev.cb.business.service.ProductService;
import dev.cb.utils.enums.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // je la laisse pour l'exo mais fondue avec la méthode getAllByCategoryAndMaxPrice
//    @GetMapping()
//    public String getAll(Model model) {
//        model.addAttribute("products", productService.getAll());
//        return "products/list";
//    }

    @GetMapping()
    public String getAllByCategoryAndMaxPrice(@RequestParam(required = false) Category category,
                                           @RequestParam(required = false) Double price,
                                           Model model) {
        model.addAttribute("products", productService.getAllByCategoryAndMaxPrice(category, price));
        return "products/list";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable UUID id, Model model) {
        model.addAttribute("optionalProduct", productService.getById(id));
        return "products/detail";
    }
}
