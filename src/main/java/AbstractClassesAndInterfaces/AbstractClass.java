package AbstractClassesAndInterfaces;

/*
* -- ABSTRACT CLASSES CANNOT HAVE AN INSTANCE LIKE new AbstractClass();
* -- THEY ARE USEFUL TO PROVIDE INHERITANCE, WHEN IN ANOTHER CLASS WE EXTENDS THIS CLASS;
* -- HERE WE CAN HAVE FIELDS, ABSTRACT METHODS, CONCRETE METHODS;
* */
public abstract class AbstractClass {
    int firstField;
    int secondField;

    public abstract void method();

    public void nonAbstractMethod() {
        System.out.println("Any action here common for all the classes");
    }
}
