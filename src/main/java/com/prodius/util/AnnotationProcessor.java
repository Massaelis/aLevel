package com.prodius.util;

import com.prodius.anotations.Autowired;
import com.prodius.anotations.Singleton;
import com.prodius.repository.CarArrayRepository;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Predicate;

public class AnnotationProcessor {
    private static final HashMap<Class, Object> HASH_MAP = new HashMap<>();
    private static final Predicate<Constructor> HAS_ANNOTATION =
            constructor -> constructor.getDeclaredAnnotation(Autowired.class) != null;

    public void processAnnotation() {
        Reflections reflections = new Reflections("com.prodius");
        final Set<Class<?>> singletonClasses = reflections.getTypesAnnotatedWith(Singleton.class);
        singletonClasses.forEach(clas -> {
            if (check(clas)) {
                addServiceClas(clas);
            } else {
                addRepositoryClas(clas);
            }
        });
        System.out.println(HASH_MAP);
    }

    private boolean check(Class<?> clas) {
        return Arrays.stream(clas.getDeclaredConstructors())
                .anyMatch(HAS_ANNOTATION);
    }

    private void addRepositoryClas(Class<?> clas) {
        final Constructor<?> constructor = createConstructor(clas, 0);
        try {
            Object instance = constructor.newInstance();
            HASH_MAP.put(clas, instance);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    private void addServiceClas(Class<?> clas) {
        final Constructor<?> constructor = createConstructor(clas, 1);
        final Class<? extends CarArrayRepository> aClass =
                constructor.getDeclaredAnnotation(Autowired.class).CRUDRepository();
        CarArrayRepository repository = createRepository(aClass);
        try {
            Object instance = constructor.newInstance(repository);
            HASH_MAP.put(clas, instance);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    private CarArrayRepository createRepository(Class<? extends CarArrayRepository> aClass) {
        final Constructor<?> constructor = createConstructor(aClass, 0);
        try {
            return (CarArrayRepository) constructor.newInstance();
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    private Constructor<?> createConstructor(Class<?> clas, int parameterCount) {
        final Constructor<?>[] constructors = clas.getDeclaredConstructors();
        if (constructors.length == 0) {
            throw new IllegalStateException();
        }
        return Arrays.stream(constructors)
                .filter(constructor -> constructor.getParameterCount() == parameterCount)
                .peek(constructor -> constructor.setAccessible(true))
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }
}