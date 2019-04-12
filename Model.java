public class Model{
    private String kid;
    private String adult;
    private String senior;
    private String all;

    Model(){
        kid = "<html><b><font color='blue'>Kid</b></font></html>";
        adult = "<html><b><font color='blue'>Adult</b></font></html>";
        senior = "<html><b><font color='blue'>Senior</b></font></html>";
        all = "<html><b><font color='blue'>All</b></font></html>";
    }


    // Getters
    public String getKid(){
        return kid;
    }
    public String getAdult(){
        return adult;
    }
    public String getSenior(){
        return senior;
    }
    public String getAll(){
        return all;
    }



}