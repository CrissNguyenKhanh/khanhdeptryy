package view1;

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

public class formdangnhap2 extends JFrame {
    Connection conn;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldusername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formdangnhap2 frame = new formdangnhap2();
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
	public formdangnhap2() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 468);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MỜI BẠN ĐĂNG NHẬP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(87, 27, 258, 48);
		contentPane.add(lblNewLabel);
		
		JLabel textusername = new JLabel("Username: ");
		textusername.setBackground(Color.BLACK);
		textusername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textusername.setBounds(25, 92, 99, 29);
		contentPane.add(textusername);
		
		JLabel lblPassword = new JLabel("PassWord:\r\n");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(25, 166, 99, 29);
		contentPane.add(lblPassword);
		
		textFieldusername = new JTextField();
		textFieldusername.setBounds(114, 98, 219, 19);
		contentPane.add(textFieldusername);
		textFieldusername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(114, 172, 219, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(124, 205, 150, 48);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\dowload\\anh-ca-phe-dep.jpg"));
		lblNewLabel_1.setBounds(338, 0, 934, 442);
		contentPane.add(lblNewLabel_1);
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
			String sql = "select*from dbo.NHANVIEN where username =? and matkhau =?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, textFieldusername.getText());
			ps.setString(2, passwordField.getText());
			rs= ps.executeQuery();
			if(textFieldusername.getText().equals("")||passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Chưa nhập tài khoản và mật khẩu" );
				
			}else if(rs.next()) {
				JOptionPane.showMessageDialog(this, "DANG NHAP THANH CONG!");
				GDnhanvien k = new GDnhanvien();
				k.setVisible(true);
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "dang nhap that bai");
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
