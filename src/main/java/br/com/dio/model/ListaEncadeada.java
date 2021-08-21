package br.com.dio.model;

public class ListaEncadeada<T> {
    No<T> refEntry;

    public ListaEncadeada() {
        this.refEntry = null;
    }

    public T remove(int index) {
        No<T> noPivo = this.getNo(index);
        if(index == 0) {
            refEntry = noPivo.getNextNo();
            return noPivo.getData();
        }
        No<T> noBefore = getNo(index-1);
        noBefore.setNextNo(noPivo.getNextNo());

        return noPivo.getData();
    }

    public T get(int index) {
        return getNo(index).getData();
    }

    private No<T> getNo(int index) {
        isValidIndex(index);

        No<T> noAux = refEntry;
        No<T> noFound = null;
        for (int i = 0; i <= index; i++) {
            noFound = noAux;
            noAux = noFound.getNextNo();
        }

        return noFound;
    }

    private void isValidIndex(int index) {
        if (index >= size()){
            throw new IndexOutOfBoundsException("Index " + index + " is invalid. List size is " + (size()-1));
        }
    }

    public void add (T content) {
        No<T> newNo = new No<>(content);
        if (isEmpty()) {
            refEntry = newNo;
            return;
        }

        No<T> noAux = refEntry;
        for (int i = 0; i < size()-1; i++) {
            noAux = noAux.getNextNo();
        }

        noAux.setNextNo(newNo);
    }

    public boolean isEmpty() {
        return refEntry == null;
    }

    public int size() {
        int sizeList = 0;
        No<T> noAux = refEntry;
        while (!isEmpty()) {
            sizeList += 1;
            if (noAux.getNextNo() != null) {
                noAux = noAux.getNextNo();
            } else {
                break;
            }
        }

        return sizeList;
    }

    @Override
    public String toString() {
        String strReturn = "";
        No<T> noAux = refEntry;
        for(int i = 0; i < this.size(); i++){
            strReturn += "No{"+noAux.getData()+"}-->";
            noAux = noAux.getNextNo();
        }
        strReturn += "null";
        return strReturn;
    }
}
