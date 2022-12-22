package com.learn.demo.Service;

import java.util.Optional;

public interface PService<T> {
	Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
