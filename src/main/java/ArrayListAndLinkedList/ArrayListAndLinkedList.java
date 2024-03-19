package ArrayListAndLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListAndLinkedList {

    public static void main(String[] args) {
        /*
        * LINKEDLIST:
        *
        * -- LINK EACH ITEM WITH YOUR NEXT AND PREVIOUS ITEM (IT'S CALLED NODES);
        * -- OPERATION OF "ADD" AND "REMOVE" ARE FASTER THAN ARRAYLIST;
        * -- OPERATION OF "READ"/"GET" SPECIFIC ITEM IN A LINKEDLIST IS BAD, BECAUSE LINKEDLIST NEEDS TO PASS AN
        * EACH ITEM TO FIND THE SPECIFIC VALUE;
        * -- WORKING WITH SMALL LISTS, DOES NOT HAVE DIFFERENCE BETWEEN LINKEDLIST AND ARRAYLIST, BUT WITH BIG LISTS THAT
        * WE NEED TO "ADD" OR "REMOVE" ITEMS FREQUENTLY, LINKEDLIST IS BETTER.
        * */

        LinkedList<String> names = new LinkedList<>();
        names.add("Ale");
        names.add("Nathi");
        System.out.println(names);
        System.out.println(names.get(1));


        /*
        * ARRAYLIST:
        *
        * -- BEHIND THE SCENES, CREATE A DYNAMIC JAVA ARRAY AND STORE EACH DATA VALUE/POSITION;
        * -- OPERATION OF "ADD" AND "REMOVE" ARE LOWER THAN LINKEDLIST, BECAUSE THE ARRAYLIST HAVE TO CREATE A NEW
        * LIST AND REORGANIZE THE ITEMS WHEN "ADD" OR "REMOVE" ONE;
        * -- OPERATION OF "READ"/"GET" SPECIFIC ITEM IN AN ARRAYLIST IS BETTER THAN LINKEDLIST, BECAUSE
        * ARRAYLIST STORE EACH ITEM VALUE/POSITION AND THEN CAN FIND THE ITEM QUICKLY;
        * -- WORKING WITH SMALL LISTS, DOES NOT HAVE DIFFERENCE BETWEEN LINKEDLIST AND ARRAYLIST, BUT WITH BIG LISTS THAT
        * WE NEED TO "GET" ITEMS FREQUENTLY, ARRAYLIST IS BETTER.
        * */

        ArrayList<String> namesArrayList = new ArrayList<>();
        namesArrayList.add("Ale");
        namesArrayList.add("Nathi");
        System.out.println(namesArrayList);
        System.out.println(namesArrayList.get(1));
    }
}
