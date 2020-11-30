/**
 * Class that contains the text, choices, and correct answer for each question
 */

public class Question {
    private String question;
    private String choices;
    private String answer;
    public String getQuestion(){
        return question;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public String getChoices(){
        return choices;
    }
    public void setChoices(String choices){
        this.choices = choices;
    }
    public String getAnswer(){
        return answer;
    }
    public void setAnswer(String Answer){
        this.answer = answer;
    }
    public Question() {
        question = "";
        choices = "";
        answer = "";
    }
    public Question(String question, String choices, String answer){
        setQuestion(question);
        setChoices(choices);
        setAnswer(answer);
    }
    @Override
    public String toString(){
        return String.format("%s\n%s\n%s", question, choices, answer);
    }
}
