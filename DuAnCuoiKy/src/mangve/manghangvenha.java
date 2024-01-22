package mangve;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import khachhangvip.khachhangvip;
import quanlidouong.douong;
import view1.GDnhanvien;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class manghangvenha extends JFrame {
	private ArrayList<douong> list;
  GDnhanvien k ;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField textFieldsdt;
	private JTextField textFieldship;
	private JTable table;
	private DecimalFormat decimalFormat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 GDnhanvien k = new GDnhanvien();
					manghangvenha frame = new manghangvenha(k);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    String url = "jdbc:sqlserver://localhost:1433;databaseName=duan";
	    String user = "sa";
	    String password = "123456789";
	    ResultSet rs;


		private double thanhtien;


		private DefaultTableModel model;
		private JTextArea textAreadiachi;


		

		
		private String formattedTotalAmount;
		
		private JLabel tienkhachtra;
		private JLabel tienthua;
		private JTextField textFieldname;
		private JLabel tongtien;
	
	public manghangvenha(GDnhanvien k) {
		list = new ArrayList<douong>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 730);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 10, 261, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ Và Tên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 54, 261, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số ĐT:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 140, 261, 55);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phí Ship:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(10, 234, 261, 55);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(10, 313, 261, 55);
		contentPane.add(lblNewLabel_1_3);
		
		
		textFieldsdt = new JTextField();
		textFieldsdt.setColumns(10);
		textFieldsdt.setBounds(10, 192, 309, 32);
		contentPane.add(textFieldsdt);
		
		textFieldship = new JTextField();
		textFieldship.setColumns(10);
		textFieldship.setBounds(10, 293, 309, 32);
		contentPane.add(textFieldship);
		
		textAreadiachi = new JTextArea();
		textAreadiachi.setBounds(10, 357, 318, 99);
		contentPane.add(textAreadiachi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(411, 39, 440, 407);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.setBackground(Color.CYAN);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u0110\u1ED3 U\u1ED1ng", "Gi\u00E1 Ti\u1EC1n", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("GIAO HÀNG");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("D:\\dowload\\delivery (1).png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(314, 591, 169, 80);
		contentPane.add(btnNewButton);
		
		tongtien = new JLabel("");
		tongtien.setFont(new Font("Tahoma", Font.BOLD, 45));
		tongtien.setBounds(598, 472, 253, 80);
		contentPane.add(tongtien);
	
		loaddatatoarraylist();
		loadarraylisttotable();
	  k = new GDnhanvien();
	  this.k = k;
	  
	  
	  JButton btnNewButton_1 = new JButton("TOTAL");
	  btnNewButton_1.setBackground(Color.WHITE);
	  btnNewButton_1.setIcon(new ImageIcon("D:\\dowload\\money.png"));
	  btnNewButton_1.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	  		do_btnNewButton_1_actionPerformed(e);
	  	}
	  });
	  btnNewButton_1.setBounds(322, 494, 200, 37);
	  contentPane.add(btnNewButton_1);
	  
	  textFieldname = new JTextField();
	  textFieldname.setBounds(10, 100, 309, 32);
	  contentPane.add(textFieldname);
	  textFieldname.setColumns(10);
	  
	  JButton btnNewButton_2 = new JButton("");
	  btnNewButton_2.setContentAreaFilled(false);
	  btnNewButton_2.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	  		do_btnNewButton_2_actionPerformed(e);
	  	}
	  });
	  btnNewButton_2.setIcon(new ImageIcon("D:\\dowload\\previous.png"));
	  btnNewButton_2.setBackground(Color.GREEN);
	  btnNewButton_2.setBounds(702, 494, 135, 145);
	  contentPane.add(btnNewButton_2);
	}
	public void loaddatatoarraylist() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "select * from dbo.ban1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				String douong1 = rs.getString(1);
				double giatien = rs.getDouble(2);
				int soluong = rs.getInt(3);
				thanhtien = rs.getDouble(4);
				douong k = new douong(douong1, giatien, soluong, thanhtien);
				list.add(k);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loadarraylisttotable() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		DecimalFormat decimalFormat = new DecimalFormat("#.###");

		for (douong k : list) {

			String formattedGiaTien = decimalFormat.format(k.giatien);
			String formattedThanhTien = decimalFormat.format(k.giatien * k.soluong);

			model.addRow(new Object[] { k.nuoc, formattedGiaTien, k.soluong, formattedThanhTien });
		}
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
   generateAndPrintInvoice();
		
		
		
	}

	private void generateAndPrintInvoice() {
	    try {
	    	
	        Date currentDate = new Date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ,  HH:mm:ss");
	        String formattedDate = dateFormat.format(currentDate);

	        double totalAmount = Double.parseDouble(tongtien.getText());

	        String invoiceContent = "Date: " + formattedDate + "\n";
	        invoiceContent += "Total Amount: " + formattedTotalAmount + "\n";

	        
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        for (int i = 0; i < model.getRowCount(); i++) {
	            String drinkName = model.getValueAt(i, 0).toString();
	            String price = model.getValueAt(i, 1).toString();
	            String quantity = model.getValueAt(i, 2).toString();
	            String subtotal = model.getValueAt(i, 3).toString();

	            invoiceContent +=  "Họ Tên Khách Hàng" + textFieldname.getText() + "\n" + "Số Điện Thoại: " + textFieldsdt.getText() + 
	            		 "\n" + "Phí ship: " + textFieldship.getText() + 
	            		  "\n" + "Địa Chỉ: " + textAreadiachi.getText() + "\n" +"Item: " + drinkName + ", Price: " + price + ", Quantity: "
	                    + quantity + ", Subtotal: " + subtotal + "\n";
	        }

	       
	        String tableNumber = "1"; 
                
	        
	        invoiceContent += "Table Number: " + tableNumber + "\n";

	        String filePath = "C:\\hoadon\\mangve.txt";
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            writer.write(invoiceContent);
	            System.out.println("Invoice saved to: " + filePath);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error while saving the invoice.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Please calculate total amount first.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		try {
    		Class.forName(driver);
    		Connection conn = DriverManager.getConnection(url, user, password);

    		String sql = "SELECT SUM(moneytotal) AS totalAmount FROM dbo.ban1";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ResultSet rs = ps.executeQuery();

    		if (rs.next()) {
    			double totalAmount = rs.getDouble("totalAmount");

    		
    			decimalFormat = new DecimalFormat("#.###");
    			formattedTotalAmount = decimalFormat.format(totalAmount);

    			
    			tongtien.setText(formattedTotalAmount);

    			
    		}

    		conn.close();
    	} catch (Exception e1) {
    		e1.printStackTrace();
    	}
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
