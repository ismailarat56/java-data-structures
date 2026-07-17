public class RecursionDemo {
    public static void main(String[] args) {
        RecursionExamples examples = new RecursionExamples();

        System.out.println("Print numbers ascending:");
        examples.printNumbersAscending(5);
        System.out.println();

        System.out.println("Print numbers descending:");
        examples.printNumbersDescending(5);
        System.out.println();

        System.out.println("Factorial recursive:");
        System.out.println(examples.factorialRecursive(5));

        System.out.println("Factorial iterative:");
        System.out.println(examples.factorialIterative(5));

        System.out.println("Fibonacci recursive:");
        System.out.println(examples.fibonacciRecursive(6));

        System.out.println("Fibonacci iterative:");
        System.out.println(examples.fibonacciIterative(6));

        System.out.println("Factorial tail recursion:");
        System.out.println(examples.factorialTail(5, 1));
    }
}
