package InnerClasses;

public class OuterClass {

    int someOuterNumber;

    public void printSomeOuterNumber() {
        System.out.println(someOuterNumber);

        /*
        *  THIS TYPE OF CLASS IS ACCESSIBLE JUST INSIDE THE METHOD
        * */
        class InnerMethodClass {
            int someInnerMethodNumber;

            public void printSomeInnerMethodNumber() {
                System.out.println(someInnerMethodNumber);
            }
        }

        InnerMethodClass innerMethodClass = new InnerMethodClass();
        innerMethodClass.someInnerMethodNumber = 15;
        innerMethodClass.printSomeInnerMethodNumber();
    }

    /*
    * INNER CLASSES ARE GOOD WHEN THE INFORMATION MAKE SENSE TO STAY EXACTLY INSIDE ANOTHER CLASS
    * AND WE WON'T NEED TO ACCESS THE CLASS ANYWHERE
    * */
    public class InnerNonStaticClass {
        int someInnerNumber;

        public void printSomeInnerNumber() {
            System.out.println(someInnerNumber);
        }
    }

    public static class InnerStaticClass {
        int someInnerNumber;

        public void printSomeInnerNumber() {
            System.out.println(someInnerNumber);
        }
    }

}
