package br.com.dio.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private static Node<Integer> node1;
    private static Node<Integer> node2;

    @BeforeAll
    static void beforeAll() {
        node1 = new Node<>(1);
        node2 = new Node<>(2);
        node1.setNextNode(node2);
    }

    @Test
    void getNextNo() {
        assertEquals(2, node1.getNextNode().getData());
        assertNull(node2.getNextNode());
    }

    @Test
    void getData() {
        assertEquals(1, node1.getData());
        assertEquals(2, node2.getData());
    }
}