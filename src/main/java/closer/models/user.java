package closer.models;

public class user {
    private String UserName;
    private String UserEmail;
    private String UserPassword;
    private int UserID;
    private String UserProfilePic;

    public user(String userName, String userEmail, String userPassword, int userID, String userProfilePic) {
        UserName = userName;
        UserEmail = userEmail;
        UserPassword = userPassword;
        UserID = userID;
        UserProfilePic = userProfilePic;
    }
}
