


package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class JDBC {
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","banco","banco");
        String selectSQL= " SELECT * from entidadbancaria WHERE idEntidadBancaria=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
      preparedStatement.setInt(1, 1);
        ResultSet rs =preparedStatement.executeQuery();
        
        while (rs.next()){
            String idEntidad =rs.getString("idEntidadBancaria");
            String CodigoEntidad = rs.getString("codigoEntidad");
            String Nombre  = rs.getString("nombre");
            String cif = rs.getString("cif");
            System.out.println("ID " + "CódigoEntidad  " +"NombreEntidad "+ "Cif ");
            System.out.println(" "+idEntidad+"     "+CodigoEntidad+"     " +Nombre+"     "+cif  );
        }
        
        
        
        connection.close();
        System.out.println("Se ha conectado a la BD!!");
        
    }
}
    

