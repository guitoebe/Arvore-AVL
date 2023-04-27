package ArvoreHandle;

import Exception.EmptyTreeException;

public class AVLTree {

    private Node rootNode;

    public boolean isEmpty() {
        if (this.rootNode == null) {
            return true;
        }
        return false;
    }

    public int getHeight() {
        return getHeight(this.rootNode);
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.getLeftNode());
        int rightHeight = getHeight(node.getRightNode());
        if (leftHeight > rightHeight) {
            return leftHeight;
        }
        return rightHeight;
    }

    public void insert(int value) {
        insert(this.rootNode, value);
    }

    public void insert(Node node, int value) {
        if (this.rootNode == null) {
            this.rootNode = new Node(value);
        } else {
            if (value < node.getValue()) {
                if (node.getLeftNode() != null) {
                    insert(node.getLeftNode(), value);
                } else {
                    node.setLeftNode(new Node(value));
                }
            } else if (value > node.getValue()) {
                if (node.getRightNode() != null) {
                    insert(node.getRightNode(), value);
                } else {
                    node.setRightNode(new Node(value));
                }
            }
        }
    }

    int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeftNode()) - getHeight(node.getRightNode());
    }

    public Node remove(int value) throws EmptyTreeException {
        return remove(this.rootNode, value);
    }

    public Node remove(Node node, int value) throws EmptyTreeException {
        if (this.rootNode == null) {
            throw new EmptyTreeException("Árvore binária está vazia!!!");
        }
        return this.rootNode;
    }

    Node rotationToRight(Node x) {
        Node y = x.getRightNode();
        Node z = y.getLeftNode();
        y.setLeftNode(x);
        x.setRightNode(z);
       // x.altura = 1 + Math.max(getHeight(x.getLeftNode()), getHeight(x.getRightNode()));
       // y.altura = 1 + Math.max(getHeight(y.getLeftNode()), getHeight(y.getRightNode()));
        return y;
    }

    Node rotationToLeft(Node x) {
        Node y = x.getLeftNode();
        Node z = y.getRightNode();
        y.setRightNode(x);
        x.setLeftNode(z);
       // x.altura = 1 + Math.max(getHeight(x.getLeftNode()), getHeight(x.getRightNode()));
       // y.altura = 1 + Math.max(getHeight(y.getLeftNode()), getHeight(y.getRightNode()));
        return y;
    }

    public void print() {
        if (this.rootNode == null) {
            System.out.println("Árvore binária vazia");
        } else
        print(this.rootNode);
    }

    public void print(Node node) {
        if (node.getLeftNode() != null) {
            print(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            print(node.getRightNode());
        }
        System.out.println("Valor do nó:" + node.getValue());
    }
}