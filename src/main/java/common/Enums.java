package common;

public enum Enums {
    Login("Login"),
    Register("Register"),
    BookTicketPage("BookTicketPage"),
    Logout("Logout"),
    MyTicket("ManageTicket"),
    ChangePassword("ChangePassword"),

    CurrentPassword("currentPassword"),
    NewPassword("newPassword"),
    ConfirmPassword("confirmPassword");
    private String Value;

    Enums(String Value) {
        this.Value = Value;
    }

    public String getValue() {
        return Value;
    }
}
