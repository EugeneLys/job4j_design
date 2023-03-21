package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("one", "two", "three", "four");
        assertThat(list).isNotEmpty()
                .isNotSameAs(List.of("five", "six", "seven"))
                .containsExactlyInAnyOrder("two", "three", "one", "four")
                .first().isSameAs("one");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("one", "one", "two", "three", "four");
        assertThat(set).isSubsetOf("one", "two", "three", "four", "five")
                .allSatisfy(e -> {
                    assertThat(e).isNotNull();
                    assertThat(e).isLowerCase();
                })
                .containsAnyOf("five", "four")
                .hasSameSizeAs(Set.of(1, 2, 3, 4));
    }

    @Test
    void mapCheck() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("spring", "summer", "autumn", "winter", "spring");
        assertThat(map).hasSize(4)
                .containsEntry("summer", 1)
                .containsAnyOf(Map.entry("winter", 3), Map.entry("basketball", 1))
                .containsAllEntriesOf(Map.of("autumn", 2, "spring", 0));
    }
}