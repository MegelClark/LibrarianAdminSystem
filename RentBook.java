package librarySystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class RentBook extends JFrame {

	 private JPanel contentPane;
	    private JTextField textField;
	    private int[] bookCopies = {2, 1, 3}; // number of copies for each book
	    private String[] bookTitles = {"System Analysis and Design", "Android Application", "Programming Concepts and Logic Formulation"};
	    private String[] bookAuthors = {"Gray B. Shelly", "Corinne Hoisington", "Rosauro E. Manuel"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentBook frame = new RentBook();
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
	    public RentBook() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 475, 244);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JPanel panel = new JPanel();
	        panel.setBounds(33, 11, 416, 136);
	        contentPane.add(panel);
	        panel.setLayout(null);

	        JLabel lblNewLabel = new JLabel("Choose a book to rent:");
	        lblNewLabel.setBounds(10, 11, 396, 27);
	        panel.add(lblNewLabel);

	        // display book options
	        int labelWidth = lblNewLabel.getWidth();
	        for (int i = 0; i < bookTitles.length; i++) {
	            JLabel label = new JLabel((i+1) + ". " + bookTitles[i] + ", " + bookAuthors[i]);
	            label.setBounds(10, 47 + 26*i, labelWidth, 25);
	            panel.add(label);
	        }


	        textField = new JTextField();
	        textField.setBounds(43, 158, 208, 32);
	        contentPane.add(textField);
	        textField.setColumns(10);

	        JButton btnNewButton = new JButton("Borrow");
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    int bookIndex = Integer.parseInt(textField.getText()) - 1; // convert input to index
	                    if (bookIndex >= 0 && bookIndex < bookTitles.length) {
	                        if (bookCopies[bookIndex] > 0) {
	                            bookCopies[bookIndex]--; // decrease number of copies
	                            JOptionPane.showMessageDialog(null, "You borrowed \"" + bookTitles[bookIndex] + "\" by " + bookAuthors[bookIndex]); // show success message
	                            JLabel label = new JLabel("Enter Y to borrow another book or N to end program:");
	                            Object[] components = {label};
	                            String input = (String) JOptionPane.showInputDialog(null, components, "Confirmation", JOptionPane.PLAIN_MESSAGE, null, null, "");
	                            if (input != null && input.equalsIgnoreCase("Y")) {
	                                textField.setText("");
	                            } else {
	                                dispose(); // close window
	                            }
	                            if (input != null && !input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
	                                JOptionPane.showMessageDialog(null, "Input does not exist."); // show error message
	                                dispose(); // close window
	                            }
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Sorry, no more copies available for \"" + bookTitles[bookIndex] + "\""); // show error message
	                            textField.setText("");
	                        }
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Index does not exist. Try again!"); // show error message
	                        textField.setText("");
	                    }
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Index does not exist. Try again!"); // show error message
	                    textField.setText("");
	                }
	            }
	        });
	        btnNewButton.setBounds(260, 163, 89, 23);
	        contentPane.add(btnNewButton);


	        JButton btnNewButton_1 = new JButton("Cancel");
	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose(); // close window
	            }
	        });
	        btnNewButton_1.setBounds(359, 163, 89, 23);
	        contentPane.add(btnNewButton_1);
	    }
	}