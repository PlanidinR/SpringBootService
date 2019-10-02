package springBootService.dto;


import java.util.Objects;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class UserDto {

    private String login;
    private String username;
    private String role;
    private String active;
    private String token;


    public UserDto(){

    }
    public UserDto(String login, String username, String role, String active, String token) {
        this.login = login;
        this.username = username;
        this.role = role;
        this.active = active;
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(getLogin(), userDto.getLogin()) &&
                Objects.equals(getUsername(), userDto.getUsername()) &&
                Objects.equals(getRole(), userDto.getRole()) &&
                Objects.equals(getActive(), userDto.getActive()) &&
                Objects.equals(getToken(), userDto.getToken());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getUsername(), getRole(), getActive(), getToken());
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", active='" + active + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
