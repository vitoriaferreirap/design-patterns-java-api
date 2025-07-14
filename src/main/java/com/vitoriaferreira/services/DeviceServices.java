package com.vitoriaferreira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoriaferreira.entities.Device;
import com.vitoriaferreira.repositories.DeviceRepository;

@Service
public class DeviceServices {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    public Device findById(Long id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositorio não encontrado: " + id));
    }

    public Device insert(Device device) {
        return deviceRepository.save(device);
    }

}
