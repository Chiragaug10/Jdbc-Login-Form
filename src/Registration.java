import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField Mobile;
	private JTextField Email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(155, 45, 163, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		Mobile = new JTextField();
		Mobile.setBounds(155, 83, 163, 26);
		contentPane.add(Mobile);
		Mobile.setColumns(10);
		
		Email = new JTextField();
		Email.setBounds(155, 133, 163, 26);
		contentPane.add(Email);
		Email.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(18, 41, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile No");
		lblNewLabel_1.setBounds(18, 88, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email Id");
		lblNewLabel_2.setBounds(18, 143, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","1236547489");
					String query="insert into registration(?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,name.getText());
					ps.setString(2, Mobile.getText());
					ps.setString(3,Email.getText());
					ps.close();
					con.close();
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(115, 199, 117, 29);
		contentPane.add(btnNewButton);
	}
}
