# 01 - Sorting Algorithms (Junior Level)

Bu klasör, temel sıralama algoritmalarını Java ile öğrenmek için sade ve
adım adım hazırlanmıştır. Değişken ve metot adları basit İngilizcedir. Önemli
algoritma adımları Türkçe yorum satırlarıyla açıklanmıştır.

## Dosyalar

- `src/BasicSortAlgorithms.java`: Dört sıralama algoritmasını içerir.
- `src/SortMetrics.java`: Karşılaştırma ve swap sayılarını tutar.
- `src/Main.java`: Algoritmaları çalıştırır, süreyi ölçer ve sonucu kontrol eder.


## Çalıştırma

Terminalde `01-sorting` klasörüne geçin:

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Algoritmaların Kısa Mantığı

### Bubble Sort

Yan yana duran iki sayıyı karşılaştırır. Soldaki sayı büyükse sayıların yerini
değiştirir. Her turda büyük sayılardan biri dizinin sonuna gider. Bir turda hiç
swap olmazsa dizi zaten sıralıdır ve algoritma durur.

### Selection Sort

Sıralanmamış bölümdeki en küçük sayıyı bulur. Bu sayıyı bölümün ilk sayısıyla
yer değiştirir. Sonra kalan bölüm için aynı işlemi tekrarlar.

### Insertion Sort

Sol bölümü sıralı kabul eder. Sıradaki sayıyı geçici olarak tutar, büyük
sayıları sağa kaydırır ve tuttuğu sayıyı açılan doğru yere koyar.

### Counting Sort

Sayıları karşılaştırmak yerine her sayının kaç kez kullanıldığını sayar. Bu
örnek yalnızca `0` ve pozitif tam sayılarla çalışır. Negatif sayı verilirse bir
uyarı yazdırır ve boş dizi döndürür.


## Beklenen Temel Sonuç

`{5, 3, 8, 1, 2}` dizisi için üç temel algoritmanın sonucu:

```text
[1, 2, 3, 5, 8]
```

Beklenen ölçüm sayıları:

| Algoritma | Karşılaştırma | Swap |
| --- | ---: | ---: |
| Bubble Sort | 10 | 7 |
| Selection Sort | 10 | 3 |
| Insertion Sort | 9 | 0 |

Insertion Sort swap yapmak yerine sayıları sağa kaydırdığı için swap sayısı
`0` kalır. Nanosecond süre sonucu her çalıştırmada değişebilir.


