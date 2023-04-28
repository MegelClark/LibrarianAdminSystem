
package librarySystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class Admin_Librarian extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Librarian frame = new Admin_Librarian();
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
	public Admin_Librarian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel adminPanel = new JPanel();
		adminPanel.setBounds(77, 100, 237, 61);
		contentPane.add(adminPanel);
		adminPanel.setLayout(null);
		// Admin Login Button
		JButton adminloginbtn = new JButton("Admin Login");
		adminloginbtn.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		adminloginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLoginFrame frame = new AdminLoginFrame();
				frame.setVisible(true);
				dispose();
				
			}
		});
		adminloginbtn.setBounds(0, 0, 237, 61);
		adminPanel.add(adminloginbtn);
		
		JPanel librarianPanel = new JPanel();
		librarianPanel.setBounds(77, 204, 237, 61);
		contentPane.add(librarianPanel);
		librarianPanel.setLayout(null);
		// librarian login Button
		JButton librarianloginbtn = new JButton("Librarian Login");
		librarianloginbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		librarianloginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianLoginFrame frame = new LibrarianLoginFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		librarianloginbtn.setBounds(0, 0, 237, 61);
		librarianPanel.add(librarianloginbtn);
		
		JPanel Titlepanel = new JPanel();
		Titlepanel.setBounds(77, 26, 237, 45);
		contentPane.add(Titlepanel);
		Titlepanel.setLayout(null);
		
		JLabel librarylbl = new JLabel("Library Management");
		librarylbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		librarylbl.setBounds(49, 0, 159, 45);
		Titlepanel.add(librarylbl);
	}
}
