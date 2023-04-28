package librarySystem;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AdminLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	private static final LibrarianUserData[] USER_DATABASE = {
		new LibrarianUserData("Admin01", "PASSWORD"),
		new LibrarianUserData("Admin02", "PASSWORD"),
		new LibrarianUserData("Admin03", "PASSWORD")
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginFrame frame = new AdminLoginFrame();
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
	public AdminLoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel usernamePanel = new JPanel();
		usernamePanel.setBounds(81, 125, 219, 41);
		contentPane.add(usernamePanel);
		usernamePanel.setLayout(null);

		username = new JTextField();
		username.setText("Username");
		username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (username.getText().equals("")) {
					username.setForeground(new Color(96, 96, 96));
					username.setText("Username");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (username.getText().equals("Username")) {
					username.setForeground(Color.BLACK);
					username.setText("");
				}
			}
		});
		username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		username.setBounds(0, 0, 219, 40);
		usernamePanel.add(username);
		username.setColumns(10);

		JPanel passwordpanel = new JPanel();
		passwordpanel.setBounds(81, 177, 219, 41);
		contentPane.add(passwordpanel);
		passwordpanel.setLayout(null);
		
		password = new JPasswordField();
		password.setText("Password");
		password.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e) {
				if (password.getText().equals("")) {
					password.setForeground(new Color(96, 96, 96));
					password.setText("Password");
					password.setEchoChar((char) 0);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (password.getText().equals("Password")) {
					password.setEchoChar('●');
					password.setForeground(Color.BLACK);
					password.setText("");
				}
			}

		});
		password.setBounds(0, 0, 219, 40);
		passwordpanel.add(password);
		password.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));

		JPanel btnpanel = new JPanel();
		btnpanel.setBounds(146, 240, 79, 33);
		contentPane.add(btnpanel);
		btnpanel.setLayout(null);

		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the username and password input from the user
				String inputUsername = username.getText();
				String inputPassword = new String(password.getPassword());
				
				// Initialize flags to check if the input username and password are correct
				boolean isOkay = false;
				boolean isUsernameCorrect = false;
				boolean isPasswordCorrect = false;
				
				// Loop through the user database to check if the input username and password match
				for (int i = 0; i < USER_DATABASE.length; i++) {
				    if (inputUsername.equals(USER_DATABASE[i].getUsername())) {
				    	// If the input username is correct, set the flag to true
				        isUsernameCorrect = true;
				     // If the input password is correct, set the flag to true and break out of the loop
				        if (inputPassword.equals(USER_DATABASE[i].getPassword())) {
				            isPasswordCorrect = true;
				            break;
				        }
				    }
				}

				if (isPasswordCorrect) {
					// Check the flags and display the appropriate message
				    JOptionPane.showMessageDialog(null, "Login successful!");
				    JOptionPane.showMessageDialog(null, "Welcome to NU Library System");
				    NULibrarySystem frame = new NULibrarySystem();
					frame.setVisible(true);
					dispose();
				} else if (isUsernameCorrect && !isPasswordCorrect) {
					// show dialog message if password is wrong
				    JOptionPane.showMessageDialog(null, "Invalid password. Please try again.");
				} else {
					// show dialog message is username is wrong 
				    JOptionPane.showMessageDialog(null, "Invalid username. Please try again.");
				}
			}
		});
		loginbtn.setBounds(0, 0, 79, 33);
		btnpanel.add(loginbtn);
		
		JPanel titlepanel = new JPanel();
		titlepanel.setBounds(81, 46, 219, 48);
		titlepanel.setOpaque(false);
		contentPane.add(titlepanel);
		titlepanel.setLayout(null);
		
		JLabel titlelbl = new JLabel("Admin Login");
		titlelbl.setBounds(57, -33, 199, 120);
		titlepanel.add(titlelbl);
		titlelbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		

	}
}

