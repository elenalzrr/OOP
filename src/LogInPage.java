import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LogInPage extends JFrame {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton autentificareButton;

    public LogInPage() throws FileNotFoundException, ResumeIncompleteException, InvalidDatesException {
        super();
        add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        autentificareButton.addActionListener(new ActionListener() {
                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      autentificareButton = (JButton) e.getSource();
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
                                                      JSONArray employees = (JSONArray) obj.get("employees");
                                                      JSONArray recruiters = (JSONArray) obj.get("recruiters");
                                                      JSONArray managers = (JSONArray) obj.get("managers");
                                                      JSONArray usera = (JSONArray) obj.get("users");
                                                      JSONObject obj1 = new JSONObject();
                                                      JSONArray jrr = new JSONArray();
                                                      String date = null;
                                                      String nr = null;
                                                      for (Object obj2 : employees) {
                                                          JSONObject objj = (JSONObject) obj2;
                                                          int size = jrr.size();
                                                          try {
                                                              date = extragereEmail(objj);
                                                          } catch (InvalidDatesException invalidDatesException) {
                                                              invalidDatesException.printStackTrace();
                                                          } catch (ResumeIncompleteException resumeIncompleteException) {
                                                              resumeIncompleteException.printStackTrace();
                                                          }
                                                          try {
                                                              nr = extragereNr(objj);
                                                          } catch (InvalidDatesException invalidDatesException) {
                                                              invalidDatesException.printStackTrace();
                                                          } catch (ResumeIncompleteException resumeIncompleteException) {
                                                              resumeIncompleteException.printStackTrace();
                                                          }
                                                          obj1.put("Username", textField1.getText());
                                                          obj1.put("Password", passwordField1.getText());
                                                          if (textField1.getText().equals(date) && passwordField1.getText().equals(nr)) {
                                                              JOptionPane.showMessageDialog(null, "Te-ai autentificat drept un employee!");
                                                              return;
                                                          }

                                                          if (!textField1.getText().contains(date) && !passwordField1.getText().contains(nr)) {
                                                              JOptionPane.showMessageDialog(null, "Incorrect User/Password!");
                                                              return;
                                                          }

                                                      }
                                                      for (Object obj2 : managers) {
                                                          JSONObject objj = (JSONObject) obj2;
                                                          int size = jrr.size();
                                                          try {
                                                              date = extragereEmail(objj);
                                                          } catch (InvalidDatesException invalidDatesException) {
                                                              invalidDatesException.printStackTrace();
                                                          } catch (ResumeIncompleteException resumeIncompleteException) {
                                                              resumeIncompleteException.printStackTrace();
                                                          }
                                                          try {
                                                              nr = extragereNr(objj);
                                                          } catch (InvalidDatesException invalidDatesException) {
                                                              invalidDatesException.printStackTrace();
                                                          } catch (ResumeIncompleteException resumeIncompleteException) {
                                                              resumeIncompleteException.printStackTrace();
                                                          }
                                                          obj1.put("Username", textField1.getText());
                                                          obj1.put("Password", passwordField1.getText());
                                                          if (textField1.getText().equals(date) && passwordField1.getText().equals(nr)) {
                                                              JOptionPane.showMessageDialog(null, "Te-ai autentificat drept un manager!");
                                                              return;
                                                          }

                                                          if (!textField1.getText().contains(date) && !passwordField1.getText().contains(nr)) {
                                                              JOptionPane.showMessageDialog(null, "Incorrect User/Password!");
                                                              return;
                                                          }

                                                      }
                                                      for (Object obj2 : recruiters) {
                                                          JSONObject objj = (JSONObject) obj2;
                                                          int size = jrr.size();
                                                          try {
                                                              date = extragereEmail(objj);
                                                          } catch (InvalidDatesException invalidDatesException) {
                                                              invalidDatesException.printStackTrace();
                                                          } catch (ResumeIncompleteException resumeIncompleteException) {
                                                              resumeIncompleteException.printStackTrace();
                                                          }
                                                          try {
                                                              nr = extragereNr(objj);
                                                          } catch (InvalidDatesException invalidDatesException) {
                                                              invalidDatesException.printStackTrace();
                                                          } catch (ResumeIncompleteException resumeIncompleteException) {
                                                              resumeIncompleteException.printStackTrace();
                                                          }
                                                          obj1.put("Username", textField1.getText());
                                                          obj1.put("Password", passwordField1.getText());
                                                          if (textField1.getText().equals(date) && passwordField1.getText().equals(nr)) {
                                                              JOptionPane.showMessageDialog(null, "Te-ai autentificat drept un recruiter!");
                                                              return;
                                                          }

                                                          if (!textField1.getText().contains(date) && !passwordField1.getText().contains(nr)) {
                                                              JOptionPane.showMessageDialog(null, "Incorrect User/Password!");
                                                              return;
                                                          }

                                                      }
                                                      for (Object obj2 : usera) {
                                                          JSONObject objj = (JSONObject) obj2;
                                                          int size = jrr.size();
                                                          try {
                                                              date = extragereEmail(objj);
                                                          } catch (InvalidDatesException invalidDatesException) {
                                                              invalidDatesException.printStackTrace();
                                                          } catch (ResumeIncompleteException resumeIncompleteException) {
                                                              resumeIncompleteException.printStackTrace();
                                                          }
                                                          try {
                                                              nr = extragereNr(objj);
                                                          } catch (InvalidDatesException invalidDatesException) {
                                                              invalidDatesException.printStackTrace();
                                                          } catch (ResumeIncompleteException resumeIncompleteException) {
                                                              resumeIncompleteException.printStackTrace();
                                                          }
                                                          obj1.put("Username", textField1.getText());
                                                          obj1.put("Password", passwordField1.getText());
                                                          if (textField1.getText().equals(date) && passwordField1.getText().equals(nr)) {
                                                              JOptionPane.showMessageDialog(null, "Te-ai autentificat drept un utilizator!");
                                                              return;
                                                          }

                                                          if (!textField1.getText().contains(date) && !passwordField1.getText().contains(nr)) {
                                                              JOptionPane.showMessageDialog(null, "Incorrect User/Password!");
                                                              return;
                                                          }

                                                      }

                                                  }

                                              }
        );
    }

    public String extragereEmail(JSONObject obj) throws InvalidDatesException, ResumeIncompleteException {
        String Email = (String) obj.get("email");
        //    System.out.println(Email);

        return Email;
    }

    public String extragereNr(JSONObject obj) throws InvalidDatesException, ResumeIncompleteException {
        String phoneNumber = (String) obj.get("phone");
        return phoneNumber;
    }
}
