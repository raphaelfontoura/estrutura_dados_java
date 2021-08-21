package br.com.dio.model;

public class ListaEncadeada<T> {
    Node<T> refEntry;

    public ListaEncadeada() {
        this.refEntry = null;
    }

    public T remove(int index) {
        Node<T> noPivo = this.getNo(index);
        if(index == 0) {
            refEntry = noPivo.getNextNode();
            return noPivo.getData();
        }
        Node<T> noBefore = getNo(index-1);
        noBefore.setNextNode(noPivo.getNextNode());

        return noPivo.getData();
    }

    public T get(int index) {
        return getNo(index).getData();
    }

    private Node<T> getNo(int index) {
        isValidIndex(index);

        Node<T> noAux = refEntry;
        Node<T> noFound = null;
        for (int i = 0; i <= index; i++) {
            noFound = noAux;
            noAux = noFound.getNextNode();
        }

        return noFound;
    }

    private void isValidIndex(int index) {
        if (index >= size()){
            throw new IndexOutOfBoundsException("Index " + index + " is invalid. List size is " + (size()-1));
        }
    }

    public void add (T content) {
        Node<T> newNo = new Node<>(content);
        if (isEmpty()) {
            refEntry = newNo;
            return;
        }

        Node<T> noAux = refEntry;
        for (int i = 0; i < size()-1; i++) {
            noAux = noAux.getNextNode();
        }

        noAux.setNextNode(newNo);
    }

    public boolean isEmpty() {
        return refEntry == null;
    }

    public int size() {
        int sizeList = 0;
        Node<T> noAux = refEntry;
        while (!isEmpty()) {
            sizeList += 1;
            if (noAux.getNextNode() != null) {
                noAux = noAux.getNextNode();
            } else {
                break;
            }
        }

        return sizeList;
    }

    @Override
    public String toString() {
        String strReturn = "";
        Node<T> noAux = refEntry;
        for(int i = 0; i < this.size(); i++){
            strReturn += "No{"+noAux.getData()+"}-->";
            noAux = noAux.getNextNode();
        }
        strReturn += "null";
        return strReturn;
    }
}
