package org.example;
import java.util.Objects;

public class IntContainer{
    private int n;
    private int last;
    private int[] elem;

    public IntContainer(){

    }
    public IntContainer(int _n){
        n = _n;
        elem = new int[_n];
    }

    public int len(){
        return last;
    }

    public void addElem(Integer e){
        if (last >= n) {
            n += 10;
            int[] elem_copy = elem.clone();
            elem = new int[n];
            if (n - 10 >= 0) System.arraycopy(elem_copy, 0, elem, 0, n - 10);
            System.out.println("Resize to " + elem.length);
        }
        elem[last] = e;
        last += 1;
    }

    public int getElem(int n){
        return elem[n];
    }

    public void removeElem(int e){
        for(int i = 0; i < last; ++i){
            if (Objects.equals(elem[i], e)){
                for (int j = i; j < last-1; ++j){
                    elem[j] = elem[j+1];
                }
                last -= 1;
            }
        }
    }

    public void showElems(){
        for (int i = 0; i < last; ++i) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IntContainer intCont = new IntContainer(5);
        intCont.addElem(1);
        intCont.addElem(2);
        intCont.addElem(3);
        intCont.addElem(4);
        intCont.addElem(5);
        intCont.addElem(6);
        intCont.addElem(7);

        intCont.removeElem(2);

        System.out.println("First element is : " + intCont.getElem(0));

        intCont.showElems();
        System.out.println("Number of elements 1: " + intCont.len());

        IntContainer intCont1 = new IntContainer();
        System.out.println("Number of elements 2: " + intCont1.len());
    }
}