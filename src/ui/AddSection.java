package ui;

import Dao.PlasticDAO;
import PlasticDBConnection.PlasticDBConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PlasticDBConnection.Queries;
import SubClasses.PlasticBottle;

public class AddSection {
    private JTextField textFieldQty;
    private JTextField textFieldName;
    private JButton addButton;
    private JPanel overviewPanel;

    private PlasticDAO plasticDAO = new PlasticDAO();

    public AddSection() {
        JPanel root = this.getOverviewPanel();
        JFrame frame = new JFrame("Add a new plastic");
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlasticBottle plasticBottle = new PlasticBottle(textFieldName.getText(), Integer.parseInt(textFieldQty.getText()));
                plasticDAO.create(plasticBottle);
                frame.dispose();
            }
        });
    }

    public JPanel getOverviewPanel() {
        return overviewPanel;
    }
}
