package com.vitoriaferreira.factory;

import com.vitoriaferreira.entities.Device;

/*
 * Aplicando conceito de Factory Method para criar dispositivos.
 */
public interface DeviceFactory {
    Device createDevice(String brand, String model);
}
