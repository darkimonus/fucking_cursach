package com.simpletrade.alpha;

import com.simpletrade.alpha.dao.OrderDao;
import com.simpletrade.alpha.database.DatabaseHandler;
import com.simpletrade.alpha.model.CourierOrder;
import com.simpletrade.alpha.model.Order;
import com.simpletrade.alpha.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OrderService extends DatabaseHandler implements OrderDao {

    @Override
    public List<CourierOrder> getCourierListIncome() {
        DatabaseHandler dbHandler=new DatabaseHandler();
        List<CourierOrder> orders=new ArrayList<>();
        String SQL="SELECT orders.id,orders.adress,status.name FROM `orders`\n" +
                "                  INNER JOIN `order_status`\n" +
                "                  INNER JOIN status\n" +
                "                             ON orders.id=order_status.order_id where status.id=2;";
        Statement St= null;
        try {
            St = dbHandler.getDbConection().createStatement();
            ResultSet resultSet=St.executeQuery(SQL);
            while(resultSet.next()){
                CourierOrder prod=new CourierOrder(resultSet.getInt(1),
                        resultSet.getString(2),resultSet.getString(3));
                orders.add(prod);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public List<CourierOrder> getCourierListActive() {
        DatabaseHandler dbHandler=new DatabaseHandler();
        List<CourierOrder> orders=new ArrayList<>();
        String SQL="SELECT orders.id,orders.adress,status.name FROM `orders`\n" +
                "                  INNER JOIN `order_status`\n" +
                "                  INNER JOIN status\n" +
                "                             ON orders.id=order_status.order_id where status.id=3;";
        Statement St= null;
        try {
            St = dbHandler.getDbConection().createStatement();
            ResultSet resultSet=St.executeQuery(SQL);
            while(resultSet.next()){
                CourierOrder prod=new CourierOrder(resultSet.getInt(1),
                        resultSet.getString(2),resultSet.getString(3));
                orders.add(prod);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

/*    @Override
    public void updateOrderStatus(int orderId) {
        DatabaseHandler dbHandler=new DatabaseHandler();
        PreparedStatement prSt= null;
        try {
            String SQL="update order_of_client set id_status="+id_status+" where id_order="+id_order+"; ";
            prSt = dbHandler.getDbConection().prepareStatement(SQL);
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }*/
}

