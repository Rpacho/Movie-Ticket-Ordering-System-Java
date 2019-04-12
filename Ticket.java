import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ticket extends javax.swing.JDialog implements ActionListener{
	private JFrame frame = new JFrame();
    private JButton cancel;
    private View view;
    private String getName;
    private String getActor;
    JLabel movieName, movieActor, mLabelName, mLabelActor;
    
	

	Ticket(View theView){
        view = theView;
        //System.out.println("asdasd");     //FORDEBUG
        getName = "<html><h2><font color='red'>"+ view.movieName.getText() +"</html></h2></font>";
        getActor = "<html><h4>Cast by: <font color='blue'>"+ view.movieActor.getText() +"</html></h2></font>";
		createView();

		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("Ticket");
		frame.setResizable(false);
		frame.setVisible(true);

	}	//end of Contractor






	private void createView(){
		JPanel panel = new JPanel();
		//panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		///Buttons 
		
		//cancel
		cancel = new JButton("Cancel");
		cancel.setBounds(345,400,80,35);
        panel.add(cancel);
        cancel.addActionListener(this);
        

        //Static Text label
        movieName = new JLabel(getName);
        movieName.setBounds(10,20,150,35);
        panel.add(movieName);

        movieActor = new JLabel(getActor);
        movieActor.setBounds(10,60,300,35);
        panel.add(movieActor);







		
    } //End of createview

    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == cancel){
            frame.dispose();
        }
    }
    

//System.out.println("debugging purpose bebap be bap");

}	// End of Class Ticket
