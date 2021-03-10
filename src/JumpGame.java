import java.util.Stack;

public class JumpGame {

	public boolean canJump(int[] nums) {
        int[] visited = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()){
            int index = stack.pop();
            if(index == visited.length-1){
                return true;
            }
            for(int i = 1; i<= nums[index]; i++){
                int pushingIndex = index+i;
                if(pushingIndex > nums.length-1)
                    break;
                if(visited[pushingIndex] == 0)
                    stack.push(pushingIndex);
            }
            visited[index] = 1;
        }
        
        return visited[nums.length-1]!=0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
