public class Data{

    public int id;
    public String name;
    public String actor;
    public String[] rating;

    Data(int id, String name, String actor, String[] rating){
        this.id = id;
        this.name = name;
        this.actor = actor;
        this.rating = rating;
    }

    //GETTERS
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getActor(){
        return actor;
    }
    public String getRating(){
        String str = "";
        for(int i = 0; i < rating.length; i++){
            str = str + rating[i] + " ";
        }
        return str;
    }



}//end of Data