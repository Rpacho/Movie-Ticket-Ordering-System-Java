
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Model{
    LocalDateTime clock = LocalDateTime.now();
    LocalDateTime clock2 = LocalDateTime.now();
    
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
    DateTimeFormatter hoursFormat = DateTimeFormatter.ofPattern("HH:mm");
    DateTimeFormatter month = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter year = DateTimeFormatter.ofPattern("YY");

    DateTimeFormatter currentDay = DateTimeFormatter.ofPattern("E");
    private String kid, adult, senior, all, clockString, currentDayStr, str2, clockMM, clockYY;
    private double priceKid, priceAdult, priceSenior, totalPrice, totalKid, totalAdult, totalSenior;
    private int ticketKid, ticketAdult, ticketSenior = 0;
    final int SEVEN = 7;
    static String[] sevenDays = new String[7];
    private String venue, rated;


    //formatting number 
    //NumberFormat formatter = new DecimalFormat("#0.00");  

    


    Model(){
        kid = "<html><b><font color='blue'>Kid</b></font></html>";
        adult = "<html><b><font color='blue'>Adult</b></font></html>";
        senior = "<html><b><font color='blue'>Senior</b></font></html>";
        all = "<html><b><font color='blue'>All</b></font></html>";
        currentDayStr = clock2.format(currentDay);
        str2 = clock.format(hoursFormat);
        str2 = str2.substring(0,2) + str2.substring(3);
        clockMM = clock.format(month);
        clockYY = clock.format(year);
        totalPrice = 0;
        venue = "";

        if(currentDayStr.equals("Tue")){
            priceKid = 7.99;
            priceAdult = 10.99;
            priceSenior = 8.50;
        }else{
            priceKid = 10.99;
            priceAdult = 14.25;
            priceSenior = 11.50;
            //System.out.println("allday");
        }

        for(int i = 0; i < SEVEN; i++){
            sevenDays[i] = clock.plusDays(i).format(myFormatObj);
        }
    }

    // Setters
    public void setTicketKid(int ticket){
        ticketKid += ticket;
        if(ticketKid == -1)
            ticketKid = 0;

    }
    public void setTicketAdult(int ticket){
        ticketAdult += ticket;
        if(ticketAdult == -1)
            ticketAdult = 0;
    }
    public void setTicketSenior(int ticket){
        ticketSenior += ticket;
        if(ticketSenior == -1)
            ticketSenior = 0;

    }
    public void setRated(String i){
        rated = i;
    }

    public void setTotalPrice(){
        totalPrice = (priceKid*ticketKid) + (priceAdult*ticketAdult) + (priceSenior*ticketSenior);
    }
    public void setVenue(String i){
        venue = i;
    }



    // Getters

    //rated
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

    //time
    public String getClock(){
        clockString = clock.format(myFormatObj);
        return clockString;
    }

    //get price
    public double getPriceKid(){
        return priceKid;
    }
    public double getPriceAdult(){
        return priceAdult;
    }
    public double getPriceSenior(){
        return priceSenior;
    }

    //Ticket Quantity

    public String getTicketKid(){
        return Integer.toString(ticketKid);
    }
    public String getTicketAdult(){
        return Integer.toString(ticketAdult);
    }
    public String getTicketSenior(){
        return Integer.toString(ticketSenior);
    }

    //get Hours
    public int getHours(){
        return Integer.parseInt(str2);
    }

    // get days
    public String getDay(){
        return currentDayStr;
    }

    public int getMonth(){
        return Integer.parseInt(clockMM);
    }
    public int getYear(){
        return Integer.parseInt(clockYY);
    }

    public String getTotalPrice(){
        return Double.toString(totalPrice);
    }
    
    public double getTotalGST(){
        double totalGST = totalPrice * 0.05;
        return Math.round(totalGST);
    }
    public double getTotalHST(){
        double totalHST = totalPrice * 0.07;
        return Math.round(totalHST);
    }
    public double getTotalPrice2(){
        double total = totalPrice + getTotalGST() + getTotalHST();
        return Math.round(total);
    }

    public String getVenue(){
        return venue;
    }

    public double getTotalKid(){
        totalKid = ticketKid * priceKid;
        return totalKid;
    }
    public double getTotalAdult(){
        totalAdult = ticketAdult * priceAdult;
        return totalAdult;
    }
    public double getTotalSenior(){
        totalSenior = ticketSenior * priceSenior;
        return totalSenior;
    }
    
    public String getRated(){
        return rated;
    }





}