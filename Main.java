import java.util.Scanner;

public class Main {
    private static node root = null;

    public static void main(String[] args) {

        RedBlackTree node = new RedBlackTree();
        try (Scanner scan = new Scanner(System.in)) {
            char ch;
            do {
                System.out.printf("Введите целое число: ");

                int num = scan.nextInt();
                root = node.insert(root, num);

                node.inorder(root);
                System.out.printf("\t Вы хотите продолжить? (введите y или n): ");
                ch = scan.next().charAt(0);
            } while (ch == 'Y' || ch == 'y');
        }
    }
}