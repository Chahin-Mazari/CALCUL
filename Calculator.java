import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.event.* ;
import java.awt.*  ;
public class Calculator implements ActionListener {
    
JFrame frame;
JTextField textField ; 
JButton [] opButtons = new JButton[8] ;
JButton [] numberButtons = new JButton[10] ;
JPanel panel ; 
double num1=0,num2=0,result=0;
char operator;
    public Calculator(){

        frame = new JFrame("Calculator : ") ; 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(420, 550);
        frame.setLayout(null); 


        textField=new JTextField("0") ; 
        textField.setBounds(55, 25, 280, 50);
        frame.add(textField) ;//ajouter textField au frame
        textField.setFont(new Font("Arial", Font.PLAIN, 20)); 
        textField.setEditable(false);

        opButtons[0]= new JButton("+") ;
        opButtons[1]= new JButton("-") ;
        opButtons[2]= new JButton("*") ;
        opButtons[3]= new JButton("/") ;
        opButtons[4]= new JButton("=") ;
        opButtons[5]= new JButton(".") ;
        opButtons[6]= new JButton("Delete") ;
        opButtons[7]= new JButton("Clear") ;

        for(int i =0 ; i<8; i++){
            opButtons[i].addActionListener(this);
            opButtons[i].setFont(new Font("Ink Free", Font.BOLD, 20));
            opButtons[i].setFocusable(false);

        }


opButtons[6].setBounds(50, 430, 145, 50);
opButtons[7].setBounds(205,430,145,50); 

frame.add(opButtons[6]) ; 
frame.add(opButtons[7]);



        for(int i=0;i<10;i++)
        {
            numberButtons[i]= new JButton(String.valueOf(9-i)) ; 
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Ink Free", Font.BOLD, 20));
            numberButtons[i].setFocusable(false);
            



        }


        panel=new JPanel(); 

        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBounds(55, 100, 280, 280);
        panel.setBackground(Color.BLACK);
        frame.add(panel) ; 

        frame.setVisible(true); 

        panel.add(numberButtons[2]) ;
        panel.add(numberButtons[1]) ;
        panel.add(numberButtons[0]) ;
        panel.add(opButtons[2]) ;

        panel.add(numberButtons[5]) ;
        panel.add(numberButtons[4]) ;
        panel.add(numberButtons[3]) ;
        panel.add(opButtons[3]) ;

        panel.add(numberButtons[8]) ;
        panel.add(numberButtons[7]) ;
        panel.add(numberButtons[6]) ;
        panel.add(opButtons[1]) ;
        panel.add(opButtons[0]) ;
        panel.add(numberButtons[9]);
        panel.add(opButtons[5]);
        panel.add(opButtons[4]);

      







    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                // Ajout du chiffre au champ de texte
                textField.setText(textField.getText().concat(String.valueOf(9 - i)));
            }
        }

        if (e.getSource() == opButtons[5]) {
            // Ajout  point decimal au champ de texte
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == opButtons[0]) {
            // Enreg de opérateur et du premier nombre
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == opButtons[1]) {
            // Enregistrement de l'opérateur et du premier nombre
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == opButtons[2]) {
            // Enregistrement de l'opérateur et du premier nombre
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == opButtons[3]) {
            // Enregistrement de l'opérateur et du premier nombre
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == opButtons[4]) {
            // Calcul et affichage du résultat
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == opButtons[7]) {
            // Effacement du champ de texte
            textField.setText("");
        }

        if (e.getSource() == opButtons[6]) {
            // Suppression du dernier caractère du champ de texte
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
    }









