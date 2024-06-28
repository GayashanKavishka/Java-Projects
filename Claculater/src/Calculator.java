import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel,panel1;

    Font myfont = new Font("Ink Free",Font.BOLD,30);
    Font myfont1 = new Font("Ink Free",Font.BOLD,20);
    double num1 = 0,num2 = 0,result = 0;
    char operator;

    //ImageIcon icon = new ImageIcon("Calculator-icon.png");
    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Calculator-icon.png"));

    String subtext(String str,char op)
    {
        int index =str.length()-1 ;
        for(int i = str.length()-1;i>=0;i--)
        {
            if(str.charAt(i) == op)
            {
                 index = i;
                 break;
            }

        }
        String x = str.substring(index+1,str.length());
        return x;
    }

    Calculator()
    {



        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.setIconImage(icon.getImage());

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("CLear");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;


        for(int i = 0; i<6;i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusPainted(false);
        }
        for(int i = 6; i<9;i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont1);
            functionButtons[i].setFocusPainted(false);
        }


        for(int i = 0; i<10;i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusPainted(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout((new GridLayout(4,4,10,10)));
        panel.setBackground(Color.YELLOW);

        panel1 = new JPanel();
        panel1.setBounds(50,420,300,50);
        panel1.setLayout((new GridLayout(1,3,10,10)));
        panel1.setBackground(Color.YELLOW);


        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        panel1.add(negButton);
        panel1.add(delButton);
        panel1.add(clrButton);

        frame.add(panel);
//        frame.add(negButton);
//        frame.add(delButton);
//        frame.add(clrButton);
        frame.add(panel1);
        frame.add(textfield);
        frame.setVisible(true);

    }

    public static void main(String[] args)
    {
        Calculator calc = new Calculator();


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i<10;i++)
        {
            if(e.getSource() == numberButtons[i])
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==decButton)
        {
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==addButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText(textfield.getText().concat("+"));
        }

        if(e.getSource()==subButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText(textfield.getText().concat("-"));
        }
        if(e.getSource()==mulButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = 'x';
            textfield.setText(textfield.getText().concat("x"));
        }
        if(e.getSource()==divButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '÷';
            textfield.setText(textfield.getText().concat("÷"));
        }
        if(e.getSource()==equButton)
        {
            num2 = Double.parseDouble(this.subtext(textfield.getText(),operator));

            if(operator == '+')
            {
                result = num1+num2;
            }
            else if(operator == '-')
            {
                result = num1-num2;
            }
            else if(operator == 'x')
            {
                result = num1*num2;
            }
            else if(operator == '÷')
            {
                result = num1/num2;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;

        }
        if(e.getSource()==clrButton)
        {
            textfield.setText("");
        }
        if(e.getSource() == delButton)
        {
            String str = textfield.getText();
            str = str.substring(0,str.length()-1);
            textfield.setText(str);
        }
        if(e.getSource() == negButton)
        {
            double num = Double.parseDouble(textfield.getText());
            num*=-1;
            textfield.setText(String.valueOf(num));
        }



    }
}