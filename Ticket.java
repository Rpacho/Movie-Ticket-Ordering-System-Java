import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Ticket extends JFrame{
    

    Ticket(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);

        JButton cancel;

        cancel = new JButton("Cancel");
        panel.add(cancel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    //}

    // public static void createView2(){
        

    // }




}