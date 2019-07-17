package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Company;
import com.tw.apistackbase.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

    @Autowired
    private CompanyRepository companyRepository;
    
    @GetMapping(produces = {"application/json"})
    public Iterable<Company> list() {
        return companyRepository.findAll();
    }
    
    @PostMapping(produces = {"application/json"})
    public Company add(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping(produces = {"application/json"})
    public Company update(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public void delete(@PathVariable long id) {
        companyRepository.deleteById(id);
    }

    @DeleteMapping(value = "/all")
    public void deleteAll() {
        companyRepository.deleteAll();
    }
}
