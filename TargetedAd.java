public class TargetedAd {

    public static void main(String[] args) {

        DataCollector collector = new DataCollector();
        collector.setData("socialMediaPosts.txt", "targetWords.txt");

        String targetedUsers =  "";
        String post  = collector.getNextPost();

        while (!post.equals("NONE")) {

            String username = post.substring(0, post.indexOf(" "));
            String lowerPost = post.toLowerCase();

            String targetWord = collector.getNextTargetWord();
//handlingg
            while (!targetWord.equals("NONE")) {

                if (lowerPost.indexOf(targetWord.toLowerCase()) != -1) {

                    if (!targetedUsers.contains(username)) {
                        targetedUsers += username + " ";
                    }
                }

                targetWord = collector.getNextTargetWord();
            }

            post = collector.getNextPost();
        }

        String advertisement = "feed ur wolf";
        collector.prepareAdvertisement("targetedAds.txt", targetedUsers.trim(), advertisement);

        System.out.println("Targeted ads created for: " +   targetedUsers.trim());
    }
}
