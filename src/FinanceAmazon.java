import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FinanceAmazon extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JEditorPane editorPane1;
    private JTextField textField1;
    private JTextArea textArea1;

    public FinanceAmazon() throws Exception, ResumeIncompleteException {
        super();
        add(panel1);
        add(tabbedPane1);
        setSize(500, 800);
        FunctiiPtTestare test = new FunctiiPtTestare();
        test.CitireJoburi();
        test.citireConsumers();

        JSONParser parser = new JSONParser();
        Object object = null;
        try {
            object = parser.parse(new FileReader("consumers.json"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException es) {
            es.printStackTrace();
        }
        JSONObject obj = (JSONObject) object;
        JSONArray usera = (JSONArray) obj.get("employees");
        JSONObject obj1 = new JSONObject();
        JSONArray jrr = new JSONArray();
        int size;
        String nume = null;
        ArrayList<String> numex = new ArrayList<>();
        for (Object obj2 : usera) {
            JSONObject objj = (JSONObject) obj2;
            try {
                nume = extragerenume(objj);
            } catch (InvalidDatesException invalidDatesException) {
                invalidDatesException.printStackTrace();
            } catch (ResumeIncompleteException resumeIncompleteException) {
                resumeIncompleteException.printStackTrace();
            }
            size = usera.size();
            numex.add(nume);
            if (tabbedPane1.getTitleAt(0).equals(nume)) {
                int a = numex.indexOf("Jarred Egbert");
                editorPane1.setText(test.employeelist.get(a).toString());
            }


        }
    }


    public String extragerenume(JSONObject obj) throws InvalidDatesException, ResumeIncompleteException {
        String name = (String) obj.get("name");
        return name;
    }


}
