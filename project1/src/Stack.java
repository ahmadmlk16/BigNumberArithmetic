
import java.util.EmptyStackException;

/**
 * Linked Stack class that implements stack interface
 * 
 * @author omaralshikh, ahmad malik
 * @version 7/8/2020
 * @param <T>
 *            generic type T
 */
public class Stack<T> {
// Node class inside Linked Stack with generic type K
    private class Node<K> {
        // fields of Node class
        private Node<K> next;
        private K data;


        /**
         * constructor
         * 
         * @param dataPortion
         *            data for node followed by null
         */
        public Node(K dataPortion) {
            this(dataPortion, null);
        }


        /**
         * Node method
         * 
         * @param dataPortion
         *            first node
         * @param nextNode
         *            call on node after current node
         */
        public Node(K dataPortion, Node<K> nextNode) {
            data = dataPortion;
            next = nextNode;
        }


        /**
         * Getter method for next node
         * 
         * @return next node
         */
        public Node<K> getNextNode() {
            return next;

        }


        /**
         * getter method for data inside node
         * 
         * @return data
         */
        public K getData() {
            return data;
        }


        /**
         * setter method
         * 
         * @param nextNode
         *            sets next to nextNode
         */
        public void setNextNode(Node<K> nextNode) {
            next = nextNode;

        }

    }

    // field of Linked Stack class
    private Node<T> topNode;

    private int size;


    /**
     * constructor
     */
    public Stack() {
        topNode = null;
        size = 0;
    }


    /**
     * size method
     * 
     * @return size of stack
     */
    public int size() {
        return size;
    }


    /**
     * clears the stack
     */
    public void clear() {
        // topNode.next = null;
        topNode = null;
        size = 0;

    }


    /**
     * empty stack method
     * 
     * @return size is zero
     */

    public boolean isEmpty() {

        return size == 0;
    }


    /**
     * peek method
     * 
     * @return what's in top of stack
     */

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return topNode.getData();
        }
    }


    /**
     * pop method that removes an item
     * 
     * @return data in specific node
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {

            Node<T> node = topNode;

            topNode = topNode.getNextNode();
            size--;
            return node.getData();
        }
    }


    /**
     * push method that adds items to stack
     * 
     * @param anEntry
     *            the object to push
     */

    public void push(T anEntry) {
        Node<T> node2 = new Node<T>(anEntry);
        node2.setNextNode(topNode);

        topNode = node2;
        size++;

    }


    /**
     * To String method
     * 
     * @return items in a string
     */
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append('[');
        boolean firstItem = true;

        Node<T> curr = topNode;
        while (curr != null) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }
            builder.append(String.valueOf(curr.getData()));
            curr = curr.getNextNode();

        }

        builder.append(']');
        return builder.toString();

    }

}
