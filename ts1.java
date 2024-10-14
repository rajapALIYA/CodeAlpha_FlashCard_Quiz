import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flashcard {
    String question;
    String answer;

    Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}

class FlashcardQuiz {
    private List<Flashcard> flashcards;
    private int score;

    FlashcardQuiz() {
        flashcards = new ArrayList<>();
        score = 0;
    }

    void addFlashcard(String question, String answer) {
        Flashcard flashcard = new Flashcard(question, answer);
        flashcards.add(flashcard);
    }

    void startQuiz() {
        System.out.println("Starting the quiz!");
        Scanner scanner = new Scanner(System.in);

        for (Flashcard card : flashcards) {
            System.out.println("Question: " + card.question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(card.answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + card.answer);
            }
        }

        System.out.println("Quiz finished! Your score: " + score + "/" + flashcards.size());
        scanner.close();
    }
}

public class FlashcardQuizApp {
    public static void main(String[] args) {
        FlashcardQuiz quiz = new FlashcardQuiz();

        // Example flashcards
        quiz.addFlashcard("What is the capital of France?", "Paris");
        quiz.addFlashcard("What is 2 + 2?", "4");
        quiz.addFlashcard("What is the color of the sky?", "blue");

        // Start the quiz
        quiz.startQuiz();
    }
}
