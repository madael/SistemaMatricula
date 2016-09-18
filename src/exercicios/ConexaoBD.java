package exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel Lucarelli
 */
public class ConexaoBD {
    private static Connection conn = null;
    private static Connection conn2 = null;
    private static Connection conn3 = null;

    /**
     * @return the conn2
     */
    public static Connection getConn2() {
        return conn2;
    }

    /**
     * @return the conn3
     */
    public static Connection getConn3() {
        return conn3;
    }
    
    private ConexaoBD(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LpsProjeto","postgres","34511781");
            conn2 = conn;
            conn3 = conn;            
        }catch(ClassNotFoundException e){
            System.out.println("Erro no driver de conexão "+e);
        }catch(SQLException ex){
            System.out.println("Não foi possivel conectar "+ ex);
        }
    }
    
    public static Connection conexao(){
        if(conn==null)
            new ConexaoBD();
        return conn;
    }
    
    

    
}
