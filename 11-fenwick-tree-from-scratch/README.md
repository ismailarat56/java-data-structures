# Fenwick Tree From Scratch

Fenwick Tree, `[2, 1, 5, 3, 4, 7]` satış array'i üzerinde prefix sum ve range sum hesaplar. Kullanıcı indexleri sıfır tabanlı, internal tree indexleri bir tabanlıdır.

## İşlemler

- `add`: Bir indexe delta ekler.
- `set`: Yeni değer ile eski değer arasındaki delta üzerinden günceller.
- `prefixSum`: `0` ile verilen index arasındaki toplamı bulur.
- `rangeSum`: İki prefix toplamının farkını kullanır.
- `lowbit`: `value & -value` işlemini uygular.

Başlangıçta `rangeSum(0, 5) = 22` olur. `set(2, 6)` işleminden sonra `rangeSum(1, 4) = 14` olur.

## Çalıştırma

```bash
cd src
javac FenwickTree.java Main.java
java Main
```
