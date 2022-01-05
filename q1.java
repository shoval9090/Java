import java.util.Arrays;

public class q1 {

    // question 1
    //    section 1
    public int maxArr1(int[] arr1) {
        int max = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] > max)
                max = arr1[i];
        }
        return max;
    }
 /*
 n זהו גודל המערך שלנו
 השמה של משתנה MAX היא פעולה אחת.
 הלולאה עושה n-1 צעדים ובתוך הלולאה יש לי צעד אחד או שתיים
 הקידום של i זה פעולה נוספת
 הreturn זה פעולה נוספת , ככה שבמקרה הגרוע יש לנו
 1+3(n-1)+1 = o(n)
  */

    // section 2

    public static double AvgSortedArr2(int[] arr) {
        double sumArray = 0;
        for (int i = 0; i < arr.length; i++) {
            sumArray += arr[i];
        }
        sumArray = sumArray / arr.length;

        return sumArray;
    }

    // במידה ולא אדע אם אורך המערך, סיבוכיות זמן ריצה היא O(n)
    // n+4 הינה פונקציות הזמן

    //    // section 3
    public static int maxSorted(int[] arr3) {
        int LastNum = arr3[arr3.length - 1];
        int FirstNum = arr3[0];
        if (FirstNum > LastNum) {
            return FirstNum;
        }
        return LastNum;
    }
//    // זמן הריצה הוא O של 1
//    // פונקציית הזמן היא 4

    // question 2
    public static void q2(int[] arrq2) {
        for (int i = 0; i < arrq2.length - 1; i++) {
            if (arrq2[i] > arrq2[i + 1]) {
                int temp = arrq2[i];
                arrq2[i] = arrq2[i + 1];
                arrq2[i + 1] = temp;
            }
        }
        for (int i = arrq2.length - 1; i >= 1; i--) {
            if (arrq2[i] < arrq2[i - 1]) {
                int tempo = arrq2[i];
                arrq2[i] = arrq2[i + 1];
                arrq2[i + 1] = tempo;
            }
        }
    }
    /*
     זמן הריצה של הפונקציה שהכנתי הינה במקרה הטוב o(n)
     משום שלולאת FOR עושה ריצה על n פעמים
     במקרה הרע הלולאה תעשה o(2n)
     */

    // question 3
    public static void sortQuestion3(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }

            }
            if (!flag) {
                break;
            }
        }
        System.out.println("The array is sorted : "
                + Arrays.toString(arr));
    }
      /*
      בפונקציה הזו נבדוק האם המערך ממוין , ה FLAG ייעזור לנו לבדוק זאת
      בלולאת FOR הראשונה .
      במידה ולא ממויין נמיין בעזרת הלולאת FOR השניה .
      כך שבמקרה הטוב ביותר נקבל פונקצית זמן של o(n)

       */


    // question 4

    // section A
    // הפונקציה בודקת אם כל הערכים במערך A גדולים מכל הערכים במערך B
    // במידה ויש ערך אחד במערך B שגדול מערך אחר במערך A
    // הפונקציה ישר תחזיר false
    // section B
    // סיבוכיות זמן ריצה הינה O של N^2 משום שיש לנו FOR בתוך FOR

    // section C
    int[] a = new int[]{50, 60, 70, 80};
    int[] b = new int[]{10, 20, 30, 40};

    public static boolean check(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        if (b[b.length - 1] > a[0])
            return false;
        return true;
    }
    // SECTION ד
    // זמן הריצה של התוכנית החדשה שלי הוא n LOG n משום שאני משתמש רק בפונקציות של Arrays.sort
    // בפונקציה שלי אני ממיין את המערכים ואפילו מספיק לי שהערך הכי גדול במערך B
    // יהיה גדול יותר מהערך הכי קטן במערך A והתוכנית תחזיר לי FALSE

    public static int BonusQuestion5(int[] arr) {
        Arrays.sort(arr);
        int maxCount = 1, normalCount = 1;
        int len = arr.length, comNumber = arr[0];

        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1])
                normalCount++;
            else {
                if (normalCount > maxCount) {
                    maxCount = normalCount;
                    comNumber = arr[i - 1];
                }
                normalCount = 1;
            }
        }
        return comNumber;

    }


    public static void main(String[] args) {

        int[] arr2 = new int[]{12, 99, 24, 100};
        System.out.println(AvgSortedArr2(arr2));

        int[] arr3 = new int[]{44, 49, 109, 535};
        System.out.println(maxSorted(arr3));

//        int[] arrPart2 = new int[]{22, 25, 34, 45, 15, 66, 70};
//        arrPa2(arrPart2);
//        System.out.println(Arrays.toString((arrPart2)));

        int[] ar = {3, 4, 5, 6, 8, 7};
        q2(ar);
        System.out.println(Arrays.toString(ar));

//        int[] ar = {1, 7, 3, 2, 9};
//        sortQuestion3(ar);

        int[] ar5 = {2, 3, 1, 8, 3, 7, 3, 4, 2, 8, 7, 3, 3, 3, 1};
        System.out.println(BonusQuestion5(ar5));

    }


}
