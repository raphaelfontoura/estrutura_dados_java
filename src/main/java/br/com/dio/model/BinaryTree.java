package br.com.dio.model;


public class BinaryTree<T extends Comparable<T>> {

    private BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void showInOrder() {
        System.out.println("\n Exibindo InOrdem");
        showInOrder(this.root);
    }

    private void showInOrder(BinaryNode<T> current) {
        if (current != null) {
            showInOrder(current.getLeftNode());
            System.out.print(current.getContent() + ", ");
            showInOrder(current.getRightNode());
        }
    }

    public void showPosOrder() {
        System.out.println("\n Exibindo PosOrdem");
        showPosOrder(this.root);
    }

    private void showPosOrder(BinaryNode<T> current) {
        if (current != null) {
            showPosOrder(current.getLeftNode());
            showPosOrder(current.getRightNode());
            System.out.print(current.getContent() + ", ");
        }
    }

    public void showPreOrder() {
        System.out.println("\n Exibindo PreOrdem");
        showPreOrder(this.root);
    }

    private void showPreOrder(BinaryNode<T> current) {
        if (current != null) {
            System.out.print(current.getContent() + ", ");
            showPreOrder(current.getLeftNode());
            showPreOrder(current.getRightNode());
        }
    }

    public void insert(T content) {
        BinaryNode<T> newNode = new BinaryNode<>(content);
        root = insert(root, newNode);
    }

    private BinaryNode<T> insert(BinaryNode<T> current, BinaryNode<T> newNode ) {
        if (current == null) {
            return newNode;
        } else if (newNode.getContent().compareTo(current.getContent()) < 0) {
            current.setLeftNode(insert(current.getLeftNode(), newNode));
        } else {
            current.setRightNode(insert(current.getRightNode(), newNode));
        }
        return current;
    }
    
    public void remove(T content) {
        try {
            BinaryNode<T> current = this.root;
            BinaryNode<T> father = this.root;
            BinaryNode<T> son = this.root;
            BinaryNode<T> temp = this.root;

            while (current != null && ! current.getContent().equals(content)) {
                father = current;
                if (content.compareTo(current.getContent()) < 0) {
                    current = current.getLeftNode();
                } else {
                    current = current.getRightNode();
                }
            }

            if (current == null) {
                throw new NullPointerException();
            }

            if (father == null) {
                if (current.getRightNode() == null) {
                    this.root = current.getLeftNode();
                } else if (current.getLeftNode() == null) {
                    this.root = current.getRightNode();
                } else {
                    for (temp = current, son = current.getLeftNode();
                        son.getRightNode() != null;
                        temp = son, son = son.getLeftNode()) {

                        if (son != current.getLeftNode()){
                            temp.setRightNode(son.getLeftNode());
                            son.setLeftNode(root.getLeftNode());
                        }
                    }
                    son.setRightNode(root.getRightNode());
                    root = son;
                }

            } else if (current.getRightNode() == null) {
                if (father.getLeftNode() == current) {
                    father.setLeftNode(current.getLeftNode());
                } else {
                    father.setRightNode(current.getLeftNode());
                }

            } else if (current.getLeftNode() == null) {
                if (father.getLeftNode() == current) {
                    father.setLeftNode(current.getRightNode());
                } else {
                    father.setRightNode(current.getRightNode());
                }

            } else {
                for (
                        temp = current, son = current.getLeftNode();
                        son.getRightNode() != null;
                        temp = son, son = son.getRightNode()
                ) {
                    if (son != current.getLeftNode()) {
                        temp.setRightNode(son.getLeftNode());
                        son.setLeftNode(current.getRightNode());
                    }
                    son.setRightNode(current.getRightNode());
                    if (father.getLeftNode() == current) {
                        father.setLeftNode(son);
                    } else {
                        father.setRightNode(son);
                    }
                }
            }

        } catch (NullPointerException err) {
            System.out.println("Content not found. " + err.getMessage());
        }
    }
}
