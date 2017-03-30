package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.Random;

public class Controller {

    @FXML
    private ListView list_Fibo;

    @FXML
    private ListView list_Fact;

    @FXML
    private ListView list_Cola;


    public void Calculate() {
        list_Fibo.getItems().clear();
        list_Fact.getItems().clear();
        list_Cola.getItems().clear();


        Random random = new Random();
        int fibonacci = random.nextInt(40);
        int factorial = 12;//random.nextInt(12);
        int collatz = random.nextInt(100000);


        calculateAllFibonacci(fibonacci);
        calculateFactorial(factorial);
        calculateCollatz(collatz);
    }

    private void calculateAllFibonacci(int max) {
        for (int i = 0; i < max; i++) {
            list_Fibo.getItems().add("Fibonacci " + i + ": " + calculateFibonacci(i));
        }
    }

    private int calculateFibonacci(int n) {
        if ((n == 0) || (n == 1)) {
            return n;
        }

        int outcome = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);

        return outcome;
    }

    private int calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        }

        int result = n * calculateFactorial(n - 1);

        list_Fact.getItems().add("Factorial " + n + ": " + result);

        return result;
    }

    private void calculateCollatz(int n) {
        list_Cola.getItems().add(n);

        if (n == 1) {
            return;
        }

        if (n % 2 == 0) {
            calculateCollatz(n / 2);
        } else {
            calculateCollatz(n * 3 + 1);
        }
    }
}
