public class ValidateBST {

	public static void main(String[] args) {
		BinNode root = new BinNode();
		BinNode left = new BinNode();
		BinNode right = new BinNode();
		
		root.right = right;
		root.left = left;
		root.num = 20;
		left.num = 10;
		right.num = 30;
		
		BinNode left1 = new BinNode();
		BinNode right1 = new BinNode();
		BinNode left2 = new BinNode();
		BinNode right2 = new BinNode();
		
		left.left = left1;
		left.right = right1;
		right.left = left2;
		right.right = right2;
		
		left1.num = 9;
		right1.num = 100;
		
		left2.num = 29;
		right2.num = 31;
		
		
		System.out.println(validate(root,null,null));
	}

	private static boolean validate(BinNode root,Integer lower,Integer upper) {
		if(root == null) return true;
		if((lower!=null && root.num < lower) || (upper!=null && root.num > upper)) return false;
		if(!validate(root.left,lower,root.num)) return false;
		if(!validate(root.right,root.num,upper)) return false;
		
		return true;
		
	/*
		if(root.left!=null)	{
			if(root.left.num<root.num) {
				result = validate(root.left);
			} else {
				return false;
			}
		}
		
		if (root.right != null) {
			if(root.right.num>root.num){
				result = validate(root.right);
			} else {
				return false;
			}
		}
		
		return result;*/
	}

}
