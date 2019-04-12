import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class View extends JFrame{
	//private JFrame frame = new JFrame();
	private JLabel movieName, movieActor, movieRating, conTitle, conActor, conRating, conFilter, conFilter2, selectedFilter;
	private JButton rAll, rKid, rAdult, rSenior, previous, next, select;
	

	View(){
		createView();

		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Movie Ticket");
		setResizable(false);
		//setVisible(true);

	}	//end of Contractor

	//SETTERS
	void setMovieName(String name){
		movieName.setText(name);
	}
	void setMovieActor(String name){
		movieActor.setText(name);
	}
	void setMovieRating(String rating){
		movieRating.setText(rating);
	}
	void setSelectedFilter(String filter){
		selectedFilter.setText(filter);
	}

	//LISTENERS
	void addPrevListener(ActionListener listeningPrev){
		previous.addActionListener(listeningPrev);
	}
	void addNextListener(ActionListener listeningNext){
		next.addActionListener(listeningNext);
	}
	void addSelectListener(ActionListener listeningSelect){
		select.addActionListener(listeningSelect);
	}
	void addKidListening(ActionListener listeningKid){
		rKid.addActionListener(listeningKid);
	}
	void addAdultListening(ActionListener listeningAdult){
		rAdult.addActionListener(listeningAdult);
	}
	void addSeniorListening(ActionListener listeningSenior){
		rSenior.addActionListener(listeningSenior);
	}
	void addAllListening(ActionListener listeningAll){
		rAll.addActionListener(listeningAll);
	}

	//Function method
	
	// for disabling button
	void disableNext(boolean status){
		next.setEnabled(status);
	}
	void disablePrev(boolean status){
		previous.setEnabled(status);
	}





	private void createView(){
		JPanel panel = new JPanel();
		//panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		///Filter button 
		
		//ALL
		rAll = new JButton("All");
		rAll.setBounds(170,20,80,35);
		panel.add(rAll);
		//Kid
		rKid= new JButton("Kid");
		rKid.setBounds(250,20,80,35);
		panel.add(rKid);
		// Adult
		rAdult= new JButton("Adult");
		rAdult.setBounds(330,20,80,35);
		panel.add(rAdult);
		// Senior
		rSenior= new JButton("Senior");
		rSenior.setBounds(410,20,80,35);
		panel.add(rSenior);

		//Prev, Select, Next button
		previous = new JButton("Previous");
		previous.setBounds(80,400,80,35);
		panel.add(previous);

		select = new JButton("Select");
		select.setBounds(190,400,125,35);
		panel.add(select);

		next = new JButton("Next");
		next.setBounds(345,400,80,35);
		panel.add(next);

		//Set Text fields
		//Static text fields
		conTitle = new JLabel("<html><b><font color='red'>Movie: </b></font></html>");
		conTitle.setBounds(100,100,250,50);
		panel.add(conTitle);

		conActor = new JLabel("<html><b><font color='red'>Main Actor: </b></font></html>");
		conActor.setBounds(100,150,250,50);
		panel.add(conActor);

		conRating = new JLabel("<html><b><font color='red'>Rating: </b></font></html>");
		conRating.setBounds(100,200,250,50);
		panel.add(conRating);

		conFilter = new JLabel("<html><h2>Filter by rating: </html></h2>");
		conFilter.setBounds(10,20,200,40);
		panel.add(conFilter);

		conFilter2 = new JLabel("<html><b>Selected Filter: </html></b>");
		conFilter2.setBounds(10,50,200,40);
		panel.add(conFilter2);

		//Dynamic text fields

		movieName = new JLabel();
		movieName.setBounds(300,100,250,50);
		//movieName.setPreferredSize(new Dimension(200,30));
		panel.add(movieName);

		movieActor = new JLabel();
		movieActor.setBounds(300,150,250,50);
		panel.add(movieActor);

		movieRating = new JLabel();
		movieRating.setBounds(300,200,250,50);
		panel.add(movieRating);

		selectedFilter = new JLabel();
		selectedFilter.setBounds(120,50,200,40);
		panel.add(selectedFilter);



		//JTextField textField = new JTextField();
		//textField.setPreferredSize(new Dimension(200, 20));
		//panel.add(textField);

		
	} //End of create view
}	// End of Class View
