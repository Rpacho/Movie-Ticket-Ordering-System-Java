import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class sql {
    //component
    public static ArrayList<Data> array = new ArrayList<Data>();
    // public static ArrayList<Data> array2 = new ArrayList<Data>();
    // public static ArrayList<Data> array3 = new ArrayList<Data>();
    // public static ArrayList<Data> array4 = new ArrayList<Data>();


    public Data data;


    sql(){
        queryData();
    }

    public void queryData(){

        Connection con = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //ResultSet resultKid = null;
        try {


            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con=DriverManager.getConnection(
"jdbc:mysql://deepblue.cs.camosun.bc.ca/ICS199Group06_dev","ICS199Group06_dev","Tempd06");  
        statement = con.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM MOVIE_TICKET;");
        //resultKid = statement.executeQuery("SELECT * FROM MOVIE_TICKET WHERE kid = 'Y';");
        writeResultSet(resultSet);
        //writeResultKid(resultKid);
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("ERROR desu!!");   
        }//end of try

        

    }//end of queryData

    //ALL
    public void writeResultSet(ResultSet resultSet)throws SQLException{
        while(resultSet.next()){
            int id = resultSet.getInt("movie_id");
            String name = resultSet.getString("movie_name");
            String venue = resultSet.getString("venue");
            String actor = resultSet.getString("actor");
            String kid = resultSet.getString("kid");
            String adult = resultSet.getString("adult");
            String senior = resultSet.getString("senior");

            String strKid = "";
            String strAdult = "";
            String strSenior = "";

            if(kid.equals("Y"))
                strKid = "Kid";
            if(adult.equals("Y"))
                strAdult = "Adult";
            if(senior.equals("Y"))
                strSenior = "Senior";
            //System.out.println(kid + adult + senior);
            String[] movieRating = {strKid, strAdult, strSenior};
            data = new Data(id, name, actor, movieRating, venue);
            array.add(data);
        }
    }//End of ALL

    // public void writeResultKid(ResultSet resultSet)throws SQLException{
    //     while(resultSet.next()){
    //         int id = resultSet.getInt("movie_id");
    //         String name = resultSet.getString("movie_name");
    //         String venue = resultSet.getString("venue");
    //         String actor = resultSet.getString("actor");
    //         String kid = resultSet.getString("kid");
    //         String adult = resultSet.getString("adult");
    //         String senior = resultSet.getString("senior");

    //         String strKid = "";
    //         String strAdult = "";
    //         String strSenior = "";

    //         if(kid.equals("Y"))
    //             strKid = "Kid";
    //         if(adult.equals("Y"))
    //             strAdult = "Adult";
    //         if(senior.equals("Y"))
    //             strSenior = "Senior";
    //         System.out.println(kid + adult + senior);
    //         String[] movieRating = {strKid, strAdult, strSenior};
    //         data2 = new Data(id, name, actor, movieRating);
    //         array2.add(data2);
    //     }
    // }


}//end of class