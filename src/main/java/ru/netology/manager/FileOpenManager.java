package ru.netology.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FileOpenManager {
    private Map<String, String> extensionApp = new HashMap<String, String>();

    public Map<String, String> getAllMap() {
        return extensionApp;
    }

    //Регистрировать новое приложение для открытия файлов с определённым расширением
    public void addApp(String extension, String app) {

        extensionApp.put(extension.toLowerCase(), app.toLowerCase());
    }

    //Получать название приложения, предназначенного для открытия файла с определённым расширением.
    public String getAppByExtension(String extension) {
        return extensionApp.get(extension.toLowerCase());
    }

    //Удалять привязку приложения к определённому расширению
    public void deleteApp(String extension) {
        extensionApp.remove(extension.toLowerCase());
    }

    //Получать список всех зарегистрированных расширений, к которым привязаны приложения для открытия
    public Set<String> getExtensionWithApp() {
        Set<String> result = new TreeSet<String>();
        for (String k : extensionApp.keySet()) {
            result.add(k);
        }
        return result;
    }

    //Получать список всех приложений, которые привязаны к каким-либо расширениям
    public Set<String> getAppWithExtension() {
        Set<String> result = new TreeSet<String>();
        for (String k : extensionApp.values()) {
            result.add(k);
        }
        return result;
    }
}
