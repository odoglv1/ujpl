package com.odoglv1.UJPL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8116841033060203220L;
	private JPanel contentPane;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					About frame = new About();
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
	public About() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/com/odoglv1/UJPL/UJPL Logo.jpg")));
		setTitle("UJPL - About");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 424);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(205, 372, 89, 23);
		contentPane.add(btnOk);
		
		JTextPane txtpnUjpl = new JTextPane();
		txtpnUjpl.setBounds(-1, 311, 295, 53);
		JScrollPane scroll = new JScrollPane(txtpnUjpl, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		txtpnUjpl.setEditable(false);
		txtpnUjpl.setText("UJPL - The Universal Java-Based Programming Language.\r\nCopyleft Odoglv1 2016-2017.\r\nIcon by Odoglv1.");
		scroll.setBounds(-1, 311, 295, 53);
		contentPane.add(scroll);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 300, 300);
		contentPane.add(label);
		label.setIcon(new ImageIcon(About.class.getResource("/com/odoglv1/UJPL/UJPL Logo.jpg")));
	}
}