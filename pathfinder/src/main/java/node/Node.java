package node;

import java.util.Objects;

public class Node<T> {
    private final T obj;

    /**
     * constructor for a node
     * @param node pass in an object
     */
    public Node(T node) {
        this.obj = node;
    }

    public void printNode(){
        System.out.print(this.obj);
    }

    public T getObj() {
        return obj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(obj, node.obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obj);
    }
}

