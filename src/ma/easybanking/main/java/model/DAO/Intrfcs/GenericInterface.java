package ma.easybanking.main.java.model.DAO.Intrfcs;

import java.util.Optional;

public interface GenericInterface<T> {

    Optional<T> save(T item);

    Optional<T> update(T item);

    Optional<T> findById(T item);

    Boolean delete(T item);

}
