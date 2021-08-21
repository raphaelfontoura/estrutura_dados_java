package br.com.dio.model;

public class Pilha<T> {

    private Node<T> refNoEntry;

    public Pilha() {
        this.refNoEntry = null;
    }

    public boolean isEmpty() {
        return refNoEntry == null;
    }

    public void push(T obj) {
        Node<T> newNo = new Node<>(obj);
        Node<T> refTemp = refNoEntry;
        refNoEntry = newNo;
        refNoEntry.setNextNode(refTemp);
    }

    public Node<T> pop() {
        if (!isEmpty()) {
            Node<T> noPoped = refNoEntry;
            refNoEntry = refNoEntry.getNextNode();
            return noPoped;
        }
        return null;
    }

    public Node<T> top() {
        return refNoEntry;
    }

    @Override
    public String toString() {
        String returnString = "=============\n" +
                "   Pilha\n" +
                "=============\n";
        Node<T> noTemp = refNoEntry;
        while (true) {
            if (noTemp != null) {
                returnString += "[No{dado="+noTemp.getData()+"}]\n";
                noTemp = noTemp.getNextNode();
            } else {
                break;
            }
        }
        return returnString;
    }
}
