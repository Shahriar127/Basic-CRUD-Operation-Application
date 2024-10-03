package com.shahriar.demo2.service;

import com.shahriar.demo2.dto.ProductDto;
import com.shahriar.demo2.dto.Response;

public interface ProductService {
    Response save(ProductDto productDto);
    Response update(Long id, ProductDto productDto);
    Response get(Long id);
    Response getAll();
    Response delete(Long id);
}
