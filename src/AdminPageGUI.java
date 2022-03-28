import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminPageGUI extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel panel2;
    private JPanel panel3;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JEditorPane editorPane1;
    private JList<String> Utilizatori = new JList<String>();
    ArrayList<String> useri;
    DefaultListModel userModel;

    public AdminPageGUI() throws Exception, ResumeIncompleteException {
        super();
        FunctiiPtTestare test = new FunctiiPtTestare();
        test.CitireJoburi();
        test.citireConsumers();
        add(panel1);
        add(tabbedPane1);

        button1.setText(test.user.get(0).resume.information.getNume() + " " + test.user.get(0).resume.information.getPrenume());
        button2.setText(test.user.get(1).resume.information.getNume() + " " + test.user.get(1).resume.information.getPrenume());
        button3.setText(test.user.get(2).resume.information.getNume() + " " + test.user.get(2).resume.information.getPrenume());
        button4.setText(test.user.get(3).resume.information.getNume() + " " + test.user.get(3).resume.information.getPrenume());
        button5.setText(test.joburii.get(0).getNume());
        button6.setText(test.joburii.get(1).getNume());
        setSize(500, 650);
        useri = new ArrayList<String>();
        userModel = new DefaultListModel<String>();
        Utilizatori.setModel(userModel);
        //add(panel2);
        button7.setText(test.joburii.get(0).departments.get(0).tip);
        button8.setText(test.joburii.get(0).departments.get(1).tip);
        button9.setText(test.joburii.get(0).departments.get(2).tip);
        button10.setText(test.joburii.get(0).departments.get(3).tip);
        button11.setText(test.joburii.get(1).departments.get(0).tip);
        button12.setText(test.joburii.get(1).departments.get(1).tip);
        button13.setText(test.joburii.get(1).departments.get(2).tip);
        button14.setText(test.joburii.get(1).departments.get(3).tip);
        //  JScrollPane scrollPane = new JScrollPane(editorPane1);
        editorPane1.setText(test.joburi.toString());
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(true);

            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel3.setVisible(true);
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ITGoogle it = null;
                try {
                    it = new ITGoogle();
                } catch (Exception exception) {
                    exception.printStackTrace();
                } catch (ResumeIncompleteException resumeIncompleteException) {
                    resumeIncompleteException.printStackTrace();
                }
                it.setVisible(true);
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagementGoogle mg = null;
                try {
                    mg = new ManagementGoogle();
                } catch (Exception exception) {
                    exception.printStackTrace();
                } catch (ResumeIncompleteException resumeIncompleteException) {
                    resumeIncompleteException.printStackTrace();
                }
                mg.setVisible(true);
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MarketingGoogle mg = null;
                try {
                    mg = new MarketingGoogle();
                } catch (Exception exception) {
                    exception.printStackTrace();
                } catch (ResumeIncompleteException resumeIncompleteException) {
                    resumeIncompleteException.printStackTrace();
                }
                mg.setVisible(true);
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinanceGoogle mg = null;
                try {
                    mg = new FinanceGoogle();
                } catch (Exception exception) {
                    exception.printStackTrace();
                } catch (ResumeIncompleteException resumeIncompleteException) {
                    resumeIncompleteException.printStackTrace();
                }
                mg.setVisible(true);
            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ITAmazon it = null;
                try {
                    it = new ITAmazon();
                } catch (Exception exception) {
                    exception.printStackTrace();
                } catch (ResumeIncompleteException resumeIncompleteException) {
                    resumeIncompleteException.printStackTrace();
                }
                it.setVisible(true);
            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagementAmazon mg = null;
                try {
                    mg = new ManagementAmazon();
                } catch (Exception exception) {
                    exception.printStackTrace();
                } catch (ResumeIncompleteException resumeIncompleteException) {
                    resumeIncompleteException.printStackTrace();
                }
                mg.setVisible(true);
            }
        });
        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MarketingAmazon mg = null;
                try {
                    mg = new MarketingAmazon();
                } catch (Exception exception) {
                    exception.printStackTrace();
                } catch (ResumeIncompleteException resumeIncompleteException) {
                    resumeIncompleteException.printStackTrace();
                }
                mg.setVisible(true);
            }
        });
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinanceAmazon mg = null;
                try {
                    mg = new FinanceAmazon();
                } catch (Exception exception) {
                    exception.printStackTrace();
                } catch (ResumeIncompleteException resumeIncompleteException) {
                    resumeIncompleteException.printStackTrace();
                }
                mg.setVisible(true);
            }
        });
    }

}
