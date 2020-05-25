package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();

    @Nested
    public class Empty {
        @Test
        void shouldAddApp() {
            Map<String, String> expected = new HashMap<String, String>();
            expected.put("png", "paint");
            manager.addApp("png", "paint");
            assertEquals(expected, manager.getAllMap());
        }

        @Test
        void shouldGetAppByExtension() {
            assertNull(manager.getAppByExtension("doc"));
        }

        @Test
        void shouldDeleteApp() {
            Map<String, String> expected = new HashMap<String, String>();
            assertEquals(expected, manager.getAllMap());
        }

        @Test
        void shouldGetExtensionWithApp() {
            Set<String> expected = new TreeSet<String>();
            assertEquals(expected, manager.getExtensionWithApp());
        }

        @Test
        void shouldGetAppWithExtension() {
            Set<String> expected = new TreeSet<String>();
            assertEquals(expected, manager.getAppWithExtension());
        }
    }

    @Nested
    public class MultipleItem {
        Map<String, String> expected = new HashMap<String, String>();

        @BeforeEach
        void init() {
            manager.addApp("doc", "word");
            manager.addApp("xls", "excel");
            manager.addApp("txt", "word");
            manager.addApp("html", "chrome");
            expected.put("doc", "word");
            expected.put("xls", "excel");
            expected.put("txt", "word");
            expected.put("html", "chrome");
        }

        @Test
        void shouldAddApp() {
            expected.put("png", "paint");
            manager.addApp("png", "Paint");
            assertEquals(expected, manager.getAllMap());
        }

        @Test
        void shouldGetAppByExtension() {
            String expected = "word";
            assertEquals(expected, manager.getAppByExtension("doc"));
        }

        @Test
        void shouldDeleteApp() {
            manager.addApp("png", "Paint");
            manager.deleteApp("png");
            assertEquals(expected, manager.getAllMap());
        }

        @Test
        void shouldGetExtensionWithApp() {
            Set<String> expected = new TreeSet<String>();
            expected.add("doc");
            expected.add("xls");
            expected.add("txt");
            expected.add("html");
            assertEquals(expected, manager.getExtensionWithApp());
        }

        @Test
        void shouldGetAppWithExtension() {
            Set<String> expected = new TreeSet<String>();
            expected.add("word");
            expected.add("excel");
            expected.add("chrome");
            assertEquals(expected, manager.getAppWithExtension());
        }
    }
}