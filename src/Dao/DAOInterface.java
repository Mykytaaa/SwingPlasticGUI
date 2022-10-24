package Dao;

public interface DAOInterface<Entity> {
    boolean create(Entity model);
    Object[][] read_all();
    Object[][] read_by_id(int id);
    Object[][] read_by_name(String title);
    Object[][] read_by_qty(int qty);
    boolean delete(int id);
}
