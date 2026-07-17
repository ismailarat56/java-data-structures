# Java Data Structures From Scratch

Java ile temel veri yapılarını ve algoritmaları sıfırdan uygulayan, birbirinden bağımsız örnek projelerden oluşan bir çalışma deposu.

Bu projelerin amacı yalnızca hazır sınıfları kullanmak değil; bir veri yapısının bellekte nasıl temsil edildiğini, temel işlemlerinin nasıl çalıştığını ve farklı yaklaşımların zaman/alan maliyetlerini anlaşılır örneklerle göstermektir.

## İçerik

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

Her proje klasöründeki README dosyası, o örneğin senaryosunu ve beklenen çıktısını daha ayrıntılı açıklar.

## Kullanılan yaklaşım

Veri yapıları Java'nın hazır `Stack`, `Queue`, `PriorityQueue`, `HashMap`, `HashSet`, `TreeMap` veya benzeri koleksiyon sınıflarına dayanmadan uygulanmıştır. Bunun yerine:

- diziler,
- özel node/entry sınıfları,
- döngüler,
- recursion,
- temel nesne yönelimli programlama yapıları

kullanılmıştır. Projelerin Maven, Gradle veya üçüncü taraf kütüphane bağımlılığı yoktur.

## Gereksinimler

- JDK 8 veya daha yeni bir sürüm
- Komut satırı/terminal

Kurulumu doğrulamak için:

```bash
java -version
javac -version
```

## Çalıştırma

Her klasör bağımsız bir Java projesidir ve kendi `Main` sınıfına sahiptir. Bu nedenle projeleri ayrı ayrı derlemek gerekir.

Örneğin min heap uygulamasını çalıştırmak için depo kök dizininde şu komutları kullanın:

```bash
cd 06-heap-from-scratch
javac -d out src/*.java
java -cp out MinHeapDemo
```

Başka bir örneği çalıştırmak için ilk komuttaki klasör adını değiştirmeniz yeterlidir:

```bash
cd 08-trie-from-scratch
javac -d out src/*.java
java -cp out TrieDemo
```

Derlenen `.class` dosyaları ilgili projenin `out` klasörüne yazılır. Temizlemek istediğinizde bu klasörü silebilirsiniz.

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

Burada `n` eleman sayısını, `V` vertex sayısını, `L` kelime uzunluğunu ve `α` ters Ackermann fonksiyonunu ifade eder.

## Önerilen öğrenme sırası

Konular birbirinin üzerine kurulacak şekilde numaralandırılmıştır. İlk kez çalışıyorsanız şu sırayı izleyebilirsiniz:

1. Stack, queue ve hash map ile temel dizi/node kullanımını inceleyin.
2. Recursion örnekleriyle recursive çağrı ve base case kavramlarını öğrenin.
3. Binary tree üzerinde recursive traversal yöntemlerini uygulayın.
4. Heap, graph ve trie ile daha gelişmiş veri temsillerine geçin.
5. Union-Find, segment tree ve Fenwick tree ile verimli sorgu/güncelleme tekniklerini karşılaştırın.

## Test durumu

Depoda ayrı bir otomatik test altyapısı bulunmuyor. Her projenin `*Demo.java` dosyası, temel işlemleri örnek verilerle çalıştıran bir demo görevi görüyor. Değişiklik yaptıktan sonra ilgili projeyi yeniden derleyip konsol çıktısını proje README'sindeki beklenen sonuçlarla karşılaştırabilirsiniz.
