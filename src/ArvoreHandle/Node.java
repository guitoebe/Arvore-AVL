package ArvoreHandle;

public class Node {
    private int value;
    private Node leftNode;
    private Node rightNode;
    
    public Node(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    @Override
    public String toString() {
        return "value do nó:" + String.valueOf(value);
    }
}
