import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Parser {
    //TODO: correct path
    private static final String filePath="C:\\Users\\UserName\\Documents\\Restaurant-DB\\data\\users.json";
    public static void main(String args[]){
        Map<String,YelpUser> userMap=new HashMap<>();
        try (Stream<String> stream= Files.lines(Paths.get(filePath))){
            stream.map(Parser::getYelpUser).forEach(yelpUser -> userMap.put(yelpUser.getUserID(),yelpUser));
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Num of user is "+userMap.size());
        System.out.println("Max num of review is "+userMap.entrySet().stream().mapToLong(value -> value.getValue().getNumReviews()).max().getAsLong());
        
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
