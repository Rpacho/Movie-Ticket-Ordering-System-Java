public class MovieTicket{
    /**
     * 
     * @author Rolando Pacho & Quang Pham
     * 
     */


    public static void main(String[] args){
        View theView = new View();
        Control theController;
        sql mySql;
        mySql = new sql();
        theController = new Control(theView, mySql);
        theView.setVisible(true);
        //System.out.println(mySql.array.get(0).getName());
    }
}