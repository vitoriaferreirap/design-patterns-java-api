package com.vitoriaferreira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vitoriaferreira.config.ConfigManager;
import com.vitoriaferreira.entities.Device;
import com.vitoriaferreira.repositories.DeviceRepository;

@Service
public class DeviceServices {

    @Autowired
    private DeviceRepository deviceRepository;

    // Método para consultar um dispositivo externo usando ConfigManager
    public String consultarDispositivoExterno() {
        // busca em ConfigManager a URL da API
        String url = ConfigManager.getInstance().getConfig("deviceApiUrl");
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }

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
