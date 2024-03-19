package EqualsAndHashCode;

public class Main {

    public static void main(String[] args) {
        /*
        * TWO DIFFERENT CLASSES WITH SAME FIELDS AND VALUES PRODUCE THE SAME HASHCODE, BUT IT IS NOT EQUALS.
        * HERE, ALWAYS THE ELSE CODE WILL BE EXECUTED
        * */
        ClassWithEqualsAndHashCode classWithEqualsAndHashCode = new ClassWithEqualsAndHashCode("Ale", 23);
        SecondClassWithEqualsAndHashCode secondClassWithEqualsAndHashCode = new SecondClassWithEqualsAndHashCode("Ale", 23);

        if (classWithEqualsAndHashCode.equals(secondClassWithEqualsAndHashCode)) {
        } else {
            System.out.println(classWithEqualsAndHashCode.hashCode());
            System.out.println(secondClassWithEqualsAndHashCode.hashCode());
            System.out.println("We are not equal but with the same hashcodes");
        }

        /*
         * TWO CLASSES, DIFFERENT INSTANCES, WITH SAME FIELDS AND VALUES PRODUCE THE SAME HASHCODE AND IT IS EQUALS.
         * HERE, ALWAYS THE IF CODE WILL BE EXECUTED
         * */
        ClassWithEqualsAndHashCode classesEquals = new ClassWithEqualsAndHashCode("Ale", 23);
        ClassWithEqualsAndHashCode classesEqualsTwo = new ClassWithEqualsAndHashCode("Ale", 23);

        if (classesEquals.equals(classesEqualsTwo)) {
            System.out.println(classesEquals.hashCode());
            System.out.println(classesEqualsTwo.hashCode());
            System.out.println("We're equal and with the same hashcodes");
        }
    }
}
