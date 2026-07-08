public class RecursionExamples {

    public void printNumbersAscending(int n) {
        // Base case: n 0 olursa recursion durur
        if (n == 0) {
            return;
        }

        // Recursive case: önce küçük sayıları yazdır
        printNumbersAscending(n - 1);

        // Geri dönüşte sayıyı yazdırır
        System.out.print(n + " ");
    }

    public void printNumbersDescending(int n) {
        // Base case: n 0 olursa recursion durur
        if (n == 0) {
            return;
        }

        // Önce mevcut sayıyı yazdırır
        System.out.print(n + " ");

        // Recursive case: bir küçük sayı ile devam eder
        printNumbersDescending(n - 1);
    }

    public int factorialRecursive(int n) {
        // Negatif sayılar için factorial tanımlı değildir
        if (n < 0) {
            throw new IllegalArgumentException("n must be zero or positive");
        }

        // Base case: 0! ve 1! değeri 1'dir
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case: n! = n * (n - 1)!
        return n * factorialRecursive(n - 1);
    }

    public int factorialIterative(int n) {
        // Negatif sayılar için factorial tanımlı değildir
        if (n < 0) {
            throw new IllegalArgumentException("n must be zero or positive");
        }

        int result = 1;

        // Döngü ile 1'den n'e kadar çarpım yapılır
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public int fibonacciRecursive(int n) {
        // Negatif sayılar için fibonacci hesaplanmaz
        if (n < 0) {
            throw new IllegalArgumentException("n must be zero or positive");
        }

        // Base case: fibonacci(0) = 0, fibonacci(1) = 1
        if (n == 0 || n == 1) {
            return n;
        }

        // Tree recursion: method kendini iki kez çağırır
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public int fibonacciIterative(int n) {
        // Negatif sayılar için fibonacci hesaplanmaz
        if (n < 0) {
            throw new IllegalArgumentException("n must be zero or positive");
        }

        // İlk iki fibonacci değeri direkt döndürülür
        if (n == 0 || n == 1) {
            return n;
        }

        int previous = 0;
        int current = 1;

        // Döngü ile fibonacci değeri hesaplanır
        for (int i = 2; i <= n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }

    public int factorialTail(int n, int result) {
        // Negatif sayılar için factorial tanımlı değildir
        if (n < 0) {
            throw new IllegalArgumentException("n must be zero or positive");
        }

        // Base case: sonuç hazır olduğunda döndürülür
        if (n == 0 || n == 1) {
            return result;
        }

        // Tail recursion: recursive çağrı en son işlemdir
        return factorialTail(n - 1, n * result);
    }
}
