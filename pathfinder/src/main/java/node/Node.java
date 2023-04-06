package node;

public class Node<T> {
    final T node;

    /**
     * @param node pass in a node
     */
    public Node(T node) {
        this.node = node;
    }

    /**
     * @return the node
     */
    public T getNode() {
        return this.node;
    }

    // delete later
    public void printNode(){
        System.out.print(this.node);
    }
}

