package ru.job4j.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithNoValue() throws IllegalArgumentException {
        String path = "./data/pair_with_no_value.properties";
        Config config = new Config(path);
        Assertions.assertThrows(IllegalArgumentException.class, config::load);
    }

    @Test
    void whenPairWithNoKey() throws IllegalArgumentException {
        String path = "./data/pair_with_no_key.properties";
        Config config = new Config(path);
        Assertions.assertThrows(IllegalArgumentException.class, config::load);
    }

    @Test
    void whenPairWithNoSymbol() throws IllegalArgumentException {
        String path = "./data/pair_with_no_symbol.properties";
        Config config = new Config(path);
        Assertions.assertThrows(IllegalArgumentException.class, config::load);
    }
}