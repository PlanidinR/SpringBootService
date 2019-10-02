package springBootService.models;

import java.util.Objects;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class Responser<T> {
    private T result;
    private String message;
    public Responser() {
    }
    public Responser(T result, String message) {
        this.result = result;
        this.message = message;
    }
    public T getResult() {
        return result;
    }
    public String getMessage() {
        return message;
    }
    public void setResult(T result) {
        this.result = result;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responser<?> responser = (Responser<?>) o;
        return Objects.equals(getResult(), responser.getResult()) &&
                Objects.equals(getMessage(), responser.getMessage());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getResult(), getMessage());
    }
    @Override
    public String toString() {
        return "Responser{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
