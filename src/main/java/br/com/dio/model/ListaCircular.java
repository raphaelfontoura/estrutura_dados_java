package br.com.dio.model;

public class ListaCircular<T> {

    private Node<T> head;
    private Node<T> tail;
    private int sizeList;

    public ListaCircular() {
        this.sizeList = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(T content) {
        Node<T> newNode = new Node<>(content);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
            this.head.setNextNode(tail);
        } else {
            newNode.setNextNode(this.tail);
            this.head.setNextNode(newNode);
            this.tail = newNode;
        }
        this.sizeList++;
    }

    public void remove(int index) {
        if (index >= this.sizeList) {
            throw new IndexOutOfBoundsException("Index greater than size list");
        }
//        Node<T> nodeAux = this.tail;
        if (index == 0) {
            this.tail = this.tail.getNextNode();
            this.head.setNextNode(this.tail);
        } else if (index == 1){
            this.tail.setNextNode(this.tail.getNextNode().getNextNode());
        } else {
            Node<T> nodeAux = getNode(index-1);
            nodeAux.setNextNode(nodeAux.getNextNode().getNextNode());
        }
        this.sizeList--;
    }

    public T get(int index) {
        return getNode(index).getData();
    }

    private Node<T> getNode(int index) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        if (index == 0) {
            return this.tail;
        }
        Node<T> nodeAux = this.tail;
        for (int i = 0; i < index; i++) {
            nodeAux = nodeAux.getNextNode();
        }
        return nodeAux;
    }

    public boolean isEmpty() {
        return sizeList == 0;
    }

    public int size() {
        return this.sizeList;
    }

    @Override
    public String toString() {
        String strReturn = "";
        Node<T> nodeAux = this.tail;
        for (int i = 0; i < this.size(); i ++) {
            strReturn += "[Node{content=" + nodeAux.getData() + "}]-->";
            nodeAux = nodeAux.getNextNode();
        }
        strReturn += ! isEmpty() ? "(Return to begin)" : "[]";
        return strReturn;
    }
}
