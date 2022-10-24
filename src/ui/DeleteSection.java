package ui;

import Dao.PlasticDAO;
import PlasticDBConnection.PlasticDBConnection;
import SubClasses.PlasticBottle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PlasticDBConnection.Queries;

public class DeleteSection {
    private JTextField textFieldId;
    private JButton ButtonDeleteId;
    private JPanel deletePanel;

    PlasticDAO plasticDAO = new PlasticDAO();

    public DeleteSection() {
        JPanel root = this.getDeletePanel();
        JFrame frame = new JFrame("Delete");
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ButtonDeleteId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plasticDAO.delete(Integer.parseInt(textFieldId.getText()));

                frame.dispose();
            }
        });
    }

    public JPanel getDeletePanel() {
        return deletePanel;
    }
}
