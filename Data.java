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
            if(rating[0].equals("Kid")){
                str = "G. PG. PG-13.";
            }else{
                str = "R. NC17";
            }
        }
        return str;
    }
    public String getKid(){
        return rating[0];
    }
    public String getAdult(){
        return rating[1];
    }
    public String getSenior(){
        return rating[2];
    }



}//end of Data