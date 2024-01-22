package view1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class formdangnhap1 extends JFrame {
     	
    Connection conn;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldusername;
	private JPasswordField passwordField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formdangnhap1 frame = new formdangnhap1();
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
	public formdangnhap1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MỜI BẠN ĐĂNG NHẬP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(95, 30, 258, 48);
		contentPane.add(lblNewLabel);
		
		JLabel textusername = new JLabel("USERNAME:");
		textusername.setForeground(Color.WHITE);
		textusername.setFont(new Font("Tahoma", Font.BOLD, 15));
		textusername.setBounds(62, 93, 99, 29);
		contentPane.add(textusername);
		
		JLabel lblPassword = new JLabel("PASSWORD:\r\n");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(55, 177, 116, 29);
		contentPane.add(lblPassword);
		
		textFieldusername = new JTextField();
		textFieldusername.setBounds(220, 99, 248, 19);
		contentPane.add(textFieldusername);
		textFieldusername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 185, 248, 19);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setIcon(new ImageIcon("D:\\dowload\\8679806_login_box_icon (1).png"));
		btnNewButton.setToolTipText("\r\n\r\n");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(145, 225, 159, 90);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\dowload\\f881ad2778cc7d7c88791e14c9419b52.jpg"));
		lblNewLabel_1.setBounds(0, 0, 830, 572);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\dowload\\th (6).jpg"));
		lblNewLabel_2.setBounds(21, 30, 468, 297);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setIcon(new ImageIcon("D:\\dowload\\turn-down.png"));
		btnNewButton_1.setBounds(563, 30, 85, 48);
		contentPane.add(btnNewButton_1);
	}
   String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   String url ="jdbc:sqlserver://localhost:1433;databaseName=duan";
   String user = "sa";
   String password = "123456789";
   Statement st;
   ResultSet rs;
   
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
	try {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		String sql = "select*from dbo.ADMIN where username =? and matkhau =?";
		PreparedStatement  ps = conn.prepareCall(sql);
		ps.setString(1, textFieldusername.getText());
		ps.setString(2, passwordField.getText());
		rs= ps.executeQuery();
		if(textFieldusername.getText().equals("")||passwordField.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Chưa nhập tài khoản và mật khẩu" );
			
		}else if(rs.next()) {
			JOptionPane.showMessageDialog(this, "DANG NHAP THANH CONG!");
			GDadmin j = new GDadmin();
			j.setVisible(true);
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "dang nhap that bai");
		}
		
	} catch (Exception e2) {
		e2.printStackTrace();
	}
	

	
	
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		this.dispose();
		phanquyen k  = new phanquyen();
		k.setVisible(true);
	}
}
