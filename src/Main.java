import java.util.Scanner; // Importing Scanner class for user input
import java.text.DecimalFormat; // Importing DecimalFormat class for formatting decimal numbers

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To The Quiz!");

        Scanner scanner = new Scanner(System.in); // Creating a new instance of Scanner for user input
        DecimalFormat hundredth = new DecimalFormat("#.00"); // Creating a DecimalFormat object for formatting

        // Array of questions
        Object[] questions = {
                "How Many States Are In The USA?",
                "How Many Seconds Are In A Minute?",
                "Who Was The First President Of The USA?"
        };

        // Array of correct answers
        Object[] correctAnswers = {
                50,
                60,
                "George Washington"
        };

        Object[] answers = new Object[questions.length]; // Array to store user answers

        // Loop through each question and get user input
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i] + ": ");

            // Check if user input is an integer
            if (scanner.hasNextInt()) {
                answers[i] = scanner.nextInt();
            } else {
                scanner.nextLine(); // Consume the remaining newline character
                answers[i] = scanner.nextLine();
            }
        }

        float correct = 0; // Counter for correct answers

        // Loop through user answers and compare with correct answers
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] instanceof String && answers[i].toString().equalsIgnoreCase(correctAnswers[i].toString()) || answers[i] == correctAnswers[i]) {
                correct += 1; // Increment correct counter if answer is correct
            }
        }

        // Calculate and display the score as a percent out of 100
        System.out.println("You Scored: " + hundredth.format((correct / answers.length) * 100));
    }
}
