package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkNamesLength() {
        NameLoad nameLoad = new NameLoad();
        String[] names = new String[] {};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("empty");
    }

    @Test
    void checkEqualSign() {
        NameLoad nameLoad = new NameLoad();
        String[] names = new String[] {"key:value", "key2=value2"};
        String checkWord = "key:value";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(checkWord)
                .hasMessageContaining("symbol");
    }

    @Test
    void checkTheKey() {
        NameLoad nameLoad = new NameLoad();
        String[] names = new String[] {"=value", "key2=value2"};
        String checkWord = "=value";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(checkWord)
                .hasMessageContaining("key");
    }

    @Test
    void checkTheValue() {
        NameLoad nameLoad = new NameLoad();
        String[] names = new String[] {"key=", "key2=value2", "key3=value3"};
        String checkWord = "key=";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(checkWord)
                .hasMessageContaining("value");
    }
}