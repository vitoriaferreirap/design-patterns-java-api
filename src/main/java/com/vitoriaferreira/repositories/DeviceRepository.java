package com.vitoriaferreira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoriaferreira.entities.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}
