# Min Heap From Scratch

Bu uygulama, hastaların öncelik değerlerini array üzerinde tutan bir Min Heap oluşturur. Küçük sayı daha yüksek öncelik demektir ve her zaman root üzerinde bulunur.

## Temel işlemler

- `insert`: Değeri sona ekler ve `heapifyUp` uygular.
- `peek`: En küçük değeri yapıyı değiştirmeden döndürür.
- `extractMin`: Root'u çıkarır ve `heapifyDown` uygular.
- `ensureCapacity`: Array dolunca kapasiteyi iki katına çıkarır.

## Beklenen sonuç

Eklenen değerler: `40, 10, 30, 50, 20, 5, 35`

- Son root: `5`
- Çıkarma sırası: `5, 10, 20, 30, 35, 40, 50`

## Çalıştırma

```bash
cd src
javac MinHeap.java MinHeapDemo.java
java MinHeapDemo
```
