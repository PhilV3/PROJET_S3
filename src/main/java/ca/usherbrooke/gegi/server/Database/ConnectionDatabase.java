package ca.usherbrooke.gegi.server.Database;
import java.sql.*;

public class ConnectionDatabase {
    private Connection connection = null;
    private String url = "jdbc:postgresql://zeus.gel.usherbrooke.ca:5432/s3iprojet00";
    private String password = "s3iprojet";
    private String username = "s3iprojet00";

    /**
     * Set la connection entre la database comme étant bonne, ou quitte le programme
     */
    public ConnectionDatabase() {
    if (Connection());
        else {
        System.out.println("Connection failed");
        System.exit(1);
        }
    }

    /**
     * Teste la connection entre le système et la database
     * @return Retourne le succès ou non
     */
    private boolean Connection(){
        boolean good = false;
        if (connection == null){
             try{
                 Class.forName("org.postgresql.Driver");
                 connection =  DriverManager.getConnection(url,username,password);
                 good = (connection != null);
                 return good;
             }catch (ClassNotFoundException e){
                 System.out.println("Driver not found");
                 return good;
             }catch (SQLException e ){
                 System.out.println("Connection failed");
                 return good;
             }finally {
                 return good;
             }
        }
        return good;
    }

    /**
     * Crée le statement qui sera exécuté dans la database
     * @return retourne le statement exécutable
     */
    public Statement createSte(){
        try{
            return connection.createStatement();
        }catch (SQLException e){
            System.out.println("Erreur, statement cannot be created");
        }
    return null;

    }

}
