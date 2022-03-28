import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class PrimaPagina extends JFrame implements ActionListener {
    private JButton AdminPage;
    private JPanel panel1;
    private JButton ProfilePage;
    private JButton logInPageButton;

    public PrimaPagina() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel1);
        setSize(400, 420);
        AdminPage.addActionListener(this);
        ProfilePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton ProfilePage = (JButton) e.getSource();

                if (ProfilePage.getText().equals("Profile Page")) {
                    ProfilePage p = null;
                    try {
                        p = new ProfilePage();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    } catch (ResumeIncompleteException resumeIncompleteException) {
                        resumeIncompleteException.printStackTrace();
                    }
                    p.setVisible(true);

                }
            }
        });
        logInPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logInPageButton = (JButton) e.getSource();
                if (logInPageButton.getText().equals("Log in Page")) {
                    LogInPage p = null;
                    try {
                        p = new LogInPage();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (ResumeIncompleteException resumeIncompleteException) {
                        resumeIncompleteException.printStackTrace();
                    } catch (InvalidDatesException invalidDatesException) {
                        invalidDatesException.printStackTrace();
                    }
                    p.setVisible(true);
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        JButton AdminPage = (JButton) e.getSource();

        if (AdminPage.getText().equals("Admin Page")) {
            AdminPageGUI p = null;
            try {
                p = new AdminPageGUI();
            } catch (Exception exception) {
                exception.printStackTrace();
            } catch (ResumeIncompleteException resumeIncompleteException) {
                resumeIncompleteException.printStackTrace();
            }
            p.setVisible(true);

        }
    }
}
