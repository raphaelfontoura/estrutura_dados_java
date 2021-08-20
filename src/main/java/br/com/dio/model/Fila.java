package br.com.dio.model;

public class Fila<E> {

    private No<E> refNoEntryQueue;

    public Fila() {
        this.refNoEntryQueue = null;
    }

    public void enqueue(E object) {
        No newNo = new No(object);
        newNo.setNextNo(refNoEntryQueue);
        refNoEntryQueue = newNo;
    }

    public No<E> dequeue() {
        No<E> tempNo = null;
        No<E> first = refNoEntryQueue;
        while (!isEmpty()) {
            if (first.getNextNo() != null) {
                tempNo = first;
                first = first.getNextNo();
            } else {
                if (tempNo == null) {
                    refNoEntryQueue = null;
                } else {
                    tempNo.setNextNo(null);
                }
                break;
            }
        }
        return first;
    }

    public No<E> first() {
        if (!this.isEmpty()) {
            No<E> fistNo = refNoEntryQueue;
            while (true) {
                if (fistNo.getNextNo() != null) {
                    fistNo = fistNo.getNextNo();
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
        No noTemp = refNoEntryQueue;

        if (refNoEntryQueue != null) {
            while (true) {
                stringReturn += "[No{objeto=" + noTemp.getData() + "}]-->";
                if (noTemp.getNextNo() != null) {
                    noTemp = noTemp.getNextNo();
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
