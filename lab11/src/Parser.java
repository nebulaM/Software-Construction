import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Parser {
    //TODO: correct path
    private static final String filePath="C:\\Users\\\\Documents\\Restaurant-DB\\data\\users.json";
    public static void main(String args[]){
        Map<String,YelpUser> userMap=new HashMap<>();
        try (Stream<String> stream= Files.lines(Paths.get(filePath))){
            stream.map(Parser::getYelpUser).forEach(yelpUser -> userMap.put(yelpUser.getUserID(),yelpUser));
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Num of user is "+userMap.size());
        System.out.println("Max num of review is "+userMap.entrySet().stream().mapToLong(value -> value.getValue().getNumReviews()).max().getAsLong());

        int range=digit(userMap.size());
        List<Long> rangeList=new ArrayList<>(range);
        long startTime = System.nanoTime();

        for(int i=1;i<=range;i++) {
            final int power=i;
            rangeList.add(userMap.entrySet().stream().filter(value -> (value.getValue().getNumReviews() < Math.pow(10,power) && value.getValue().getNumReviews() >= Math.pow(10,power-1))).count());
        }
        System.out.println("User range Runtime: " + (System.nanoTime() - startTime) / 1000000 + "ms");


        System.out.println("User range classic Runtime: " + (System.nanoTime() - startTime) / 1000000 + "ms");


        for(int i=1;i<=range;i++) {
            System.out.println("Num of user in range "+(int)Math.pow(10,i-1)+"-"+(int)(Math.pow(10,i)-1)+" is "+rangeList.get(i-1));
        }
    }


    public static void findPositionInRange(long number,int range, List<Long> list){
        int x=1;
        while(x<=range) {
            int lower = (int) Math.pow(10, x-1);
            int upper = (int) Math.pow(10, x);
            if(number>=lower && number<upper){
                list.set(x,list.get(x)+1);
            }
            x++;
        }
    }

    public static int digit(int num){
        num=Math.abs(num);
        int digit=1;
        while(num>=10){
            num/=10;
            digit++;
        }
        return digit;
    }

    private static YelpUser getYelpUser(String jText){
        YelpUser yUser=new YelpUser();
        JSONParser parser=new JSONParser();
        try {
            yUser.setData((JSONObject)parser.parse(jText));
        }catch (ParseException e){
            e.printStackTrace();
        }
        return yUser;
    }
}
