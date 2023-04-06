package node;

import java.util.Objects;

public class Node<T> {
    private final T obj;

    /**
     * @param node pass in a node
     */
    public Node(T node) {
        this.obj = node;
    }

    // delete later
    public void printNode(){
        System.out.print(this.obj);
    }

   /* @Override
    public boolean equals(Object o){
        Node<T> card = (Node<T>) o;
        if(this.node == ((Node<?>) o).node){
            return true;
        }
        return false;
    }*/

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

