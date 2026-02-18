import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class DataCollector {

    private ArrayList<String> socialMediaPosts;
    private ArrayList<String> targetWords;
    private Scanner sc;
    private int currentPost;
    private int currentTargetWord;

    public DataCollector() { 
      
        socialMediaPosts = new ArrayList<String>();
        targetWords = new ArrayList<String>();
        currentPost = 0;
        currentTargetWord = 0;
    }
  
    public void setData(String socialMediaPostsFilename, String targetWordsFilename) {

          try {
            sc = new Scanner(new File(socialMediaPostsFilename));
            
            while (sc.hasNextLine()) {
                String temp = sc.nextLine().trim();
                socialMediaPosts.add(temp);
            }
        } catch (Exception e) {
            System.out.println("Error reading posts file.");
        }

        try {
            sc = new Scanner(new File(targetWordsFilename));
            while (sc.hasNextLine()) {
                targetWords.add(sc.nextLine().trim());
            }
        } catch (Exception e) {
            System.out.println("Error reading target words file.");
        }
    }

    public String getNextPost() {
        if (currentPost < socialMediaPosts.size()) {
            currentPost++;
            return socialMediaPosts.get(currentPost - 1);
        } else {
            return "NONE";
        }
    }

    public String getNextTargetWord() {
        if (currentTargetWord < targetWords.size()) {
            currentTargetWord++;
            return targetWords.get(currentTargetWord - 1);
        } else {
            currentTargetWord = 0;
          // inc aps cuz its in other file
            return "NONE";
        }
    }

    public void prepareAdvertisement(String filename, String usernames, String advertisement) {

        try {
            FileWriter fw = new FileWriter(filename);

            for (String username : usernames.split(" ")) {
                fw.write("@" + username + " " + advertisement + " \n");
            }

            fw.close();
        } catch (IOException e) {
            System.out.println("Couldnnt writefile.");
        }
    }

    public void printAllPosts() {
        for (String post : socialMediaPosts) {
            System.out.println(post);
        }
    }

    public void printAllTargetWords() {
        for (String word : targetWords) {
            System.out.println(word);
        }
    }
}
