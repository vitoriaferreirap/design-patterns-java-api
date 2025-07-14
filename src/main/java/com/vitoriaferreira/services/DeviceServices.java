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

    public Device findById(Integer id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo não encontrado: "));
    }

    public Device insert(Device device) {
        return deviceRepository.save(device);
    }

    public Device update(Integer id, Device device) {
        Device existingDevice = findById(id);
        updateDate(existingDevice, device);
        return deviceRepository.save(existingDevice);
    }

    private void updateDate(Device existingDevice, Device device) {
        existingDevice.setType(device.getType());
        existingDevice.setBrand(device.getBrand());

    }

    public void delete(Integer id) {
        Device device = findById(id);
        deviceRepository.delete(device);
    }

}
