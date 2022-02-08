public class TestObject {
    public static void main(String[] args) {

        // We create a DoublyLinkedList
        DoublyLinkedList list = new DoublyLinkedList();

        // We add Integers and Strings
        list.add(34);
        list.add("abc");
        list.add(67);
        list.add("test");
        System.out.println("Object Linked List:");
        System.out.println(" ----- " + list);

        // We test oppsite adding
        list.addOppositeSide(33);
        System.out.println("33 is appended at the end:");
        System.out.println(" ----- " + list);

        // We test searchAndRemove
        list.searchAndRemove(33);
        System.out.println("33 removed:");
        System.out.println(" ----- " + list);

        list.searchAndRemove("hello");
        System.out.println("hello (that is not in the list) removed:");
        System.out.println(" ----- " + list);

        // We test the search
        System.out.println("We search for 34 (int)");
        System.out.println(" ----- " + list.search(34));
        System.out.println("We search for \"abc\"");
        System.out.println(" ----- " + list.search("abc"));
        System.out.println("We search for \"isItHere\"");
        System.out.println(" ----- " + list.search("isItHere?"));

        // We test the remove
        list.removeAt(1);
        System.out.println("We remove the second element:");
        System.out.println(" ----- " + list);
        list.removeAt(list.getSize() - 2);
        System.out.println("We remove the second to last element:");
        System.out.println(" ----- " + list);

        // We test getFirst.
        // Elements need to be casted into theire actual class.
        String elem1 = (String) list.getFirst();
        System.out.println("First element is a String ---> " + elem1);
        list.removeAt(0);
        Integer elem2 = (Integer) list.getFirst();
        System.out.println("Second element is an Integer ---> " + elem2);
    }
}
