package com.odoglv1.UJPL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UJPL extends JFrame {

	/**
	 * Initialize variables and the serialVersionUID.
	 */
	private static final long serialVersionUID = -7305914329606587459L;
	private JPanel contentPane;
	private static UJPL frame;
	private boolean editedYet = false;
	private int i = 0;
	private boolean running = false;
	private boolean truthVar = false;
	public static String mostRecentInput = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UJPL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UJPL() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				if (editedYet) {
					int j = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit? You haven't yet saved the document you're working on!", "UJPL", JOptionPane.YES_NO_OPTION);
					if (j == JOptionPane.YES_OPTION) {
						
					}
					else {
						frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					}
				}
				else {
					
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(UJPL.class.getResource("/com/odoglv1/UJPL/UJPL Logo.jpg")));
		setTitle("UJPL v1.1 - New File");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenu mnCompile = new JMenu("Compile");
		menuBar.add(mnCompile);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new About().setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Syntax");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Syntax().setVisible(true);
			}
		});
		mnHelp.add(mntmNewMenuItem);
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if (!editedYet) {
					editedYet = true;
					frame.setTitle(frame.getTitle() + "*");
				}
				if (editedYet) {
					
				}
			}
		});
		editorPane.setFont(new Font("Courier New", Font.PLAIN, 16));
		JScrollPane scrollBar = new JScrollPane(editorPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollBar, BorderLayout.CENTER);
		//contentPane.add(editorPane, BorderLayout.CENTER);
		
		JMenuItem mntmRun = new JMenuItem("Run");
		mntmRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				running = true;
				editorPane.setEditable(false);
				editorPane.setEnabled(false);
				try {
					String[] lineByLine = editorPane.getText().split("\n");
					while (i <= lineByLine.length && running) {
						String[] fullArray = lineByLine[i].toString().split(";");
						if (fullArray[0].equals("if")) {
							if (fullArray[2].equals(">")) {
								if (Integer.parseInt(fullArray[1]) > Integer.parseInt(fullArray[3])) {
									truthVar = true;
									System.out.println("truthVar is now TRUE");
								}
								else {
									truthVar = false;
									System.out.println("truthVar is now FALSE");
								}
							}
							if (fullArray[2].equals("==")) {
								if (Integer.parseInt(fullArray[1]) == Integer.parseInt(fullArray[3])) {
									truthVar = true;
									System.out.println("truthVar is now TRUE");
								}
								else {
									truthVar = false;
									System.out.println("truthVar is now FALSE");
								}
							}
							if (fullArray[2].equals("<")) {
								if (Integer.parseInt(fullArray[1]) < Integer.parseInt(fullArray[3])) {
									truthVar = true;
									System.out.println("truthVar is now TRUE");
								}
								else {
									truthVar = false;
									System.out.println("truthVar is now FALSE");
								}
							}
							
							if (fullArray[2].equals("str==")) {
								if (fullArray[1].toString().equals(fullArray[3].toString())) {
									truthVar = true;
									System.out.println("truthVar is now TRUE");
								}
								else {
									truthVar = false;
									System.out.println("truthVar is now FALSE");
								}
							}
						}
						if (fullArray[0].equals("true")) {
							if (truthVar) {
								for (int xyz = 0; xyz<fullArray.length; xyz++) {
									if (xyz == 0) {
										fullArray[xyz] = "";
									}
									else {
										fullArray[xyz-1] = fullArray[xyz];
									}
									
									if (xyz == fullArray.length) {
										i--;
										break;
									}
								}
							}
							else {
								//i++;
							}
						}
						if (fullArray[0].equals("false")) {
							if (!truthVar) {
								for (int xyz = 0; xyz<fullArray.length; xyz++) {
									if (xyz == 0) {
										fullArray[xyz] = "";
									}
									else {
										fullArray[xyz-1] = fullArray[xyz];
									}
									
									if (xyz == fullArray.length) {
										i--;
										break;
									}
								}
							}
							else {
								//i++;
							}
						}
						if (fullArray[0].equals("return")) {
							i = Integer.parseInt(fullArray[1]);
							actionPerformed(e);
						}
						if (fullArray[0].equals("close")) {
							System.exit(0);
						}
						if (fullArray[0].equals("sound")) {
							if (fullArray[1].equals("tone")) {
								try {
									Clip clip = AudioSystem.getClip();
									AudioInputStream ain = AudioSystem.getAudioInputStream(UJPL.class.getResource("A-Tone.wav"));
									clip.open(ain);
									clip.start();
									if (fullArray[2].equals("wait")) {
										java.lang.Thread.sleep(clip.getMicrosecondLength() / 1000);
									}
									else {
										
									}
								} catch (Exception exce) {
									//exce.printStackTrace();
								}
							}
						}
						if (fullArray[0].equals("add")) {
							 JOptionPane.showMessageDialog(null, Integer.parseInt(fullArray[1]) + Integer.parseInt(fullArray[2]), "Addition Result", JOptionPane.PLAIN_MESSAGE);
						}
						if (fullArray[0].equals("sub")) {
							 JOptionPane.showMessageDialog(null, Integer.parseInt(fullArray[1]) - Integer.parseInt(fullArray[2]), "Subtraction Result", JOptionPane.PLAIN_MESSAGE);
						}
						if (fullArray[0].equals("mul")) {
							 JOptionPane.showMessageDialog(null, Integer.parseInt(fullArray[1]) * Integer.parseInt(fullArray[2]), "Multiplication Result", JOptionPane.PLAIN_MESSAGE);
						}
						if (fullArray[0].equals("div")) {
							 JOptionPane.showMessageDialog(null, Integer.parseInt(fullArray[1]) / Integer.parseInt(fullArray[2]), "Division Result", JOptionPane.PLAIN_MESSAGE);
						}
						if (fullArray[0].equals("wait")) {
							java.lang.Thread.currentThread();
							Thread.sleep(Long.parseLong(fullArray[1]) * 1000);
						}
						if (fullArray[0].equals("n")) {
							
						}
						if (fullArray[0].equals("note")) {
							
						}
						if (fullArray[0].equals("say")) {
							if (fullArray[1].contains("UJPL.mostRecentInput") && !fullArray[2].contains("UJPL.mostRecentInput")) {
								String newFullArray1 = fullArray[1].replace("UJPL.mostRecentInput", mostRecentInput);
								JOptionPane.showMessageDialog(null, newFullArray1, fullArray[2], JOptionPane.PLAIN_MESSAGE);
							}
							if (!fullArray[1].contains("UJPL.mostRecentInput") && fullArray[2].contains("UJPL.mostRecentInput")) {
								String newFullArray2 = fullArray[2].replace("UJPL.mostRecentInput", mostRecentInput);
								JOptionPane.showMessageDialog(null, fullArray[1], newFullArray2, JOptionPane.PLAIN_MESSAGE);
							}
							if (fullArray[1].contains("UJPL.mostRecentInput") && fullArray[2].contains("UJPL.mostRecentInput")) {
								String newFullArray1 = fullArray[1].replace("UJPL.mostRecentInput", mostRecentInput);
								String newFullArray2 = fullArray[2].replace("UJPL.mostRecentInput", mostRecentInput);
								JOptionPane.showMessageDialog(null, newFullArray1, newFullArray2, JOptionPane.PLAIN_MESSAGE);
							}
							if (!fullArray[1].contains("UJPL.mostRecentInput") && !fullArray[2].contains("UJPL.mostRecentInput")) {
								JOptionPane.showMessageDialog(null, fullArray[1], fullArray[2], JOptionPane.PLAIN_MESSAGE);
							}
						}
						if (fullArray[0].equals("getUserInput")) {
							new UserInput().setVisible(true);
						}
						else {
							//Activates at end of file
						}
						i++;
					}
				} catch (Exception exce) {
					//Activates at end of file
				}
				editorPane.setEditable(true);
				editorPane.setEnabled(true);
				running = false;
				i = 0;
			}
		});
		mnCompile.add(mntmRun);
		
		JMenuItem mntmStopExecution = new JMenuItem("Stop Execution");
		mntmStopExecution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				running = false;
				editorPane.setEditable(true);
				editorPane.setEnabled(true);
				i = 0;
			}
		});
		mnCompile.add(mntmStopExecution);
		
		JMenuItem mntmNewDocument = new JMenuItem("New Document");
		mntmNewDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!editedYet) {
					editorPane.setText("");
					frame.setTitle("UJPL v1.1 - New File");
				}
				else {
					int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to open a new document? You haven't yet saved the one you're working on!", "UJPL", JOptionPane.YES_NO_OPTION);
					if (x == JOptionPane.YES_OPTION) {
						editorPane.setText("");
						editedYet = false;
						frame.setTitle("UJPL v1.1 - New File");
					}
					else {
						
					}
				}
			}
		});
		mnFile.add(mntmNewDocument);
		
		JMenuItem mntmOpenDocument = new JMenuItem("Open Document");
		mntmOpenDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser c = new JFileChooser();
				c.setFileFilter(new FileNameExtensionFilter("UJPL File", "ujp"));
			      // Demonstrate "Open" dialog:
			      int rVal = c.showOpenDialog(UJPL.this);
			      if (rVal == JFileChooser.APPROVE_OPTION) {
			    	  if (c.getSelectedFile().getName().endsWith(".ujp")) {
			    		  try {
				    		  editorPane.setText("");
				    		  String line = null;
				    		  
				              // FileReader reads text files in the default encoding.
				              FileReader fileReader = 
				                  new FileReader(c.getSelectedFile().getAbsolutePath());

				              // Always wrap FileReader in BufferedReader.
				              BufferedReader bufferedReader = 
				                  new BufferedReader(fileReader);

				              while((line = bufferedReader.readLine()) != null) {
				                  if (editorPane.getText().equals("")) {
				                	  editorPane.setText(editorPane.getText() + line);
				                  }
				                  else if (!(editorPane.getText().equals(""))) {
				                	  editorPane.setText(editorPane.getText() + "\n" + line);
				                  }
				              }
				              
				              editedYet = false;
				              frame.setTitle("UJPL v1.1 - " + c.getSelectedFile().getAbsolutePath().toString());
				              // Always close files.
				              bufferedReader.close();         
				          }
				          catch(Exception exceptionA) {
				        	  JOptionPane.showMessageDialog(null, "There was an error opening the file.", "UJPL Error", JOptionPane.ERROR_MESSAGE);
				          }
			    	  }
			    	  else {
			    		  JOptionPane.showMessageDialog(null, "You can't open non-UJPL Files!", "UJPL Error", JOptionPane.ERROR_MESSAGE);
			    	  }
			      }
			      if (rVal == JFileChooser.CANCEL_OPTION) {
			    	  
			      }
			}
		});
		mnFile.add(mntmOpenDocument);
		
		JMenuItem mntmSaveCurrentDocument = new JMenuItem("Save Document");
		mntmSaveCurrentDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser c = new JFileChooser();
				c.setFileFilter(new FileNameExtensionFilter("UJPL File", "ujp"));
			      // Demonstrate "Save" dialog:
			      int rVal = c.showSaveDialog(UJPL.this);
			      if (rVal == JFileChooser.APPROVE_OPTION) {
			    	  if (c.getSelectedFile().getName().endsWith(".ujp")) {
			    		  try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				                  new FileOutputStream(c.getSelectedFile().getAbsolutePath()), "utf-8"))) {
				    		  writer.write(editorPane.getText());
				    		  
				    		  editedYet = false;
					    	  frame.setTitle("UJPL v1.1 - " + c.getSelectedFile().getAbsolutePath().toString());
				    	  } catch (Exception exception) {
				    		  JOptionPane.showMessageDialog(null, "There was an error saving the file.", "UJPL Error", JOptionPane.ERROR_MESSAGE);
				    	  }
			    	  }
			    	  else {
			    		  try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				                  new FileOutputStream(c.getSelectedFile().getAbsolutePath() + ".ujp"), "utf-8"))) {
				    		  writer.write(editorPane.getText());
				    		  
				    		  editedYet = false;
					    	  frame.setTitle("UJPL v1.1 - " + c.getSelectedFile().getAbsolutePath().toString() + ".ujp");
				    	  } catch (Exception exception) {
				    		  JOptionPane.showMessageDialog(null, "There was an error saving the file.", "UJPL Error", JOptionPane.ERROR_MESSAGE);
				    	  }
			    	  }
			      }
			      if (rVal == JFileChooser.CANCEL_OPTION) {
			        
			      }
			}
		});
		mnFile.add(mntmSaveCurrentDocument);
		mnFile.add(mntmExit);
	}
}