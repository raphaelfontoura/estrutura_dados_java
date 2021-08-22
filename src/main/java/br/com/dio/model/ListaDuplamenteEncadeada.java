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

    public void remove(int index) {

        if (index == 0) {
            firstNode = firstNode.getNextNode();
            if (firstNode != null) {
                firstNode.setPreviousNode(null);
            }
        } else {
            NodeDouble<T> nodeAux = getNode(index);
            nodeAux.getPreviousNode().setNextNode(nodeAux.getNextNode());
            if (nodeAux != lastNode) {
                nodeAux.getNextNode().setPreviousNode(nodeAux.getPreviousNode());
            } else {
                lastNode = nodeAux;
            }
        }
        this.sizeList--;
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

    public void add(int index, T element) {
        NodeDouble<T> newNodeDouble = new NodeDouble<>(element);
        NodeDouble<T> nodeAux = getNode(index);
        newNodeDouble.setNextNode(nodeAux);

        if (newNodeDouble.getNextNode() != null) {
            newNodeDouble.setPreviousNode(nodeAux.getPreviousNode());
            newNodeDouble.getNextNode().setPreviousNode(newNodeDouble);
        } else {
            newNodeDouble.setPreviousNode(lastNode);
            lastNode = newNodeDouble;
        }

        if (index == 0){
            firstNode = newNodeDouble;
        } else {
            newNodeDouble.getPreviousNode().setNextNode(newNodeDouble);
        }
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

    @Override
    public String toString() {
        String strReturn = "";
        NodeDouble<T> nodeAux = firstNode;
        for (int i = 0; i < size(); i++) {
            strReturn += "[No{content="+nodeAux.getData()+"}]-->";
            nodeAux = nodeAux.getNextNode();
        }
        strReturn += "null";
        return strReturn;
    }
}
