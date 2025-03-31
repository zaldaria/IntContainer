package org.example;

import java.util.Objects;

/**
 * Класс IntContainer представляет собой контейнер для хранения целых чисел.
 * Поддерживает динамическое расширение при заполнении и основные операции с элементами, такие как добавление, удаление,
 * получение элемента по индексу, поиск элемента по значению.
 */
public class IntContainer {
    private int capacity;  // Текущая вместимость контейнера
    private int last;      // Индекс последнего добавленного элемента
    private int[] elem;    // Массив для хранения элементов

    /**
     * Конструктор по умолчанию. Создает контейнер с начальной вместимостью 10.
     */
    public IntContainer() {
        elem = new int[10];  // Делегируем вызов конструктору с параметром
    }

    /**
     * Конструктор с заданной начальной вместимостью.
     *
     * @param _n начальная вместимость контейнера
     */
    public IntContainer(int _n) {
        capacity = _n;
        elem = new int[_n];
    }

    /**
     * Возвращает текущее количество элементов в контейнере.
     * @return количество элементов
     */
    public int len() {
        return last;
    }

    /**
     * Добавляет новый элемент в контейнер.
     * При заполнении контейнер автоматически увеличивает вместимость на 10.
     * @param e добавляемый элемент
     */
    public void addElem(int e) {
        if (last >= capacity) {
            capacity += 10;
            int[] elem_copy = elem.clone();
            elem = new int[capacity];
            if (capacity - 10 >= 0) System.arraycopy(elem_copy, 0, elem, 0, capacity - 10);
            System.out.println("Resize to " + elem.length);
        }
        elem[last] = e;
        last += 1;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за границы
     * @param n индекс элемента
     */
    public int getElem(int n) {
        if (n < 0 || n >= last) {
            throw new IndexOutOfBoundsException("Index: " + n + ", Size: " + last);
        }
        return elem[n];
    }

    /**
     * Удаляет все вхождения указанного элемента из контейнера.
     * @param e удаляемый элемент
     */
    public void removeElem(int e) {
        for (int i = 0; i < last; ++i) {
            if (Objects.equals(elem[i], e)) {
                System.arraycopy(elem, i + 1, elem, i, last - i - 1);
                last -= 1;
                i--;
            }
        }
    }

    /**
     * Вывод всех элементов контейнера.
     */
    public void showElems() {
        for (int i = 0; i < last; ++i) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }

    /**
     * Поиск элемента по значению.
     */
    public boolean inCont(int e) {
        int in = 0;
        for (int i = 0; i < last; ++i) {
            if (Objects.equals(elem[i], e))
                in++;
        }
        return in > 0;
    }

    /**
     * Основной метод для демонстрации функциональности класса.
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        IntContainer intCont = new IntContainer(5);
        intCont.addElem(1);
        intCont.addElem(2);
        intCont.addElem(3);
        intCont.addElem(4);
        intCont.addElem(2);
        intCont.addElem(6);
        intCont.addElem(7);

        intCont.removeElem(2);

        System.out.println("First element is : " + intCont.getElem(0));

        intCont.showElems();
        System.out.println("Number of elements 1: " + intCont.len());

        System.out.println("1 is in container : " + intCont.inCont(1));

        IntContainer intCont1 = new IntContainer();
        System.out.println("Number of elements 2: " + intCont1.len());
    }
}