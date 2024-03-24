package com.kk.productmanagement.service;

import com.kk.productmanagement.models.Product;
import com.kk.productmanagement.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public void saveProduct(Product product, MultipartFile imageFile) throws IOException {
        productRepository.save(product);
        saveImage(imageFile, product.getId());
    }

    public Product updateProduct(Product product, MultipartFile newImage) {
        if (!newImage.isEmpty()) {
            try {
                // Save the new image file
                String filename = newImage.getOriginalFilename();
                byte[] bytes = newImage.getBytes();
                Path path = Paths.get("src/main/resources/static/images/" + filename);
                Files.write(path, bytes);

                // Update the product's image filename
                product.setImage_filename(filename);
            } catch (IOException e) {
                // Handle file upload error
                e.printStackTrace();
            }
        }
        
        // Update the product in the database
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    private void saveImage(MultipartFile imageFile, Integer productId) throws IOException {
        if (!imageFile.isEmpty()) {
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get("src/main/resources/static/images/" + productId + "_" + imageFile.getOriginalFilename());
            Files.write(path, bytes);
        }
    }
}
