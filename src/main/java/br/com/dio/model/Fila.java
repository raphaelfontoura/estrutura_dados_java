package br.com.dio.model;

public class Fila<T> {

    private No<T> refNoEntryQueue;

    public Fila() {
        this.refNoEntryQueue = null;
    }

    public void enqueue(No<T> newNo) {
        newNo.setNextNo(refNoEntryQueue);
        refNoEntryQueue = newNo;
    }

    public No<T> dequeue() {
        No<T> tempNo = null;
        No<T> first = refNoEntryQueue;
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

    public No<T> first() {
        if (!this.isEmpty()) {
            No<T> fistNo = refNoEntryQueue;
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
