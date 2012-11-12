public class Node<T extends Comparable>{
	private Node left;
	private Node right;
	private T data;

	public Node(T t){
		data = t;
		left = right = null;
	}


	public T data(){
		return data;
	}

	public Node left(){
		return left;
	}

	public Node right(){
		return right;
	}

	public void setLeft(Node l){
		this.left = l;
	}

	public void setRight(Node r){
		this.right = r;
	}



}


