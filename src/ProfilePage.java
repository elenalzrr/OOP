import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePage extends JFrame {
    private JTextField textField1;
    private JButton Cauta;
    private JPanel panel1;
    JFrame f;

    public ProfilePage() throws Exception, ResumeIncompleteException {
        super();
        f = new JFrame();
        FunctiiPtTestare test = new FunctiiPtTestare();
        test.CitireJoburi();
        test.citireConsumers();
        add(panel1);
        setSize(300, 100);
        Cauta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cauta = (JButton) e.getSource();


                if (Cauta.getText().equals("Cauta")) {
                    if (textField1.getText().equals("Daniel Edmund")) {
                        DanielEdmund it = null;
                        try {
                            it = new DanielEdmund();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        } catch (ResumeIncompleteException resumeIncompleteException) {
                            resumeIncompleteException.printStackTrace();
                        }
                        it.setVisible(true);
                    } else if (textField1.getText().equals("Julia Matvei")) {
                        JuliaMatvei it = null;
                        try {
                            it = new JuliaMatvei();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        } catch (ResumeIncompleteException resumeIncompleteException) {
                            resumeIncompleteException.printStackTrace();
                        }
                        it.setVisible(true);
                    } else if (textField1.getText().equals("Tamara Haci")) {
                        TamaraHaci it = null;
                        try {
                            it = new TamaraHaci();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        } catch (ResumeIncompleteException resumeIncompleteException) {
                            resumeIncompleteException.printStackTrace();
                        }
                        it.setVisible(true);
                    } else if (textField1.getText().equals("Linette Spartak")) {
                        LinetteSpartak it = null;
                        try {
                            it = new LinetteSpartak();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        } catch (ResumeIncompleteException resumeIncompleteException) {
                            resumeIncompleteException.printStackTrace();
                        }
                        it.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(f, "Eroare!Utilizatorul nu se afla la noi in sistem! Te rugam cauta un utilizator valid");
                    }

                }
            }
        });
    }
}
