package com.devsuperior.bds02.services.impl;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repository.CityRepository;
import com.devsuperior.bds02.services.CityService;
import com.devsuperior.bds02.services.exception.DatabaseException;
import com.devsuperior.bds02.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDTO> findAll() {
        List<City> cities = cityRepository.findAll(Sort.by("name"));
        return cities.stream().map(city -> new CityDTO(city)).collect(Collectors.toList());
    }

    @Override
    public CityDTO save(final CityDTO cityDTO) {
        City city = cityRepository.save(new City(cityDTO));
        return new CityDTO(city);
    }

    @Override
    public void delete(final Long id) {
        try {
            cityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
