package br.com.dio;

import br.com.dio.model.Fila;
import br.com.dio.model.No;
import br.com.dio.model.Pilha;

public class MainApp {
    public static void main(String[] args) {

        System.out.println("=== Nós ===");
        NosTest();

        System.out.println("===== pilha =====");
        PilhaTest();

        System.out.println("==== fila ====");
        FilaTest();

        System.out.println("==== fila de inteiros ====");
        FilaTestInteger();

    }

    private static void FilaTest() {
        Fila<String> minhaFila = new Fila<>();
        minhaFila.enqueue("primeiro");
        minhaFila.enqueue("segundo");
        minhaFila.enqueue("terceiro");
        minhaFila.enqueue("quarto");

        System.out.println(minhaFila);
        No<String> first = minhaFila.first();
        System.out.println(first);
        System.out.println("== dequeue ==");
        No<String> dequeue = minhaFila.dequeue();
        System.out.println(first +" = "+ dequeue);
        System.out.println(minhaFila);

        minhaFila.dequeue();
        System.out.println(minhaFila);
        minhaFila.dequeue();
        System.out.println(minhaFila);
        minhaFila.dequeue();
        System.out.println(minhaFila);
        minhaFila.dequeue();
        System.out.println(minhaFila);
    }

    private static void FilaTestInteger() {
        Fila<Integer> minhaFila = new Fila<>();
        minhaFila.enqueue(1);
        minhaFila.enqueue(2);
        minhaFila.enqueue(3);
        minhaFila.enqueue(4);

        System.out.println(minhaFila);
        No<Integer> first = minhaFila.first();
        System.out.println(first);
        System.out.println("== dequeue ==");
        No<Integer> dequeue = minhaFila.dequeue();
        System.out.println(first + " = " + dequeue);
        System.out.println(minhaFila);

        minhaFila.dequeue();
        System.out.println(minhaFila);
    }

    private static void PilhaTest() {
        Pilha<Integer> minhaPilha = new Pilha<>();
        minhaPilha.push(new No<Integer>(1));
        minhaPilha.push(new No<Integer>(2));
        minhaPilha.push(new No<Integer>(3));
        minhaPilha.push(new No<Integer>(4));
        minhaPilha.push(new No<Integer>(5));
        minhaPilha.push(new No<Integer>(6));
        System.out.println(minhaPilha);

        System.out.println("== pop 2 ==");
        No<Integer> pop1 = minhaPilha.pop();
        No<Integer> pop2 = minhaPilha.pop();
        System.out.println(minhaPilha);
        System.out.println("== resultado dos 2 pops ==");
        System.out.println(pop1);
        System.out.println(pop2);
    }

    private static void NosTest() {
        No<String> no1 = new No<>("No 1");
        No<String> no2 = new No<>("No 2");
        no1.setNextNo(no2);
        No<String> no3 = new No<>("No 3");
        no2.setNextNo(no3);
        No<String> no4 = new No<>("No 4");
        no3.setNextNo(no4);

        System.out.println(no1);
        System.out.println(no1.getNextNo());
        System.out.println(no1.getNextNo().getNextNo());
        System.out.println(no2.getNextNo().getNextNo());
        System.out.println(no3.getNextNo().getNextNo());
    }
}
