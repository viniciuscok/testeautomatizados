package com.devsuperior.bds02.controller;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<CityDTO> findAll() {
        return cityService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityDTO save(@RequestBody CityDTO cityDTO) {
        return cityService.save(cityDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable() Long id) {
        cityService.delete(id);
    }
}
