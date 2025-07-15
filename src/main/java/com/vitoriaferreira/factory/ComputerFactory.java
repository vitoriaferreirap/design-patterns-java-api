package com.vitoriaferreira.factory;

import com.vitoriaferreira.entities.Device;

/*
 * Aplicando conceito de Factory Method para criar computadores.
 * Classe concreta que implementa a interface DeviceFactory.
 * Elas centralizam a lógica de criação de objetos Device.
 * Em vez de criar o Device diretamente, pede para a fábrica podendo aplicar regras específicas para cada tipo.
 */
public class ComputerFactory implements DeviceFactory {

    @Override
    public Device createDevice(String brand, String model) {
        // Lógica para criar um dispositivo do tipo computador
        return new Device(null, "Computador", brand);
    }
}
