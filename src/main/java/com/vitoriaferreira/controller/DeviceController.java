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

import com.vitoriaferreira.entities.Device;
import com.vitoriaferreira.services.DeviceServices;

@RestController
@RequestMapping(value = "/devices")
public class DeviceController {

    @Autowired
    private DeviceServices deviceServices;

    // endpoints

    @GetMapping
    public ResponseEntity<List<Device>> findAll() {
        List<Device> devices = deviceServices.findAll();
        return ResponseEntity.ok().body(devices);
    }

    @PostMapping
    public ResponseEntity<Device> insert(@RequestBody Device device) {
        device = deviceServices.insert(device);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(device.getId()).toUri();
        return ResponseEntity.created(uri).body(device);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> update(@PathVariable Integer id, @RequestBody Device device) {
        device = deviceServices.update(id, device);
        return ResponseEntity.ok().body(device);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        deviceServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
