public class TrieDemo {
    public static void main(String[] args) {
        MyTrie dictionary = new MyTrie();
        String[] words = {"car", "card", "care", "cat", "dog", "door"};

        // Ortak ön eke sahip kelimeler trie içinde aynı düğümleri paylaşır.
        for (int index = 0; index < words.length; index++) {
            dictionary.insert(words[index]);
        }

        System.out.println("car: " + dictionary.containsWord("car"));
        System.out.println("ca: " + dictionary.containsWord("ca"));
        System.out.println("apple: " + dictionary.containsWord("apple"));
        System.out.println("Prefix ca: " + dictionary.startsWith("ca"));
        System.out.println("Prefix dor: " + dictionary.startsWith("dor"));

        System.out.println("Words with ca:");
        dictionary.printWordsWithPrefix("ca");
        System.out.println("Count ca: " + dictionary.countWordsWithPrefix("ca"));
        System.out.println("Count car: " + dictionary.countWordsWithPrefix("car"));
        System.out.println("Count do: " + dictionary.countWordsWithPrefix("do"));

        // "card" silinirken aynı yolu kullanan "car" ve "care" korunmalıdır.
        System.out.println("Delete card: " + dictionary.delete("card"));
        System.out.println("card: " + dictionary.containsWord("card"));
        System.out.println("car: " + dictionary.containsWord("car"));
        System.out.println("care: " + dictionary.containsWord("care"));
    }
}
