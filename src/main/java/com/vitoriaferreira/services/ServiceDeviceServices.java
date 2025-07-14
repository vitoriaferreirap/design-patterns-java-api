package com.vitoriaferreira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoriaferreira.entities.Device;
import com.vitoriaferreira.entities.ServiceDevice;
import com.vitoriaferreira.entities.User;
import com.vitoriaferreira.repositories.ServiceDeviceRepository;

@Service
public class ServiceDeviceServices {

    @Autowired
    private ServiceDeviceRepository serviceRepository;

    @Autowired
    private UserServices userServices;

    @Autowired
    private DeviceServices deviceServices;

    public List<ServiceDevice> findAll() {
        return serviceRepository.findAll();
    }

    public ServiceDevice findById(Integer id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado: " + id));
    }

    public ServiceDevice inserir(ServiceDevice serviceDevice) {
        User user = userServices.findById(serviceDevice.getUser().getId());
        Device device = deviceServices.findById(serviceDevice.getDevice().getId());
        serviceDevice.setUser(user);
        serviceDevice.setDevice(device);
        return serviceRepository.save(serviceDevice);
    }

    public ServiceDevice update(Integer id, ServiceDevice serviceDevice) {
        ServiceDevice entity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado: " + id));
        entity.setDescription(serviceDevice.getDescription());
        entity.setStatus(serviceDevice.getStatus());
        if (serviceDevice.getUser() == null || serviceDevice.getUser().getId() == null) {
            throw new IllegalArgumentException("Usuário não informado no payload");
        }
        if (serviceDevice.getDevice() == null || serviceDevice.getDevice().getId() == null) {
            throw new IllegalArgumentException("Device não informado no payload");
        }
        User user = userServices.findById(serviceDevice.getUser().getId());
        Device device = deviceServices.findById(serviceDevice.getDevice().getId());
        entity.setUser(user);
        entity.setDevice(device);
        return serviceRepository.save(entity);
    }

    public void delete(Integer id) {
        findById(id); // Verifica se o serviço existe
        serviceRepository.deleteById(id);
    }

}
