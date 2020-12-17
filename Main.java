/**
 * This program is designed to check if a string is a palindrome.
 * This is the first window that contains drop-down menu and table with palindromes loaded from database.  
 * @author Saule Buhler
 * @version 3.0
 */
package Palindromes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Point;

public class Main extends JFrame
{
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Palindrome Checker");
	private JTable table;
	private JRadioButton enableRadioButton;
	private JLabel lblNewLabel_2;
	private JComboBox<String> comboBox;
	private JButton btnNewButton;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					//main frame
					Main frame = new Main();
					int frameWidth = 560;
				    int frameHeight = 500;
				    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				    frame.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
				    frame.setVisible(true);
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Main() 
	{
		//main frame design 
		setForeground(Color.MAGENTA);
		setFont(new Font("Chalkduster", Font.BOLD | Font.ITALIC, 20));
		setBackground(new Color(255, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		setContentPane(contentPane);
		
		//Drop-down menu design
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Chalkduster", Font.BOLD, 15));
		comboBox.addItem("1 Palindrome");
		comboBox.addItem("2 Palindromes");
		comboBox.addItem("3 Palindromes");
		comboBox.addItem("4 Palindromes");
		comboBox.addItem("5 Palindromes");
		comboBox.setSelectedItem(null);
		comboBox.getSelectedItem();
		comboBox.setBounds(310, 354, 230, 30);
		comboBox.setForeground(new Color(128, 0, 128));
		contentPane.add(comboBox);
		
		//choose number of pals label
		JLabel lblNewLabel_1 = new JLabel("Choose number of palindromes");
		lblNewLabel_1.setFont(new Font("Chalkduster", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setBounds(28, 353, 277, 30);
		contentPane.add(lblNewLabel_1);
		
		//ok button
		btnNewButton = new JButton("OK");
		btnNewButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton.setBorder(new EmptyBorder(1, 1, 1, 1));
		btnNewButton.setBackground(new Color(255, 0, 255));
		btnNewButton.setFont(new Font("Chalkduster", Font.BOLD, 15));
		
		/* when you check the radiobutton, comboBox and ok button
		 * gets disabled and load data button appears
		 */
		//radio button to load data from database
		enableRadioButton = new JRadioButton("Use default value");
		enableRadioButton.setFont(new Font("Chalkduster", Font.BOLD, 15));
		enableRadioButton.setBounds(28, 321, 213, 30);
		enableRadioButton.setVerticalAlignment(SwingConstants.TOP);
		enableRadioButton.setForeground(new Color(128, 0, 128));
		enableRadioButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(enableRadioButton.isSelected() == true) 
				{
					comboBox.setEnabled(false);
					btnNewButton.setEnabled(false);
					
					//this button is not appearing automatically, click on the screen
					JButton tableBtn = new JButton("Load Data");
					Image img_3 = new ImageIcon(this.getClass().getResource("/data-icon.png")).getImage();
					tableBtn.setIcon(new ImageIcon(img_3));
					tableBtn.setForeground(new Color(128, 0, 128));
					tableBtn.setFont(new Font("Chalkduster", Font.BOLD, 15));
			        tableBtn.addActionListener(new ActionListener()
			        {
			        	String phrase = "";
						@Override
						public void actionPerformed(ActionEvent e)
						{
							/* After load data button clicked this table will be displayed
							 * with palindromes that exist in Database
							 */
							DefaultTableModel model = new DefaultTableModel(new String[] {"Palindromes"}, 0);  
							table = new JTable();
							table.setGridColor(new Color(165, 42, 42));
							table.setSelectionBackground(new Color(75, 0, 130));
							table.setFont(new Font("Chalkduster", Font.BOLD, 15));
							table.setBackground(new Color(221, 160, 221));
							table.setAlignmentY(Component.BOTTOM_ALIGNMENT);
							table.setAlignmentX(Component.RIGHT_ALIGNMENT);
							table.setModel(model);
							table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
							table.setFillsViewportHeight(true);
							table.setVisible(true);
							JScrollPane scrollPane = new JScrollPane();
							scrollPane.setForeground(new Color(0, 0, 0));
							scrollPane.setFont(new Font("Chalkduster", Font.BOLD, 15));
							scrollPane.setBackground(new Color(221, 160, 221));
							scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
							scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
							scrollPane.setBounds(28, 11, 512, 298);
							contentPane.add(scrollPane);
							scrollPane.setViewportView(table);
							
							//mysql connection start
							//config error for timezone, now it's working 
							String connectionString = "jdbc:mysql://localhost/palindromes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
							String dbLogin = "javauser2";
							String dbPassword = "j4v4us3r?";
			    			
							String sql = "SELECT * FROM PALINDROME";
			    		
							Connection conn = null;
			    				try 
			    				{
			    					conn = DriverManager.getConnection(connectionString, dbLogin, dbPassword);
			    					if (conn != null) 
			    					{
			    						//System.out.println("Database connection successful.");
			    						Statement stmt = conn.createStatement();
			    						ResultSet rs = stmt.executeQuery(sql);
			    						while (rs.next()) 
			    						{
			    							phrase = rs.getString("phrase");
			    							model.addRow(new Object[]{phrase});
			    						}
			    					}
			    				}
			    				catch (Exception i) 
			    				{
			    					System.out.println("Database connection failed.");
			    					i.printStackTrace();
			    				}
			    				//mysql connection ends 
							}
			        	});
			        	tableBtn.setBounds(310, 314, 150, 40);
			        	tableBtn.setVisible(true);
			        	contentPane.add(tableBtn);
				}
				else 
				{
					comboBox.setEnabled(true);
					btnNewButton.setEnabled(true);
				}
			}
		});
		contentPane.add(enableRadioButton);
		
		//ok button
		Image img = new ImageIcon(this.getClass().getResource("/ok-2-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBounds(310, 392, 110, 50);
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.addActionListener(new ActionListener() 
		{
			/* If ok button clicked without comboBox or radioButton selected
			 * error message will be displayed. if number of pals picked and button clicked
			 * comboBox value will be passed to Palindrome class
			 */
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(comboBox.getSelectedIndex() == -1 && enableRadioButton.isSelected() == false)
				{
					JFrame frame = new JFrame("Error message");
					JOptionPane.showMessageDialog(frame,
					        "Pick from drop-down menu or select default value",
					        getTitle(), JOptionPane.INFORMATION_MESSAGE, null);
				}
				else if(enableRadioButton.isSelected() == false)
				{
					comboBox.setEnabled(true);
					Palindrome p = new Palindrome((String) comboBox.getSelectedItem());
					p.userPal();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		lblNewLabel.setFont(new Font("Chalkduster", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 6, 440, 30);
		lblNewLabel.setForeground(new Color(128, 0, 128));
		contentPane.add(lblNewLabel);
		
		//big palindrome image
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/palindrome.png")).getImage().getScaledInstance(512, 275, Image.SCALE_SMOOTH)));
		lblNewLabel_2.setBounds(28, 34, 512, 275);
		contentPane.add(lblNewLabel_2);
		
	}
}
