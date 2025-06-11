package src.Tree;

public class TrieMain {
    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert(trieTree.root, "cat");
        trieTree.insert(trieTree.root,"dog");
        trieTree.insert(trieTree.root,"do");
        trieTree.insert(trieTree.root,"dad");
        trieTree.insert(trieTree.root,"and");
        trieTree.insert(trieTree.root,"ant");

        System.out.print("\n search:");
        System.out.print("\nsearch cat:"+trieTree.search(trieTree.root,"cat"));
        System.out.print("\nsearch do:"+trieTree.search(trieTree.root,"do"));
        System.out.print("\n search dog:"+trieTree.search(trieTree.root,"dog"));
        System.out.print("\n search drum:"+trieTree.search(trieTree.root,"drum"));

        System.out.print("\nsearch ca:"+trieTree.search(trieTree.root,"ca"));
        System.out.print("\nsearch prefix ca:"+trieTree.isPrefix(trieTree.root,"ca"));
    }
}
