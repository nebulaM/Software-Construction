import org.json.simple.JSONObject;

public class YelpUser {
    private String name;
    private String userID;
    private long numReviews;

    public YelpUser(String name, String userID, long numReviews){
        this.name=name;
        this.userID=userID;
        this.numReviews=numReviews;
    }

    public YelpUser(){

    }

    public void setData(JSONObject jsonObject){
        name=(String) jsonObject.get("name");
        userID = (String) jsonObject.get("user_id");
        numReviews = (Long) jsonObject.get("review_count");
    }

    public String getName(){
        return name;
    }
    public String getUserID(){
        return userID;
    }

    public long getNumReviews(){
        return numReviews;
    }

}
