import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test2{
    public static void main(String[] args) {
        
    
    LocalDateTime clock = LocalDateTime.now();
    String clock3, clock4;
    //String[] str = new String[7];
    
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("YY");

    //LocalDateTime clock2 = LocalDateTime.parse("11:30", myFormatObj);
        clock3 = clock.format(myFormatObj);
        clock4 = clock.format(myFormatObj2);
        System.out.println(Integer.parseInt(clock3));
        System.out.println(Integer.parseInt(clock4));

    }



}