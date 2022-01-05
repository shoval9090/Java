package HW_shoval;

public class LinkedList<T> implements List<T> {

    // שאלות 1 ו2


    private Node head;
    private int size;
    private int index;

    public LinkedList() {
        this.head = null;
        this.size = 0;
        this.index = 0;
    }


    public Node getHead() {
        return head;
    }

    // ---------------------------
    // שאלה 2 ADD ברקורסיה
    // זמן ריצה מקרה גרוע הואO(n) משום שאנו לא יודעים
    // כמה איברים נצטרך לעבור הפונקציות עזר
    public void addRec(T data) {
        if (this.head == null) { // אם אין אובייקט בראש הרשימה , ניצור אחד ונכניס
            this.head = new Node(data, size++);
            // תקדם לי את האינדקס
//            this.head.index++;

        } else { // במידה ויש אובייקט והרשימה אינה ריק נשלח לפונקציית העזר שלנו
            RecursiaHelp(head, data);

        }
        size++; // בכל מקרה נגדיל את אורך הרשימה
        // index++; // קדם לי את האינדקס בהתאם

    }
    // הפונקציה מחזירה אובייקט גינרי מסוג T וגם DATA כאילו מידע
    private static <T> void RecursiaHelp(Node<T> node, T data) {
        // הפונקציה יוצרת אובייקט מסוג NODE עם data
        if (node.next == null) {// הפונקציה תכניס לי איבר לסוף הרשימה
            node.next = new Node(data, node.index+1);
        } else {
            RecursiaHelp(node.next, data);
            node.index++;// קדם לי את האינדקס
        }
    }


    // שאלה 2 REMOVE ברקורסיה
    // זמן ריצה הוא O(n) - משום שאנו לא יודעים את גודל הרשימה שנעבוד עליה
    public T remove_REC(int num) {
        // create an T new object
        T temp_head = null;
        if (isEmpty()) {
            // אם הרשימה ריקה תדפיס לי את זה :
            System.out.println("We can't give you this Index ");
        } else if (this.size == 1) {
            // אם ברשימה רק איבר אחד , תשים אותו באובייקט
            temp_head = (T) this.head;
        } else {
            temp_head = (T) remove_HELP(head);
        }
        // קצר לי את אורך הרשימה ב1
        size--;
        // תחזיר את המשתנה שיצרתי
        return temp_head;

    }

    // פונקציית עזר להזיז אובייקט מהרשימה
    public static <T> T remove_HELP(Node<T> node) {
        if (node.next.next == null) {
            // אם הנקסט של האיבר הבא יהיה ריק , תוציא לי אותו
            T data = (T) node.next;
            // תשים לי אותו בתוך המשתנה החדש שיצרתי
            node.next = null;
            return data;
        }
        return remove_HELP(node.next);
    }
    // ---------------------------------------


    @Override

    public void add(T data) {
        if (this.head == null) { // בודקים האם קיים איבר ראשון ברשימה
            this.head = new Node(data, size); // מוסיף למקום הראשון במידה וריק
        } else {
            Node <T> new_Node = new Node <T>(data, size); // יוצרים צומת חדשה , מגדירים NODE חדש
            Node temp_head = this.head;
            // לוקחים את הכתובת של ההד ונעבוד איתה עכשיו
            while (temp_head.next != null) {
                // מתחילים מההד ובודקים האם יש לי איבר בצומת הבאה
                temp_head = temp_head.next;
                 // כל עוד יש אובייקט והכתובת בזיכרון תפוסה תתקדם לאיבר הבא
                // וגם תקדם את האינדקס בשביל שנכנס למיקום הנכון
            }
            // במידה ופנוי תכניס לי מופע חדש מסוג NODE
            temp_head.next = new_Node;
        }// תקדם לי את האורך של הרשימה
        size++;


    }

    @Override
    public void addFirst(T data) {
        Node temp_head = new Node(data, 0);
        if (this.head == null) {
            this.head = temp_head;
            temp_head.index++;
        } else {
            temp_head.next = this.head; // סוג של ניקח צעד אחורה ונגדיר את ההד המקורי לאיבר הבא
            this.head = temp_head;
            while (temp_head.next != null) {
                // כל עוד האיבר הבא תפוס , תקדם את כולם עוד אחד
                temp_head = temp_head.next;
                temp_head.index++;
            }
        }// תקדם לי את אורך הרשימה
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T data) {
        if (isEmpty()) // בודקים האם הרשימה ריקה
            return false;
        Node temp_head = this.head; // יוצרים משתנה עזר שיתחיל לעבוד עם ההד
        while (temp_head != null && temp_head.data != data)
            temp_head = temp_head.next; // כל עוד התנאי לא מתקיים לעבוד לי לצומת הבאה לבדיקה
        return temp_head != null;
    }

    @Override
    public T get(int index) {
        // הפונקציה תבדוק האם האינדקס נמצא ברשימה
        if (isEmpty() || index >= this.size || index < 0)
            return null;
        Node temp_head = this.head;
        // משתנה עזר שנעבוד איתו
        while (temp_head != null && temp_head.index != index) {
            temp_head = temp_head.next;
        }

        assert temp_head != null;
        return (T) temp_head.data;
    }

    @Override
    public T getFirst() {
        return this.head != null ? (T) this.head.data : null;
    }

    @Override
    public T getLast() {
        // תמיד שנעבוד עם צמתים לא נעבוד עם צומת עצמה אלה נשתמש במשתנה עזר שלו
        Node tempo_head = this.head;
        if (tempo_head.data != null && tempo_head.next != null)
            tempo_head = tempo_head.next;
        return (T) tempo_head.data;
    }

    @Override
    public T peek() {
        // להציץ על האיבר הראשון ברשימה
        return this.head != null ? (T) this.head.data : null;
    }


    public String toString() {
        // פונקציית toString
        Node temp_head = this.head;
        while (temp_head != null) {
            System.out.printf("Index = %d ", temp_head.index);
            // System.out.printf("prev = %s ", temp_head.prev != null ? temp_head.prev.data : "null");
            System.out.printf(",data =%s ", temp_head.data);
            System.out.printf(",next = %s ", temp_head.next != null ? temp_head.next.data : "null");
            temp_head = temp_head.next;
            System.out.println("");
        }
        return "LinkedList{size =" + size + "}";
    }


}
