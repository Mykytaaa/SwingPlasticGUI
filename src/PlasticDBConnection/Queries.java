package PlasticDBConnection;

public class Queries {
    public static final String SELECT_ALL = "SELECT * FROM p_plastic";
    public static final String SELECT_BY_ID = "SELECT plastic_name, volume, density, qty FROM p_plastic WHERE id=?";
    public static final String SELECT_BY_PLASTIC_NAME = "SELECT id, volume, density, qty FROM p_plastic WHERE plastic_name=?";
    public static final String SELECT_BY_QTY= "SELECT id, volume, density, plastic_name FROM p_plastic WHERE qty=?";
    public static final String INSERT_NEW= "INSERT INTO p_plastic(plastic_name, volume, density, qty) VALUES(?, ?, ?, ?)";
    public static final String DELETE= "DELETE FROM p_plastic WHERE id=?";
}
