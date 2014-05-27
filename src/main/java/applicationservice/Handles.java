package applicationservice;
/**
 * Created by agjendem on 27.05.2014.
 */
public interface Handles<T> {

    void handle(T t);
}
