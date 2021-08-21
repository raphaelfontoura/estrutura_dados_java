package br.com.dio.model;

public class ListaDuplamenteEncadeada<T> {
    private NodeDouble<T> firstNode;
    private NodeDouble<T> lastNode;
    private int sizeList;

    public ListaDuplamenteEncadeada() {
        this.firstNode = null;
        this.lastNode = null;
        this.sizeList = 0;
    }

    public void add(T element) {
        NodeDouble<T> newNodeDouble = new NodeDouble<>(element);
        newNodeDouble.setNextNode(null);
        newNodeDouble.setPreviousNode(lastNode);
        if (firstNode == null) {
            firstNode = newNodeDouble;
        }
        if (lastNode != null) {
            lastNode.setNextNode(newNodeDouble);
        }
        lastNode = newNodeDouble;
        sizeList++;
    }

    public T get(int index) {
        return getNode(index).getData();
    }

    private NodeDouble<T> getNode(int index) {
        NodeDouble<T> noAux = firstNode;
        for (int i = 0; (i < index) && (noAux != null); i++ ){
            noAux = noAux.getNextNode();
        }
        return noAux;
    }

    public int size() {
        return sizeList;
    }
}
