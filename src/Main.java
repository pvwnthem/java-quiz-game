import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To The Quiz!");
        Scanner scanner = new Scanner(System.in);
        DecimalFormat hundredth = new DecimalFormat("#.00");

        Object[] questions = {"How Many States Are In The USA?", "How Many Seconds Are In A Minute?", "Who Was The First President Of The USA?"};
        Object[] correctAnswers = {50, 60, "George Washington"};
        Object[] answers = new Object[questions.length];

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i] + ": ");

            if (scanner.hasNextInt()) {
                answers[i] = scanner.nextInt();
            } else {
                scanner.nextLine(); // Consume the remaining newline character
                answers[i] = scanner.nextLine();
            }
        }

        float correct = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] instanceof String && answers[i].toString().equalsIgnoreCase(correctAnswers[i].toString()) || answers[i] == correctAnswers[i]) {
                correct += 1;
            }
        }

        System.out.println("You Scored: " + hundredth.format((correct / answers.length) * 100));
    }
}
