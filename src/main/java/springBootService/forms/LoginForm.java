package springBootService.forms;

import java.util.Objects;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class LoginForm {
    private String login;
    private String password;
    public LoginForm(){
    }
    public LoginForm(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginForm loginForm = (LoginForm) o;
        return Objects.equals(getLogin(), loginForm.getLogin()) &&
                Objects.equals(getPassword(), loginForm.getPassword());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword());
    }
    @Override
    public String toString() {
        return "LoginForm{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
