import java.util.*;
import java.math.*;
import java.io.*;

public class BSTree<T extends Comparable>{
	private Node<Word> root;
	private OutputPanel out;

	public BSTree( OutputPanel out){
		this.root = null;
		this.out = out;
	}

	public Node root(){
		return root;
	}

	public boolean isEmpty(){
		if(root == null)
			return true;
		return false;
	}

	public int height(){
		return height(root);
	}
	public int height(Node node){
		if(node == null)
			return -1;

		int left = height(node.left());
		int right = height(node.right());

		if(left > right)
			return left + 1;
		else
			return right +1;
	}

	public ArrayList returnTree() 
	{

		if(isEmpty())
			return null;

		ArrayList<Node<Word>> list1 = levelOrderTraversal(root);
		ArrayList<Word> list2 = new ArrayList<Word>();

		for(int i=0;i < list1.size();i++)
		{
			if(list1.get(i) != null)
			{
				list2.add(list1.get(i).data());
			}
			else
			{
				list2.add(null);
			}
		}
		return list2;

	}


	private ArrayList<Node<Word>> levelOrderTraversal(Node<Word> rt)
	{
		int index = 0;
		ArrayList<Node<Word>> nodes, result;
		nodes = new ArrayList<Node<Word>>();
		result = new ArrayList<Node<Word>>();
		Node<Word> current = rt;
		nodes.add(current);

		while (index < Math.pow(2,height()+1)-1)
		{
			current = (Node<Word>) nodes.get(index);

			if(current != null)
			{
				nodes.add(current.left());
				nodes.add(current.right());
				result.add(current);
			}
			else
			{
				nodes.add(null);
				nodes.add(null);
				result.add(null);
			}
			index++;
		}
		return result;
	}

	public int countNodes(){
		return countNodes(root);
	}

	public boolean delete(Word t){
		Node temp;
		Node ptr = findNode(t);
		if(ptr == null)
			return false;
		if(ptr.left() == null){
			ptr.setData(ptr.right().data());
			ptr.setRight(ptr.right().right());
			ptr.setLeft(ptr.right().left());
			return true;
		}
		else if(ptr.right() == null){
			ptr.setData(ptr.left().data());
			ptr.setLeft(ptr.left().left());
			ptr.setRight(ptr.left().right());
			return true;
		}
		else{
			temp = ptr.right();
			while(temp.left() != null){
				temp = temp.left();
			}
			ptr.setData(temp.data());
			ptr.setRight(temp.right());
			return delete(ptr.right(), temp.data());
		}
	}

	public boolean delete(Node ptr, Word t){
		Node temp;
		if(ptr == null)
			return false;
		if(ptr.left() == null){
			ptr.setData(ptr.right().data());
			ptr.setRight(ptr.right().right());
			ptr.setLeft(ptr.right().left());
			return true;
		}
		else if(ptr.right() == null){
			ptr.setData(ptr.left().data());
			ptr.setLeft(ptr.left().right());
			ptr.setRight(ptr.left().right());
			return true;
		}
		else{
			temp = ptr.right();
			while(temp.left() != null)
				temp = temp.left();
			ptr.setData(temp.data());
			ptr.setRight(temp.right());
			return delete(ptr.right(), temp.data());
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
		out.clear();
		System.out.println("Post Order Traversal");
		postOrder(this.root);
		System.out.println("END OF TREE\n");
	}

	public boolean postOrder(Node node){
		if(node == null )
			return true;
		postOrder(node.left());
		postOrder(node.right());
		visit(node);
		return true;
	}

	public boolean clearOrder(){
		Node node = root;
		out.clear();
		clearOrder(node.left());
		clearOrder(node.right());
		clear(node);
		return true;
	}
	public boolean clearOrder(Node node){
		clearOrder(node.left());
		clearOrder(node.right());
		clear(node);
		return true;
	}

	public void clear(Node node){
		node.clear();
	}

	public void clear(){
		root = null;
	}

	public Node findMin(){
		return findMin(root);
	}

	public Node findMin(Node node){
		if(node.left() == null)
			return node;
		else
			return findMin(node.left());
	}

	public void preOrder(){
		out.clear();
		System.out.println("Pre Order Traversal");
		preOrder(this.root);
		System.out.println("END OF TREE\n");
	}

	public boolean preOrder(Node<Word> node){
		if(node == null )
			return true;
		visit(node);
		preOrder(node.left());
		preOrder(node.right());
		return true;
	}

	public void inOrder(){
		out.clear();
		System.out.println("In Order Traversal");
		inOrder(this.root);
		System.out.println("END OF TREE\n");
	}

	public boolean inOrder(Node<Word> node){
		if(node == null )
			return true;
		inOrder(node.left());
		visit(node);
		inOrder(node.right());
		return true;
	}

	public void visit(Node<Word> node){
		System.out.println(node.data());
		out.setOutput(node.data().toString());
	}

	public Node findNode(Word word){
		return findNode(root,word);

	}

	public Node findNode(Node node, Word t){
		if(node == null)
			return null;
		if(node.data().compareTo(t) == 0){
			System.out.println("Found");
			return node;
		}
		else if(node.compareTo(t) > 0)
			return findNode(node.left(), t);
		else if(node.compareTo(t) < 0)
			return findNode(node.right(), t);
		return null;
	}

	public boolean insertFromInput(){
		return insertNode(this.root,out.getWord());
	}
	public boolean deleteFromInput(){
		return delete(out.getWord());
	}


	public boolean insertNode(Word data){
		if(isEmpty()){
			root = new Node(data);
			return true;
		}
		return insertNode(this.root,data);
	}

	private boolean insertNode(Node<Word> root, Word word){
		if(word.compareTo(root.data()) < 0){
			if(root.left() == null){
				root.setLeft(new Node(word));
				return true;
			}
			else
				return insertNode(root.left(), word);
		}
		else if(word.compareTo(root.data()) >= 0){
			if(root.right() == null){
				root.setRight(new Node(word));
				return true;
			}
			else
				return insertNode(root.right(), word);
		}
		return false;
	}



}


