class Node {
		int num;
		Node next;
		Node arbitrary;
	}

public class CopyLinkedListWithArbitraryPointer {
	
	static Node copyLinkedListWithArbitraryPointer(Node head) {
		Node current = head;
		while(current != null) {
			Node newNode = new Node();
			newNode.num = current.num;
			newNode.next = current.next;
			newNode.arbitrary = current.arbitrary;
			if(current.next == null) {
				newNode.next =null;
			}
			current.next = newNode;
			current = newNode.next;
		}
		
		current = head;
		Node newHead;
		if(head == null) {
			return null;
		} else {
			newHead = head.next;
		}
		while(current!= null) {
			Node temp = current.next;
			temp.arbitrary = temp.arbitrary == null? null:temp.arbitrary.next;
			current = temp.next;
		}

		current = head;
		while(current!=null) {
			Node temp = current.next;
			current.next = temp.next;
			temp.next = temp.next == null ? null:temp.next.next;
			current = current.next;
		}
		
		return newHead;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		
		node1.num = 1;
		node1.next = node2;
		node2.num = 2;
		node2.next = node3;
		node3.num = 3;
		node3.next = null;
		
		node1.arbitrary = node3;
		node2.arbitrary = node1;
		node3.arbitrary = node2;
		
		convertString(node1, node2, node3);
		Node result = copyLinkedListWithArbitraryPointer(node1);
		convertString(result,result.next,result.next.next);
	}

	private static void convertString(Node node1, Node node2, Node node3) {
		System.out.println(String.valueOf(node1.num) + node1.next + node1.arbitrary);
		System.out.println(String.valueOf(node2.num) + node2.next + node2.arbitrary);
		System.out.println(String.valueOf(node3.num) + node3.next + node3.arbitrary);
	}
}
