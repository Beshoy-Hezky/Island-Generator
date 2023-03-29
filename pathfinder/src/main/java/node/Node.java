package node;

public class Node<T> {
    T node;

    /**
     *
     * @param node pass in a node
     */
    public Node(T node){
        this.node = node;
    }

    /**
     *
     * @return the node
     */
    public T getNode(){
        return this.node;
    }

}
