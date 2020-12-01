import sun.misc.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) throws InterruptedException {
		BinNode root = new BinNode();
		root.num = 1;
		BinNode lRoot = new BinNode();
		BinNode rRoot = new BinNode();
		
		root.left = lRoot;
		root.right = rRoot;
		lRoot.num = 2;
		rRoot.num = 3;
		
		BinNode ll = new BinNode(4);
		BinNode lr = new BinNode(5);
		BinNode rl = new BinNode(6);
		BinNode rr = new BinNode(7);
		
		lRoot.left = ll;
		lRoot.right = lr;
		rRoot.left = rl;
		rRoot.right = rr;
		
		levelOrderTraversal(root);
	}

	private static void levelOrderTraversal(BinNode root) throws InterruptedException {
		Queue<BinNode> printQueue = new Queue<>();
		Queue<BinNode> rootQueue = new Queue<>();
		if(root != null) {
			printQueue.enqueue(root);
		}
		while(!printQueue.isEmpty()) {
			BinNode temp = printQueue.dequeue();
			System.out.print(temp.num);
			if(temp.left!= null)
				rootQueue.enqueue(temp.left);
			if(temp.right!= null)
				rootQueue.enqueue(temp.right);
			if(printQueue.isEmpty()) {
				printQueue = rootQueue;
				rootQueue = new Queue<>();
				System.out.println();
			}
			
		}
		
	}

}
