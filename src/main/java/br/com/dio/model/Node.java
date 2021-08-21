package br.com.dio.model;

public class Node<T> {
    private T content;
    private Node<T> nextNode;

    public Node(T content) {
        this.content = content;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    @Override
    public String toString() {
        return "No{" +
                "content=" + content +
                '}';
    }

    public T getData() {
        return content;
    }
}
