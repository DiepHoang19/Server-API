package com.example.apicsw.service;

import com.example.apicsw.entity.Products;
import com.example.apicsw.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public Optional<Products> findById(Long id) {
        return productsRepository.findById(id);
    }

    public Products save(Products products) {
        return productsRepository.save(products);
    }

    public void delete(Long id) {
        productsRepository.deleteById(id);
    }

    public Products update(Products employeeDto,Long id) {
        Optional<Products> optionalEmployee = productsRepository.findById(id);
        Products products = optionalEmployee.get();
        products.setName(employeeDto.getName());
        products.setSalary(employeeDto.getSalary());
        return productsRepository.save(products);

    }
}
