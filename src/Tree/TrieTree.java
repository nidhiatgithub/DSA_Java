package src.Tree;

public class TrieTree {
   TrieNode root;
    static class TrieNode {
        TrieNode children[];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];
        }

    }

    TrieTree() {
        root = new TrieNode();
    }

    //Time Complexity: O(n), where n is the length of the word to insert.
    //Auxiliary Space: O(n)
    public void insert(TrieNode root, String key) {
        TrieNode current = root;
        for(char c : key.toCharArray()) {
            if(current.children[c-'a'] == null) {
                TrieNode trieNode = new TrieNode();
                current.children[c-'a'] = trieNode;
            }
            current = current.children[c-'a'];
        }
        current.isEndOfWord = true;
    }

    //O(n) Time and O(1) Space
    public boolean search(TrieNode node, String key) {

        for(char ch: key.toCharArray()) {
            if(node.children[ch-'a'] == null)
                return false;
            node = node.children[ch-'a'];
        }
        return node.isEndOfWord;
    }

    public boolean isPrefix(TrieNode node, String prefix) {
        for(char ch: prefix.toCharArray()) {
            if(node.children[ch-'a'] == null)
                return false;
            node = node.children[ch-'a'];
        }
        return true;
    }
}
