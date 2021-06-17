package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClassDescription {

    final private Class<?> testClass;

    TestClassDescription(Class<?> testClass) {
        this.testClass = testClass;
    }

    @TestMethod
    public List<Method> listTestMethods() {
        List<Method> res;

        Method[] method = testClass.getDeclaredMethods();

        res = Arrays.stream(method)
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .filter(m -> m.getParameterCount() == 0)
            .filter(m -> m.getReturnType() == void.class)
            .filter(m -> m.isAnnotationPresent(TestMethod.class))
            .collect(Collectors.toList());

        return res;
    }
}
