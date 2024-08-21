package ru.job4j.template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
    public class GeneratorTest {

        @Test
        public void whenCorrectGeneration() {
            Generator gen = new TemplateGenerator();
            String template = "${city} is the capital of ${country}?";
            String check = "Moscow is the capital of Russia";
            Map<String, String> map = new HashMap<>();
            map.put("city", "Moscow");
            map.put("country", "Russia");
            Assertions.assertEquals(gen.produce(template, map), check);
        }

        @Test
        public void whenNoSuchKey() {
            Generator gen = new TemplateGenerator();
            String template = "${city} is the capital of ${country}?";
            Map<String, String> map = new HashMap<>();
            map.put("city", "Moscow");
            map.put("country", "Russia");
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> gen.produce(template, map))
                    .withMessageContaining("no key found");
        }

    @Test
    public void whenExtraKeyFound() {
        Generator gen = new TemplateGenerator();
        String template = "${city} is the capital of ${country}?";
        Map<String, String> map = new HashMap<>();
        map.put("city", "Moscow");
        map.put("country", "Russia");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gen.produce(template, map))
                .withMessageContaining("extra key found");
    }
}
