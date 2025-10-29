package org.datastructures.tries;

public class Trie {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        public TrieNode(){
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //Insert a word
    public void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];

        }
        node.isEndOfWord = true;
    }

    //search a word
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    //check if prefix exists
    // Check if a prefix exists
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }


    static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("car");
        trie.insert("dog");

        System.out.println(trie.search("cat"));    // true
        System.out.println(trie.search("cap"));    // false
        System.out.println(trie.startsWith("ca")); // true
        System.out.println(trie.startsWith("do")); // true
        System.out.println(trie.startsWith("de")); // false
    }
}
