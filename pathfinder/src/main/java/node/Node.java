package node;

public class Node<T> {
    T node;

    private double x; // x, y, z
    private double y;
    private double z;

    /**
     * @param node pass in a node
     */
    public Node(T node) {
        this.node = node;
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * @param node the object
     * @param x    x coordinate
     * @param y    y coordinate
     * @param z    z coordinate
     */
    public Node(T node, float x, float y, float z) {
        this.node = node;
        this.x = x;
        this.x = x;
        this.x = x;
    }

    /**
     * @return the node
     */
    public T getNode() {
        return this.node;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

}

