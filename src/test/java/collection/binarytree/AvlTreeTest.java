package collection.binarytree;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AvlTreeTest {

    @Test
    void simmetricalOrderIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
        }
        List<Integer> list = tree.inSymmetricalOrder();
        assertThat(list).containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void removeIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
        }
        tree.remove(4);
        List<Integer> list = tree.inSymmetricalOrder();
        assertThat(list).containsExactly(1, 2, 3, 5, 6, 7);
    }

    @Test
    void removeAndAgainInsertIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
        }
        tree.remove(4);
        List<Integer> list = tree.inSymmetricalOrder();
        assertThat(list).containsExactly(1, 2, 3, 5, 6, 7);
        tree.insert(4);
        List<Integer> list2 = tree.inSymmetricalOrder();
        assertThat(list2).containsExactly(1, 2, 3, 4, 5, 6, 7);
        System.out.println(tree);
    }

    @Test
    void preOrderIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
        }
        List<Integer> list = tree.inPreOrder();
        assertThat(list).containsExactly(4, 2, 1, 3, 6, 5, 7);
    }

    @Test
    void postOrderIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
        }
        List<Integer> list = tree.inPostOrder();
        assertThat(list).containsExactly(1, 3, 2, 5, 7, 6, 4);
    }

    @Test
    void minimumIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
        }
        assertThat(1).isEqualTo(tree.minimum());
    }

    @Test
    void maximumIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
        }
        assertThat(7).isEqualTo(tree.maximum());
    }
}