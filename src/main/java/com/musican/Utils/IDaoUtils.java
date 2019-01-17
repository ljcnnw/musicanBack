package com.musican.Utils;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoUtils<T>  {
    void insert(T entity);
}
