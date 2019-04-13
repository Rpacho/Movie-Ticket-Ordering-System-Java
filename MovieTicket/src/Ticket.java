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


public class Ticket extends javax.swing.JDialog implements ActionListener{
	private JFrame frame = new JFrame();
    private JButton cancel, plusKid, minusKid, plusAdult, minusAdult, plusSenior, minusSenior, firstHour, secondHour, thirdHour, payment;
    private View view;
    private Model model;
    private String getName, getActor, getRated, getTime, getPriceKid, getPriceAdult, getPriceSenior, day, dateOfTicket, getHours, getRating;
    JLabel movieName, movieActor, movieRated, showClock, showPriceKid, showPriceAdult, showPriceSenior,
            showQuantity, showKidQty, showAdultQty, showSeniorQty, showTotalPrice, priceSet;
    private JComboBox selectDays;
    private boolean triggerHour = false;

    
	

	Ticket(View theView, Model theModel){
        model = theModel;
        view = theView;
        //System.out.println("asdasd");     //FORDEBUG
        getName = "<html><h2><font color='red'>"+ view.movieName.getText() +"</html></h2></font>";
        getActor = "<html><h4>Cast by: <font color='blue'>"+ view.movieActor.getText() +"</html></h2></font>";
        getRated = "<html><h4>Rated by: <font color='blue'>" + view.movieRating.getText() + "</html></h2></font>";
        getTime = "<html><b>" + model.getClock() +"</b></html>";
        getPriceKid = "<html><b>Children (age 3-13):   <font color='red'>$"+ model.getPriceKid() + "</font></b></html>";
        getPriceAdult = "<html><b>Adult (ages 14 & up):     <font color='red'>$"+ model.getPriceAdult() + "</font></b></html>";
        getPriceSenior = "<html><b>Senior (ages 65+):       <font color='red'>$"+ model.getPriceSenior() + "</font></b></html>";
        day = "";
        dateOfTicket = model.getClock();
        getRating = model.getRated();



        createView();
        disableHours();

		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("Ticket");
		frame.setResizable(false);
		frame.setVisible(true);

    }	//end of Contractor
    
    public void disableHours(){
        if(model.getHours() > 1230){
            setEnableHour1(false);
        }else{
            setEnableHour1(true);
        }
        if(model.getHours() > 1700){
            setEnableHour2(false);
        }else{
            setEnableHour2(true);
        }
        if(model.getHours() > 2000){
            setEnableHour3(false);
        }else{
            setEnableHour3(true);
        }
    }





        
	private void createView(){
		JPanel panel = new JPanel();
		//panel.setBackground(Color.BLACK);
		panel.setLayout(null);
        frame.getContentPane().add(panel);
        
        // Combobox
        selectDays = new JComboBox<>(model.sevenDays);
        selectDays.setBounds(10,305,200,40);
        panel.add(selectDays);
        selectDays.addActionListener(this);
		
		///Buttons 
		
		//cancel
		cancel = new JButton("Cancel");
		cancel.setBounds(345,400,80,35);
        panel.add(cancel);
        cancel.addActionListener(this);
        //kid quantity
        plusKid = new JButton("+");
		plusKid.setBounds(250,150,20,20);
        panel.add(plusKid);
        plusKid.addActionListener(this);

        minusKid = new JButton("-");
		minusKid.setBounds(300,150,20,20);
        panel.add(minusKid);
        minusKid.addActionListener(this);

        //adult quantity
        plusAdult = new JButton("+");
		plusAdult.setBounds(250,180,20,20);
        panel.add(plusAdult);
        plusAdult.addActionListener(this);

        minusAdult = new JButton("-");
		minusAdult.setBounds(300,180,20,20);
        panel.add(minusAdult);
        minusAdult.addActionListener(this);

        //senior quantity
        plusSenior = new JButton("+");
		plusSenior.setBounds(250,210,20,20);
        panel.add(plusSenior);
        plusSenior.addActionListener(this);

        minusSenior = new JButton("-");
		minusSenior.setBounds(300,210,20,20);
        panel.add(minusSenior);
        minusSenior.addActionListener(this);

        //Hours
        firstHour = new JButton("12:30pm");
        firstHour.setBounds(220,300,80,40);
        panel.add(firstHour);
        firstHour.addActionListener(this);

        secondHour = new JButton("5:00pm");
        secondHour.setBounds(320,300,80,40);
        panel.add(secondHour);
        secondHour.addActionListener(this);

        thirdHour= new JButton("8:00pm");
        thirdHour.setBounds(420,300,80,40);
        panel.add(thirdHour);
        thirdHour.addActionListener(this);

        //payment

        payment = new JButton("Pay here");
        payment.setBounds(55,400,80,35);
        panel.add(payment);
        payment.addActionListener(this);


        //Static text label
        showQuantity = new JLabel("Quantity");
        showQuantity.setBounds(260,120,100,35);
        panel.add(showQuantity);
        
        priceSet = new JLabel("Grand Total of $");
        priceSet.setBounds(10,265,120,30);
        panel.add(priceSet);
        

        //Dynamic Text label
        movieName = new JLabel(getName);
        movieName.setBounds(10,20,150,35);
        panel.add(movieName);

        movieActor = new JLabel(getActor);
        movieActor.setBounds(10,60,300,35);
        panel.add(movieActor);

        movieRated = new JLabel(getRated);
        movieRated.setBounds(10,90,300,35);
        panel.add(movieRated);

        showClock = new JLabel(getTime);
        showClock.setBounds(350,20,150,35);
        panel.add(showClock);

        showPriceKid = new JLabel(getPriceKid);
        showPriceKid.setBounds(10,140,200,35);
        panel.add(showPriceKid);

        showPriceAdult = new JLabel(getPriceAdult);
        showPriceAdult.setBounds(10,170,200,35);
        panel.add(showPriceAdult);

        showPriceSenior = new JLabel(getPriceSenior);
        showPriceSenior.setBounds(10,200,200,35);
        panel.add(showPriceSenior);

        showTotalPrice = new JLabel("0.00");
        showTotalPrice.setBounds(120,265,70,30);
        panel.add(showTotalPrice);

        //Quantity
        showKidQty= new JLabel("0");
        showKidQty.setBounds(275,145,30,30);
        panel.add(showKidQty);

        showAdultQty= new JLabel("0");
        showAdultQty.setBounds(275,175,30,30);
        panel.add(showAdultQty);

        showSeniorQty= new JLabel("0");
        showSeniorQty.setBounds(275,205,30,30);
        panel.add(showSeniorQty);

		
    } //End of createview

    public void displayText(){
        //System.out.println(model.getDay() + " " + day);
        if((!model.getDay().equals(day)) && (triggerHour)){
            //System.out.println("true");
            setEnableHour1(true);
            setEnableHour2(true);
            setEnableHour3(true);
        }else{
            disableHours();
        }
        showTotalPrice.setText(model.getTotalPrice());
        showKidQty.setText(model.getTicketKid());
        showAdultQty.setText(model.getTicketAdult());
        showSeniorQty.setText(model.getTicketSenior());
    }

    //disabling hours
    public void setEnableHour1(boolean status){
        firstHour.setEnabled(status);
    }
    public void setEnableHour2(boolean status){
        secondHour.setEnabled(status);
    }
    public void setEnableHour3(boolean status){
        thirdHour.setEnabled(status);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == cancel){
            frame.dispose();
        }
        if(event.getSource() == plusKid){
            if(!getRating.equals("Kid")){
                JOptionPane.showMessageDialog(this, "Kid Ticket is restricted because of the rated R. NC-17");
            }else{
                model.setTicketKid(1);
                model.setTotalPrice();
                displayText();
            }
        }
        if(event.getSource() == minusKid){
            model.setTicketKid(-1);
            model.setTotalPrice();
            displayText();
        }
        if(event.getSource() == plusAdult){
            model.setTicketAdult(1);
            model.setTotalPrice();
            displayText();
        }
        if(event.getSource() == minusAdult){
            model.setTicketAdult(-1);
            model.setTotalPrice();
            displayText();
        }
        if(event.getSource() == plusSenior){
            model.setTicketSenior(1);
            model.setTotalPrice();
            displayText();
        }
        if(event.getSource() == minusSenior){
            model.setTicketSenior(-1);
            model.setTotalPrice();
            displayText();
        }
        if(event.getSource() == firstHour){
            getHours = firstHour.getText();
        }
        if(event.getSource() == secondHour){
            getHours = secondHour.getText();
        }
        if(event.getSource() == thirdHour){
            getHours = thirdHour.getText();
        }
        if(event.getSource() == payment){
            Payment payment;
            payment = new Payment(model, view.movieName.getText(), model.getVenue(), dateOfTicket, getHours);
        }
        if(event.getSource() == selectDays){
            triggerHour = true;
            JComboBox cb = (JComboBox)event.getSource();
            String msg = (String) cb.getSelectedItem();
            dateOfTicket = msg;
            String ssMsg = msg.substring(0,3);
            switch (ssMsg) {
                case "Mon": day = ssMsg;
                            displayText();
                    break;
                case "Tue": day = ssMsg;
                            displayText();
                    break;
                case "Wed": day = ssMsg;
                            displayText();
                    break;
                case "Thu": day = ssMsg;
                            displayText();
                    break;
                case "Fri": day = ssMsg;
                            displayText();
                    break;
                case "Sat": day = ssMsg;
                            displayText();
                    break;
                case "Sun": day = ssMsg;
                            displayText();
                    break;
            
            }
            
        }
    }// end of action perform
    

//System.out.println("debugging purpose bebap be bap");

}	// End of Class Ticket
