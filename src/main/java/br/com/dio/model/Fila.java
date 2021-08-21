package br.com.dio.model;

public class Fila<E> {

    private Node<E> refNoEntryQueue;

    public Fila() {
        this.refNoEntryQueue = null;
    }

    public void enqueue(E object) {
        Node newNo = new Node(object);
        newNo.setNextNode(refNoEntryQueue);
        refNoEntryQueue = newNo;
    }

    public Node<E> dequeue() {
        Node<E> tempNo = null;
        Node<E> first = refNoEntryQueue;
        while (!isEmpty()) {
            if (first.getNextNode() != null) {
                tempNo = first;
                first = first.getNextNode();
            } else {
                if (tempNo == null) {
                    refNoEntryQueue = null;
                } else {
                    tempNo.setNextNode(null);
                }
                break;
            }
        }
        return first;
    }

    public Node<E> first() {
        if (!this.isEmpty()) {
            Node<E> fistNo = refNoEntryQueue;
            while (true) {
                if (fistNo.getNextNode() != null) {
                    fistNo = fistNo.getNextNode();
                } else {
                    break;
                }
            }
            return fistNo;
        }
        return null;
    }

    public boolean isEmpty() {
        return refNoEntryQueue == null;
    }

    @Override
    public String toString() {
        String stringReturn = "";
        Node noTemp = refNoEntryQueue;

        if (refNoEntryQueue != null) {
            while (true) {
                stringReturn += "[No{objeto=" + noTemp.getData() + "}]-->";
                if (noTemp.getNextNode() != null) {
                    noTemp = noTemp.getNextNode();
                } else {
                    stringReturn += "null";
                    break;
                }
            }
        } else {
            stringReturn = "null";
        }

        return stringReturn;
    }
}
