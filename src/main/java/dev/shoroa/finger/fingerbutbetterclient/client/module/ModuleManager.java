package dev.shoroa.finger.fingerbutbetterclient.client.module;

import java.util.HashMap;
import java.util.List;

public class ModuleManager {
    private HashMap<Class<? extends Module>,Module> moduleMap = new HashMap<>();

    public void register(Class<? extends Module> clazz, Module mod) {
        moduleMap.put(clazz, mod);
    }

    public <T> T get(Class<T> clazz) {
        return (T) moduleMap.get(clazz);
    }

    public List<Module> modules() {
        return moduleMap.values().stream().toList();
    }
    public List<Class<? extends Module>> classes() {
        return moduleMap.keySet().stream().toList();
    }
}
