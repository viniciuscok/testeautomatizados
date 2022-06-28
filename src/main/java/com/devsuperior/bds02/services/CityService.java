package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;

import java.util.List;

public interface CityService {

    List<CityDTO> findAll();

    CityDTO save(CityDTO cityDTO);

    void delete(Long id);
}
