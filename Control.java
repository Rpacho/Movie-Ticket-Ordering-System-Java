import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control{
    //component
    View theView;
    sql mySql;
    int arraySize; 
    int index = 0;

    Control(View mView, sql mySql){
        this.mySql = mySql;
        theView = mView;
        // Listener
        theView.addPrevListener(new PrevListener());
        theView.addNextListener(new NextListener());
        theView.addSelectListener(new SelectListener());
        theView.addAllListening(new AllListener());
        theView.addKidListening(new KidListener());
        theView.addAdultListening(new AdultListener());
        theView.addSeniorListening(new SeniorListener());

        arraySize = mySql.array.size();
        display();
    }// end of Contractor


    void display(){

        // Condition for disabling buttons Next and Previous
        if(index == 0){
            theView.disablePrev(false);
        }else{
            theView.disablePrev(true);
        }
        if(index == arraySize-1){
            theView.disableNext(false);
        }else{
            theView.disableNext(true);
        }

        //Displaying Movie info
        theView.setMovieName(mySql.array.get(index).getName());
        theView.setMovieActor(mySql.array.get(index).getActor());
        theView.setMovieRating(mySql.array.get(index).getRating());
    }

    /**
     * The class below here is all for listener
     */
    class PrevListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try{
                index--;
                display();
            }catch(Exception ex){
                System.out.print(ex);
            }
        }
    }//end of PrevListener Class

    class NextListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            

            try{
                index++;
                display(); 
            }catch(Exception ex){
                System.out.print(ex);
            }
        }
    }//end of NextListener

    class SelectListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                theView.setMovieName("Testing Select button");
            }catch(Exception ex){
                System.out.print(ex);
            }
        }
    }//End of SelectListener

    class AllListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
            } catch (Exception ex) {
                System.out.print(ex);
            }
        }
    } // end of AllListener

    class KidListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
            } catch (Exception ex) {
                System.out.print(ex);
            }
        }
    } // enf of KidListener

    class AdultListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
            } catch (Exception ex) {
                System.out.print(ex);
            }
        }
    }// end of AdultListener

    class SeniorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
            } catch (Exception ex) {
                System.out.print(ex);
            }
        }
    }//end of SeniorListener





}