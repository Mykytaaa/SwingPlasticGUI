package ui;

import Dao.PlasticDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class OverviewSection {
    private JLabel Label1;
    private JTable dataTable;
    private JComboBox filters;
    private JTextField textValue;
    private JButton addNew;
    private JButton delete;
    private JPanel overviewPanel;
    private JButton search;

    private PlasticDAO plasticDAO = new PlasticDAO();

    public OverviewSection(){
        JPanel root = this.getRootPanel();
        JFrame frame = new JFrame("Overview data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        createFilters();
        createTable();

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jComboBoxValue = Objects.requireNonNull(filters.getSelectedItem()).toString();
                switch (jComboBoxValue) {
                    case "All the data":
                        createTable();
                        break;
                    case "By id":
                        sortTableById(Integer.parseInt(textValue.getText()));
                        break;
                    case "By title":
                        sortTableByName(textValue.getText());
                        break;
                    case "By qty":
                        sortTableByQty(Integer.parseInt(textValue.getText()));
                        break;
                }

                textValue.setText("");
            }
        });

        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSection addSection = new AddSection();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteSection deleteSection = new DeleteSection();
            }
        });
    }

    private JPanel getRootPanel(){
        return overviewPanel;
    }

    public void createFilters(){
        filters.setModel(new DefaultComboBoxModel(new String[]{"All the data","By id", "By title", "By qty"}));
    }

    public void createTable(){
        Object[][] data = plasticDAO.read_all();


        dataTable.setModel(new DefaultTableModel(
                data,
                new String[]{"id", "plastic name", "volume", "density", "qty"}
        ));

        TableColumnModel columnModel = dataTable.getColumnModel();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setCellRenderer(centerRenderer);
        columnModel.getColumn(3).setCellRenderer(centerRenderer);

    }

    public void sortTableById(int pid){
        Object[][] data = plasticDAO.read_by_id(pid);

        dataTable.setModel(new DefaultTableModel(
                data,
                new String[]{"id", "plastic name", "volume", "density", "qty"}
        ));
    }

    public void sortTableByName(String plasticName){
        Object[][] data = plasticDAO.read_by_name(plasticName);

        dataTable.setModel(new DefaultTableModel(
                data,
                new String[]{"id", "plastic name", "volume", "density", "qty"}
        ));
    }

    public void sortTableByQty(int qty){
        Object[][] data = plasticDAO.read_by_qty(qty);

        dataTable.setModel(new DefaultTableModel(
                data,
                new String[]{"id", "plastic name", "volume", "density", "qty"}
        ));
    }


}
