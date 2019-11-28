public class Main {

    public static void main(String[] args) {

        MyList list = new MyList();

        list.addElementAtStart(new Element("1"));
        list.addElementAtStart(new Element("2"));
        list.addElementAtEnd(new Element("3"));
        list.addElementAtEnd(new Element("4"));
        list.addElementAtStart(new Element("5"));
        list.addElementAtPosition(new Element("------"), 4);
        list.deleteElementAtPosition(3);
        list.printList();
    }
}
