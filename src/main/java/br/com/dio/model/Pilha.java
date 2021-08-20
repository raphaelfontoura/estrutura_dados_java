package br.com.dio.model;

public class Pilha<T> {

    private No<T> refNoEntry;

    public Pilha() {
        this.refNoEntry = null;
    }

    public boolean isEmpty() {
        return refNoEntry == null;
    }

    public void push(No<T> newNo) {
        No<T> refTemp = refNoEntry;
        refNoEntry = newNo;
        refNoEntry.setNextNo(refTemp);
    }

    public No<T> pop() {
        if (!isEmpty()) {
            No<T> noPoped = refNoEntry;
            refNoEntry = refNoEntry.getNextNo();
            return noPoped;
        }
        return null;
    }

    public No<T> top() {
        return refNoEntry;
    }

    @Override
    public String toString() {
        String returnString = "=============\n" +
                "   Pilha\n" +
                "=============\n";
        No<T> noTemp = refNoEntry;
        while (true) {
            if (noTemp != null) {
                returnString += "[No{dado="+noTemp.getData()+"}]\n";
                noTemp = noTemp.getNextNo();
            } else {
                break;
            }
        }
        return returnString;
    }
}
