package br.com.dio.model;

public class NodeDouble<T> extends Node<T> {

    private NodeDouble<T> nextNode;
    private NodeDouble<T> previousNode;

    public NodeDouble(T content) {
        super(content);
    }

    public void setPreviousNode(NodeDouble<T> previousNode) {
        this.previousNode = previousNode;
    }

    public void setNextNode(NodeDouble<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public NodeDouble<T> getNextNode() {
        return nextNode;
    }

    public NodeDouble<T> getPreviousNode() {
        return previousNode;
    }
}
