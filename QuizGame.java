import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizGame {

    private static class Question {
        String question;
        String[] options;
        int correctOption;

        Question(String question, String[] options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    private List<Question> questions;
    private int score;

    public QuizGame() {
        questions = new ArrayList<>();
        score = 0;

        // Add questions to the quiz
        questions.add(new Question("What is the capital of France?", 
            new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3));
        questions.add(new Question("What is 2 + 2?", 
            new String[]{"1. 3", "2. 4", "3. 5", "4. 6"}, 2));
        // Add more questions here
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question q : questions) {
            System.out.println(q.question);
            for (String option : q.options) {
                System.out.println(option);
            }
            System.out.print("Choose an option (1-4): ");
            int userAnswer = scanner.nextInt();
            if (userAnswer == q.correctOption) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }
        System.out.println("Quiz over! Your score is: " + score);
        scanner.close();
    }

    public static void main(String[] args) {
        QuizGame game = new QuizGame();
        game.start();
    }
}
