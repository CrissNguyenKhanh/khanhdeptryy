package daoquanlithucan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class quanlithucandao{
    private Connection conn;

    public quanlithucandao() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Tutorial",
                    "sa", "123456789");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean addcf(loaicafe l ) {
    	String sql = "INSERT INTO dbo.loaicaphe(ID,name,kind,gia,size) VALUES(?,?,?,?,?)";
    	try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, l.getId());
			ps.setString(2, l.getName());
			ps.setString(3, l.getKind());
			ps.setString(4, l.getSize());
			ps.setFloat(5, l.getMoney());
			
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	return false;
    	
    }
    //doc ra 
    public ArrayList<loaicafe> getlisst(){
    	ArrayList<loaicafe> list = new ArrayList<loaicafe>();
    	String sql = "SELECT * FROM dbo.loaicaphe";
    	try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				loaicafe l = new loaicafe();
				l.setId(rs.getString("ID"));
				l.setName(rs.getString("name"));
				l.setKind(rs.getString("kind"));
				l.setMoney(rs.getFloat("gia"));
				l.setSize(rs.getString("size"));
				
				list.add(l);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	return list;
    }
}
