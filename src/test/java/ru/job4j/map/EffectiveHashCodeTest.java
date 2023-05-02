package ru.job4j.map;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class EffectiveHashCodeTest {

    @Test
    void whenSameHashCode() {
        EffectiveHashCode first = new EffectiveHashCode(1, 10, "Eff");
        EffectiveHashCode second = new EffectiveHashCode(1, 10, "Eff");
        EffectiveHashCode third = new EffectiveHashCode(2, 22, "fEf");
        assertThat(first.hashCode()).isEqualTo(second.hashCode());
        assertThat(first.hashCode()).isNotEqualTo(third.hashCode());
    }
}