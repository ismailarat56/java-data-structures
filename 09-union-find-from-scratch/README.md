# Union Find From Scratch

Sekiz bilgisayarın hangi network grubunda bulunduğu üç array ile takip edilir:

- `parent`: Elemanın bağlı olduğu parent
- `rank`: Ağacın yaklaşık yüksekliği
- `componentSize`: Root'a ait grubun eleman sayısı

`find` sırasında path compression, `union` sırasında union by rank uygulanır.

Verilen bağlantılardan sonra beklenen gruplar:

- `{0, 1, 2, 5, 6, 7}`
- `{3, 4}`

Beklenen component sayısı: `2`

## Çalıştırma

```bash
cd src
javac UnionFind.java UnionFindDemo.java
java UnionFindDemo
```
