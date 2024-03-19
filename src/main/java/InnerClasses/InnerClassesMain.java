package InnerClasses;

public class InnerClassesMain {

    public static void main(String[] args) {

        OuterClass outerClass = new OuterClass();
        outerClass.someOuterNumber = 10;
        outerClass.printSomeOuterNumber();

        /* HOW WE CREATE AN INSTANCE OF A NON STATIC INNER CLASS
        * WE NEED AN INSTANCE OF OUTERCLASS
        * */
        OuterClass.InnerNonStaticClass innerNonStaticClass = outerClass.new InnerNonStaticClass();
        innerNonStaticClass.someInnerNumber = 20;
        innerNonStaticClass.printSomeInnerNumber();

        /* HOW WE CREATE AN INSTANCE OF A STATIC INNER CLASS
        * HERE DOES NOT NEED TO HAVE AN INSTANCE OF OUTERCLASS, WE CAN CALL DIRECTLY
        * */
        OuterClass.InnerStaticClass innerStaticClass = new OuterClass.InnerStaticClass();
        innerStaticClass.someInnerNumber = 30;
        innerStaticClass.printSomeInnerNumber();
    }
}
