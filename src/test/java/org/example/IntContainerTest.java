package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования функциональности IntContainer.
 */
public class IntContainerTest {
    private IntContainer container;

    /**
     * Инициализация перед каждым тестом.
     * Создается новый контейнер с начальной емкостью 3.
     */
    @BeforeEach
    void setUp() {
        container = new IntContainer(3);
    }

    /**
     * Тест проверяет инициализацию пустого контейнера.
     */
    @Test
    void testInitialization() {
        assertEquals(0, container.len());
    }

    /**
     * Тест проверяет добавление элементов в контейнер.
     */
    @Test
    void testAddElements() {
        container.addElem(10);
        container.addElem(20);
        assertEquals(2, container.len());
    }

    /**
     * Тест проверяет получение элемента по индексу.
     */
    @Test
    void testGetElements() {
        container.addElem(10);
        container.getElem(0);
        assertEquals(10, container.getElem(0));
    }

    /**
     * Тест проверяет получение элемента по некорректному индексу.
     * Ожидается IndexOutOfBoundsException.
     */
    @Test
    void testGetElementInvalidIndex() {
        container.addElem(10);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            container.getElem(5);
        });
    }

    /**
     * Тест проверяет автоматическое расширение контейнера при заполнении.
     */
    @Test
    void testAddElementsBeyondCapacity() {
        container.addElem(10);
        container.addElem(20);
        container.addElem(30);
        container.addElem(40);
        assertEquals(4, container.len());
    }

    /**
     * Тест проверяет удаление существующего элемента.
     */
    @Test
    void testRemoveExistingElement() {
        container.addElem(10);
        container.addElem(20);
        container.addElem(30);
        container.removeElem(20);
        assertEquals(2, container.len());
    }

    /**
     * Тест проверяет попытку удаления несуществующего элемента.
     */
    @Test
    void testRemoveNonExistingElement() {
        container.addElem(10);
        container.addElem(20);
        container.removeElem(30);
        assertEquals(2, container.len());
    }

    /**
     * Тест проверяет удаление всех вхождений элемента.
     */
    @Test
    void testRemoveMultipleOccurrences() {
        container.addElem(10);
        container.addElem(10);
        container.addElem(20);
        container.removeElem(10);
        assertEquals(1, container.len());
    }
}