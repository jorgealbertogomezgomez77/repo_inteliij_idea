package Clase16Recursividad;

public class Recursividad {
    public double Factorial(int n) {
        // Caso base.
        if (n == 0) {
            return 1;
        }
        // Caso revursivo.
        else {
            return n * Factorial(n - 1);
        }
    }

    public int SumaLenta(int a, int b) {
        if (a == 0) {
            return b;
        }
        else {
            return SumaLenta(a - 1, b + 1);
        }
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return Fibonacci(n -2) + Fibonacci(n - 1);
        }
    }

    public int Factorialite(int n) {
        int num = n;
        int f = 1;
        while (num > 0) {
            f = f * num;
            num--;
        }
        return f;
    }
}
