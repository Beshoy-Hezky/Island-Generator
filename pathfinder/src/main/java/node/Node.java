package node;

public class Node<T> {
    private final T node;

    /**
     * @param node pass in a node
     */
    public Node(T node) {
        this.node = node;
    }

    // delete later
    public void printNode(){
        System.out.print(this.node);
    }
}

