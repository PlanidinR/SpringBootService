package springBootService.models;

import java.util.Objects;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class Token {
    private Integer id;
    private String value;
    private String user_login;
    private User user;
    public Token (){}
    public Token( String value, String user_login) {
        this.value = value;
        this.user_login = user_login;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getUser_login() {
        return user_login;
    }
    public void setUser_login(String user_login) {
        this.user_login= user_login;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(getId(), token.getId()) &&
                Objects.equals(getValue(), token.getValue()) &&
                Objects.equals(getUser_login(), token.getUser_login()) &&
                Objects.equals(user, token.user);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue(), getUser_login(), user);
    }
    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", user_id=" + user_login +
                ", user=" + user +
                '}';
    }
}
