package com.prodius.anotations;

import com.prodius.repository.CarArrayRepository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.CONSTRUCTOR)
public @interface Autowired {
    Class<? extends CarArrayRepository> CRUDRepository();
}