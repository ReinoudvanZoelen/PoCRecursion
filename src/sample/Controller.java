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
        int fibonacci = random.nextInt(100000);
        int factorial = 12;//random.nextInt(12);
        int collatz = random.nextInt(100000);


        calculateFibonacci(0, 1, fibonacci);
        calculateFactorial(factorial);
        calculateCollatz(collatz);
    }

    private void calculateFibonacci(int n1, int n2, int endpoint) {
        list_Fibo.getItems().add(n1);

        if (n1 >= endpoint) {
            return;
        }

        int solution = n1 + n2;

        calculateFibonacci(n2, solution, endpoint);

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
