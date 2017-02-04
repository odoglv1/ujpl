package com.odoglv1.UJPL;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Syntax extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 997824452657735111L;
	private JPanel contentPane;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Syntax frame = new Syntax();
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
	public Syntax() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Syntax.class.getResource("/com/odoglv1/UJPL/UJPL Logo.jpg")));
		setTitle("UJPL Syntax");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextPane txtpnSyntaxSaymessagetitleCreates = new JTextPane();
		txtpnSyntaxSaymessagetitleCreates.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSyntaxSaymessagetitleCreates.setEditable(false);
		txtpnSyntaxSaymessagetitleCreates.setText("Syntax:\r\n\r\nsay;MESSAGE;TITLE;\r\nCreates a message box with your input.\r\n\r\nadd;NUMBER1;NUMBER2;\r\nAdds NUMBER1 and NUMBER2 and prints the result in a message box.\r\n\r\nsub;NUMBER1;NUMBER2;\r\nSubtracts NUMBER1 and NUMBER2 and prints the result in a message box.\r\n\r\nmul;NUMBER1;NUMBER2;\r\nMultiplies NUMBER1 and NUMBER2 and prints the result in a message box.\r\n\r\ndiv;NUMBER1;NUMBER2;\r\nDivides NUMBER1 and NUMBER2 and prints the result in a message box.\r\n\r\nsound;tone;wait;\r\nPlays a tone. If you add wait; to the to the end of the command, then UJPL will wait for the sound to finish before moving to the next line.\r\n\r\nwait;SECONDS;\r\nWaits for a specified number of seconds before resuming execution.\r\n\r\nreturn;LINENUMBER;\r\nReturns to the specified line number during execution. Line numbering begins at 0, so the first line is 0, and the second line is 1, etc.\r\n\r\ngetUserInput;\r\nCreates a pop-up window that can be used to retrieve user input.\r\n\r\nclose;\r\nCloses UJPL.\r\n\r\nn;\r\nIgnores the rest of the line, so it can be used for commenting.\r\n\r\nnote;\r\nIgnores the rest of the line, so it can be used for commenting.\r\n\r\nNotes on User Input:\r\nAfter using the getUserInput; command, in the say; command, you can replace any part of MESSAGE and TITLE with UJPL.mostRecentInput to get the user's most recent input. Keep in mind, however, that if you did not use the getUserInput; command prior to referencing UJPL.mostRecentInput, the say; command will not run.");
		JScrollPane scroll = new JScrollPane(txtpnSyntaxSaymessagetitleCreates, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//scroll.setWheelScrollingEnabled(true);
		//contentPane.add(txtpnSyntaxSaymessagetitleCreates, BorderLayout.CENTER);
		contentPane.add(scroll, BorderLayout.CENTER);
	}
}