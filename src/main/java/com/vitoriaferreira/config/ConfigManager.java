package com.vitoriaferreira.config;

import java.util.HashMap;
import java.util.Map;

/*
 * Classe que gerencia as configurações do sistema.
 * A ideia central do Singleton é:
 * - Ter um construtor privado para impedir que outras classes criem instâncias diretamente.
 * - Ter um atributo estático que armazena a única instância da classe.
 * - Ter um método público e estático (geralmente chamado de getInstance) que retorna sempre a mesma instância, ou cria se ainda não existir.
 * - Assim, qualquer parte do sistema que chamar ConfigManager.getInstance() vai receber sempre o mesmo objeto, garantindo uma única instância no sistema.
 * - Centralizar configs sensíveis
 * - Centraliza valores de configuração em tempo de execução.
 */
public class ConfigManager {

    // Armazena a única instância da classe.
    private static ConfigManager instance;

    // map para armazenar as configs
    private Map<String, String> configMap;

    // Construtor privado impede que outras classes criem instâncias diretamente.
    private ConfigManager() {
        // inicialização do map de configurações
        configMap = new HashMap<>();
    }

    // Método que retorna a instância única, criando-a se ainda não existir.
    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    // manipula configs (definir ou obter configs)
    public void setConfig(String key, String value) {
        configMap.put(key, value);
    }

    public String getConfig(String key) {
        return configMap.get(key);
    }

}