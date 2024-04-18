package closer.models;

public class user {
    private String UserName;
    private String UserEmail;
    private String UserPassword;
    private int UserID;
    private String UserProfilePic;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserProfilePic() {
        return UserProfilePic;
    }

    public void setUserProfilePic(String userProfilePic) {
        UserProfilePic = userProfilePic;
    }

    public user(String userName, String userEmail, String userPassword, int userID, String userProfilePic) {
        UserName = userName;
        UserEmail = userEmail;
        UserPassword = userPassword;
        UserID = userID;
        UserProfilePic = userProfilePic;


    }
}
