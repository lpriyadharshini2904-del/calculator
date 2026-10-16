import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
public class SimpleCalculator{
    public static void main(String args[]){
        JFrame frame=new JFrame("simple calc");
        frame.setSize(320,350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1=new JLabel("Number 1:");
        l1.setBounds(30,30,80,25);
        JTextField tf1=new JTextField();
        tf1.setBounds(120,30,150,25);

        JLabel l2=new JLabel("Number 2:");
        l2.setBounds(30,70,80,25);
        JTextField tf2=new JTextField();
        tf2.setBounds(120,70,150,25);


        JLabel resultLabel =new JLabel("Result:");
        resultLabel.setBounds(30,110,240,25);

        JButton bAdd=new JButton("+");
        bAdd.setBounds(30,160,50,40);

        JButton bSub=new JButton("-");
        bSub.setBounds(190,160,50,40);

        JButton bMul=new JButton("*");
        bMul.setBounds(150,160,50,40);
        
        JButton bDiv=new JButton("/");
        bDiv.setBounds(210,160,50,40);
        DecimalFormat df=new DecimalFormat("0.##");
        ActionListener listener=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    double num1=Double.parseDouble(tf1.getText());
                    double num2=Double.parseDouble(tf2.getText());
                    double res=0;

                       if(e.getSource()==bAdd)res=num1+num2;
                       else if(e.getSource()==bSub)res=num1-num2;
                       else if(e.getSource()==bMul)res=num1*num2;
                       else if(e.getSource()==bDiv)
                       {
                        if(num2==0){
                            resultLabel.setText("Result:cannot divide by 0");
                            return;}
                            res=num1/num2;}
                       resultLabel.setText("Result:"+df.format(res));

                       }catch(NumberFormatException ex){
                        resultLabel.setText("RSesult:Invalid input");
                       }
                }
            };
            bAdd.addActionListener(listener);
            bSub.addActionListener(listener);
            bMul.addActionListener(listener);
            bDiv.addActionListener(listener);
            frame.add(l1);
            frame.add(tf1);
            frame.add(l2);
            frame.add(tf2);
            frame.add(resultLabel);
            frame.add(bAdd);
            frame.add(bSub);
            frame.add(bMul);
            frame.add(bDiv);
            frame.setVisible(true);
        }
    }