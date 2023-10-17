import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBD {
    private static String 
        DRIVER = "com.mysql.jdbc.Driver",
        USER = System.getenv("MARIADB_USER"),
        PASS = System.getenv("MARIADB_PASS"),
        PORT = "3306",
        HOST = "127.0.0.1",
        BD = "mercado",
        // estilo da URL: "jdbc:mysql://localhost:3306/mercao"
        URL = "jdbc:mariadb://"+HOST+":"+PORT+"/"+BD;

    static Connection conn;
    static PreparedStatement estado;
      
    public static void abrirConexao () {
        try {
            // Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            JOptionPane.showMessageDialog(null, "Conexão bem-sucedida em "+URL);
      /*} catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver necessário para a conexão não encontrado.");
            e.printStackTrace();  */
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar assegurar conexão.");
            e.printStackTrace();
        }
    }

    public static void fecharConexao () {
        try {
            estado.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Conexão encerrada em "+URL);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar encerrar conexão.");
            e.printStackTrace();
        }
    }
}
