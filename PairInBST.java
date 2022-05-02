import java.util.HashSet;
import java.util.Set;

class Node{
	int data;
	Node left = null, right = null;
	
	Node(int data)
	{
		this.data = data;
	}
}
public class PairInBST {

	//insert in BST Tree
	public static Node insert(Node root,int key) {
		if(root == null)
			return new Node(key);
		
		if( key < root.data) {
			root.left = insert(root.left,key);
		}
		else
		{
			root.right = insert(root.right,key);
		}
		
		return root;
	}
	
	public static boolean findPair(Node root,int target, Set<Integer> set) {
		
		//empty tree
		if(root == null)
			return false;
		
		//search the left subtree first
		if(findPair(root.left,target,set)) {
			return true;
		}
		
		//SUbtract the current , from target number and search the resultant
		if(set.contains(target - root.data)) {
			System.out.println("Pair is ("+(target-root.data) + ","+root.data+")");
			return true;
		}
		else {
			set.add(root.data);
		}
		
		//search the right subtree
		return findPair(root.right,target,set);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] keys = {40,20,60,10,30,50,70};
		Node root = null;
		
		for(int key: keys)
			root = insert(root,key);
		
		int target = 130;
		
		Set<Integer> set = new HashSet<>();
		
		if(!findPair(root,target,set)) {
			System.out.println("Pair doesnt exist");
		}
	}

}
