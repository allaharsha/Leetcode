public class AddTwoNumbers {

	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        int tens = 0;
        while(l1 !=  null || l2 != null || tens!=0){
            int op1 = 0;
            int op2 = 0;
            if(l1 != null){
                op1 = l1.val;
                l1 = l1.next; 
            }
            if(l2 != null){
                op2 = l2.val;
                l2 = l2.next; 
            }
            int result = op1+op2+tens;
            tens = result/10;
            if(current == null){
                current = new ListNode(result % 10,null);
                head = current;
            } else {
                ListNode newNode = new ListNode(result % 10,null);
                current.next = newNode;
                current = newNode;
            }
        }
        return head;
    }
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(8);
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		node1.next = node2;
		ListNode node4 = new ListNode(0);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		node5.next = node6;
		node4.next = node5;
		ListNode result = addTwoNumbers(node1,node4);
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
	}

}
