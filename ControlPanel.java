import javax.swing.JFrame;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	private JButton exit;
	private JButton help;
	private JButton clear; 
	private JButton postOrder;
	private JButton preOrder;
	private JButton inOrder;
	private JButton insert;
	private JButton delete;
	private LogPanel output;
	private ButtonHandler buttonHandler;
	private BSTree tree; 

	public ControlPanel(BSTree tree)
	{
		this.tree = tree;
		setLayout(new FlowLayout());
		buttonHandler = new ButtonHandler();

		insert= new JButton("insert");
		insert.addActionListener(buttonHandler);
		delete= new JButton("delete");
		delete.addActionListener(buttonHandler);

		inOrder = new JButton("inOrder");
		inOrder.addActionListener(buttonHandler);
		preOrder = new JButton("preOrder");
		preOrder.addActionListener(buttonHandler);
		postOrder = new JButton("postOrder");
		postOrder.addActionListener(buttonHandler);
		clear = new JButton("clear");
		clear.addActionListener(buttonHandler);

		help = new JButton("HELP");
		help.addActionListener(buttonHandler);

		exit = new JButton("EXIT");
		exit.addActionListener(buttonHandler);

		add(insert);
		add(delete);
		add(postOrder);
		add(preOrder);
		add(inOrder);
		add(clear);
		add(help);
		add(exit);

	}





	/****************************************************************************
	 * Listener class for buttons
	 ****************************************************************************/
	class ButtonHandler implements ActionListener{ // button listener, on click event handlers

		public ButtonHandler(){}

		public void actionPerformed(ActionEvent e)
		{
			if (e.getActionCommand().equals("postOrder")){
				tree.postOrder();	
			}
			else if (e.getActionCommand().equals("insert")){
				tree.insertFromInput();
			}
			else if (e.getActionCommand().equals("delete")){
				tree.deleteFromInput();
			}
			else if (e.getActionCommand().equals("inOrder")){
				tree.inOrder();
			}
			else if (e.getActionCommand().equals("preOrder")){
				tree.preOrder();
			}
			else if (e.getActionCommand().equals("HELP")){
				JOptionPane.showMessageDialog(null, "Select a DEPARTURE and DESTINATION city and press FIND FLIGHT" ,"Help",JOptionPane.PLAIN_MESSAGE); 
			}
			else if (e.getActionCommand().equals("EXIT")){
				System.exit(0);
			}		
		}
	}
}
