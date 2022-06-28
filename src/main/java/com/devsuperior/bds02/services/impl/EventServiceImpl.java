package com.devsuperior.bds02.services.impl;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repository.EventRepository;
import com.devsuperior.bds02.services.EventService;
import com.devsuperior.bds02.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventDTO update(final EventDTO eventDTO, final Long id) {
        try {
            Event event = eventRepository.getOne(id);
            event.getCity().setId(eventDTO.getCityId());
            event.setName(eventDTO.getName());
            event.setUrl(eventDTO.getUrl());
            event.setDate(eventDTO.getDate());
            return new EventDTO(eventRepository.save(event));
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }
}
