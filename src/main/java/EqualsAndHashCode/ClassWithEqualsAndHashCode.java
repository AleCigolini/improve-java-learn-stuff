package EqualsAndHashCode;

import java.util.Objects;

public class ClassWithEqualsAndHashCode {

    private String name;
    private int age;

    public ClassWithEqualsAndHashCode(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassWithEqualsAndHashCode that = (ClassWithEqualsAndHashCode) o;
        return age == that.age && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
