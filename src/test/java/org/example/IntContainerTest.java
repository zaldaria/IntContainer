package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntContainerTest {
    private IntContainer container;

    @BeforeEach
    void setUp() {
        container = new IntContainer(3); // Начальная емкость 3
    }

    @Test
    void testInitialization() {
        assertEquals(0, container.len());
    }

    @Test
    void testAddElements() {
        container.addElem(10);
        container.addElem(20);
        assertEquals(2, container.len());
    }

    @Test
    void testGetElements() {
        container.addElem(10);
        container.getElem(0);
        assertEquals(10, container.getElem(0));
    }

    @Test
    void testAddElementsBeyondCapacity() {
        container.addElem(10);
        container.addElem(20);
        container.addElem(30);
        container.addElem(40); // Должно вызвать увеличение массива
        assertEquals(4, container.len());
    }

    @Test
    void testRemoveExistingElement() {
        container.addElem(10);
        container.addElem(20);
        container.addElem(30);
        container.removeElem(20);
        assertEquals(2, container.len());
    }

    @Test
    void testRemoveNonExistingElement() {
        container.addElem(10);
        container.addElem(20);
        container.removeElem(30); // Нет такого элемента
        assertEquals(2, container.len());
    }

    @Test
    void testRemoveMultipleOccurrences() {
        container.addElem(10);
        container.addElem(10);
        container.addElem(20);
        container.removeElem(10);
        assertEquals(2, container.len());
    }

    @Test
    void testEmptyContainer() {
        IntContainer emptyContainer = new IntContainer();
        assertEquals(0, emptyContainer.len());
    }

    @Test
    void testBoundaryConditions() {
        assertThrows(NullPointerException.class, () -> {
            container.addElem(null);
        });
        container.removeElem(10);
        assertEquals(0, container.len());
    }
}