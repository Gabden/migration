package ru.gabdulin.migration.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gabdulin.migration.main.models.newer.product.ProductDetails;
import ru.gabdulin.migration.main.models.old.Product;
import ru.gabdulin.migration.main.models.old.ProductImage;
import ru.gabdulin.migration.main.repos.newa.NewProductRepo;
import ru.gabdulin.migration.main.repos.old.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/migration")
public class ProductController {
    private ProductRepository oldProductRepository;
    private NewProductRepo newProductRepo;

    public ProductController(ProductRepository oldProductRepository, NewProductRepo newProductRepo) {
        this.oldProductRepository = oldProductRepository;
        this.newProductRepo = newProductRepo;
    }

    @RequestMapping("/products")
    public ResponseEntity migrateProducts(){
        Iterable<Product> oldProducts = oldProductRepository.findAll();
        oldProducts.forEach(product -> {
            ru.gabdulin.migration.main.models.newer.product.Product newProduct = new ru.gabdulin.migration.main.models.newer.product.Product();
            newProduct.setDiscount(product.getDiscount());
            newProduct.setProductCategory(product.getProductCategory());
            newProduct.setProductDescription(product.getProductDescription());
            newProduct.setProductName(product.getProductName());
            newProduct.setProductPrice(product.getProductPrice());
            //details
            ProductDetails productDetails = new ProductDetails();
            productDetails.setProduct(newProduct);
            productDetails.setProductAlcoholColor(product.getProductAlcoholColor());
            productDetails.setProductAlcoholDegree(product.getProductAlcoholDegree());
            productDetails.setProductAlcoholSort(product.getProductAlcoholSort());
            productDetails.setProductAlcoholSugar(product.getProductAlcoholSugar());
            productDetails.setProductAlcoholTemperature(product.getProductAlcoholTemperature());
            productDetails.setProductCountry(product.getProductCountry());
            productDetails.setProductManufacturer(product.getProductManufacturer());
            productDetails.setProductMature(product.getProductMature());
            productDetails.setProductRegion(product.getProductRegion());
            productDetails.setProductTaste(product.getProductTaste());
            productDetails.setProductType(product.getProductType());
            productDetails.setProductUnitInStock(product.getProductUnitInStock());
            productDetails.setProductVolume(product.getProductVolume());
            newProduct.setProductDetails(productDetails);
            //image
            ru.gabdulin.migration.main.models.newer.product.ProductImage newImage = new ru.gabdulin.migration.main.models.newer.product.ProductImage();
            newImage.setProduct(newProduct);
            List<ProductImage> images = new ArrayList<>(product.getProductImageSet());
            newImage.setFileData(images.get(0).getFileData());
            newImage.setFileName(images.get(0).getFileName());
            newImage.setFileType(images.get(0).getFileType());
            newProduct.setProductImage(newImage);
            newProduct.setProductSalePrice(product.getSalePrice());
            newProductRepo.save(newProduct);
        });
        return ResponseEntity.ok("Products migrated");
    }
}
