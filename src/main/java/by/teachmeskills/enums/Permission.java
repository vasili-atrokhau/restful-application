package by.teachmeskills.enums;

// user:read
//user:read, write
public enum Permission {

    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}