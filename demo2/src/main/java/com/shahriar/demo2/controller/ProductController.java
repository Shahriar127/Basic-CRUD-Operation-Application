package com.shahriar.demo2.controller;

import com.shahriar.demo2.annotations.ApiController;
import com.shahriar.demo2.dto.ProductDto;
import com.shahriar.demo2.dto.Response;
import com.shahriar.demo2.service.ProductService;
import com.shahriar.demo2.util.ResponseBuilder;
import com.shahriar.demo2.util.UrlConstant;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@ApiController
@RequestMapping(UrlConstant.ProductManagement.ROOT)
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping(UrlConstant.ProductManagement.CREATE)
    public Response Create(@Valid @RequestBody ProductDto productDto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseBuilder.getFailureResponse(result,"Bean Binding Error");
        }
        return productService.save(productDto);
    }

    @PutMapping(UrlConstant.ProductManagement.UPDATE)
    public Response update(@PathVariable("id") Long id,@Valid @RequestBody ProductDto productDto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseBuilder.getFailureResponse(result,"Bean Binding Error");
        }
        return productService.update(id,productDto);
    }

    @DeleteMapping(UrlConstant.ProductManagement.DELETE)
    public Response delete(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @GetMapping(UrlConstant.ProductManagement.GET)
    public Response get(@PathVariable("id") Long id) {
        return productService.get(id);
    }

    @GetMapping(UrlConstant.ProductManagement.GET_ALL)
    public Response getAll() {
        System.out.println("getAll method in ProductController called");
        return productService.getAll();
    }

}
