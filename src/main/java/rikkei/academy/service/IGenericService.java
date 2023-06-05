package rikkei.academy.service;

import java.util.Optional;

public interface IGenericService <T>{
    Iterable<T> findALl();
    //Optional --> là kiểu bọc đối tượng, khi xảy ra trường hợp null thì ko bắn ngoại lệ
    Optional<T> findById(Long id);
    void save(T t);
    void deleteById(Long id);
}
