package com.kk.productmanagement.controller;

import com.kk.productmanagement.models.Product;
import com.kk.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "products";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create-product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            product.setImage_filename(imageFile.getOriginalFilename());
            productService.saveProduct(product, imageFile);
        }
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, @RequestParam("newImage") MultipartFile newImage) {
        productService.updateProduct(product, newImage);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
