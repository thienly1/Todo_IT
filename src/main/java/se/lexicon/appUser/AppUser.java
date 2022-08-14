package se.lexicon.appUser;

public class AppUser {
    private String useName;  // not allowed to be null or empty
    private String password; // not allowed to be null or empty
    private AppRole role; // not allowed to be null

    public AppUser(String useName, String password, AppRole role) {
        this.useName = useName;
        this.password = password;
        this.role = role;
        setUseName(useName);
        setPassword(password);
        setRole(role);
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        if(useName == null || useName == "") throw  new IllegalArgumentException("useName is not allowed to be null or empty");
        this.useName = useName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password ==null || password =="") throw new IllegalArgumentException("passWord is not allowed to be null or empty");
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if(role == null) throw new IllegalArgumentException("role is not allowed to be null");
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "useName='" + useName + '\'' +
                ", role=" + role +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return getUseName().equals(appUser.getUseName()) && getPassword().equals(appUser.getPassword());
    }
}
