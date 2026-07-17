# Trie From Scratch

Bu Trie yalnızca `a-z` arası küçük İngilizce harfleri destekler. Her node, 26 elemanlı bir child array içerir; `HashMap` kullanılmaz.

## Özellikler

- Kelime ekleme
- Tam kelime arama
- Prefix arama
- Ortak node'ları koruyarak kelime silme
- Prefix altındaki kelime sayısını recursion ile bulma
- Kelimeleri alfabetik sırada yazdırma

`ca` prefix'i için başlangıç kelimeleri `car`, `card`, `care` ve `cat`; beklenen kelime sayısı `4` olur.

## Çalıştırma

```bash
cd src
javac TrieNode.java MyTrie.java Main.java
java Main
```
