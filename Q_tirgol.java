package com.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Q_tirgol {
    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 5, 7, 2, 4, 1, 3, 2, 5, 5, 1};
        Queue<Integer> n = new LinkedList();
        for (int i = 0; i < a.length; i++) {
            n.add(a[i]);
        }
        System.out.println(n);
        System.out.println(doubleNum(n));

    }
    // כתבו פעולה המקבלת תור של מספרים שלמים. האיברים בתור לא ממוינים ויכולים להופיע כמה פעמים.
    //הפעולה תחזיר תור חדש הכולל רק את האיברים שמופיעים יותר מפעמיים.
    public static Queue doubleNum(Queue<Integer> q) {
        // מעתיק את התוכן שיש לי ב Q שהפונקציה קיבלה
        Queue<Integer> newQ = new LinkedList(q);
        Queue<Integer> ReturnQ = new LinkedList();

        for (int i = 0; i < q.size(); i++) {
            int temp = newQ.remove();
            // פה אני בודק האם הערך הזה מוכל לי כבר ברשימה החדשה
            if (ReturnQ.contains(temp))
                continue; // אם הוא מוכל לי כבר אז תמשיך
            // ניצור תור חדש שיכיל את התור הקודם ועליו נעשה בדיקות
            Queue<Integer> te = new LinkedList(newQ);
            int counter = 1; // מגדירים קאונטר
            while (!te.isEmpty()) { // כל עוד התור החדש אינו ריק
                if (temp == te.poll()) // אם האובייקט שעליו נעשה את הבדיקה נמצא,תעלה את הקאונטר
                    counter++;
            }
            // אם נמצא בקאונטר שלנו שיש את האיבר
            // הזה יותר מפעמיים נכניס אותו פנימה
            if (counter > 2)
                ReturnQ.add(temp);
        }
        return ReturnQ;
    }

}

