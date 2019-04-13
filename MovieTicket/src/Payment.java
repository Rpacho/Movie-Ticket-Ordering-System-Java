import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Payment extends JDialog implements ActionListener {
    // public static void main(String[] args) {
    //     Payment payment = new Payment();
    // }
        JFrame frame2 = new JFrame();
        private JButton cancel, submit, ticket, receipt, refund;
        private JTextField cardNum, expMonth, expYear, cvNum;
        private JLabel choosePayment, paymentText, cardNumLabel, cardExpLabel, validationCard, validationExp, validationCv, gst, hst, total;
        private boolean cardValid = false;
        private boolean cardExp = false;
        private boolean cardCv = false;
        private Model model;
        private String venue, movieName, date, getTime, paymentTypeCard;
        private JComboBox paymentType;
        private String[] paymentCard = {"Debit Card", "Credit Card"};
        
    Payment(Model theModel, String movieName, String venue, String date, String hours){
        model = theModel;
        this.venue = venue;
        this.movieName = movieName;
        this.date = date;
        this.getTime = hours;
        //System.out.println("debugging purpose bebap be bap");
        createView();
        ticket.setEnabled(false);
        receipt.setEnabled(false);
        refund.setEnabled(false);

        frame2.setSize(500, 500);
		frame2.setLocationRelativeTo(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame2.setTitle("Payment");
		frame2.setResizable(false);
        frame2.setVisible(true);
    }
    //}

    public void createView(){
        JPanel panel = new JPanel();
		//panel.setBackground(Color.BLACK);
		panel.setLayout(null);
        frame2.getContentPane().add(panel);

        //JBox

        paymentType = new JComboBox<>(paymentCard);
        paymentType.setBounds(10,70,200,35);
        panel.add(paymentType);
        paymentType.addActionListener(this);

            //Buttons
        cancel = new JButton("Cancel");
		cancel.setBounds(345,400,80,35);
        panel.add(cancel);
        cancel.addActionListener(this);

        submit = new JButton("Submit");
        submit.setBounds(55,400,80,35);
        panel.add(submit);
        submit.addActionListener(this);

        ticket = new JButton("Ticket");
        ticket.setBounds(10,300,80,35);
        panel.add(ticket);
        ticket.addActionListener(this);

        receipt = new JButton("Receipt");
        receipt.setBounds(120,300,80,35);
        panel.add(receipt);
        receipt.addActionListener(this);

        refund = new JButton("Refund");
        refund.setBounds(200,300,80,35);
        panel.add(refund);
        refund.addActionListener(this);

        // Static
        paymentText = new JLabel("Pay Here!");
        paymentText.setBounds(10,20,150,35);
        panel.add(paymentText);

        choosePayment = new JLabel("Choose the type of Payment");
        choosePayment.setBounds(10,50,200,35);
        panel.add(choosePayment);

        cardNumLabel = new JLabel("Card number: ");
        cardNumLabel.setBounds(10,100,150,25);
        panel.add(cardNumLabel);
        
        gst = new JLabel("GST: $" + model.getTotalGST());
        gst.setBounds(10,200,150,25);
        panel.add(gst);
        
        hst = new JLabel("HST: $" + model.getTotalHST());
        hst.setBounds(10,225,150,25);
        panel.add(hst);
        
        total = new JLabel("Grand total of: $" + model.getTotalPrice2());
        total.setBounds(10,250,150,25);
        panel.add(total);

        cardExpLabel = new JLabel("Expiry date MM/YY: ");
        cardExpLabel.setBounds(10,135,150,25);
        panel.add(cardExpLabel);

        cardNumLabel = new JLabel("3 digit Number ");
        cardNumLabel.setBounds(10,170,150,25);
        panel.add(cardNumLabel);
        

        //Dynamic
        cardNum = new JTextField();
        cardNum.setBounds(160,100,150,25);
        panel.add(cardNum);

        expMonth = new JTextField();
        expMonth.setBounds(160,135,35,25);
        panel.add(expMonth);

        expYear = new JTextField();
        expYear.setBounds(190,135,35,25);
        panel.add(expYear);

        cvNum = new JTextField();
        cvNum.setBounds(160,170,50,25);
        panel.add(cvNum);

        validationCard = new JLabel();
        validationCard.setBounds(320,100,150,25);
        panel.add(validationCard);

        validationExp = new JLabel();
        validationExp.setBounds(235,135,150,25);
        panel.add(validationExp);

        validationCv = new JLabel();
        validationCv.setBounds(220,170,150,25);
        panel.add(validationCv);
    }

    public void proceed(){
        if((cardValid) && (cardExp) && (cardCv)){
            JOptionPane.showMessageDialog(this, "Payment Success!!\n Receipt and your tickets are now Available!");
            ticket.setEnabled(true);
            receipt.setEnabled(true);
            refund.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(this, "Payment Rejected Please try again");
            validationCard.setText("");
            validationExp.setText("");
            validationCv.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == cancel){
            frame2.dispose();
        }
        if(event.getSource() == ticket){
            JOptionPane.showMessageDialog(this, "Movie Ticket: \n" + "Title: " + movieName + "\nMovie venue: " + venue + 
                "\nYou got " + model.getTicketKid() + " ticket for kid\n"  
                + "You got " + model.getTicketAdult() + " ticket for Adult\n" + "You got " + model.getTicketSenior() + " ticket for Senior\n"
                + "Date: " + date + "\nTime: " + getTime);
        }
        if(event.getSource() == receipt){
            JOptionPane.showMessageDialog(this, "You purchase " + movieName + "\n" + "Payment type: " + paymentTypeCard + "\nKid ticket Qty: " + model.getTicketKid()
            + " price $" + model.getTotalKid() +"\n" + "Adult ticket Qty: " + model.getTicketAdult() + " price $" + model.getTotalAdult()
            + "\n" + "Senior ticket Qty: " + model.getTicketSenior() + " price $" + model.getTotalSenior() + "\n" + "Grand total of $" +
            model.getTotalPrice());
        }
        if(event.getSource() == refund){
            JOptionPane.showMessageDialog(this, "Please ask any of our representative for refund issues.");
        }

        if(event.getSource() == submit){
            //Card Number
            if((cardNum.getText().chars().allMatch(Character::isDigit)) && (!cardNum.getText().isEmpty()) &&(cardNum.getText().length() == 16) 
                ){
                    cardValid = true;
            }else{
                    validationCard.setText("<html><b><font color='red'>*Invalid Card Number</html></b></font>");
                    cardValid = false;
            }
            String month = expMonth.getText();
            String year = expYear.getText();

            if(model.getMonth() <= Integer.parseInt(month) && model.getYear() <= Integer.parseInt(year)){
                cardExp = true;
                //JOptionPane.showMessageDialog(this, "true");
            }else{
                validationExp.setText("<html><b><font color='red'>*Invalid Expiry Date</html></b></font>");
                cardExp = false;
            }
            if((cvNum.getText().chars().allMatch(Character::isDigit)) && (!cvNum.getText().isEmpty()) &&(cvNum.getText().length() == 3) 
                ){
                    cardCv = true;
            }else{
                    validationCv.setText("<html><b><font color='red'>*Invalid Card Number</html></b></font>");
                    cardCv = false;
            }
            proceed();
        }

        if(event.getSource() == paymentType){
            JComboBox cb = (JComboBox)event.getSource();
            String msg = (String) cb.getSelectedItem();

            switch (msg) {
                case "Debit Card": paymentTypeCard = "Debit card";
                    
                    break;
            
                case "Credit Card": paymentTypeCard = "Credit card";

                    break;
            }

        }
    }// end of event listener



}