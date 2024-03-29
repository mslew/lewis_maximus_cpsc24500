import java.util.ArrayList;

/**
 * Prints the questions and their correct answers to the screen
 * @author Max Lewis
 */
public class QuestionPrinter {
    /**
     * This simply prints only the question and answer for the arraylists of
     * all questions
     * @param questions array list of all the questions
     */
    public static void printQuestions(ArrayList<Question> questions){
        for (Question question : questions){
            System.out.print(question.getQuestion() + " Answer: ");
            System.out.print(question.getAnswer() + "\n\n");
        }
    }
}
