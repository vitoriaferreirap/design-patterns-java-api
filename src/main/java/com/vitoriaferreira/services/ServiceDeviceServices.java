package com.vitoriaferreira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoriaferreira.entities.ServiceDevice;
import com.vitoriaferreira.repositories.ServiceDeviceRepository;

@Service
public class ServiceDeviceServices {

    @Autowired
    private ServiceDeviceRepository serviceRepository;

    public List<ServiceDevice> findAll() {
        return serviceRepository.findAll();
    }

    public ServiceDevice findById(Integer id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado: " + id));
    }

    public ServiceDevice inserir(ServiceDevice serviceDevice) {
        return serviceRepository.save(serviceDevice);
    }

}
