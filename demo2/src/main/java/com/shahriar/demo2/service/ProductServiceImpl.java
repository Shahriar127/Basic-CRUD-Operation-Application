package com.shahriar.demo2.service;

import com.shahriar.demo2.dto.ProductDto;
import com.shahriar.demo2.dto.Response;
import com.shahriar.demo2.model.Product;
import com.shahriar.demo2.repository.ProductRepository;
import com.shahriar.demo2.util.ResponseBuilder;
import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    private final HttpMessageConverters messageConverters;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final String root = "Product";

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, HttpMessageConverters messageConverters) {
        this.productRepository = productRepository;
        this.modelMapper = new ModelMapper();
        this.messageConverters = messageConverters;
    }

    @Override
    public Response save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product = productRepository.save(product);
        if(product != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED , root + "created successfully ",null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, root + "Internal Server Error");
    }

    @Override
    public Response update(Long id, ProductDto productDto) {
        Product product = productRepository.findByIdAndIsActiveTrue(id);
        if(product != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            modelMapper.map(productDto, product);
            product = productRepository.save(product);
            if(product != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK , root + "updated successfully ",null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, root + "Internal Server Error");

        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, root + "Internal Server Error");
    }

    @Override
    public Response get(Long id) {
        Product product = productRepository.findByIdAndIsActiveTrue(id);
        if(product != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
          ProductDto productDto = modelMapper.map(product, ProductDto.class);
            if(product != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK , root + "Get successfully ",null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, root + "Internal Server Error");

        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, root + "Internal Server Error");

    }

    @Override
    public Response delete(Long id) {
        Product product = productRepository.findByIdAndIsActiveTrue(id);
        if(product != null) {
            product.setActive(false);
            product = productRepository.save(product);
            if(product != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK , root + "deleted successfully ",null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, root + "Internal Server Error");

        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, root + "Internal Server Error");

    }

    @Override
    public Response getAll() {
        List<Product> products = productRepository.findAllByActiveTrue();
        List<ProductDto> productDtos = this.getProductDtoList(products);

        return ResponseBuilder.getSuccessResponse(HttpStatus.OK , root + "retrive successfully ",productDtos)  ;
    }

    private List<ProductDto> getProductDtoList(List<Product> productList) {
        List<ProductDto> productDtoList = new ArrayList<>();
            productList.forEach(product -> {
                modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
                ProductDto productDto = modelMapper.map(product, ProductDto.class);
                productDtoList.add(productDto);
        });
            return productDtoList;
    }

}
