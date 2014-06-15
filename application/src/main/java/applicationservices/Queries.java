package applicationservices;


public interface Queries<T, U> {

    U query(T t);
}
