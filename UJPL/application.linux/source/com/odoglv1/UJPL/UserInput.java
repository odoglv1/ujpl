package com.odoglv1.UJPL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInput extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3053504335364014072L;
	private JPanel contentPane;
	public static JTextField textField;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserInput frame = new UserInput();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UserInput() {
		super();
		setAlwaysOnTop(true);
		setModal(true);
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("User Input");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 96);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UJPL.mostRecentInput = textField.getText();
				dispose();
			}
		});
		btnOk.setBounds(355, 45, 89, 23);
		contentPane.add(btnOk);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 424, 23);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
