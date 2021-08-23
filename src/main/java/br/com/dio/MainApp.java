package br.com.dio;

import br.com.dio.model.*;

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

        System.out.println("==== lista encadeada ====");
        ListaEncadeadaTest();

        System.out.println("=== lista duplamente encadeada ===");
        ListaDuplamenteEncadeadaTest();

        System.out.println("=== lista circular ===");
        ListaCircularTest();

    }

    private static void ListaCircularTest() {
        ListaCircular<String> minhaListaCircular = new ListaCircular<>();
        System.out.println(minhaListaCircular.isEmpty());
        System.out.println(minhaListaCircular);
        minhaListaCircular.add("item1");
        minhaListaCircular.add("item2");
        minhaListaCircular.add("item3");
        minhaListaCircular.add("item4");
        minhaListaCircular.add("item5");
        System.out.println(minhaListaCircular);
        System.out.println(minhaListaCircular.isEmpty());
        System.out.println("Tamanho da lista: " + minhaListaCircular.size());
        minhaListaCircular.remove(3);
        System.out.println(minhaListaCircular);
        System.out.println("Novo tamanho da lista: " + minhaListaCircular.size());
        System.out.println("Remove index 0");
        minhaListaCircular.remove(0);
        System.out.println(minhaListaCircular);
        System.out.println("Remove index 1");
        minhaListaCircular.remove(1);
        System.out.println(minhaListaCircular);
    }

    private static void ListaDuplamenteEncadeadaTest() {
        ListaDuplamenteEncadeada<String> minhaListaEncadeada = new ListaDuplamenteEncadeada<>();
        minhaListaEncadeada.add("one");
        minhaListaEncadeada.add("two");
        System.out.println(minhaListaEncadeada.size());
        System.out.println(minhaListaEncadeada.toString());
        minhaListaEncadeada.add("three");
        minhaListaEncadeada.add(2,"four");
        minhaListaEncadeada.add("five");
        System.out.println(minhaListaEncadeada.toString());
        minhaListaEncadeada.remove(2);
        System.out.println(minhaListaEncadeada.toString());
    }

    private static void ListaEncadeadaTest() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        System.out.println(listaEncadeada.isEmpty());
        System.out.println(listaEncadeada.size());
        listaEncadeada.add(1);
        System.out.println(listaEncadeada.size());
        listaEncadeada.add(2);
        System.out.println(listaEncadeada.size());
        System.out.println(listaEncadeada.toString());
        System.out.println(listaEncadeada.get(0));
        System.out.println(listaEncadeada.get(1));
        listaEncadeada.add(3);
        Integer removeNo = listaEncadeada.remove(2);
        System.out.println(removeNo.toString());
        System.out.println(listaEncadeada.toString());
        listaEncadeada.add(4);
        listaEncadeada.add(5);
        System.out.println(listaEncadeada.toString());
    }

    private static void FilaTest() {
        Fila<String> minhaFila = new Fila<>();
        minhaFila.enqueue("primeiro");
        minhaFila.enqueue("segundo");
        minhaFila.enqueue("terceiro");
        minhaFila.enqueue("quarto");

        System.out.println(minhaFila);
        Node<String> first = minhaFila.first();
        System.out.println(first);
        System.out.println("== dequeue ==");
        Node<String> dequeue = minhaFila.dequeue();
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
        Node<Integer> first = minhaFila.first();
        System.out.println(first);
        System.out.println("== dequeue ==");
        Node<Integer> dequeue = minhaFila.dequeue();
        System.out.println(first + " = " + dequeue);
        System.out.println(minhaFila);

        minhaFila.dequeue();
        System.out.println(minhaFila);
    }

    private static void PilhaTest() {
        Pilha<Integer> minhaPilha = new Pilha<>();
        minhaPilha.push(1);
        minhaPilha.push(2);
        minhaPilha.push(3);
        minhaPilha.push(4);
        minhaPilha.push(5);
        minhaPilha.push(6);
        System.out.println(minhaPilha);

        System.out.println("== pop 2 ==");
        Node<Integer> pop1 = minhaPilha.pop();
        Node<Integer> pop2 = minhaPilha.pop();
        System.out.println(minhaPilha);
        System.out.println("== resultado dos 2 pops ==");
        System.out.println(pop1);
        System.out.println(pop2);
    }

    private static void NosTest() {
        Node<String> no1 = new Node<>("No 1");
        Node<String> no2 = new Node<>("No 2");
        no1.setNextNode(no2);
        Node<String> no3 = new Node<>("No 3");
        no2.setNextNode(no3);
        Node<String> no4 = new Node<>("No 4");
        no3.setNextNode(no4);

        System.out.println(no1);
        System.out.println(no1.getNextNode());
        System.out.println(no1.getNextNode().getNextNode());
        System.out.println(no2.getNextNode().getNextNode());
        System.out.println(no3.getNextNode().getNextNode());
    }
}
