package com.bridgelabz;

/**
 * Purpose - To create methods for Hash table features.
 */
public class MyHashMap<K, V> {
    MyMapNode head;
    MyMapNode tail;

    /**
     * Purpose: Method to get the word from Linked List.
     * @param word: word returned.
     */
    public V get(K word) {
        MyMapNode<K, V> myNode = searchNode(word);
        return (myNode == null) ? null : myNode.getValue();
    }

    /**
     * Purpose: Method to search word from Linked List.
     * @param word: word to search.
     */
    public MyMapNode<K, V> searchNode(K word) {
        MyMapNode<K, V> currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            if (currentNode.getKey().equals(word)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Purpose: Method to add key and value to hash table.
     * @param key: word to be added.
     * @param value: frequency of word.
     */
    public void add(K key, V value) {
        MyMapNode<K, V> myNode = searchNode(key);
        if (myNode == null) {
            myNode = new MyMapNode<>(key, value);
            this.append(myNode);
        } else
            myNode.setValue(value);

    }

    /**
     * Purpose: Method to append value to Linked List.
     * @param myNode: value to append.
     */

    private void append(MyMapNode<K, V> myNode) {
        if (this.head == null)
            this.head = myNode;
        if (this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }
    /**
     * Purpose : Method to remove a word
     * @param key : word to be removed
     */
    public void remove(K key) {
        MyMapNode<K, V> currentNode = head;
        MyMapNode<K, V> previousNode = null;
        while (currentNode != null && currentNode.getKey().equals(key)) {
            head = currentNode.getNext();
        }
        while (currentNode != null && !(currentNode.getKey().equals(key))) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode != null)
            previousNode.next = currentNode.next;
        if (currentNode == null)
            System.out.println("Word not found");
    }

    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head + '}';
    }
}
