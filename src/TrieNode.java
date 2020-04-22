/**
 * Implements a TrieNode class.
 * This is an implementation of TrieNode where each node points to 26 other nodes
 * and holds one data value of generic type.
 *
 * @author  Peter Weiblen
 */

public class TrieNode<T> {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private T data;
    private TrieNode<T>[] children;

    /**
     * Class constructor that initializes the data and all children nodes to null.
     */
    public TrieNode () {
        this.data = null;
        this.children = new TrieNode[26];

    }

    /**
     * Method which returns the data held by this node.
     * @return T This returns the data at this node.
     */
    public T getData() {
        return this.data;
    }

    /**
     * Method which sets the data held by this node.
     * @param newData This the data to be set at this node.
     */
    public void setData(T newData) {
        this.data = newData;
    }

    /**
     * Method which returns one of the children of this node according to its alphabetic address.
     * If desired node is null, create a new one and put it place. If address is invalid, return null.
     * @param letter The address of the desired child node
     * @return TrieNode The child node to at the given address
     */
    public TrieNode<T> getChild(char letter) {
        if (! Character.isLowerCase(letter)) {
            return null;
        } else {
            int index = alphabet.indexOf(letter);
            if (this.children[index] == null) {
                this.children[index] = new TrieNode<T>();
                return this.children[index];
            }
            return this.children[index];
        }
    }

    /**
     * Method which returns the size of the tree below this node, including this node, not counting null values
     * @return int The size of the tree from this node down
     */
    public int getTreeSize() {
        int total = 1;
        for (int i = 0; i < 26; i++) {
            if (this.children[i] != null) {
                total += this.children[i].getTreeSize();
            }
        }
        return total;
    }
}
