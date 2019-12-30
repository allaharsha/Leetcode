import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        while(l1!=null){
            list1.add(l1.val);
            l1=l1.next;
        }
        List<Integer> list2 = new ArrayList<>();
        while(l2!=null){
            list2.add(l2.val);
            l2=l2.next;
        }
        int length1 = list1.size();
        int length2 = list2.size();
        int length = (length1>length2) ? length1 : length2;
        int trail = 0;
        int a;
        int b;
        int k = 0;
        int j = 0;
        int sum;
        List<Integer> result = new ArrayList<>();
        while(length>0){
            a=0;
            b=0;
            
            if(length1>k){
                a = list1.get(k);
                System.out.print(a);
                k++;
            }
            if(length2>j){
                b = list2.get(j);
                System.out.print(b);
                j++;
            }
            length--;
            sum=a+b+trail;
            trail=sum/10;
            sum = sum%10;
            System.out.println(trail);
            System.out.println(sum);
            result.add(sum);
        }
        if(trail>0){
            result.add(trail);
        }
        
        ListNode head = new ListNode(0);
        head.next = null;
        for(int i = result.size()-1 ; i>=0;i--){
            ListNode newNode = new ListNode(result.get(i));
            newNode.next = head.next;
            head.next = newNode;
        }
        
        return head.next;
    }
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(8);
		ListNode node3 = new ListNode(3);
		//node2.next = node3;
		node1.next = node2;
		ListNode node4 = new ListNode(0);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		//node5.next = node6;
		//node4.next = node5;
		ListNode result = addTwoNumbers(node1,node4);
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
	}

}
