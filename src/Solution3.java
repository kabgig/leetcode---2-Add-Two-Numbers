import java.util.LinkedList;

class Solution3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int firstNum = 0;
        int firstNumReversed = 0;
        int secondNum = 0;
        int secondNumReversed = 0;
        ListNode now1 = l1;
        ListNode next1 = l1.next;
        ListNode now2 = l2;
        ListNode next2 = l2.next;

        // L1----------------
        while (next1 != null) {
            firstNum = firstNum * 10 + now1.val;
            now1 = next1;
            next1 = now1.next;
        }
        while (firstNum > 0) {  // reversing 1
            firstNumReversed = firstNumReversed * 10 + firstNum % 10;
            firstNum /= 10;
        }
        // L2----------------
        while (next2 != null) {
            secondNum = secondNum * 10 + now2.val;
            now2 = next2;
            next2 = now2.next;
        }
        while (secondNum > 0) { // reversing 2
            secondNumReversed = secondNumReversed * 10 + secondNum % 10;
            secondNum /= 10;
        }

        int resultNum = firstNumReversed + secondNumReversed;
        LinkedList<ListNode> list = new LinkedList<>();
        int index = 0;

        while (resultNum > 0) {
            int valueToAdd = resultNum % 10;
            resultNum /= 10;
            ListNode LNCurrent = new ListNode(valueToAdd,null);
            list.add(index, LNCurrent);
            if (index < 0) {
                ListNode prev = list.get(index - 1);
                prev.next = LNCurrent;
                list.set(index - 1, prev);
            }
            index++;
        }
        return list.get(0);
    }
}
