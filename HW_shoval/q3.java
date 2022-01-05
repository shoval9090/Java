package HW_shoval;

public class q3 {
    //  זמן ריצה הינו -O(n)
    // במקרה הגרוע - משום שנו לא יודעים כמה איברים יהיה על הפונקציה למחוק
    public static Node<Integer> deleteInteger(int data , Node<Integer> nodeToMove){
        // בודק האם הפרמט שלי ריק
        if (nodeToMove == null) {
            return null;
        }
        if (nodeToMove.data == data){
            // מחיקה של כל איבר מסוג INTEGER שמחזיק באובייקט מסוג DATA בצורה רקורסיבית
            return deleteInteger(data,nodeToMove.next);
        } // ממשיכים לבדוק האם ישנם עוד איברים שאנחנו צריכים להוציא
        nodeToMove.next = deleteInteger(data,nodeToMove.next);
        return nodeToMove;
    }


    public static void main(String[] args) {
        Node <Integer > first = new Node<>(10);
        first.next = new Node<>(20);
        first.next.next = new Node<>(30);
        first.next.next.next = new Node<>(40);
        first.next.next.next.next = new Node<>(30);
        // הדפסה לרשימה לםני הקריאה לפונקציה
        System.out.println(first.toString());
        // הדפסה לרשימה אחרי הקריאה לפונקציה
        System.out.println(deleteInteger(30,first).toString());

    }
}
