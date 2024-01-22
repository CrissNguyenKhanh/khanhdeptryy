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
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import daoquanlithucan.loaicafe;
import daoquanlithucan.quanlithucandao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class quanlithucuong extends JFrame {
     private ArrayList<loaicafe> list ;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldid;
	private JTextField textFielname;
	private JTextField textFieldkind;
	private JTextField textFieldgia;
	private JTextField textFieldsize;
	private JTable table;
	int current = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanlithucuong frame = new quanlithucuong();
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
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	   String url ="jdbc:sqlserver://localhost:1433;databaseName=duan";
	   String user = "sa";
	   String password = "123456789";
	   Statement st;
	   ResultSet rs;
	   private JScrollPane scrollPane_1;
	   private JButton btnNewButton_1;
	
	public quanlithucuong() {
		this.setLocationRelativeTo(null);
	   list = new ArrayList<loaicafe>();
	     int current = 0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 763);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID SẢN PHẨM:");
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(26, 42, 129, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnSnPhm = new JLabel("TÊN SẢN PHẨM:");
		lblTnSnPhm.setBackground(Color.RED);
		lblTnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnSnPhm.setBounds(26, 119, 129, 47);
		contentPane.add(lblTnSnPhm);
		
		JLabel lblLoiSnPhm = new JLabel("LOẠI SẢN PHẨM:");
		lblLoiSnPhm.setBackground(Color.RED);
		lblLoiSnPhm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoiSnPhm.setBounds(26, 176, 180, 47);
		contentPane.add(lblLoiSnPhm);
		
		JLabel lblKchC = new JLabel("GIÁ SẢN PHẨM:");
		lblKchC.setBackground(Color.RED);
		lblKchC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKchC.setBounds(26, 246, 129, 47);
		contentPane.add(lblKchC);
		
		JLabel lblKchC_1 = new JLabel("KÍCH CỠ :");
		lblKchC_1.setBackground(Color.RED);
		lblKchC_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKchC_1.setBounds(26, 313, 129, 47);
		contentPane.add(lblKchC_1);
		
		textFieldid = new JTextField();
		textFieldid.setBounds(186, 50, 400, 35);
		contentPane.add(textFieldid);
		textFieldid.setColumns(10);
		
		textFielname = new JTextField();
		textFielname.setColumns(10);
		textFielname.setBounds(186, 119, 400, 35);
		contentPane.add(textFielname);
		
		textFieldkind = new JTextField();
		textFieldkind.setColumns(10);
		textFieldkind.setBounds(186, 176, 400, 35);
		contentPane.add(textFieldkind);
		
		textFieldgia = new JTextField();
		textFieldgia.setColumns(10);
		textFieldgia.setBounds(186, 258, 400, 35);
		contentPane.add(textFieldgia);
		
		textFieldsize = new JTextField();
		textFieldsize.setColumns(10);
		textFieldsize.setBounds(186, 325, 400, 35);
		contentPane.add(textFieldsize);
		
		JButton btnAdd = new JButton("THÊM");
		btnAdd.setIcon(new ImageIcon("D:\\dowload\\plus.png"));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(66, 396, 98, 27);
		contentPane.add(btnAdd);
		
		JButton btnSa = new JButton("SỬA");
		btnSa.setIcon(new ImageIcon("D:\\dowload\\tools.png"));
		btnSa.setBackground(Color.WHITE);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSa_actionPerformed(e);
			}
		});
		btnSa.setBounds(208, 396, 98, 27);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("XÓA");
		btnXa.setIcon(new ImageIcon("D:\\dowload\\trash-can.png"));
		btnXa.setBackground(Color.WHITE);
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXa_actionPerformed(e);
			}
		});
		btnXa.setBounds(371, 396, 98, 27);
		contentPane.add(btnXa);
		
		JButton btnLmMi = new JButton("LÀM MỚI");
		btnLmMi.setIcon(new ImageIcon("D:\\dowload\\turn-down.png"));
		btnLmMi.setBackground(Color.WHITE);
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLmMi_actionPerformed(e);
			}
		});
		btnLmMi.setBounds(536, 396, 115, 27);
		contentPane.add(btnLmMi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 450, 697, 266);
		contentPane.add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.setBackground(Color.CYAN);
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
				"ID", "T\u00CAN", "LO\u1EA0I", "GI\u00C1", "K\u00CDCH C\u1EE0"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("x");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(646, 10, 77, 63);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("find");
		btnNewButton_1.setIcon(new ImageIcon("D:\\dowload\\search.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(616, 191, 85, 41);
		contentPane.add(btnNewButton_1);
		
		loaddatatoarraylist();
		loadarraylisttotable();
		this.setLocationRelativeTo(null);
		
		
	}
	
	//bat trung khoa 
	public boolean checktrungkhoa(String ma ) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).id.equalsIgnoreCase(ma)) {
				return true;
				
			}
		
		}
		return false;
	}
	
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if(checktrungkhoa(textFieldid.getText())== true) {
			JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN MÃ KHÁC VỚI MÃ CŨ ĐỂ THÊM!!");
			
		}else {
		try {
			int row =0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			String sql = " INSERT INTO dbo.loaicaphe  values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, textFieldid.getText());
			ps.setString(2, textFielname.getText());
			ps.setString(3,textFieldkind.getText());
			ps.setString(4, textFieldgia.getText());
			ps.setString(5, textFieldsize.getText());
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
	public void loaddatatoarraylist() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from dbo.loaicaphe";
		    PreparedStatement ps =conn.prepareStatement(sql);
		    ResultSet rs = ps.executeQuery();
		    list.clear();
		    while(rs.next()) {
		    	String id = rs.getString(1);
		    	String name = rs.getString(2);
		    	String kind = rs.getString(3);
		    	Float gia = rs.getFloat(4);
		    	String size = rs.getString(5);
		    	loaicafe l = new loaicafe(id,name , kind , gia , size);
		    	
		    	list.add(l);
		    }
		    conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void loadarraylisttotable() {
		DefaultTableModel model  =  (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(loaicafe l : list) {
			model.addRow(new Object[] {
				l.getId(),l.getName(),l.getKind(),l.getMoney(),l.getSize()
			});
		}
	}

	protected void do_table_mouseClicked(MouseEvent e) {
		current = table.getSelectedRow();
		Display(current);
	}
	public void Display(int i)
	{
		loaicafe l = list.get(i);
		textFieldid.setText(l.getId());
		textFielname.setText(l.getName());
		textFieldkind.setText(l.getKind());
		 textFieldgia.setText(String.valueOf(l.getMoney()));
		textFieldsize.setText(l.getSize());
		
	}
	protected void do_btnXa_actionPerformed(ActionEvent e) {
		if(textFieldid.getText().equals(" ")) {
			JOptionPane.showMessageDialog(this, "vui long nhap ma");
			textFieldid.requestFocus();
			return;
		}
		try {
			int row =0;
			Class.forName(driver);
			Connection conn  = DriverManager.getConnection(url,user,password);
			String sql = " DELETE FROM dbo.loaicaphe where ID = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, textFieldid.getText());
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
	protected void do_btnSa_actionPerformed(ActionEvent e) {
	 if(textFieldid.getText().equals(" ")) {
		 JOptionPane.showMessageDialog(this, "MỜI ADMIN NHẬP MÃ !!");
		 textFieldid.requestFocus();
		 return;
	 }
	 try {
		 int row = 0;
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		String sql = "update dbo.loaicaphe set  name = ? , kind = ? , gia = ? , size = ? where ID =?";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, textFielname.getText());
		st.setString(2, textFieldkind.getText());
		st.setString(3, textFieldgia.getText());
		st.setString(4, textFieldsize.getText());
		st.setString(5, textFieldid.getText());
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
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		GDadmin k =  new GDadmin();
		k.setVisible(true);
		this.dispose();
	}
	protected void do_btnLmMi_actionPerformed(ActionEvent e) {
		textFieldid.setText(" " );
		textFieldgia.setText(" " );
		textFieldkind.setText(" ");
		textFieldsize.setText(" " );
		textFielname.setText("  " );
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
	    try {
	        Class.forName(driver);
	        Connection conn = DriverManager.getConnection(url, user, password);
	        String sql = "select * from dbo.loaicaphe where ID like N'%" + textFieldid.getText() + "%'";
	        System.out.println(sql);
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        list.clear(); // Clear existing data before loading new results
	        while (rs.next()) {
	            String id = rs.getString("ID");
	            String name = rs.getString("name");
	            String kind = rs.getString("kind");
	            float gia = rs.getFloat("gia");
	            String size = rs.getString("size");
	            loaicafe k = new loaicafe(id, name, kind, gia, size);
	            list.add(k);
	        }
	        conn.close();
	        loadarraylisttotable();
	    } catch (Exception e2) {
	        e2.printStackTrace();
	    }
	}
}
