public class Node<T extends Comparable> {
	private Node left;
	private Node right;
	private T word;

	public Node(T t){
		word = t;
		left = right = null;
	}


	public Word data(){
		return (Word) word;
	}

	public void setData(T data){
		word = data;
	}

	public Node left(){
		return left;
	}

	public Node right(){
		return right;
	}

	public void clear(){
		left = null;
		right = null;
	}
	public void clearRight(){
		right.clear();
	}
	public void clearLeft(){
		left.clear();
	}

	public void setLeft(Node l){
		this.left = l;
	}

	public void setRight(Node r){
		this.right = r;
	}

	public int compareTo(T w){
		return word.compareTo(w);
	}

	public String toString(){
		return word.toString();
	}


}


