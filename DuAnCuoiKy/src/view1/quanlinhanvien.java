package view1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import daoquanlithucan.loaicafe;
import quanlinhanvien.NhanVien;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;

public class quanlinhanvien extends JFrame {
	private ArrayList<NhanVien> list ;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldtaikhoan;
	private JTextField textFielmatkhau;
	private JTextField textFielname;
	private JTextField textFielddob;
	private JTextField textFieldgioitinh;
	private JTextField textFieldemail;
	private JTextField textFieldadres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanlinhanvien frame = new quanlinhanvien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	

	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	   String url ="jdbc:sqlserver://localhost:1433;databaseName=duan";
	   String user = "sa";
	   String password = "123456789";
	   Statement st;
	   ResultSet rs;
	   private JScrollPane scrollPane_1;
	   private JButton btnNewButton_1;
	public quanlinhanvien() {
		list = new ArrayList<NhanVien>();
		 int current = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1220, 831);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BẢNG QUẢN LÍ NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(394, -22, 688, 104);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 1196, 171);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"t\u00E0i kho\u1EA3n", "m\u1EADt kh\u1EA9u", "h\u1ECD v\u00E0 t\u00EAn", "ng\u00E0y sinh", "gi\u1EDBi t\u00EDnh", "email", "\u0110\u1ECAA CH\u1EC8"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 325, 129, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 488, 129, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ Và Tên: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(670, 325, 129, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày Sinh :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(670, 412, 129, 34);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("giới Tính:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_4.setBounds(670, 500, 129, 34);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Email: ");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_5.setBounds(670, 598, 129, 34);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_6.setBounds(670, 687, 129, 34);
		contentPane.add(lblNewLabel_1_6);
		
		textFieldtaikhoan = new JTextField();
		textFieldtaikhoan.setBounds(133, 334, 286, 25);
		contentPane.add(textFieldtaikhoan);
		textFieldtaikhoan.setColumns(10);
		
		textFielmatkhau = new JTextField();
		textFielmatkhau.setColumns(10);
		textFielmatkhau.setBounds(133, 497, 286, 25);
		contentPane.add(textFielmatkhau);
		
		textFielname = new JTextField();
		textFielname.setColumns(10);
		textFielname.setBounds(779, 325, 286, 25);
		contentPane.add(textFielname);
		
		textFielddob = new JTextField();
		textFielddob.setColumns(10);
		textFielddob.setBounds(779, 421, 286, 25);
		contentPane.add(textFielddob);
		
		textFieldgioitinh = new JTextField();
		textFieldgioitinh.setColumns(10);
		textFieldgioitinh.setBounds(779, 506, 286, 25);
		contentPane.add(textFieldgioitinh);
		
		textFieldemail = new JTextField();
		textFieldemail.setColumns(10);
		textFieldemail.setBounds(779, 595, 286, 25);
		contentPane.add(textFieldemail);
		
		textFieldadres = new JTextField();
		textFieldadres.setColumns(10);
		textFieldadres.setBounds(779, 680, 286, 25);
		contentPane.add(textFieldadres);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setIcon(new ImageIcon("D:\\dowload\\plus.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(0, 631, 91, 59);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setIcon(new ImageIcon("D:\\dowload\\tools.png"));
		btnSa.setBackground(Color.WHITE);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSa_actionPerformed(e);
			}
		});
		btnSa.setBounds(153, 631, 91, 59);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon("D:\\dowload\\trash-can.png"));
		btnXa.setBackground(Color.WHITE);
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXa_actionPerformed(e);
			}
		});
		btnXa.setBounds(296, 631, 91, 59);
		contentPane.add(btnXa);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setIcon(new ImageIcon("D:\\dowload\\turn-down.png"));
		btnLmMi.setBackground(Color.WHITE);
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLmMi_actionPerformed(e);
			}
		});
		btnLmMi.setBounds(433, 631, 98, 59);
		contentPane.add(btnLmMi);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("sdt:");
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_6_1.setBounds(670, 750, 129, 34);
		contentPane.add(lblNewLabel_1_6_1);
		
		textFieldsdt = new JTextField();
		textFieldsdt.setColumns(10);
		textFieldsdt.setBounds(779, 759, 286, 25);
		contentPane.add(textFieldsdt);
		
		labelvipro = new JLabel("");
		labelvipro.setBounds(437, 313, 223, 238);
		contentPane.add(labelvipro);
		
		btnNewButton_2 = new JButton("TÌM NHÂN VIÊN");
		btnNewButton_2.setIcon(new ImageIcon("D:\\dowload\\search.png"));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setBounds(10, 559, 171, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("X");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_3_actionPerformed(e);
			}
		});
		btnNewButton_3.setBounds(1038, 26, 107, 43);
		contentPane.add(btnNewButton_3);
		loaddatatoarraylist();
		loadarraylisttotable();
		this.setLocationRelativeTo(null);
		
	}
	public void loaddatatoarraylist() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from dbo.NHANVIEN";
		    PreparedStatement ps =conn.prepareStatement(sql);
		    ResultSet rs = ps.executeQuery();
		    list.clear();
		    while(rs.next()) {
		    	String username= rs.getString(1);
		    	String matkhau = rs.getString(2);
		    	String  name = rs.getString(3);
		    	Date dob = rs.getDate(4);
		    	String gioitinh = rs.getString(5);
		    	String phone = rs.getString(6);
		    	String email = rs.getString(7);
		    	String addres = rs.getString(8);
		    	NhanVien k = new NhanVien(username, matkhau	, name, dob, gioitinh, phone, email, addres);
		    	
		    	list.add(k);
		    }
		    conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	public void loadarraylisttotable() {
		DefaultTableModel model  =  (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(NhanVien l : list) {
			model.addRow(new Object[] {
				l.getUsernmae() ,l.getPassword(),l.getName(),l.getDob(),l.getGioitinh(),l.getPhonenumber(),l.getEmail(),l.getAddres()
			});
		}
	}
	int current = 0;
	private JTextField textFieldsdt;
	private JLabel labelvipro;
	private JButton btnNewButton_2;
	protected void do_table_mouseClicked(MouseEvent e) {
		current = table.getSelectedRow();
		Display(current);
	}
	public void Display(int i)
	{
		NhanVien l = list.get(i);
		
	    textFieldtaikhoan.setText(l.usernmae);
		textFielmatkhau.setText(l.password);
		textFielname.setText(l.name);
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    textFielddob.setText(dateFormat.format(l.dob));
		textFieldgioitinh.setText(l.gioitinh);
		textFieldsdt.setText(l.phonenumber);
		textFieldemail.setText(l.email);
		textFieldadres.setText(l.addres);
		if(i ==0) {
			String imagePath = "D:\\dowload\\tải xuống (3).jpg";
			 ImageIcon icon = new ImageIcon(imagePath);
			labelvipro.setIcon(icon);
			labelvipro.setVisible(true);
			
		}
		
		if(i ==1 ) {
			String imagePath = "D:\\dowload\\unnamed (1).jpg";
			 ImageIcon icon = new ImageIcon(imagePath);
			labelvipro.setIcon(icon);
			labelvipro.setVisible(true);
			
		}
		if(i == 2 ) {
			String imagePath = "D:\\dowload\\7039e7ca3ce847f4cfe7c2766749024b.jpeg";
			 ImageIcon icon = new ImageIcon(imagePath);
			labelvipro.setIcon(icon);
			labelvipro.setVisible(true);
		}
		if(i ==3 ) {
			String imagePath = "D:\\dowload\\ảnh thẻ.jpg";
			 ImageIcon icon = new ImageIcon(imagePath);
			labelvipro.setIcon(icon);
			labelvipro.setVisible(true);
		}
		
		
	}
	
		public boolean checktrungkhoa(String ma ) {
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).usernmae.equalsIgnoreCase(ma)) {
					return true;
					
				}
			
			}
			return false;
		}
		
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if(checktrungkhoa(textFieldtaikhoan.getText())== true) {
			JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN MÃ KHÁC VỚI MÃ CŨ ĐỂ THÊM!!");
			
		}else {
		try {
			int row =0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			String sql = " INSERT INTO dbo.NHANVIEN values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, textFieldtaikhoan.getText());
			ps.setString(2, textFielmatkhau.getText());
			ps.setString(3,textFielname.getText());
			ps.setString(4, textFielddob.getText());
			ps.setString(5, textFieldgioitinh.getText());
			ps.setString(6,textFieldsdt.getText());
			ps.setString(7, textFieldemail.getText());
			ps.setString(8, textFieldadres.getText());
			
			row = ps.executeUpdate();
			if(row > 0 ) {
				JOptionPane.showMessageDialog(this, "THÊM THÀNH CÔNG");
				
			}else {
				JOptionPane.showConfirmDialog(this, "THÊM THẤT BẠI!!");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		loaddatatoarraylist();
		loadarraylisttotable();
		
		}
		
		
	}
	protected void do_btnSa_actionPerformed(ActionEvent e) {
		if(textFieldtaikhoan.getText().equals(" ")) {
			 JOptionPane.showMessageDialog(this, "MỜI ADMIN NHẬP MÃ !!");
			 textFieldtaikhoan.requestFocus();
			 return;
		 }
		 try {
			 int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			String sql = "update dbo.NHANVIEN set  matkhau = ? , name = ? , ngaysinh = ? , gioitinh = ? ,phoneNumber  = ?  ,  email = ? ,addres = ? where username = ?";
					
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, textFielmatkhau.getText());
			st.setString(2, textFielname.getText());
			st.setString(3, textFielddob.getText());
			st.setString(4, textFieldgioitinh.getText());
			st.setString(5, textFieldsdt.getText());
			st.setString(6,textFieldemail.getText());
			st.setString(7, textFieldadres.getText());
			st.setString(8, textFieldtaikhoan.getText());
			
			row = st.executeUpdate();
			if(row > 0)
			JOptionPane.showMessageDialog(this, "Sửa Thành Công");
			else {
				JOptionPane.showMessageDialog(this, "sửa không thành công!!");
			}
			conn.close();
			
			
		} catch (Exception e2) {
		e2.printStackTrace();
		JOptionPane.showMessageDialog(this, "error");
		}
		loaddatatoarraylist();
		loadarraylisttotable();
		
		 
		
		
		
	}
	protected void do_btnXa_actionPerformed(ActionEvent e) {
		if(textFieldtaikhoan.getText().equals(" ")) {
			JOptionPane.showMessageDialog(this, "vui long nhap ma");
			textFieldtaikhoan.requestFocus();
			return;
		}
		try {
			int row =0;
			Class.forName(driver);
			Connection conn  = DriverManager.getConnection(url,user,password);
			String sql = " DELETE FROM dbo.NHANVIEN where username = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, textFieldtaikhoan.getText());
			row = st.executeUpdate();
			if(row > 0)
			JOptionPane.showMessageDialog(this, "delete thanh cong!");
			else {
				JOptionPane.showMessageDialog(this, "mời ADMIN nhập lại mã , mã không đúng!");
			}
			conn.close();
			
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		loaddatatoarraylist();
		loadarraylisttotable();
		
		
		
	}
	protected void do_btnLmMi_actionPerformed(ActionEvent e) {
		textFielname.setText(" " );
		textFielddob.setText(" " );
		textFieldemail.setText(" " );
		textFieldadres.setText(" " );
		textFieldgioitinh.setText(" ");
		textFieldsdt.setText( " " );
		textFieldtaikhoan.setText("");
		textFielmatkhau.setText(" ");
		
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		try {
	        Class.forName(driver);
	        Connection conn = DriverManager.getConnection(url, user, password);
	        String sql = "select * from dbo.NHANVIEN where username like N'%" + textFieldtaikhoan.getText() + "%'";
	        System.out.println(sql);
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        list.clear(); // Clear existing data before loading new results
	        while (rs.next()) {
	            String username = rs.getString("username");
	            String password = rs.getString("matkhau");
	            String name = rs.getString("name");
	           Date dob = rs.getDate("ngaysinh");
	            String gioitinh = rs.getString("gioitinh");
	            String phone = rs.getString("phoneNumber");
	            String email = rs.getString("email");
	            String addres = rs.getString("addres");
	            NhanVien k = new NhanVien(username, password, name, dob, gioitinh, phone, email, addres);
	            list.add(k);
	        }
	        conn.close();
	        loadarraylisttotable();
	    } catch (Exception e2) {
	        e2.printStackTrace();
	    }
	}
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		GDadmin k= new GDadmin();
		k.setVisible(true);
		this.dispose();
	}
	}

