import javax.swing.JFrame;

public class BSTreeMain {
	private BSTree tree;

	public static void main(String args[]) // Runs JFrame with panels
	{
		final BSTree tree = new BSTree();
		tree.insertNode("bacon");
		tree.insertNode("potato");
		tree.insertNode("banana");
		tree.insertNode("cow");
		tree.insertNode("moo");
		tree.postOrder();
		tree.preOrder();
	}
}



