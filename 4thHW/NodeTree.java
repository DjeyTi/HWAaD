public class NodeTree {
    public static void main(String[] args) {
        Node Tree = BuildTree(6);
        printTreeNLR(Tree, " ");        
        printTreeLNR(Tree, " ");
        printTreeLRN(Tree, " ");
    }

    static int t = 1;

    public static Node BuildTree(int number) {
        Node Root;
        if (number == 0)
            return null;
        else {
            Root = new Node(t++);
            Root.Left = BuildTree(number / 2);
            Root.Right = BuildTree(number - number / 2 - 1);
        }
        return Root;
    }

    // Прямой обход NLR
    public static void printTreeNLR(Node Node, String Slash) {
        if (Node != null) {
            System.out.println(Slash + Node.value);
            printTreeNLR(Node.Left, Slash + "| ");
            printTreeNLR(Node.Right, Slash + "  ");
        }
    }

    // Центрированный обход NLR
    public static void printTreeLNR(Node Node, String Slash) {
        if (Node != null) {
            printTreeNLR(Node.Left, Slash + "| ");
            System.out.println(Slash + Node.value);
            printTreeNLR(Node.Right, Slash + "  ");
        }
    }

    // Обратный обход LRN
    public static void printTreeLRN(Node Node, String Slash) {
        if (Node != null) {
            printTreeLRN(Node.Left, Slash + "| ");
            printTreeLRN(Node.Right, Slash + "  ");
            System.out.println(Slash + Node.value);
        }
    }
}

class Node {
    int value;
    Node Left;
    Node Right;

    public Node(int value) {
        this.value = value;
    }


}
