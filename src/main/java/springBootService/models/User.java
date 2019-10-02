package springBootService.models;

import java.util.List;
import java.util.Objects;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class User {
    private Integer id;
    private String name;
    private String login;
    private String hashPassword;
    private String role;
    private String state;
    private List<Token> tokens;
    public User(){
    }
    public User(Integer id, String name, String login, String hashPassword, String role, String state) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.hashPassword = hashPassword;
        this.role = role;
        this.state = state;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getHashPassword() {
        return hashPassword;
    }
    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public List<Token> getTokens() {
        return tokens;
    }
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getHashPassword(), user.getHashPassword()) &&
                getRole() == user.getRole() &&
                getState() == user.getState() &&
                Objects.equals(getTokens(), user.getTokens());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLogin(), getHashPassword(), getRole(), getState(), getTokens());
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                ", role=" + role +
                ", state=" + state +
                ", tokens=" + tokens +
                '}';
    }
}

