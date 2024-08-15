public class TestClass {
    public static void main(String[] args) {
        PhonebookManager phonebook = new PhonebookManager();

        phonebook.addEntry("Hatsune Miku", "456 Elm St", "Bellingham", "123-456-7890");
        phonebook.addEntry("Kagamine Rin", "123 Main St", "Texas", "987-654-3210");
        phonebook.addEntry("Megurine Luka", "789 Oak St", "Bellingham", "555-1212");

        phonebook.printPhonebook();

        phonebook.sortByName();
        System.out.println("\nAfter sorting:");
        phonebook.printPhonebook();

        phonebook.modifyEntry("Hatsune Miku", "999 Pine St", "Seattle", "555-5555");
        System.out.println("\nAfter modifying Hatsune Miku's entry:");
        phonebook.printPhonebook();

        phonebook.deleteEntry("Kagamine Rin");
        System.out.println("\nAfter deleting Kagamine Rin:");
        phonebook.printPhonebook();
    }
}
