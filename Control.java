import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Control{
    //component
    Model model;
    View theView;
    sql mySql;
    int arraySize; 
    int index = 0;
    String filter;
    ArrayList<Data> filteredArray;



    Control(View mView, sql mySql, Model model){
        this.mySql = mySql;
        theView = mView;
        this.model = model;
        filter = model.getAll();
        filteredArray = new ArrayList<Data>(mySql.array);
        // Listener
        theView.addPrevListener(new PrevListener());
        theView.addNextListener(new NextListener());
        theView.addSelectListener(new SelectListener());
        theView.addAllListening(new AllListener());
        theView.addKidListening(new KidListener());
        theView.addAdultListening(new AdultListener());
        theView.addSeniorListening(new SeniorListener());

        
        display();
    }// end of Contractor


    void display(){
        arraySize = filteredArray.size();
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
        theView.setMovieName(filteredArray.get(index).getName());
        theView.setMovieActor(filteredArray.get(index).getActor());
        theView.setMovieRating(filteredArray.get(index).getRating());
        theView.setSelectedFilter(filter);
        //System.out.println(filteredArray.get(index).getRating());
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
                //System.out.println("Selectesd");
                Ticket ticket;
                ticket = new Ticket(theView);

                //ticket.setVisible(true);
                
                display();
            }catch(Exception ex){
                System.out.print(ex);
            }
        }
    }//End of SelectListener

    class AllListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                filter = model.getAll();
                filteredArray.clear();
                index = 0;
                filteredArray = new ArrayList<Data>(mySql.array);
                display();
            } catch (Exception ex) {
                System.out.print(ex);
            }
        }
    } // end of AllListener

    class KidListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                filter = model.getKid();
                filteredArray.clear();
                index = 0;
                for(int i = 0; i < mySql.array.size(); i++){
                    if(mySql.array.get(i).getKid().equals("Kid")){
                        filteredArray.add(mySql.array.get(i));
                    }
                }
                display();
            } catch (Exception ex) {
                System.out.print(ex);
            }
        }
    } // enf of KidListener

    class AdultListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                filter = model.getAdult();
                filteredArray.clear();
                index = 0;
                for(int i = 0; i < mySql.array.size(); i++){
                    if(mySql.array.get(i).getAdult().equals("Adult")){
                        filteredArray.add(mySql.array.get(i));
                    }
                }
                display();
            } catch (Exception ex) {
                System.out.print(ex);
            }
        }
    }// end of AdultListener

    class SeniorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                filter = model.getSenior();
                filteredArray.clear();
                index = 0;
                for(int i = 0; i < mySql.array.size(); i++){
                    if(mySql.array.get(i).getSenior().equals("Senior")){
                        filteredArray.add(mySql.array.get(i));
                    }
                }
                display();
            } catch (Exception ex) {
                System.out.print(ex);
            }
        }
    }//end of SeniorListener





}