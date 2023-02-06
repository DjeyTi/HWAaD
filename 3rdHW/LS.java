public class LS {
    public static void main(String[] args) {
        MyList ml = new MyList();
        ml.add("Раз");
        ml.add("Два");
        ml.add("Три");

        Node temp = ml.head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

        ml = ml.reverse();

        temp = ml.head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}

class MyList {
    Node head;

    void add(String val) {
        Node n = new Node(val);
        if (head == null)
            head = n;
        else {
            Node t = head;
            while(t.next != null) {
                t = t.next;
            }
            t.next = n;
        }
    }

    MyList removeLast() {
        MyList NewMyList = new MyList();
        Node n = head;
        if (n == null)
            System.out.println("Ошибка: данный список пуст");
        else {
            while (n.next != null) {
                NewMyList.add(n.value);
                n = n.next;
            }
        }
        return NewMyList;
    }

    MyList reverse() {
        MyList StandartList = new MyList();
        Node n = new Node(null);
        n = head;
        while (n.next != null) {
            StandartList.add(n.value);
            n = n.next;
        }
        StandartList.add(n.value);
        MyList ReverseMyList = new MyList();
        while (StandartList.head != null) {
            n = StandartList.head;
            while (n.next != null) {
                n = n.next;
            }
            ReverseMyList.add(n.value);
            StandartList = StandartList.removeLast();
        }
        return ReverseMyList;
    }
}

class Node {
    String value;

    public Node(String value) {
        this.value = value;
    }

    Node next;
}