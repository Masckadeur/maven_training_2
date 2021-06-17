package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;

public class TestClassDescriptionLernejoTests {
    public static void main(String[] args) {
        Class<SomeLernejoTests> testclass = SomeLernejoTests.class;
        TestClassDescription test = new TestClassDescription(testclass);
        System.out.println(test.listTestMethods().toString());
    }
}
