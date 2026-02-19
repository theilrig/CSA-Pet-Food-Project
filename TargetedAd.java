public class TargetedAd {


    
    public static void main(String[] args) {

        DataCollector collector = new DataCollector();
        collector.setData("socialMediaPostsSmall.txt", "targetWords.txt");

        String targetedUsers = "";
        String post = collector.getNextPost();

        while (!post.equals("NONE")) {

            

            String targetWord = collector.getNextTargetWord();

            while (!targetWord.equals("NONE")) {

                targetedUsers = toEqual(post.toLowerCase(), targetWord.toLowerCase(), targetedUsers);

                targetWord = collector.getNextTargetWord();
            }

            post = collector.getNextPost();
        }

        String adMessage = "fed the wolve s";
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
