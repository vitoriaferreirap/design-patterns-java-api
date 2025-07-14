package com.vitoriaferreira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoriaferreira.entities.ServiceDevice;

public interface ServiceDeviceRepository extends JpaRepository<ServiceDevice, Integer> {

}
