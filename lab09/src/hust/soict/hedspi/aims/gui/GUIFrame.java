package hust.soict.hedspi.aims.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFrame extends JFrame{
	private JButton exitButton;
	public GUIFrame() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setResizable(false);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 600))/2;
		int y = (int) ((dimension.getHeight() - 400))/2;
		setLocation(x, y);
		setVisible(true);
	}
	public void addExitButton() {
		exitButton = new JButton("Exit");
		exitButton.setSize(100, 40);
		exitButton.setLocation(500,330);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		add(exitButton);
	}
	
//	public void addJLabel(String title, int width, int height) {
//		JLabel label = new JLabel(title);
//		label.setLocation(width,height);
//		this.add(label);
//	}
//	public JButton addJButton(String title, int width, int height) {
//		JButton button = new JButton(title);
//		button.setLocation(width,height);
//		this.add(button);
//		return button;
//	}
//	public JTextField addJText(String title, int width, int height) {
//		JTextField textField = new JTextField(title);
//		textField.setLocation(width,height);
//		this.add(textField);
//		return textField;
//	}
}
