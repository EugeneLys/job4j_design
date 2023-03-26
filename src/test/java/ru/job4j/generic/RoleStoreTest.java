package ru.job4j.generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddThenRoleIsSoloist() {
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

    @Test
    void whenAddPresentThenSameRole() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        store.add(new Role("1", "Assistant"));
        Role result = store.findById("1");
        assertThat(result.getType()).isEqualTo("Soloist");
    }

    @Test
    void whenRightReplace() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        store.replace("1", new Role("1", "Assistant"));
        Role result = store.findById("1");
        assertThat(result.getType()).isEqualTo("Assistant");
    }

    @Test
    void whenWrongReplace() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Soloist"));
        store.replace("1", new Role("10", "Assistant"));
        Role result = store.findById("1");
        assertThat(result.getType()).isEqualTo("Soloist");
    }
}