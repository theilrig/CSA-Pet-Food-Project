public class TargetedAd {

    public static void main(String[] args) {

        DataCollector collector = new DataCollector();
        //uses big file in final verison, takes anyhting wolf or dog related 
        collector.setData("socialMediaPosts.txt", "targetWords.txt"); // Gets the key words and phrases realting to wolf 

        
        String targetedUsers = ""; // Empty String - Used for the Targeted People in it 
        String post = collector.getNextPost(); // Gets the posrt  

        while (!post.equals("NONE")) {

            

            String targetWord = collector.getNextTargetWord();
//iteraiton in requirement 2 part 1
            while (!targetWord.equals("NONE")) {

                targetedUsers = toEqual(post.toLowerCase(), targetWord.toLowerCase(), targetedUsers);

                targetWord = collector.getNextTargetWord();
            }

            post = collector.getNextPost();
        }

        String adMessage = "feed the wolves - even the puppies that could be wolves, by coming to us!!";
        //file generation in requirement 2 part 2 
        collector.prepareAdvertisement("targetedAds.txt", targetedUsers.trim(), adMessage);

        System.out.println("Targeted ads created for: " + targetedUsers.trim());
    }

    public static String addName(String currentList, String newName) {
        if (!currentList.contains(newName)) {
            return currentList + newName + " ";
        }
        return currentList;
    }

    public static String toEqual(String post, String targetWord, String list) {
        if (post.indexOf(targetWord) != -1) {
            list = addName(list, getId(post));
        }
        return list;
    }

    

    public static String getId(String post) {
        return post.substring(0, post.indexOf(" "));
    }
}
