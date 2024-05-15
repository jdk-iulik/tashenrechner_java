import javax.swing.*;
import java.awt.event.*;

public class rechner extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton equal;
    private JButton a1Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a4Button;
    private JButton a6Button;
    private JButton a5Button;
    private JButton a7Button;
    private JButton a9Button;
    private JButton a8Button;
    private JTextField textField1;
    private JButton a0Button;
    private JButton additionbutton;
    private JButton substractionButton;
    private JButton multiplicationButton;
    private JButton divisionButton;
    private JButton clear;

    private double input;
    private boolean isOperatorCliked;
    private char operator;

    public rechner() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            buttonCliked("1");

            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked("2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked("3");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked("4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked("5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked("6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked("7");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked("8");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked("9");
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked("0");
            }
        });
        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               input=Double.parseDouble(textField1.getText());
               operator='*';
               isOperatorCliked=true;
            }
        });
       divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input=Double.parseDouble(textField1.getText());
                operator='/';
                isOperatorCliked=true;
            }
        });
        additionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input=Double.parseDouble(textField1.getText());
                operator='+';
                isOperatorCliked=true;
            }
        });
        substractionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input=Double.parseDouble(textField1.getText());
                operator='-';
                isOperatorCliked=true;
            }
        });

        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double var;
                switch (operator){
                    case '+':
                        var=input+Double.parseDouble(textField1.getText());
                        textField1.setText(Double.toString(var));
                        break;
                    case '-':
                        var=input-Double.parseDouble(textField1.getText());
                        textField1.setText(Double.toString(var));
                        break;
                    case '*':
                        var=input*Double.parseDouble(textField1.getText());
                        textField1.setText(Double.toString(var));
                        break;
                    case '/':
                        var=input/Double.parseDouble(textField1.getText());
                        textField1.setText(Double.toString(var));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + operator);
                }
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input=0;
                isOperatorCliked=true;
                textField1.setText("");
            }
        });
    }

    private void buttonCliked(String input){
        if(isOperatorCliked){
            textField1.setText(input);
            isOperatorCliked=false;
        }else{
            textField1.setText(textField1.getText()+ input);
        }


    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        rechner dialog = new rechner();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
