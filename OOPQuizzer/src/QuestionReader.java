/**
 * This class reads the JSON File of questions and returns an ArrayList of them
 * @author Max Lewis
 */

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class QuestionReader {
    /**
     * This function takes in a file name entered by the user
     * and takes each part of the json file and stores it into an
     * arraylist of objects
     * @param fname file name entered by the user
     * @return am arraylist of questions if the file was of correct format
     * and the process was a success. If not, null is returned
     */
    public ArrayList<Question> readFromJSON(String fname){
        ArrayList<Question> questions = new ArrayList<Question>();
        try{
            FileReader reader = new FileReader(new File(fname));
            JSONParser parser = new JSONParser();
            JSONObject all = (JSONObject)parser.parse(reader);
            JSONArray arr = (JSONArray)all.get("questions");
            Iterator itr = arr.iterator();
            JSONObject questionObject;
            String question, a, b, c, d, answer;
            while (itr.hasNext()){
                questionObject = (JSONObject)itr.next();
                question = questionObject.get("question").toString();
                a = questionObject.get("a").toString().strip();
                b = questionObject.get("b").toString().strip();
                c = questionObject.get("c").toString().strip();
                d = questionObject.get("d").toString().strip();
                answer = questionObject.get("answer").toString().strip();
                questions.add(new Question(question, a, b, c, d, answer));
            }
            reader.close();
            return questions;
        }catch (Exception ex){
            return null;
        }
    }
}
