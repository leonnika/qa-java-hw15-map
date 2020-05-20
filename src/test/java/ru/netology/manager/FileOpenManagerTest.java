package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class FileOpenManagerTest {

    private Map<String, String> extensionApp = new HashMap<String, String>();
    private FileOpenManager manager = new FileOpenManager();

    @Nested
    public class Empty {
        @Test
        void shouldAddApp() {
            manager.addApp("png", "Paint", extensionApp);
            System.out.println("Test for AddApp, expected 1 elements, actual:" + extensionApp);
        }

        @Test
        void shouldGetAppByExtension() {
            System.out.println("Test for getAppByExtension, expected: null, actual: " + manager.getAppByExtension("doc", extensionApp));
        }

        @Test
        void shouldDeleteApp() {
            manager.deleteApp("png", extensionApp);
            System.out.println("Test for AddApp, expected null, actual:" + extensionApp);
        }

        @Test
        void shouldGetExtensionWithApp() {
            System.out.println("Test for GetExtensionWithApp, expected null, actual:" + manager.getExtensionWithApp(extensionApp));
        }

        @Test
        void shouldGetAppWithExtension() {
            System.out.println("Test for GetAppWithExtension, expected null, actual:" + manager.getAppWithExtension(extensionApp));
        }
    }

    @Nested
    public class MultipleItem {
    @BeforeEach
    void init() {
        extensionApp.put("doc", "word");
        extensionApp.put("xls", "excel");
        extensionApp.put("txt", "word");
        extensionApp.put("html", "chrome");
    }

    @Test
    void shouldAddApp() {
        manager.addApp("png", "Paint", extensionApp);
        System.out.println("Test for AddApp, expected 5 elements, actual:" + extensionApp);
    }

    @Test
    void shouldGetAppByExtension() {
        System.out.println("Test for getAppByExtension, expected: word, actual: " + manager.getAppByExtension("doc", extensionApp));
    }

    @Test
    void shouldDeleteApp() {
        manager.deleteApp("png", extensionApp);
        System.out.println("Test for AddApp, expected 4 elements, actual:" + extensionApp);
    }

    @Test
    void shouldGetExtensionWithApp() {
        System.out.println("Test for GetExtensionWithApp, expected 4 elements, actual:" + manager.getExtensionWithApp(extensionApp));
    }

    @Test
    void shouldGetAppWithExtension() {
        System.out.println("Test for GetAppWithExtension, expected 3 elements, actual:" + manager.getAppWithExtension(extensionApp));
    }
}}