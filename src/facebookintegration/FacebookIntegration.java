package facebookintegration;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;
import com.restfb.Version;
import com.restfb.types.Post;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Faceebook Integratation with Java using RestFB API 
 * External JAR Library: restfb-1.19.0.jar by Mark Allen [http://restfb.com/] 
 * AppName: NoobApp 
 * AppID: 236423726701316 
 * AppSecret: 3ef6d2080a6467f99cb67605b3035a89
 * ExtendedAccessToken:
 * CAADXBrAZCGwQBAKCF0G8PaQCeMuRW0nYjZCh1k7isS63kKEWK2C1kZAd6LZBjvk636NcOYaN06PvIqhqhiBgj0zfhG5ueXB5ZAr9xFgCtPZB7l1P1B4bqIyqrhYNjFhrxHwXvPqi5PLRCxZBRp8wSVzspQ87lyZBs5cNQp2pFPEGZCrK73kmGbno0JF0H3J16NcIZD
 * Expires: Wed Apr 27 04:15:39 BDT 2016 API Version: v2.5
 *
 * @author Minhazul Arefin Abtahi
 */

public class FacebookIntegration {

    static final String APP_ID = "236423726701316";
    static final String APP_SECRET = "3ef6d2080a6467f99cb67605b3035a89";
    static final String TEMP_ACCESS_TOKEN = "CAADXBrAZCGwQBAAgjokYrxHgKY0LFIGU87CziIgLcRc4BFCX1moqjRl2U4yJAREiwym2zVidUEZBYW7MDqyXB5ojMUHbjnZAi0odpGw9g8bA5lvE6Wyx5SB1EDvIpk9ANNT3wHDYlDwZC2dZA0rgZAIZBg0Kd3UzBuvEvBxoJxXcZB4MS9UdQ8fPuh7bV5jArvXyotqZBtW9zgQZDZD";
    static final String EXTENDED_ACCESS_TOKEN = "CAADXBrAZCGwQBAKCF0G8PaQCeMuRW0nYjZCh1k7isS63kKEWK2C1kZAd6LZBjvk636NcOYaN06PvIqhqhiBgj0zfhG5ueXB5ZAr9xFgCtPZB7l1P1B4bqIyqrhYNjFhrxHwXvPqi5PLRCxZBRp8wSVzspQ87lyZBs5cNQp2pFPEGZCrK73kmGbno0JF0H3J16NcIZD";

    public static void main(String[] args) {
        // Initializing facebookClient
        FacebookClient facebookClient = new DefaultFacebookClient(EXTENDED_ACCESS_TOKEN, Version.LATEST);

        // Getting extended access token
        AccessToken extendedAccessToken = facebookClient.obtainExtendedAccessToken(APP_ID, APP_SECRET);

        // Creating self user object
        User selfUser = facebookClient.fetchObject("me", User.class);

        // Printing self info
        System.out.println(selfUser.getName());
        //System.out.println(extendedAccessToken.getAccessToken());
        //System.out.println(extendedAccessToken.getExpires());

        // Getting self user's timeline posts
        Connection<Post> postResults = facebookClient.fetchConnection("me/feed", Post.class);

        // List of posts
        ArrayList<String> messageList = new ArrayList<String>();

        // Post counter
        int postCounter = 0;
        int postNo = 0;

        // Printing the posts and post ids
        for (List<Post> page : postResults) {
            for (Post post : page) {
                //System.out.println(++postNo);
                //System.out.println(post.getMessage());
                //System.out.println("fb.com/" + post.getId() + "\n")
                String message = post.getMessage();
                
                // Adding messages to the messageList
                messageList.add(message);
                //System.out.println(messageList.get(postNo));

                postCounter++;
            }
            if (postCounter >= 10) {
                System.out.println("\nNumber of Posts: " + postCounter);
                break;
            }
        }

        try {
            // File Path
            String filePath = "C:\\Users\\abtah\\Desktop\\TimeLinePost4.txt";
            
            FileUtil fileUtil = new FileUtil();
            
            System.out.println(messageList.size());
            
            // Writting to File
            fileUtil.writeToFile(filePath, messageList, true);
        } 
        catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println(ioException);
        }

        //System.out.println("Number of Posts: " + postCounter);
    }
}
