package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    //private  Map<String, String> extensionApp = new HashMap<String, String>();

    public FileOpenManager() {
    }

    //Регистрировать новое приложение для открытия файлов с определённым расширением
    public void addApp(String extension, String app, Map<String, String> map) {

        map.put(extension.toLowerCase(), app.toLowerCase());
    }

    //Получать название приложения, предназначенного для открытия файла с определённым расширением.
    public String getAppByExtension(String extension, Map<String, String> map) {
        return map.get(extension.toLowerCase());
    }

    //Удалять привязку приложения к определённому расширению
    public void deleteApp(String extension, Map<String, String> map) {
        map.remove(extension.toLowerCase());
    }

    //Получать список всех зарегистрированных расширений, к которым привязаны приложения для открытия
    public List<String> getExtensionWithApp(Map<String, String> map) {
        List<String> result = new ArrayList<String>();
        for (String k : map.keySet()) {
            result.add(k);
        }
        Collections.sort(result);
        return result;
    }

    //Получать список всех приложений, которые привязаны к каким-либо расширениям
    public Set<String> getAppWithExtension(Map<String, String> map) {
        //List<String> result = new ArrayList<String>();
        Set<String> result1 = new TreeSet<String>();
        for (String k : map.values()) {
            result1.add(k);
        }
        // Collections.sort(result);
        return result1;
    }
}
