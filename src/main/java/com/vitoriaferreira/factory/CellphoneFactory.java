package com.vitoriaferreira.factory;

import com.vitoriaferreira.entities.Device;

/*
 * Aplicando conceito de Factory Method para criar celulares.
 * Classe concreta que implementa a interface DeviceFactory.
 */
public class CellphoneFactory implements DeviceFactory {

    @Override
    public Device createDevice(String brand, String model) {
        // Lógica para criar um dispositivo do tipo celular
        return new Device(null, "Celular", brand);
    }
}
