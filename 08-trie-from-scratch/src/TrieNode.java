// Her düğüm, sonraki harfleri ve burada bir kelimenin bitip bitmediğini tutar.
public class TrieNode {
    // 0-25 indeksleri sırasıyla 'a'-'z' harflerine karşılık gelir.
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}
