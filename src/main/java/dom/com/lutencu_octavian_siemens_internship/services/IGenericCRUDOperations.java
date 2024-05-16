package dom.com.lutencu_octavian_siemens_internship.services;

public interface IGenericCRUDOperations<T> {

    T create(T t);
    T update(T t);
    void delete(T t);
    T findById(long id);
}
