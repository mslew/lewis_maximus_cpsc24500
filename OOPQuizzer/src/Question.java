/**
 * Class that contains the text, choices, and correct answer for each question
 */

public class Question {
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;
    private String answer;
    public String getQuestion(){
        return question;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public String getA(){
        return a;
    }
    public void setA(String a){
        this.a = a;
    }
    public String getB(){
        return b;
    }
    public void setB(String b){
        this.b = b;
    }
    public String getC(){
        return c;
    }
    public void setC(String c){
        this.c = c;
    }
    public String getD(){
        return d;
    }
    public void setD(String d){
        this.d = d;
    }
    public String getAnswer(){
        return answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public Question() {
        question = "";
        a = "";
        b = "";
        c = "";
        d = "";
        answer = "";
    }
    public Question(String question, String a, String b, String c, String d, String answer){
        setQuestion(question);
        setA(a);
        setB(b);
        setC(c);
        setD(d);
        setAnswer(answer);
    }
    @Override
    public String toString(){
        return String.format("%s\na: %s\nb: %s\nc: %s\nd: %s\nAnswer: %s\n", question, a, b, c, d, answer);
    }
}
