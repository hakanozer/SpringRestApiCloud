package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {


    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost/";
    final private String endCode = "?useUnicode=true&characterEncoding=utf-8";
    private String dbName = "mvc";
    private String dbUser = "root";
    private String dbPassword = "";

    private Connection conn = null;
    private Statement st = null;
    private PreparedStatement prest = null;
    public DB() {

    }

    public DB(String dbName, String dbUser, String dbPassword){
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        

    }

   
    public Statement baglan() {
        if (st != null) {
            kapat();
        }
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url + dbName + endCode, dbUser, dbPassword);
            st = conn.createStatement();
            System.out.println("baglanti basarili");

        } catch (Exception e) {

            System.err.println("baglanti hatasi! " + e);
        }

        return st;
    }

     public PreparedStatement preBaglan(String query) {

        if (prest != null) {
        	kapat();
        }
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url + dbName + endCode, dbUser, dbPassword);
            prest = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            System.out.println("prepared baglanti basarili");
        } catch (Exception e) {
            System.err.println("prepared baglanti hatasi!:  " + e);
        }

        return prest;
    }

     public void kapat() {
    	 try {
            if (prest != null) {
                prest.close();
                prest = null;
                System.out.println("prepared statement kapatildi");
            }
            if (st != null) {
                st.close();
                st = null;
                 System.out.println("statement kapatildi");
            }
            if (conn != null) {
                conn.close();
                conn = null;
                System.out.println("connection kapatildi");
            }
        } catch (SQLException e) {
            System.err.println("kapatma hatası!: " + e);
        }
    }
}
