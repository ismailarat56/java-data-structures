# Segment Tree From Scratch

`[2, 1, 5, 3, 4, 7]` satış array'i için aralık toplamları hızlı şekilde hesaplanır. Tree, `long[]` üzerinde ve root indexi `1` olacak şekilde tutulur.

## İşlemler

- `build`: Tree'yi recursion ile oluşturur.
- `rangeSum`: No overlap, total overlap ve partial overlap durumlarını işler.
- `update`: Tek indexi değiştirir ve root'a kadar toplamları yeniler.

Başlangıç toplamı `22` olur. `update(2, 6)` işleminden sonra toplam `23` olur.

## Çalıştırma

```bash
cd src
javac SegmentTree.java SegmentTreeDemo.java
java SegmentTreeDemo
```
