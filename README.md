**English** · [Türkçe](README.tr.md)

<div align="center">

# Java Data Structures From Scratch

**12 standalone sample projects that implement basic data structures and algorithms in Java from scratch, without the built-in collection classes.**

![Java](https://img.shields.io/badge/Java-8%2B-ED8B00?logo=openjdk&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-2ea44f)

[Highlights](#highlights) · [Projects](#projects) · [Setup and running](#setup-and-running) · [Complexity summary](#complexity-summary)

</div>

A study repository made of standalone sample projects that implement basic data structures and algorithms in Java from scratch. The goal is not only to use the built-in classes. It is to show, with clear examples, how a data structure is represented in memory, how its basic operations work, and what the time and space costs of different approaches are. It is intended for people who are learning data structures; only a JDK is needed to compile it.

Note: the README files in the project folders are kept as they are; five are in English and seven are in Turkish. The console output of three demos (`stack-from-scratch`, `queue-from-scratch`, `hashmap-from-scratch`) is in Turkish; the other nine print English text.

## Highlights

- **No built-in collections:** the source files have no `import` lines; the structures are built with arrays and custom node/entry classes.
- **Standalone projects:** each of the 12 folders compiles on its own, with its own `src/` folder and entry class.
- **No dependencies:** no Maven, Gradle or third-party library is needed; `javac` and `java` are enough.
- **Linear structures:** an array-based stack, a circular-array-based queue and a hash map that uses separate chaining.
- **Sorting:** bubble, selection, insertion and counting sort; for the first three, the number of comparisons, the number of swaps and the elapsed time are measured.
- **Tree and heap:** preorder, inorder and postorder traversal on a binary tree; a min heap that doubles its capacity when it is full.
- **Graph:** recursive DFS on an adjacency matrix, BFS with a custom `IntQueue`, path check and connected component count.
- **Trie:** a 26-element child array in every node; word and prefix search, deletion, counting and alphabetical listing.
- **Range queries:** range sum and update with a segment tree and a Fenwick tree; path compression and union by rank in Union-Find.
- **Demo classes:** every project has an entry class that prints a sample scenario to the console; seven of the sub-folder READMEs also give the expected result.

## Projects

| No. | Project | Topic | Main operations |
| ---: | --- | --- | --- |
| 1 | [`stack-from-scratch`](stack-from-scratch/) | Array-based stack | `push`, `pop`, `peek`, LIFO |
| 2 | [`queue-from-scratch`](queue-from-scratch/) | Circular-array-based queue | `enqueue`, `dequeue`, `peek`, FIFO |
| 3 | [`hashmap-from-scratch`](hashmap-from-scratch/) | Hash map that uses separate chaining | `put`, `get`, `remove`, collision handling |
| 4 | [`04-recursion-basics`](04-recursion-basics/) | Recursion basics | Factorial, Fibonacci, recursive and iterative solutions |
| 5 | [`05-tree-basics`](05-tree-basics/) | Binary tree basics | Preorder, inorder and postorder traversal |
| 6 | [`06-heap-from-scratch`](06-heap-from-scratch/) | Array-based min heap | `insert`, `peek`, `extractMin`, dynamic capacity |
| 7 | [`07-graph-from-scratch`](07-graph-from-scratch/) | Adjacency-matrix-based graph | Edge operations, DFS, BFS, path and component checks |
| 8 | [`08-trie-from-scratch`](08-trie-from-scratch/) | Array-based trie | Word/prefix search, deletion, counting and sorted listing |
| 9 | [`09-union-find-from-scratch`](09-union-find-from-scratch/) | Disjoint set (Union-Find) | Path compression, union by rank, component tracking |
| 10 | [`10-segment-tree-from-scratch`](10-segment-tree-from-scratch/) | Segment tree | Range sum and point update |
| 11 | [`11-fenwick-tree-from-scratch`](11-fenwick-tree-from-scratch/) | Fenwick tree (BIT) | Prefix sum, range sum, `add` and `set` |
| 12 | [`01-sorting`](01-sorting/) | Basic sorting algorithms | Bubble, selection, insertion and counting sort; comparison and swap counting |

The README file in each project folder explains the scenario of that example in more detail; some of them also give the expected output.

Note: the number prefixes in the folder names do not match the order in the table exactly. The first three folders have no prefix, and `01-sorting` is last in the table.

## Requirements

- JDK 8 or newer
- A command line/terminal

To verify the installation:

```bash
java -version
javac -version
```

## Setup and running

There is no installation step; downloading the repository is enough. Each folder is a standalone Java project and has its own entry class (the class that contains the `main` method). For this reason the projects have to be compiled one by one.

For example, to run the min heap implementation, use these commands in the repository root:

```bash
cd 06-heap-from-scratch
javac -encoding UTF-8 -d out src/*.java
java -cp out MinHeapDemo
```

To run another example, change the folder name and the entry class in the last command:

```bash
cd 08-trie-from-scratch
javac -encoding UTF-8 -d out src/*.java
java -cp out TrieDemo
```

| Folder | Entry class | Folder | Entry class |
| --- | --- | --- | --- |
| `stack-from-scratch` | `StackDemo` | `07-graph-from-scratch` | `GraphDemo` |
| `queue-from-scratch` | `QueueDemo` | `08-trie-from-scratch` | `TrieDemo` |
| `hashmap-from-scratch` | `HashMapDemo` | `09-union-find-from-scratch` | `UnionFindDemo` |
| `04-recursion-basics` | `RecursionDemo` | `10-segment-tree-from-scratch` | `SegmentTreeDemo` |
| `05-tree-basics` | `TreeDemo` | `11-fenwick-tree-from-scratch` | `FenwickTreeDemo` |
| `06-heap-from-scratch` | `MinHeapDemo` | `01-sorting` | `Main` |

The source files are UTF-8 encoded and contain Turkish characters; that is why the `-encoding UTF-8` option is passed. The compiled `.class` files are written to the `out` folder of the project. You can delete this folder when you want to clean up. Some of the commands in the sub-folder READMEs write the `.class` files into `src`; both outputs are covered by `.gitignore`.

## Approach

The data structures are implemented without relying on Java's built-in `Stack`, `Queue`, `PriorityQueue`, `HashMap`, `HashSet`, `TreeMap` or similar collection classes. Instead, they use:

- arrays,
- custom node/entry classes,
- loops,
- recursion,
- basic object-oriented programming constructs.

The projects have no Maven, Gradle or third-party library dependencies.

## Complexity summary

| Data structure | Basic operation | Time complexity |
| --- | --- | --- |
| Stack | `push`, `pop`, `peek` | `O(1)` |
| Circular queue | `enqueue`, `dequeue`, `peek` | `O(1)` |
| Hash map | `put`, `get`, `remove` | Average `O(1)`, worst case `O(n)` |
| Binary tree | One traversal | `O(n)` |
| Min heap | `insert`, `extractMin` | `O(log n)` |
| Graph (adjacency matrix) | DFS, BFS | `O(V²)` |
| Trie | Insertion, search, deletion | `O(L)` |
| Union-Find | `find`, `union` | Amortized `O(α(n))` |
| Segment tree | Range query, point update | `O(log n)` |
| Fenwick tree | Prefix/range query, update | `O(log n)` |
| Bubble, selection, insertion sort | Sorting | Worst case `O(n²)` |
| Counting sort | Sorting | `O(n + k)` |

Here `n` is the number of elements, `V` the number of vertices, `L` the word length, `k` the largest value in the array and `α` the inverse Ackermann function.

## Suggested learning order

The topics are numbered so that they build on each other. If you are studying them for the first time, you can follow this order:

1. Study basic array/node usage with the stack, queue and hash map.
2. Learn the concepts of recursive call and base case with the recursion examples.
3. Apply the recursive traversal methods on a binary tree.
4. Move on to more advanced data representations with the heap, graph and trie.
5. Compare efficient query/update techniques with Union-Find, the segment tree and the Fenwick tree.

The sorting algorithms (`01-sorting`) use only arrays; they can be studied at any point in this order.

## Folder structure

```
<project-folder>/    12 projects; their names are in the table above
  README.md          the scenario of the project and the commands to run it
  src/               data structure classes and the entry class (.java, no package declaration)
README.md
LICENSE
.gitignore
```

## Tests

The repository has no separate automated test setup. The entry class of each project (`*Demo.java`, or `Main.java` in `01-sorting`) acts as a demo that runs the basic operations with sample data. After making a change, you can recompile the project and compare the console output with the expected results in the project README, if it has any.

## Known limitations

- There are no automated tests; verification is done by comparing the demo output by eye.
- The stack and the queue have a fixed capacity; when they are full, they do not accept a new element. The hash map does not grow its table.
- The structures are not generic; for example, the hash map holds `int` keys and `String` values.
- The trie supports only the lowercase letters `a-z`, and counting sort supports only `0` and positive integers.
- Five of the sub-folder READMEs are in English and seven are in Turkish.

## License

The code is released under the [MIT license](LICENSE).
