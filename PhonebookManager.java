public class PhonebookManager {
    ListNode head;

    public void addEntry(String name, String address, String city, String phoneNumber) {
        ListNode newNode = new ListNode(name, address, city, phoneNumber);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void sortByName() {
        // Implementation of bubble sort for simplicity
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        ListNode current;
        ListNode next;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                next = current.next;
                if (current.name.compareToIgnoreCase(next.name) > 0) {
                    // Swap data
                    String tempName = current.name;
                    String tempAddress = current.address;
                    String tempCity = current.city;
                    String tempPhone = current.phoneNumber;

                    current.name = next.name;
                    current.address = next.address;
                    current.city = next.city;
                    current.phoneNumber = next.phoneNumber;

                    next.name = tempName;
                    next.address = tempAddress;
                    next.city = tempCity;
                    next.phoneNumber = tempPhone;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void modifyEntry(String name, String newAddress, String newCity, String newPhoneNumber) {
        ListNode current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                current.address = newAddress;
                current.city = newCity;
                current.phoneNumber = newPhoneNumber;
                return;
            }
            current = current.next;
        }
        System.out.println("Entry not found.");
    }

    public void deleteEntry(String name) {
        if (head == null) {
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.next.name.equals(name)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("Entry not found.");
    }

    public void printPhonebook() {
        ListNode current = head;
        while (current != null) {
            System.out.println("Name: " + current.name);
            System.out.println("Address: " + current.address);
            System.out.println("City: " + current.city);
            System.out.println("Phone Number: " + current.phoneNumber);
            System.out.println();
            current = current.next;
        }
    }
}
