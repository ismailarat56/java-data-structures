[English](README.md) · **Türkçe**

<div align="center">

# Java Data Structures From Scratch

**Java ile temel veri yapılarını ve algoritmaları hazır koleksiyon sınıfları olmadan, sıfırdan uygulayan 12 bağımsız örnek proje.**

![Java](https://img.shields.io/badge/Java-8%2B-ED8B00?logo=openjdk&logoColor=white)
![Lisans](https://img.shields.io/badge/lisans-MIT-2ea44f)

[Öne çıkanlar](#öne-çıkanlar) · [Projeler](#projeler) · [Kurulum ve çalıştırma](#kurulum-ve-çalıştırma) · [Karmaşıklık özeti](#karmaşıklık-özeti)

</div>

Java ile temel veri yapılarını ve algoritmaları sıfırdan uygulayan, birbirinden bağımsız örnek projelerden oluşan bir çalışma deposu. Amaç yalnızca hazır sınıfları kullanmak değil; bir veri yapısının bellekte nasıl temsil edildiğini, temel işlemlerinin nasıl çalıştığını ve farklı yaklaşımların zaman/alan maliyetlerini anlaşılır örneklerle göstermektir. Veri yapılarını öğrenenler için hazırlanmıştır; derlemek için yalnızca JDK gerekir.

## Öne çıkanlar

- **Hazır koleksiyon yok:** kaynak dosyalarda `import` satırı bulunmaz; yapılar dizi ve özel node/entry sınıflarıyla kurulur.
- **Bağımsız projeler:** 12 klasörün her biri kendi `src/` klasörü ve giriş sınıfıyla tek başına derlenir.
- **Bağımlılık yok:** Maven, Gradle ya da üçüncü taraf kütüphane gerekmez; `javac` ve `java` yeterlidir.
- **Doğrusal yapılar:** dizi tabanlı stack, dairesel dizi tabanlı queue ve ayrı zincirleme kullanan hash map.
- **Sıralama:** bubble, selection, insertion ve counting sort; ilk üçünde karşılaştırma sayısı, swap sayısı ve süre ölçülür.
- **Ağaç ve heap:** binary tree üzerinde preorder, inorder ve postorder dolaşma; dolunca kapasitesini iki katına çıkaran min heap.
- **Graph:** adjacency matrix üzerinde recursive DFS, özel `IntQueue` ile BFS, yol kontrolü ve connected component sayımı.
- **Trie:** her node'da 26 elemanlı child dizisi; kelime ve prefix arama, silme, sayma ve alfabetik listeleme.
- **Aralık sorguları:** segment tree ve Fenwick tree ile range sum ve güncelleme; Union-Find'da path compression ve union by rank.
- **Demo sınıfları:** her projede örnek senaryoyu konsola yazdıran bir giriş sınıfı vardır; alt README'lerin yedisi beklenen sonucu da verir.

## Projeler

| Sıra | Proje | Konu | Öne çıkan işlemler |
| ---: | --- | --- | --- |
| 1 | [`stack-from-scratch`](stack-from-scratch/) | Dizi tabanlı stack | `push`, `pop`, `peek`, LIFO |
| 2 | [`queue-from-scratch`](queue-from-scratch/) | Dairesel dizi tabanlı queue | `enqueue`, `dequeue`, `peek`, FIFO |
| 3 | [`hashmap-from-scratch`](hashmap-from-scratch/) | Ayrı zincirleme kullanan hash map | `put`, `get`, `remove`, çakışma yönetimi |
| 4 | [`04-recursion-basics`](04-recursion-basics/) | Recursion temelleri | Factorial, Fibonacci, özyinelemeli ve iteratif çözümler |
| 5 | [`05-tree-basics`](05-tree-basics/) | Binary tree temelleri | Preorder, inorder ve postorder dolaşma |
| 6 | [`06-heap-from-scratch`](06-heap-from-scratch/) | Dizi tabanlı min heap | `insert`, `peek`, `extractMin`, dinamik kapasite |
| 7 | [`07-graph-from-scratch`](07-graph-from-scratch/) | Adjacency matrix tabanlı graph | Edge işlemleri, DFS, BFS, yol ve component kontrolü |
| 8 | [`08-trie-from-scratch`](08-trie-from-scratch/) | Dizi tabanlı trie | Kelime/prefix arama, silme, sayma ve sıralı listeleme |
| 9 | [`09-union-find-from-scratch`](09-union-find-from-scratch/) | Disjoint set (Union-Find) | Path compression, union by rank, component takibi |
| 10 | [`10-segment-tree-from-scratch`](10-segment-tree-from-scratch/) | Segment tree | Range sum ve point update |
| 11 | [`11-fenwick-tree-from-scratch`](11-fenwick-tree-from-scratch/) | Fenwick tree (BIT) | Prefix sum, range sum, `add` ve `set` |
| 12 | [`01-sorting`](01-sorting/) | Temel sıralama algoritmaları | Bubble, selection, insertion ve counting sort; karşılaştırma ve swap sayımı |

Her proje klasöründeki README dosyası o örneğin senaryosunu daha ayrıntılı açıklar; bir kısmı beklenen çıktıyı da verir.

Not: klasör adlarındaki numara önekleri tablodaki sırayla birebir örtüşmez. İlk üç klasörde önek yoktur, `01-sorting` ise tabloda son sıradadır.

## Gereksinimler

- JDK 8 veya daha yeni bir sürüm
- Komut satırı/terminal

Kurulumu doğrulamak için:

```bash
java -version
javac -version
```

## Kurulum ve çalıştırma

Kurulum adımı yoktur; depoyu indirmek yeterlidir. Her klasör bağımsız bir Java projesidir ve kendi giriş sınıfına (`main` metodunu içeren sınıf) sahiptir. Bu nedenle projeleri ayrı ayrı derlemek gerekir.

Örneğin min heap uygulamasını çalıştırmak için depo kök dizininde şu komutları kullanın:

```bash
cd 06-heap-from-scratch
javac -encoding UTF-8 -d out src/*.java
java -cp out MinHeapDemo
```

Başka bir örneği çalıştırmak için klasör adını ve son komuttaki giriş sınıfını değiştirmeniz yeterlidir:

```bash
cd 08-trie-from-scratch
javac -encoding UTF-8 -d out src/*.java
java -cp out TrieDemo
```

| Klasör | Giriş sınıfı | Klasör | Giriş sınıfı |
| --- | --- | --- | --- |
| `stack-from-scratch` | `StackDemo` | `07-graph-from-scratch` | `GraphDemo` |
| `queue-from-scratch` | `QueueDemo` | `08-trie-from-scratch` | `TrieDemo` |
| `hashmap-from-scratch` | `HashMapDemo` | `09-union-find-from-scratch` | `UnionFindDemo` |
| `04-recursion-basics` | `RecursionDemo` | `10-segment-tree-from-scratch` | `SegmentTreeDemo` |
| `05-tree-basics` | `TreeDemo` | `11-fenwick-tree-from-scratch` | `FenwickTreeDemo` |
| `06-heap-from-scratch` | `MinHeapDemo` | `01-sorting` | `Main` |

Kaynak dosyalar UTF-8 kodludur ve Türkçe karakter içerir; `-encoding UTF-8` seçeneği bu yüzden verilir. Derlenen `.class` dosyaları ilgili projenin `out` klasörüne yazılır. Temizlemek istediğinizde bu klasörü silebilirsiniz. Alt README'lerdeki komutların bir kısmı `.class` dosyalarını `src` içine yazar; iki çıktı da `.gitignore` kapsamındadır.

## Kullanılan yaklaşım

Veri yapıları Java'nın hazır `Stack`, `Queue`, `PriorityQueue`, `HashMap`, `HashSet`, `TreeMap` veya benzeri koleksiyon sınıflarına dayanmadan uygulanmıştır. Bunun yerine:

- diziler,
- özel node/entry sınıfları,
- döngüler,
- recursion,
- temel nesne yönelimli programlama yapıları

kullanılmıştır. Projelerin Maven, Gradle veya üçüncü taraf kütüphane bağımlılığı yoktur.

## Karmaşıklık özeti

| Veri yapısı | Temel işlem | Zaman karmaşıklığı |
| --- | --- | --- |
| Stack | `push`, `pop`, `peek` | `O(1)` |
| Circular queue | `enqueue`, `dequeue`, `peek` | `O(1)` |
| Hash map | `put`, `get`, `remove` | Ortalama `O(1)`, en kötü `O(n)` |
| Binary tree | Bir dolaşma işlemi | `O(n)` |
| Min heap | `insert`, `extractMin` | `O(log n)` |
| Graph (adjacency matrix) | DFS, BFS | `O(V²)` |
| Trie | Ekleme, arama, silme | `O(L)` |
| Union-Find | `find`, `union` | Amortize `O(α(n))` |
| Segment tree | Range query, point update | `O(log n)` |
| Fenwick tree | Prefix/range query, update | `O(log n)` |
| Bubble, selection, insertion sort | Sıralama | En kötü `O(n²)` |
| Counting sort | Sıralama | `O(n + k)` |

Burada `n` eleman sayısını, `V` vertex sayısını, `L` kelime uzunluğunu, `k` dizideki en büyük değeri ve `α` ters Ackermann fonksiyonunu ifade eder.

## Önerilen öğrenme sırası

Konular birbirinin üzerine kurulacak şekilde numaralandırılmıştır. İlk kez çalışıyorsanız şu sırayı izleyebilirsiniz:

1. Stack, queue ve hash map ile temel dizi/node kullanımını inceleyin.
2. Recursion örnekleriyle recursive çağrı ve base case kavramlarını öğrenin.
3. Binary tree üzerinde recursive traversal yöntemlerini uygulayın.
4. Heap, graph ve trie ile daha gelişmiş veri temsillerine geçin.
5. Union-Find, segment tree ve Fenwick tree ile verimli sorgu/güncelleme tekniklerini karşılaştırın.

Sıralama algoritmaları (`01-sorting`) yalnızca dizi kullanır; bu sıranın herhangi bir yerinde çalışılabilir.

## Klasör yapısı

```
<proje-klasörü>/     12 proje; adları yukarıdaki tabloda
  README.md          projenin senaryosu ve çalıştırma komutları
  src/               veri yapısı sınıfları ve giriş sınıfı (.java, paket bildirimi yok)
README.md
LICENSE
.gitignore
```

## Testler

Depoda ayrı bir otomatik test altyapısı bulunmuyor. Her projenin giriş sınıfı (`*Demo.java`, `01-sorting` içinde `Main.java`), temel işlemleri örnek verilerle çalıştıran bir demo görevi görüyor. Değişiklik yaptıktan sonra ilgili projeyi yeniden derleyip konsol çıktısını, varsa proje README'sindeki beklenen sonuçlarla karşılaştırabilirsiniz.

## Bilinen eksikler

- Otomatik test yok; doğrulama demo çıktısı gözle karşılaştırılarak yapılır.
- Stack ve queue sabit kapasitelidir; dolduğunda yeni elemanı kabul etmez. Hash map tablo boyutunu büyütmez.
- Yapılar generic değildir; örneğin hash map `int` anahtar ve `String` değer tutar.
- Trie yalnızca `a-z` küçük harflerini, counting sort yalnızca `0` ve pozitif tam sayıları destekler.
- Alt README'lerin beşi İngilizce, yedisi Türkçedir.

## Lisans

Kod [MIT lisansı](LICENSE) ile sunulur.
