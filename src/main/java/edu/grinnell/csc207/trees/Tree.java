package edu.grinnell.csc207.trees;

import java.util.ArrayList;
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
   
    public void toStringHelper(Node<T> node, StringBuffer buf){
        if (node != null) {
            buf.append(",");
            buf.append(node.value);
            toStringHelper(node.left, buf);
            toStringHelper(node.right, buf);
        }
    }

    /**
     * @return a string represent of this tree in the form, "[x1, ..., xk]."
     * The order of the elements is left unspecified.
     */
    @Override
    public String toString() {
        if(root != null){
            StringBuffer buf = new StringBuffer("[");
            buf.append(root.value);
            toStringHelper(root.left, buf);
            toStringHelper(root.right, buf);
            buf.append("]");
            return buf.toString();
        } else{return "[]";}
    }

    ///// Part 3: Traversals
    /// 
    public void toListInorderHelper(Node<T> node, List<T> newList){
        if (node != null) {
            toListInorderHelper(node.left, newList);
            newList.add(node.value);
            toListInorderHelper(node.right, newList);
        }
    }
    // If leaf return, else if node do a recursive call on the left branch, add value to string then 
    // followed by a recursive call on the right branch, then add value to string then .
    /**
     * @return the elements of this tree collected via an in-order traversal
     */
    public List<T> toListInorder() {
        List<T> newList = new ArrayList<>();
        toListInorderHelper(root, newList);
        return newList;
    }

    public void toListPreorderHelper(Node<T> node, List<T> newList){
        if (node != null) {
            newList.add(node.value);
            toListPreorderHelper(node.left, newList);
            toListPreorderHelper(node.right, newList);
        }
    }

    // If leaf return, else if node add value to string then do a recursive call on the left branch
    // followed by a recursive call on the right branch.
    /**
     * @return the elements of this tree collected via a pre-order traversal
     */
    public List<T> toListPreorder() {
        List<T> newList = new ArrayList<>();
        toListPreorderHelper(root, newList);
        return newList;
    }


    public void toListPostorderHelper(Node<T> node, List<T> newList){
        if (node != null) {
            toListPostorderHelper(node.left, newList);
            toListPostorderHelper(node.right, newList);
            newList.add(node.value);
        }
    }
    // If leaf return, else if node do a recursive call on the left branch, 
    // followed by a recursive call on the right branch, then add values to string .
    /**
     * @return the elements of this tree collected via an post-order traversal
     */
    public List<T> toListPostorder() {
        List<T> newList = new ArrayList<>();
        toListPostorderHelper(root, newList);
        return newList;
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
