package com.example.apicsw.api;


import com.example.apicsw.entity.Products;
import com.example.apicsw.repository.ProductsRepository;
import com.example.apicsw.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"https://client-csw.vercel.app/","http://localhost:3000/"})
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {
    @Autowired
    ProductsRepository productsRepository;
    ProductsService productsService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(productsService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productsService.findById(id));
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Products> Save(@RequestBody Products products) {
        return ResponseEntity.ok(productsService.save(products));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> Delete(@PathVariable Long id) {
        productsService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Products> Update(@RequestBody Products employeeDto, @PathVariable Long id) {
        return ResponseEntity.ok(productsService.update(employeeDto, id));
    }

}
