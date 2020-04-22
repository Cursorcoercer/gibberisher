/**
 * A class to organize and interact with TrieNodes.
 * This class defines a Trie, which consists of TrieNodes that can be addressed
 * by an alphabetic string, since each node has 26 children.
 *
 * @author  Peter Weiblen
 */

public class Trie <T>{
    private TrieNode<T> root;

    /**
     * Class constructor that initializes a Trie to one non-null node.
     */
    public Trie() {
        root = new TrieNode<T>();
    }

    /**
     * Method which returns the node at a given string address, or creates said node if it doesn't exist.
     * @param name The address of the desired node
     * @return TrieNode The node to at the given address
     */
    private TrieNode<T> getNode(String name) {
        TrieNode<T> currNode = root;
        for (int i = 0; i < name.length(); i++){
            currNode = currNode.getChild(name.charAt(i));
        }
        return currNode;
    }

    /**
     * Method which returns the data from a node at a given string address.
     * @param name The address of the desired node
     * @return T The data from the node to at the given address
     */
    public T get(String name) {
        return getNode(name).getData();
    }

    /**
     * Method which sets the data at a node at a given string address.
     * @param name The address of the desired node
     * @param data The data to be set at the node at the given address
     */
    public void put(String name, T data) {
        getNode(name).setData(data);
    }

    /**
     * Method which returns the root node of the Trie.
     * @return TrieNode The root node of the tree
     */
    public TrieNode<T> getRoot() {
        return root;
    }
}
