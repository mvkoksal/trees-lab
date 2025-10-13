package edu.grinnell.csc207.trees;

import java.util.List;

/**
 * A generic binary tree implementation.
 */
public class Tree<T extends Comparable<? super T>> {

    ///// From the reading
    
    // N.B., the Node<T> class is made public for this lab, so that you can
    // construct trees without an insert-style method!

    private Node<T> root;

    /**
     * Constructs a new, empty binary tree.
     */
    public Tree() {
        root = null;
    }

    /**
     * Constructs a new binary tree with the given root node.
     * @param root the root node of the tree
     */
    public Tree(Node<T> root) {
        this.root = root;
    }

    /**
     * @param node the root of the tree 
     * @return the number elements found in this tree rooted at node
     */
    private int sizeH(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeH(node.left) + sizeH(node.right);
        }
    }

    /** @return the number of elements in the tree */
    public int size() {
        return sizeH(root);
    }

    ///// Part 1: Contains
    
    // We'll recursively go all the way down the leftmost branches, comparing the value of the nodes to the value we're searching for.
    // Then if the value has not been found, we go all the way down the rightmost brances recursively.


    public boolean containsHelper(T value, Node<T> node){
        if (node == null) {
            return false;
        } else {
            if (node.value.equals(value)) {
                return true;
            } else{
                return(containsHelper(value, node.left) || containsHelper(value, node.right));
            }
        }
    }

    /**
     * @param value the value to search for
     * @return true iff the tree contains <code>value</code>
     */
    public boolean contains(T value) {
        return containsHelper(value, root);
    }

    ///// Part 2: toString
    
    // First we will create an empty string, for the first value we find we will simply append that value to the string.
    // Then we'll recursively go all the way down the leftmost branches, appending a comma then the value of the nodes to the string.
    // Then we'll recursively go all the way down the rightmost branches, appending a comma then the value of the nodes to the string.
   
    /**
     * @return a string represent of this tree in the form, "[x1, ..., xk]."
     * The order of the elements is left unspecified.
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    ///// Part 3: Traversals

    /**
     * @return the elements of this tree collected via an in-order traversal
     */
    public List<T> toListInorder() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return the elements of this tree collected via a pre-order traversal
     */
    public List<T> toListPreorder() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return the elements of this tree collected via a post-order traversal
     */
    public List<T> toListPostorder() {
        throw new UnsupportedOperationException();
    }

    ///// Extra: Pretty Printing
    
    /**
     * @return a string represent of this tree in bulleted list form.
     */
    public String toPrettyString() {
        throw new UnsupportedOperationException();
    }

    /**
     * The main driver for this program
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Nothing to do. 'Run' via the JUnit tests instead!");
    }
}
