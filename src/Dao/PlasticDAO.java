package Dao;

import PlasticDBConnection.*;
import SubClasses.PlasticBottle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PlasticDAO implements DAOInterface<PlasticBottle>{
    PlasticDBConnection plasticDBConnection = new PlasticDBConnection();

    @Override
    public boolean create(PlasticBottle plasticBottle) {

        try(PreparedStatement preparedStatement = plasticDBConnection.getConnection().prepareStatement(Queries.INSERT_NEW)){

            preparedStatement.setString(1, plasticBottle.getPlasticName());
            preparedStatement.setInt(2, plasticBottle.getPackingVolume());
            preparedStatement.setInt(3, plasticBottle.getDensity());
            preparedStatement.setInt(4, plasticBottle.getQty());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return true;
    }

    @Override
    public Object[][] read_all() {

        Object[][] data;

        try(PreparedStatement preparedStatement = plasticDBConnection.getConnection().prepareStatement(Queries.SELECT_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            List<PlasticBottle> list = new ArrayList<>();

            while(resultSet.next()){
                String plastic_name = resultSet.getString("plastic_name");
                int volume = resultSet.getInt("volume");
                int density = resultSet.getInt("density");
                int qty = resultSet.getInt("qty");
                int id = resultSet.getInt("id");

                PlasticBottle plasticBottle = new PlasticBottle(plastic_name, qty, volume, id, density);
                list.add(plasticBottle);
            }

            data = new Object[list.size()][5];

            for(int i = 0; i < data.length; i++){
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getPlasticName();
                data[i][2] = list.get(i).getPackingVolume();
                data[i][3] = list.get(i).getDensity();
                data[i][4] = list.get(i).getQty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public Object[][] read_by_id(int id) {
        Object[][] data = new Object[1][5];

        try(PreparedStatement preparedStatement = plasticDBConnection.getConnection().prepareStatement(Queries.SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                String plastic_name = resultSet.getString("plastic_name");
                int volume = resultSet.getInt("volume");
                int density = resultSet.getInt("density");
                int qty = resultSet.getInt("qty");

                createPlastic(id, data, plastic_name, volume, density, qty);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public Object[][] read_by_name(String plasticName) {
        Object[][] data = new Object[1][5];

        try(PreparedStatement preparedStatement = plasticDBConnection.getConnection().prepareStatement(Queries.SELECT_BY_PLASTIC_NAME)){
            preparedStatement.setString(1, plasticName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int volume = resultSet.getInt("volume");
                int density = resultSet.getInt("density");
                int qty = resultSet.getInt("qty");
                int id = resultSet.getInt("id");

                createPlastic(id, data, plasticName, volume, density, qty);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public Object[][] read_by_qty(int qty) {
        Object[][] data = new Object[1][5];

        try(PreparedStatement preparedStatement = plasticDBConnection.getConnection().prepareStatement(Queries.SELECT_BY_QTY)){
            preparedStatement.setInt(1, qty);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int volume = resultSet.getInt("volume");
                int density = resultSet.getInt("density");
                String plasticName = resultSet.getString("plastic_name");
                int id = resultSet.getInt("id");

                createPlastic(id, data, plasticName, volume, density, qty);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    @Override
    public boolean delete(int id) {
        try(PreparedStatement preparedStatement = plasticDBConnection.getConnection().prepareStatement(Queries.DELETE)){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return true;
    }

    private void createPlastic(int id, Object[][] data, String plastic_name, int volume, int density, int qty) {
        PlasticBottle plasticBottle = new PlasticBottle(plastic_name, qty, volume, id, density);

        data[0][0] = plasticBottle.getId();
        data[0][1] = plasticBottle.getPlasticName();
        data[0][2] = plasticBottle.getPackingVolume();
        data[0][3] = plasticBottle.getDensity();
        data[0][4] = plasticBottle.getQty();
    }
}
