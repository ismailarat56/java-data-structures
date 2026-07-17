public class HashMapDemo {
    public static void main(String[] args) {
        MyHashMap students = new MyHashMap(10);

        addStudent(students, 101, "Ali");
        addStudent(students, 102, "Ayşe");
        addStudent(students, 103, "Mehmet");
        addStudent(students, 104, "Zeynep");
        addStudent(students, 105, "Elif");
        addStudent(students, 111, "Can");

        searchStudent(students, 103);
        searchStudent(students, 999);

        removeStudent(students, 102);
        searchStudent(students, 102);

        System.out.println();
        System.out.println("Aynı key tekrar eklenirse güncelleme yapılır:");
        students.put(101, "Ali Yılmaz");
        System.out.println("101 key değerinin yeni value değeri: " + students.get(101));

        System.out.println();
        System.out.println("Toplam öğrenci sayısı: " + students.size());

        students.printTable();
    }

    public static void addStudent(MyHashMap students, int id, String name) {
        students.put(id, name);
        System.out.println(id + " numaralı öğrenci eklendi: " + name);
    }

    public static void searchStudent(MyHashMap students, int id) {
        System.out.println();
        System.out.println("Aranan ID: " + id);

        if (students.containsKey(id)) {
            System.out.println("Bulunan öğrenci: " + students.get(id));
        } else {
            System.out.println("Bu ID ile kayıtlı öğrenci bulunamadı.");
        }
    }

    public static void removeStudent(MyHashMap students, int id) {
        System.out.println();

        if (students.remove(id)) {
            System.out.println(id + " numaralı öğrenci silindi.");
        } else {
            System.out.println("Bu ID ile kayıtlı öğrenci bulunamadı.");
        }
    }
}
