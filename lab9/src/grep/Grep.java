package grep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** Search web pages for lines matching a pattern. */
public class Grep {
    public static void main(String[] args) throws Exception {
        
        // substring to search for
        String substring = "CPEN 221";
        
        // URLs to search
        String[] urls = new String[] {
                "http://cpen221.ece.ubc.ca/about/",
                "https://github.com/CPEN-221/lab2",
                "https://github.com/CPEN-221/mp3-f16",
        };
        
        // list for accumulating matching lines
        List<Text> matches = Collections.synchronizedList(new ArrayList<Text>());
        
        // queue for sending lines from producers to consumers
        BlockingQueue<Line> queue = new LinkedBlockingQueue<Line>();

        Thread[] producers = new Thread[urls.length]; // one producer per URL
        Thread[] consumers = new Thread[50];
        
        for (int ii = 0; ii < consumers.length; ii++) { // start Consumers
            Thread consumer = consumers[ii] = new Thread(new Consumer(substring,matches,queue));
            consumer.start();
        }
        
        for (int ii = 0; ii < urls.length; ii++) { // start Producers
            Thread producer = producers[ii] = new Thread(new Producer(urls[ii],queue));
            producer.start();
        }
        
        for (Thread producer : producers) { // wait for Producers to stop
            producer.join();
        }
        
        // stop Consumers
        queue.add(new Text("terminate", 0, "-1-1-1STOP"));

        for (Thread consumer : consumers) { // wait for Consumers to stop
            consumer.join();
        }
        
        for (Text match : matches) {
            System.out.println(match);
        }
        System.out.println(matches.size() + " lines matched");
    }
}

class Producer implements Runnable {

    private final String mLink;
    private final BlockingQueue<Line> mQueue;

    Producer(String url, BlockingQueue<Line> queue) {
        mLink=url;
        mQueue=queue;
    }

    public void run() {
        try {
            URL mURL=new URL(mLink);
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(mURL.openStream()));
                String line;
                int lineNum=1;
                while ((line = in.readLine()) != null) {
                    try{mQueue.put(new Text(mLink,lineNum++,line));}catch (InterruptedException ire){
                        System.out.println("InterruptedException" + ire.getMessage());
                    }
                }

            }catch (IOException ioe){
                System.out.println("IOException " + ioe.getMessage());
            }
        }catch (MalformedURLException mfe){
            System.out.println("MalformedURLException " + mfe.getMessage());
        }
    }
    
}

class Consumer implements Runnable {

    private final String mKeyword;
    private final List<Text> mMatches;
    private final BlockingQueue<Line> mQueue;
    private final int mConsumerId;
    static private int countConsumerId=1;

    Consumer(String keyword, List<Text> matches, BlockingQueue<Line> queue) {
        mKeyword=keyword;
        mMatches=matches;
        mQueue=queue;
        mConsumerId=countConsumerId++;
    }

    public void run() {
        while (true){
            try{
                Line line = mQueue.take();
                if(line.text().equals("-1-1-1STOP")){
                    try{mQueue.put(line);}catch (InterruptedException ire){
                        System.out.println("InterruptedException" + ire.getMessage());
                    }
                    break;
                }else{
                    if(line.text().contains(mKeyword)){
                        mMatches.add(new Text(line.filename(),line.lineNumber(),line.text()));
                        System.out.println("Thread ID " + mConsumerId + " finds line : " + line);
                    }
                }
            }catch (InterruptedException ire){
                System.out.println("InterruptedException" + ire.getMessage());
            }
        }
    }
    
    
}

interface Line {
    /** @return the filename. */
    public String filename();
    /** @return the line number. */
    public int lineNumber();
    /** @return the text on the line. */
    public String text();
}

class Text implements Line {
    private final String filename;
    private final int lineNumber;
    private final String text;
    
    public Text(String filename, int lineNumber, String text) {
        this.filename = filename;
        this.lineNumber = lineNumber;
        this.text = text;
    }
    
    public String filename() {
        return filename;
    }
    
    public int lineNumber() {
        return lineNumber;
    }
    
    public String text() {
        return text;
    }
    
    @Override public String toString() {
        return filename + ":" + lineNumber + ":" + text;
    }
}
