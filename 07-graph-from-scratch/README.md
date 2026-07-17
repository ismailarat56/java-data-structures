# Graph From Scratch

Şehir bağlantıları `int[][]` adjacency matrix ile tutulur. Graph yonsuzdur; bu nedenle her bağlantı matrix içinde iki yönde işaretlenir. Self-loop kabul edilmez, duplicate edge ise mevcut değeri değiştirmez.

## Özellikler

- Edge ekleme, silme ve kontrol etme
- Vertex degree hesaplama
- Recursive DFS
- Özel `IntQueue` ile BFS
- İki vertex arasında yol kontrolü
- Connected component sayma

A'dan başlayan beklenen sıralar:

- DFS: `A B D C E F`
- BFS: `A B C D E F`

## Çalıştırma

```bash
cd src
javac MatrixGraph.java IntQueue.java Main.java
java Main
```
