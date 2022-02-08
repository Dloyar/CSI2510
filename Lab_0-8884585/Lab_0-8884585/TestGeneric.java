public class TestGeneric {
    public static void main(String[] args) {

        // We create a DoublyLinkedList for Integer and one for String
        DoublyLinkedList<Integer> integerList = new DoublyLinkedList<Integer>();
        DoublyLinkedList<String> stringList = new DoublyLinkedList<String>();

        // We add Integers
        integerList.add(34);
        integerList.add(67);
        System.out.println("Integer Linked List:");
        System.out.println(" ----- " + integerList);

        stringList.add("abc");
        stringList.add("test");
        System.out.println("String Linked List:");
        System.out.println(" ----- " + stringList);

        // We test opposite adding
        integerList.addOppositeSide(33);
        System.out.println("33 is appended at the end:");
        System.out.println(" ----- " + integerList);

        stringList.addOppositeSide("33");
        System.out.println("\"33\" is appended at the end:");
        System.out.println(" ----- " + stringList);

        // We test searchAndRemove
        integerList.searchAndRemove(33);
        System.out.println("33 removed:");
        System.out.println(" ----- " + integerList);

        stringList.searchAndRemove("hello");
        System.out.println("hello (that is not in the list) removed:");
        System.out.println(" ----- " + stringList);

        // We test the search
        System.out.println("We search for 34 (int)");
        System.out.println(" ----- " + integerList.search(34));
        System.out.println("We search for \"abc\"");
        System.out.println(" ----- " + stringList.search("abc"));
        System.out.println("We search for \"isItHere\"");
        System.out.println(" ----- " + stringList.search("isItHere?"));

        // We test the remove
        integerList.removeAt(1);
        System.out.println("We remove the second element (integerList):");
        System.out.println(" ----- " + integerList);
        stringList.removeAt(stringList.getSize() - 2);
        System.out.println("We remove the second to last element (stringList):");
        System.out.println(" ----- " + stringList);

        // We test getFirst.
        // We do not need to cast anymore
        String elem1 = stringList.getFirst();
        System.out.println("First element in stringList ---> " + elem1);
        Integer elem2 = integerList.getFirst();
        System.out.println("First element in integerList ---> " + elem2);
    }
}
