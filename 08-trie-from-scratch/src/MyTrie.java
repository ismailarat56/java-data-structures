// Trie, kelimeleri karakter karakter saklayarak ön ek sorgularını hızlandırır.
public class MyTrie {
    private final TrieNode root;

    public MyTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        validateText(word);
        TrieNode currentNode = root;

        for (int position = 0; position < word.length(); position++) {
            char character = word.charAt(position);
            int index = character - 'a';

            // Yalnızca eksik olan karakter için yeni düğüm oluşturulur.
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }

            currentNode = currentNode.children[index];
        }

        currentNode.isWord = true;
    }

    public boolean containsWord(String word) {
        validateText(word);
        TrieNode node = findNode(word);

        // Yolun bulunması yetmez; son düğüm tam bir kelimeyi işaretlemelidir.
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        validateText(prefix);
        return findNode(prefix) != null;
    }

    public boolean delete(String word) {
        validateText(word);

        if (!containsWord(word)) {
            return false;
        }

        // Rekürsif dönüşte artık hiçbir kelimenin kullanmadığı düğümler temizlenir.
        deleteRecursive(root, word, 0);
        return true;
    }

    private boolean deleteRecursive(TrieNode currentNode, String word, int position) {
        if (position == word.length()) {
            // Kelime işareti kaldırılır; çocuk yoksa bu düğüm de silinebilir.
            currentNode.isWord = false;
            return !hasChildren(currentNode);
        }

        int index = word.charAt(position) - 'a';
        TrieNode child = currentNode.children[index];
        boolean removeChild = deleteRecursive(child, word, position + 1);

        if (removeChild) {
            // Başka bir kelime kullanmıyorsa gereksiz düğüm temizlenir.
            currentNode.children[index] = null;
        }

        return !currentNode.isWord && !hasChildren(currentNode);
    }

    private boolean hasChildren(TrieNode node) {
        for (TrieNode children : node.children) {
            if (children != null) {
                return true;
            }
        }

        return false;
    }

    public int countWordsWithPrefix(String prefix) {
        validateText(prefix);
        TrieNode prefixNode = findNode(prefix);

        if (prefixNode == null) {
            return 0;
        }

        return countWords(prefixNode);
    }

    private int countWords(TrieNode currentNode) {
        // Her kelime sonu bir kez sayılır ve alt dallardaki sonuçlara eklenir.
        int count = currentNode.isWord ? 1 : 0;

        for (TrieNode children : currentNode.children) {
            if (children != null) {
                count += countWords(children);
            }
        }

        return count;
    }

    public void printWordsWithPrefix(String prefix) {
        validateText(prefix);
        TrieNode prefixNode = findNode(prefix);

        if (prefixNode == null) {
            System.out.println("No words found.");
            return;
        }

        // Çocuk dizisi a'dan z'ye gezildiği için sonuç alfabetik sıradadır.
        printWordsRecursive(prefixNode, prefix);
    }

    private void printWordsRecursive(TrieNode currentNode, String currentWord) {
        if (currentNode.isWord) {
            System.out.println(currentWord);
        }

        for (int index = 0; index < currentNode.children.length; index++) {
            if (currentNode.children[index] != null) {
                char nextCharacter = (char) ('a' + index);
                printWordsRecursive(currentNode.children[index], currentWord + nextCharacter);
            }
        }
    }

    private TrieNode findNode(String text) {
        TrieNode currentNode = root;

        // Metindeki her karakter, bir sonraki çocuk düğümün indeksini belirler.
        for (int position = 0; position < text.length(); position++) {
            int index = text.charAt(position) - 'a';

            if (currentNode.children[index] == null) {
                return null;
            }

            currentNode = currentNode.children[index];
        }

        return currentNode;
    }

    private void validateText(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be empty.");
        }

        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);

            if (character < 'a' || character > 'z') {
                throw new IllegalArgumentException(
                    "Only lowercase English letters are supported."
                );
            }
        }
    }
}
