package ru.job4j.generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddThenTypeIsCorrect() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        Role result = store.findById("1");
        assertThat(result.getType()).isEqualTo("Soloist");
    }

    @Test
    void whenAddThenFindByAnotherIDTisNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        Role result = store.findById("3");
        assertThat(result).isNull();
    }

    @Test
    void whenAddPresentThenSameType() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        store.add(new Role("1", "Assistant"));
        Role result = store.findById("1");
        assertThat(result.getType()).isEqualTo("Soloist");
    }

    @Test
    void whenCorrectIDReplaceThenNewType() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        store.replace("1", new Role("1", "Assistant"));
        Role result = store.findById("1");
        assertThat(result.getType()).isEqualTo("Assistant");
    }

    @Test
    void whenIncorrectIDReplaceThenTypeNotChanged() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        store.replace("10", new Role("10", "Assistant"));
        Role result = store.findById("1");
        assertThat(result.getType()).isEqualTo("Soloist");
    }

    @Test
    void whenCorrectDeleteThenFindByIDTsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenDeleteAnotherThenPreviouslyAddedExists() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Prompter"));
        store.delete("1");
        Role result = store.findById("3");
        assertThat(result.getType()).isEqualTo("Prompter");
    }

    @Test
    void whenCorrectDeleteThenDeleteIsTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenIncorrectDeleteThenDeleteIsFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }


    @Test
    void whenFindByIDIsCorrect() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        Role result = store.findById("1");
        assertThat(result.getType()).isEqualTo("Soloist");
    }

    @Test
    void whenFindByIdIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

}