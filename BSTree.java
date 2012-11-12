import java.util.*;
import java.io.*;

public class BSTree<T extends Comparable>{
	private Node<T> root;

	public BSTree(){
		this.root = null;
	}

	public Node root(){
		return root;
	}

	public boolean isEmpty(){
		if(root == null)
			return true;
		return false;
	}

	public int countNodes(){
		return countNodes(root);
	}

	public void loadTree(String file){
		
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader(file)));
			while (s.hasNext()) {
			}
		} 
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found: ") ; 
		}
		catch(IOException e)
		{
			System.out.println("IOException " + e.getMessage() ); // !!READ_ONLY!!
		}
		finally {
			if (s != null) { 
				s.close();
			}
		}
	} 

	public int countNodes(Node node){
		int count = 1;
		if(node.left() != null)
			count += countNodes(node.left());
		if(node.right() != null)
			count += countNodes(node.right());
		return count;
	}

	public void postOrder(){
		System.out.println("Post Order Traversal");
		postOrder(this.root);
		System.out.println("END OF TREE\n");
	}

	public boolean postOrder(Node<T> node){
		if(node == null )
			return true;
		postOrder(node.left());
		postOrder(node.right());
		visit(node);
		return true;
	}

	public void preOrder(){
		System.out.println("Pre Order Traversal");
		preOrder(this.root);
		System.out.println("END OF TREE\n");
	}

	public boolean preOrder(Node<T> node){
		if(node == null )
			return true;
		visit(node);
		preOrder(node.left());
		preOrder(node.right());
		return true;
	}

	public void visit(Node<T> node){
		System.out.println(node.data());
	}


	public Node findNode(Node node,T t){
		if(node.data() == t)
			return node;
		else if(node.left() != null)
			return findNode(node.left(),t);
		else if(node.right() != null)
			return findNode(node.right(),t);
		return null;
	}


	public boolean insertNode(T data){
		if(isEmpty()){
			root = new Node(data);
			return true;
		}
		return insertNode(this.root,data);
	}

	private boolean insertNode(Node<T> root, T data){
		if(data.compareTo(root.data()) < 0){
			if(root.left() == null){
				root.setLeft(new Node(data));
				return true;
			}
			else
				return insertNode(root.left(), data);
		}
		else if(data.compareTo(root.data()) >= 0){
			if(root.right() == null){
				root.setRight(new Node(data));
				return true;
			}
			else
				return insertNode(root.right(), data);
		}
		return false;
	}


}


