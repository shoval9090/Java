package HW_shoval;

public class q4 {
    // זמן הריצה במקרה הגרוע הינו - O(n)
    // משום שאנו לא נדע כמה איברים יש לנו ברשימה ונצטרך לעבור על כולה ולחשב את הממוצע
    public static double nodes_AVG(Node<Integer> first) {
        // בודקים האם ההאד שלי ריק ז"א NULL
        if (first == null)
            return -1;

        // אתחול של משתנים
        int count = 0;
        int sum = 0;
        double avg = 0.0;

        // אתחול של אובייקט NODE חדש
        Node<Integer> first_Node = first;
        // כל עוד האובייקט החדש שנריץ עליו את הבדיקה אינו ריק
        while (first_Node != null) {
            // קדם לי כאן את המשתנים
            count++;
            sum += first_Node.data;
            first_Node = first_Node.next;
        }
        // חישוב הממוצע שלי
        avg = (double) sum / count;
        return avg;
    }


    public static void main(String[] args) {
        // ------ הרצה לשאלה 4 ------
        LinkedList<Integer> test = new
                LinkedList<Integer>();
        test.add(4);
        test.add(6);
        test.add(8);
        test.add(3);

        LinkedList<Integer> test2 = new
                LinkedList<Integer>();
        test2.add(2);
        test2.add(3);
        test2.add(4);
        test2.add(5);
        System.out.println(nodes_AVG(test.getHead()));
        System.out.println(nodes_AVG(test2.getHead()));
    }
}
