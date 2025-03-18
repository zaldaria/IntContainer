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

    public void addElem(int e){
        if (last >= n) {
            n += 10;
            int[] elem_copy = elem.clone();
            elem = new int[n];
            for (int i = 0; i < n - 10; i++) {
                elem[i] = elem_copy[i];
            }
            System.out.println("Resize to " + elem.length);
        }
        elem[last] = e;
        last+=1;

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
            System.out.println(elem[i]);
        }
    }

    public static void main(String[] args) {
        IntContainer intCont = new IntContainer(5);
        intCont.addElem(1);
        intCont.addElem(2);
        intCont.addElem(3);
        intCont.addElem(4);
        intCont.addElem(5);
        intCont.addElem(6);//!!!
        intCont.addElem(7);//!!!

        intCont.removeElem(2);

        intCont.showElems();
        System.out.println("Number of elements 1: " + intCont.len());

        IntContainer intCont1 = new IntContainer();
        System.out.println("Number of elements 2: " + intCont1.len());
    }
}