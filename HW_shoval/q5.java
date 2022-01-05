package HW_shoval;

public class q5<T> {
    // זמן ריצה הינו O(n)
    // משום שלא יודעים כמה אובייקטים יש לנו תחת אותה רשימה ועליהם נצטרך לעשות את הבדיקה
    public Boolean q5a(LinkedList<T> list) {
        // בודק האם הרשימה מלאה או ריקה לחולטין
        if (list.isEmpty()) return false;

        Node<T> temp = list.getHead();
        // בודק על הצומת החדשה שלי שיצרתי
        // האם האינדקס שלה גדול מהבא אחריה
        while (temp.next != null) {
            if (temp.index > temp.next.index) {
                return true;
            } // מקדם את הטמפ שלי
            temp = temp.next;
        }
        return false;
    }

    public Node<T> q5b(LinkedList<T> list) {
        // במידה ואקבל FALSE מהפונקציה הראשונה אז פה תחזיר לי NULL
        if (!q5a(list)) return null;
        Node temp = list.getHead();
        // תיצור לי NODE חדש שמתחזיק את משתנה HEAD
        while (true) {
            if (temp.index > temp.next.index) {
                return temp.next;
            }
            temp = temp.next;
        }
    }


}
