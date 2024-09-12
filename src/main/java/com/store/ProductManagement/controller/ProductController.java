package com.store.ProductManagement.controller;

import com.store.ProductManagement.entity.Product;
import com.store.ProductManagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/store")
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/home")
    public String homePage(){
        return "products/home-page";
    }

    @GetMapping("/list")
    public String listProduct(Model theModel){

        List<Product> theProduct = productService.findAll();
        theModel.addAttribute("products" , theProduct);
        return "products/list-product";

    }

    @GetMapping("/createProduct")
    public String createProduct(Model theModel) {
        Product theProduct = new Product();
        theModel.addAttribute("product" , theProduct );
        return "products/product-form";
    }

    @GetMapping("/showFormForEdit")
    public String editProduct(@RequestParam("productId")int theId , Model theModel){
        // get employee from service
        Product theProduct = productService.findById(theId);
        // set employee in the model to prepopulate the form
        theModel.addAttribute("product" , theProduct);
        return "products/product-form";

    }


    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("product")Product theProduct , BindingResult theResult){



        if (theResult.hasErrors()){
            return "products/product-form";
        }

        else {
            productService.save(theProduct);
            return "redirect:/store/list";
        }
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int theId) {
        productService.deleteById(theId);
        return "redirect:/store/list";
    }
}
