
import java.util.List;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.*;


public class LogPanel extends JPanel{
	private JTextArea output;
	private BufferedImage plane;
	private BufferedImage img;
	private JPanel welcomePanel;
	private InputPanel inputPanel;

	public LogPanel(){
		setLayout(new BorderLayout());
		plane = load_image("plane.jpg");
		output = new JTextArea();
		inputPanel = new InputPanel();
		welcomePanel = new WelcomePanel();
		JScrollPane scrollPane = new JScrollPane(output);
		add(welcomePanel, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);
		add(inputPanel, BorderLayout.PAGE_END);
	}
	public void setOutPut2 (String data) {String temp = output.getText() + "\n\r"; output.setText( temp + data );}
	public void clear(){
		output.setText("");
	}
	public String getText(){
		return inputPanel.getText();
	}

	public BufferedImage load_image(String path){
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			return null;
		}
		return img;
	}
	public void paintComponent(Graphics g) {
		g.drawImage(plane,  0, 0, null);
	}


}


class WelcomePanel extends JPanel{
	private JLabel welcomeLabel;

	public WelcomePanel(){
		setLayout(new FlowLayout());
		welcomeLabel = new JLabel("Welcome to BSTree Simulation");
		add(welcomeLabel);
	} 
} 

