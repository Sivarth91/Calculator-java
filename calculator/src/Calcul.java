import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calcul implements ActionListener {

    JFrame frame;
    JTextField textfield;

    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[9];

    JButton addButton,subButton,mulButton,divButton,decButton,equalsButton,delButton,CButton,negButton;
    JPanel panel;

    Font myFont = new Font("Roboto", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    /* constructor */
    Calcul() {
        frame = new JFrame("calculator_V1 win x64");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        /* functions buttons */
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalsButton = new JButton("=");
        delButton = new JButton("CE");
        CButton = new JButton("C");
        negButton = new JButton("(-)");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equalsButton;
        functionButton[6] = delButton;
        functionButton[7] = CButton;
        functionButton[8] = negButton;

        /* boucles */
        for (int i = 0; i < 9; i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
            functionButton[i].setBackground(Color.cyan);
        }

        for (int i = 0; i<10; i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
            numberButton[i].setBackground(Color.GRAY);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        CButton.setBounds(250, 430, 100, 50);

        /* panels buttons */
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.white);

        panel.add(numberButton[1] );
        panel.add(numberButton[2] );
        panel.add(numberButton[3] );
        panel.add(addButton);
        panel.add(numberButton[4] );
        panel.add(numberButton[5] );
        panel.add(numberButton[6] );
        panel.add(subButton);
        panel.add(numberButton[7] );
        panel.add(numberButton[8] );
        panel.add(numberButton[9] );
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0] );
        panel.add(equalsButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(CButton);
        frame.add(textfield);
        frame.setVisible(true);

        /* constructor's end */
    }
    /*  method */
    public void actionPerformed (ActionEvent e) {

        for (int i = 0; i<10; i++){
            if (e.getSource() == numberButton[i] ){
                textfield.setText(textfield.getText().concat(String.valueOf(i) ) );

            }
        }


        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat(".") );
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText() );
            operator = '+' ;
            textfield.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText() );
            textfield.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText() );
            operator = 'x';
            textfield.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }



        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(textfield.getText());

            /* operations */
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textfield.setText(String.valueOf(result));
            num1 = result;

            /* operations' end*/
        }

        if (e.getSource() == CButton) {
            textfield.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");


            for (int i = 0; i< string.length()-1; i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }

        if (e.getSource() == negButton) {
            double temps = Double.parseDouble(textfield.getText());
            temps *= -1;
            textfield.setText(String.valueOf(temps));
        }

        /* method's end*/
    }

    /* code's end, now run it ! */

}

