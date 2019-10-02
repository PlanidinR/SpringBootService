package springBootService.models;

import java.util.Objects;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class Token {
    private Integer id;
    private String value;
    private Integer user_id;
    private User user;
    public Token (){}
    public Token( String value, Integer user_id) {
        this.value = value;
        this.user_id = user_id;
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
    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(getId(), token.getId()) &&
                Objects.equals(getValue(), token.getValue()) &&
                Objects.equals(getUser_id(), token.getUser_id()) &&
                Objects.equals(user, token.user);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue(), getUser_id(), user);
    }
    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", user_id=" + user_id +
                ", user=" + user +
                '}';
    }
}
