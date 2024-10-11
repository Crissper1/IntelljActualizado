import javax.swing.*;
import java.sql.*;

public class BaseDeDatos {
    //parámetros para la conexión: final = una constante
    private final String url = "jdbc:mysql://localhost:3306/login";
    private final String usuario = "root";
    private final String contra = "";

    //Propiedades de la clase
    private Connection conexion;
    private ResultSet resultado;

    //Método constructor
    public BaseDeDatos() {
        try{
            this.conexion = DriverManager.getConnection(url, usuario, contra);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage() );
        }
    }

    public void ejecutarSQL(PreparedStatement sql){
        try{
            this.resultado = sql.executeQuery();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage() );
        }
    }

    //Métodos getters & setters
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

}
