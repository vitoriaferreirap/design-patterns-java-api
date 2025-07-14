package com.vitoriaferreira.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitoriaferreira.entities.ServiceDevice;
import com.vitoriaferreira.services.ServiceDeviceServices;

@RestController
@RequestMapping("/services")
public class ServiceDeviceController {

    @Autowired
    private ServiceDeviceServices serviceDeviceServices;

    // endepoints
    @GetMapping
    public ResponseEntity<List<ServiceDevice>> getAllServices() {
        List<ServiceDevice> services = serviceDeviceServices.findAll();
        return ResponseEntity.ok(services);
    }

    @PostMapping
    public ResponseEntity<ServiceDevice> createService(@RequestBody ServiceDevice service) {
        service = serviceDeviceServices.inserir(service);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(service.getId())
                .toUri();
        return ResponseEntity.created(uri).body(service);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceDevice> updateService(@PathVariable Integer id, @RequestBody ServiceDevice service) {
        service = serviceDeviceServices.update(id, service);
        return ResponseEntity.ok().body(service);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Integer id) {
        serviceDeviceServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
