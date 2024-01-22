package view1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import khachhangvip.khachhangvip;
import quanlinhanvien.NhanVien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class quanlikhachhang extends JFrame {
	private ArrayList<khachhangvip> list ;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldcmnd;
	private JTextField textFieldname;
	private JTextField textFieldsdt;
	private JTextField textFieldMATHE;
	private JTable table;
	private JButton btnNewButtonADD;
	private JPanel panelVIP;
	private JTextField textFieldemail;
	private JTextField textFielddatedk;
	private JTextField textFieldsoli;
	private JTextField textFieldchietkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanlikhachhang frame = new quanlikhachhang();
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
	public quanlikhachhang() {
		list = new ArrayList<khachhangvip>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1286, 836);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN THÀNH VIÊN");
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(24, 10, 444, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thẻ căn cước / CMND:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 97, 215, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ Và Tên :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(24, 148, 215, 48);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("SỐ ĐIỆN THOẠI:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(24, 208, 215, 48);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("MÃ THẺ:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(24, 266, 215, 48);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("Điều Kiện Thêm\\CậpNhật\\Sửa\\Xóa : Thẻ Căn Cước\\CMND gốc.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setBounds(10, 349, 449, 13);
		contentPane.add(lblNewLabel_2);
		
		textFieldcmnd = new JTextField();
		textFieldcmnd.setBounds(207, 114, 324, 19);
		contentPane.add(textFieldcmnd);
		textFieldcmnd.setColumns(10);
		
		textFieldname = new JTextField();
		textFieldname.setColumns(10);
		textFieldname.setBounds(207, 165, 324, 19);
		contentPane.add(textFieldname);
		
		textFieldsdt = new JTextField();
		textFieldsdt.setColumns(10);
		textFieldsdt.setBounds(207, 225, 324, 19);
		contentPane.add(textFieldsdt);
		
		textFieldMATHE = new JTextField();
		textFieldMATHE.setColumns(10);
		textFieldMATHE.setBounds(207, 283, 324, 19);
		contentPane.add(textFieldMATHE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(614, 102, 648, 672);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.setBackground(SystemColor.info);
		table.setForeground(SystemColor.desktop);
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
				"M\u00E3 Th\u1EBB", "CMND", "H\u1ECD V\u00E0 T\u00EAn", "Ng\u00E0y \u0111\u0103ng k\u00ED", "S\u0110T", "Email", "S\u1ED1 ly", "Chi\u1EBFt Kh\u1EA5u"
			}
		));
		scrollPane_1.setViewportView(table);
		
		btnNewButtonADD = new JButton("");
		btnNewButtonADD.setIcon(new ImageIcon("D:\\dowload\\plus.png"));
		btnNewButtonADD.setBackground(Color.WHITE);
		btnNewButtonADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButtonADD_actionPerformed(e);
			}
		});
		btnNewButtonADD.setBounds(10, 392, 85, 89);
		contentPane.add(btnNewButtonADD);
		
		JButton btnSa = new JButton("");
		btnSa.setIcon(new ImageIcon("D:\\dowload\\tools.png"));
		btnSa.setBackground(Color.WHITE);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSa_actionPerformed(e);
			}
		});
		btnSa.setBounds(153, 392, 85, 89);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("");
		btnXa.setIcon(new ImageIcon("D:\\dowload\\trash-can.png"));
		btnXa.setBackground(Color.WHITE);
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXa_actionPerformed(e);
			}
		});
		btnXa.setBounds(297, 392, 85, 89);
		contentPane.add(btnXa);
		
		JButton btnTmKim = new JButton("");
		btnTmKim.setIcon(new ImageIcon("D:\\dowload\\search.png"));
		btnTmKim.setBackground(Color.WHITE);
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTmKim_actionPerformed(e);
			}
		});
		btnTmKim.setBounds(446, 392, 85, 89);
		contentPane.add(btnTmKim);
		
		panelVIP = new JPanel();
		panelVIP.setBackground(Color.CYAN);
		panelVIP.setBounds(12, 482, 592, 271);
		contentPane.add(panelVIP);
		panelVIP.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("THÔNG TIN THÊM");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(10, 10, 316, 28);
		panelVIP.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("EMAIL:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 48, 74, 28);
		panelVIP.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("NGÀY ĐĂNG KÍ:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(10, 107, 127, 28);
		panelVIP.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("SỐ LY ĐÃ DÙNG:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_2.setBounds(10, 158, 108, 28);
		panelVIP.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("CHIẾT KHẤU:");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_3.setBounds(10, 209, 97, 28);
		panelVIP.add(lblNewLabel_4_3);
		
		textFieldemail = new JTextField();
		textFieldemail.setBounds(137, 48, 280, 19);
		panelVIP.add(textFieldemail);
		textFieldemail.setColumns(10);
		
		textFielddatedk = new JTextField();
		textFielddatedk.setColumns(10);
		textFielddatedk.setBounds(137, 113, 280, 19);
		panelVIP.add(textFielddatedk);
		
		textFieldsoli = new JTextField();
		textFieldsoli.setColumns(10);
		textFieldsoli.setBounds(137, 164, 280, 19);
		panelVIP.add(textFieldsoli);
		
		textFieldchietkhau = new JTextField();
		textFieldchietkhau.setColumns(10);
		textFieldchietkhau.setBounds(137, 215, 280, 19);
		panelVIP.add(textFieldchietkhau);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(1127, 10, 105, 72);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("KHÁCH HÀNG VIP");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_5.setBounds(614, 13, 524, 53);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("D:\\dowload\\turn-down.png"));
		btnNewButton_2.setBounds(490, 346, 85, 21);
		contentPane.add(btnNewButton_2);
		panelVIP.setVisible(false);
		loaddatatoarraylist();
		loadarraylisttotable();
		this.setLocationRelativeTo(null);
	}
	public void loaddatatoarraylist() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from dbo.khachhang";
		    PreparedStatement ps =conn.prepareStatement(sql);
		    ResultSet rs = ps.executeQuery();
		    list.clear();
		    while(rs.next()) {
		    	String mathe1= rs.getString(1);
		    	String cmnd1 = rs.getString(2);
		    	String  name1 = rs.getString(3);
		    	Date ngaydangki1 = rs.getDate(4);
		    	String phone1 = rs.getString(5);		    	
		    	String email1 = rs.getString(6);
		    	String soly2 = rs.getString(7);
		    	String chietkhau2 = rs.getString(8);
		    	khachhangvip k = new khachhangvip(mathe1, cmnd1, name1, ngaydangki1, phone1, email1, soly2, chietkhau2);
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
		for(khachhangvip k : list) {
			model.addRow(new Object[] {
			k.getMathe() , k.getCmnd(),k.getName(),k.getNgaydangki(),k.getPhone(),k.getEmail(),k.getSoly(),k.getChietkhau()	
			});
		}
	}

	public boolean checktrungkhoa(String ma ) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).mathe.equalsIgnoreCase(ma)) {
				return true;
				
			}
		
		}
		return false;
	}
	
	protected void do_btnNewButtonADD_actionPerformed(ActionEvent e) {
		if(checktrungkhoa(textFieldemail.getText())== true) {
			
			JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN MÃ KHÁC VỚI MÃ CŨ ĐỂ THÊM!!");
			
		}else {
		try {
			int row =0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			String sql = " INSERT INTO dbo.khachhang values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, textFieldMATHE.getText());
			ps.setString(2, textFieldcmnd.getText());
			ps.setString(3,textFieldname.getText());
			ps.setString(4, textFielddatedk.getText());
			ps.setString(5, textFieldsdt.getText());
			ps.setString(6,textFieldemail.getText());
			ps.setString(7, textFieldsoli.getText());
			ps.setString(8, textFieldchietkhau.getText());
			
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
	public void Display(int i)
	{
		khachhangvip  l = list.get(i);
		textFieldMATHE.setText(l.getMathe());
		
		textFieldcmnd.setText(l.getCmnd());
		textFieldname.setText(l.getName());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    textFielddatedk.setText(dateFormat.format(l.getNgaydangki()));
		 
		textFieldsdt.setText(l.getPhone());
		textFieldemail.setText(l.getEmail());
		textFieldsoli.setText(l.getSoly());
		textFieldchietkhau.setText(l.getChietkhau());
		
		
	    
	}
	int current = 0;
	protected void do_table_mouseClicked(MouseEvent e) {
		current = table.getSelectedRow();
		Display(current);
		panelVIP.setVisible(true);
	}
	protected void do_btnSa_actionPerformed(ActionEvent e) {
		 if(textFieldMATHE.getText().equals(" ")) {
			 JOptionPane.showMessageDialog(this, "MỜI ADMIN NHẬP MÃ !!");
			 textFieldMATHE.requestFocus();
			 return;
		 }
		 try {
			 int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			String sql = "update dbo.khachhang set   cmnd = ? , name = ? , ngaydangki = ? ,phoneNumber = ? ,email = ? , soly = ? ,chietkhau = ? 	where MATHE =?";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, textFieldcmnd.getText());
			st.setString(2, textFieldname.getText());
			st.setString(3, textFielddatedk.getText());
			st.setString(4, textFieldsdt.getText());
			st.setString(5, textFieldemail.getText());
			st.setString(6, textFieldsoli.getText());
			st.setString(7, textFieldchietkhau.getText());
			
			st.setString(8, textFieldMATHE.getText());
			
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
		if(textFieldMATHE.getText().equals(" ")) {
			JOptionPane.showMessageDialog(this, "vui long nhap ma");
			textFieldMATHE.requestFocus();
			return;
		}
		try {
			int row =0;
			Class.forName(driver);
			Connection conn  = DriverManager.getConnection(url,user,password);
			String sql = " DELETE FROM dbo.khachhang where MATHE = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, textFieldMATHE.getText());
			row = st.executeUpdate();
			if(row > 0)
			JOptionPane.showMessageDialog(this, "delete thanh cong!");
			else {
				JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN ĐỐI TƯỢNG ĐỂ XÓA !");
			}
			conn.close();
			
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		loaddatatoarraylist();
		loadarraylisttotable();
		
		
	}
	protected void do_btnTmKim_actionPerformed(ActionEvent e) {
		try {
	        Class.forName(driver);
	        Connection conn = DriverManager.getConnection(url, user, password);
	        String sql = "select * from dbo.khachhang where MATHE like N'%" + textFieldMATHE.getText() + "%'";
	        System.out.println(sql);
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        list.clear(); // Clear existing data before loading new results
	        while (rs.next()) {
	        	String mathe1= rs.getString(1);
		    	String cmnd1 = rs.getString(2);
		    	String  name1 = rs.getString(3);
		    	Date ngaydangki1 = rs.getDate(4);
		    	String phone1 = rs.getString(5);		    	
		    	String email1 = rs.getString(6);
		    	String soly2 = rs.getString(7);
		    	String chietkhau2 = rs.getString(8);
	            khachhangvip k = new khachhangvip(mathe1, cmnd1, name1, ngaydangki1, phone1, email1, soly2, chietkhau2);
	            list.add(k);
	        }
	        conn.close();
	        loadarraylisttotable();
	    } catch (Exception e2) {
	        e2.printStackTrace();
	    }
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		GDadmin k = new GDadmin();
		k.setVisible(true);
		this.dispose();
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		textFieldchietkhau.setText(" ");
		textFieldcmnd.setText(" ");
		textFielddatedk.setText(" ");
		textFieldMATHE.setText(" ");
		textFieldemail.setText(" ");
		textFieldname.setText(" ");
		textFieldsdt.setText(" ");
		textFieldsoli.setText(" ");
		
	}
	}
	

