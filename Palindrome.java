/**
 * This program is designed to check if a string is a palindrome.
 * This is the second window that contains text fields to process strings   
 * @author Saule Buhler
 * @version 3.0
 */
package Palindromes;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class Palindrome extends JFrame
{
	protected static final String String = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	String numPal;
	private JTextField textField_5;
	
	public void userPal() 
	{
		//main frame and it's design
		int frameWidth = 560;
		int frameHeight = 700;
		Palindrome frame = new Palindrome(numPal);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setVisible(true);
		setForeground(Color.MAGENTA);
		setFont(new Font("Chalkduster", Font.BOLD | Font.ITALIC, 20));
		setBackground(new Color(255, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 560, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}
	//get number of palindromes
	public String getNumPalindrome() 
	{
		return numPal;
	}
	
	public Palindrome(String pal) 
	{
		//panel design
		getContentPane().setForeground(new Color(128, 0, 128));
		getContentPane().setFont(new Font("Chalkboard", Font.BOLD | Font.ITALIC, 15));
		getContentPane().setBackground(new Color(255, 240, 245));
		setType(Type.POPUP);
		setForeground(Color.MAGENTA);
		setBackground(Color.MAGENTA);
		setFont(new Font("Chalkduster", Font.BOLD | Font.ITALIC, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.numPal = pal; //<-- set number of palindromes passed from the main class
		
		//main label
		JLabel lblNewLabel = new JLabel("Is it palindrome?");
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("Chalkduster", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(76, 6, 440, 30);
		getContentPane().add(lblNewLabel);
		
		/* depending how many palindromes user picked in main class
		 * so many testfields will be displayed
		 */
		if(this.numPal == "1 Palindrome") 
		{
			textField_1 = new JTextField();
			textField_1.setBounds(31, 70, 150, 30);
			getContentPane().add(textField_1);
			textField_1.setColumns(10);
		}
		else if(this.numPal == "2 Palindromes") 
		{
			textField_1 = new JTextField();
			textField_1.setBounds(31, 70, 150, 30);
			getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(31, 105, 150, 30);
			getContentPane().add(textField_2);
			textField_2.setColumns(10);
		}
		else if(this.numPal == "3 Palindromes") 
		{
			textField_1 = new JTextField();
			textField_1.setBounds(31, 70, 150, 30);
			getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(31, 105, 150, 30);
			getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(31, 140, 150, 30);
			getContentPane().add(textField_3);
			textField_3.setColumns(10);
		}
		else if(this.numPal == "4 Palindromes") 
		{
			textField_1 = new JTextField();
			textField_1.setBounds(31, 70, 150, 30);
			getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(31, 105, 150, 30);
			getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(31, 140, 150, 30);
			getContentPane().add(textField_3);
			textField_3.setColumns(10);
		
			textField_4 = new JTextField();
			textField_4.setBounds(31, 175, 150, 30);
			getContentPane().add(textField_4);
			textField_4.setColumns(10);
		}
		else if(this.numPal == "5 Palindromes") 
		{
			textField_1 = new JTextField();
			textField_1.setBounds(31, 70, 150, 30);
			getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(31, 105, 150, 30);
			getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(31, 140, 150, 30);
			getContentPane().add(textField_3);
			textField_3.setColumns(10);
		
			textField_4 = new JTextField();
			textField_4.setBounds(31, 175, 150, 30);
			getContentPane().add(textField_4);
			textField_4.setColumns(10);
		
			textField_5 = new JTextField();
			textField_5.setBounds(31, 215, 150, 30);
			getContentPane().add(textField_5);
			textField_5.setColumns(10);
		}
		
		//check button
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setFont(new Font("Chalkduster", Font.BOLD, 15));
		Image img = new ImageIcon(this.getClass().getResource("/ok-2-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBounds(31, 273, 117, 44);
		btnNewButton.addActionListener(new ActionListener() 
		{
			/* textfields can't be empty, error msg 
			 * if not empty each textfield values will be passed to Pal_string class
			 * processed values will return yes or no message
			 */
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(getNumPalindrome() == "1 Palindrome") 
				{
					if(textField_1.getText() ==  null || textField_1.getText().trim().isEmpty()) 
					{
						JFrame frame = new JFrame("Error message");
						JOptionPane.showMessageDialog(frame,
						        "The field is empty. Please fill it out.",
						        getTitle(), JOptionPane.INFORMATION_MESSAGE, null);
					}
					else 
					{
						Pal_string ps = new Pal_string((String) textField_1.getText());
						JLabel lblNewLabel_1 = new JLabel(ps.getPal_string());
						lblNewLabel_1.setBounds(200, 70, 573, 30);
						getContentPane().add(lblNewLabel_1);
						lblNewLabel_1.setVisible(true);
					}
				}
				else if(getNumPalindrome() == "2 Palindromes")
				{
					if((textField_1.getText() ==  null || textField_1.getText().trim().isEmpty()) || 
							(textField_2.getText() ==  null || textField_2.getText().trim().isEmpty()))
					{
						JFrame frame = new JFrame("Error message");
						JOptionPane.showMessageDialog(frame,
						        "Please fill out the empty fields.",
						        getTitle(), JOptionPane.INFORMATION_MESSAGE, null);
					}
					else 
					{
						Pal_string ps1 = new Pal_string((String) textField_1.getText());
						Pal_string ps2 = new Pal_string((String) textField_2.getText());
						JLabel lblNewLabel_1 = new JLabel(ps1.getPal_string());
						lblNewLabel_1.setBounds(200, 70, 573, 30);
						getContentPane().add(lblNewLabel_1);
						JLabel lblNewLabel_2 = new JLabel(ps1.getPal_string());
						lblNewLabel_2.setBounds(200, 105, 573, 30);
						getContentPane().add(lblNewLabel_2);

					}
				}
				else if(getNumPalindrome() == "3 Palindromes")
				{
					if((textField_1.getText() ==  null || textField_1.getText().trim().isEmpty()) || 
							(textField_2.getText() ==  null || textField_2.getText().trim().isEmpty()) ||
							(textField_3.getText() ==  null || textField_3.getText().trim().isEmpty())) 
					{
						JFrame frame = new JFrame("Error message");
						JOptionPane.showMessageDialog(frame,
						        "Please fill out the empty fields.",
						        getTitle(), JOptionPane.INFORMATION_MESSAGE, null);
					}
					else 
					{
						Pal_string ps1 = new Pal_string((String) textField_1.getText());
						Pal_string ps2 = new Pal_string((String) textField_2.getText());
						Pal_string ps3 = new Pal_string((String) textField_3.getText());
						JLabel lblNewLabel_1 = new JLabel(ps1.getPal_string());
						lblNewLabel_1.setBounds(200, 70, 573, 30);
						getContentPane().add(lblNewLabel_1);
						JLabel lblNewLabel_2 = new JLabel(ps2.getPal_string());
						lblNewLabel_2.setBounds(200, 105, 573, 30);
						getContentPane().add(lblNewLabel_2);
						JLabel lblNewLabel_3 = new JLabel(ps3.getPal_string());
						lblNewLabel_3.setBounds(200, 140, 573, 30);
						getContentPane().add(lblNewLabel_3);
					}
				}
				else if(getNumPalindrome() == "4 Palindromes")
				{
					if((textField_1.getText() ==  null || textField_1.getText().trim().isEmpty()) || 
							(textField_2.getText() ==  null || textField_2.getText().trim().isEmpty()) ||
							(textField_3.getText() ==  null || textField_3.getText().trim().isEmpty()) ||
							(textField_4.getText() ==  null || textField_4.getText().trim().isEmpty())) 
					{
						JFrame frame = new JFrame("Error message");
						JOptionPane.showMessageDialog(frame,
						        "Please fill out the empty fields.",
						        getTitle(), JOptionPane.INFORMATION_MESSAGE, null);
					}
					else 
					{
						Pal_string ps1 = new Pal_string((String) textField_1.getText());
						Pal_string ps2 = new Pal_string((String) textField_2.getText());
						Pal_string ps3 = new Pal_string((String) textField_3.getText());
						Pal_string ps4 = new Pal_string((String) textField_4.getText());
						JLabel lblNewLabel_1 = new JLabel(ps1.getPal_string());
						lblNewLabel_1.setBounds(200, 70, 573, 30);
						getContentPane().add(lblNewLabel_1);
						JLabel lblNewLabel_2 = new JLabel(ps2.getPal_string());
						lblNewLabel_2.setBounds(200, 105, 573, 30);
						getContentPane().add(lblNewLabel_2);
						JLabel lblNewLabel_3 = new JLabel(ps3.getPal_string());
						lblNewLabel_3.setBounds(200, 140, 573, 30);
						getContentPane().add(lblNewLabel_3);
						JLabel lblNewLabel_4 = new JLabel(ps4.getPal_string());
						lblNewLabel_4.setBounds(200, 175, 573, 30);
						getContentPane().add(lblNewLabel_4);
					}
				}
				else if(getNumPalindrome() == "5 Palindromes")
				{
					if((textField_1.getText() ==  null || textField_1.getText().trim().isEmpty()) || 
							(textField_2.getText() ==  null || textField_2.getText().trim().isEmpty()) ||
							(textField_3.getText() ==  null || textField_3.getText().trim().isEmpty()) ||
							(textField_4.getText() ==  null || textField_4.getText().trim().isEmpty()) ||
							(textField_5.getText() ==  null || textField_5.getText().trim().isEmpty())) 
					{
						JFrame frame = new JFrame("Error message");
						JOptionPane.showMessageDialog(frame,
								"Please, fill out the empty fields",
								getTitle(), JOptionPane.INFORMATION_MESSAGE, null);
					}
					else 
					{
						Pal_string ps1 = new Pal_string((String) textField_1.getText());
						Pal_string ps2 = new Pal_string((String) textField_2.getText());
						Pal_string ps3 = new Pal_string((String) textField_3.getText());
						Pal_string ps4 = new Pal_string((String) textField_4.getText());
						Pal_string ps5 = new Pal_string((String) textField_5.getText());
						JLabel lblNewLabel_1 = new JLabel(ps1.getPal_string());
						lblNewLabel_1.setBounds(200, 70, 573, 30);
						getContentPane().add(lblNewLabel_1);
						JLabel lblNewLabel_2 = new JLabel(ps2.getPal_string());
						lblNewLabel_2.setBounds(200, 105, 573, 30);
						getContentPane().add(lblNewLabel_2);
						JLabel lblNewLabel_3 = new JLabel(ps3.getPal_string());
						lblNewLabel_3.setBounds(200, 140, 573, 30);
						getContentPane().add(lblNewLabel_3);
						JLabel lblNewLabel_4 = new JLabel(ps4.getPal_string());
						lblNewLabel_4.setBounds(200, 175, 573, 30);
						getContentPane().add(lblNewLabel_4);
						JLabel lblNewLabel_5 = new JLabel(ps5.getPal_string());
						lblNewLabel_5.setBounds(200, 215, 573, 30);
						getContentPane().add(lblNewLabel_5);
					}
				}
			}
			
		});
		getContentPane().add(btnNewButton);
		
		//clear button is not working 
		JButton button = new JButton("Clear");
		button.setBorder(new EmptyBorder(0, 0, 0, 0));
		button.setForeground(new Color(128, 0, 128));
		button.setFont(new Font("Chalkduster", Font.BOLD, 15));
		Image img_1 = new ImageIcon(this.getClass().getResource("/close-2-icon.png")).getImage();
		button.setIcon(new ImageIcon(img_1));
		button.setBounds(160, 273, 117, 44);
		button.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(getNumPalindrome() == "1 Palindrome") 
				{
					if(textField_1.getText() != null || textField_1.getText().trim().isEmpty() == false)
					{
						textField_1 = new JTextField();
						textField_1.setBounds(31, 70, 150, 30);
						getContentPane().add(textField_1);
						textField_1.setColumns(10);
					}
				}
				else if(getNumPalindrome() == "2 Palindromes") 
				{
					if(textField_1.getText() !=  null || textField_1.getText().trim().isEmpty() == false || 
							(textField_2.getText() !=  null || textField_2.getText().trim().isEmpty() == false))
					{
						textField_1 = new JTextField();
						textField_1.setBounds(31, 70, 150, 30);
						getContentPane().add(textField_1);
						textField_1.setColumns(10);
						
						textField_2 = new JTextField();
						textField_2.setBounds(31, 105, 150, 30);
						getContentPane().add(textField_2);
						textField_2.setColumns(10);
					}
				}
				else if(getNumPalindrome() == "3 Palindromes") 
				{
					if(textField_1.getText() !=  null || textField_1.getText().trim().isEmpty() == false || 
							(textField_2.getText() !=  null || textField_2.getText().trim().isEmpty() == false) ||
							(textField_3.getText() !=  null || textField_3.getText().trim().isEmpty() == false)) 
					{
						textField_1 = new JTextField();
						textField_1.setBounds(31, 70, 150, 30);
						getContentPane().add(textField_1);
						textField_1.setColumns(10);
						
						textField_2 = new JTextField();
						textField_2.setBounds(31, 105, 150, 30);
						getContentPane().add(textField_2);
						textField_2.setColumns(10);
						
						textField_3 = new JTextField();
						textField_3.setBounds(31, 140, 150, 30);
						getContentPane().add(textField_3);
						textField_3.setColumns(10);
					}
				}
				else if(getNumPalindrome() == "4 Palindromes") 
				{
					if(textField_1.getText() !=  null || textField_1.getText().trim().isEmpty() == false || 
							(textField_2.getText() !=  null || textField_2.getText().trim().isEmpty() == false) ||
							(textField_3.getText() !=  null || textField_3.getText().trim().isEmpty() == false) ||
							(textField_4.getText() !=  null || textField_4.getText().trim().isEmpty() == false)) 
					{
						textField_1 = new JTextField();
						textField_1.setBounds(31, 70, 150, 30);
						getContentPane().add(textField_1);
						textField_1.setColumns(10);
						
						textField_2 = new JTextField();
						textField_2.setBounds(31, 105, 150, 30);
						getContentPane().add(textField_2);
						textField_2.setColumns(10);
						
						textField_3 = new JTextField();
						textField_3.setBounds(31, 140, 150, 30);
						getContentPane().add(textField_3);
						textField_3.setColumns(10);
					
						textField_4 = new JTextField();
						textField_4.setBounds(31, 175, 150, 30);
						getContentPane().add(textField_4);
						textField_4.setColumns(10);
					}
				}
				else if(getNumPalindrome() == "5 Palindromes") 
				{
					if(textField_1.getText() !=  null || textField_1.getText().trim().isEmpty() == false || 
						(textField_2.getText() !=  null || textField_2.getText().trim().isEmpty() == false) ||
						(textField_3.getText() !=  null || textField_3.getText().trim().isEmpty() == false) ||
						(textField_4.getText() !=  null || textField_4.getText().trim().isEmpty() == false) ||
						(textField_5.getText() !=  null || textField_5.getText().trim().isEmpty() == false)) 
					{
						textField_1 = new JTextField();
						textField_1.setBounds(31, 70, 150, 30);
						getContentPane().add(textField_1);
						textField_1.setColumns(10);
						
						textField_2 = new JTextField();
						textField_2.setBounds(31, 105, 150, 30);
						getContentPane().add(textField_2);
						textField_2.setColumns(10);
						
						textField_3 = new JTextField();
						textField_3.setBounds(31, 140, 150, 30);
						getContentPane().add(textField_3);
						textField_3.setColumns(10);
					
						textField_4 = new JTextField();
						textField_4.setBounds(31, 175, 150, 30);
						getContentPane().add(textField_4);
						textField_4.setColumns(10);
					
						textField_5 = new JTextField();
						textField_5.setBounds(31, 215, 150, 30);
						getContentPane().add(textField_5);
						textField_5.setColumns(10);
					}
				}
			}
		});
		getContentPane().add(button);
		
		//tacocat image
		JLabel lblNewLabel_6 = new JLabel("");
		Image img_2 = new ImageIcon(this.getClass().getResource("/tacocat.gif")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img_2));
		lblNewLabel_6.setBounds(31, 322, 547, 300);
		getContentPane().add(lblNewLabel_6);
		
	}
}
