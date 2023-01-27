package Mockup;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractListModel;




public class Mockup extends JFrame {
	private static final long serialVersionUID = 1L;

    JTabbedPane tabbedPane = new JTabbedPane();
  
   

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	try {
            	    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            	    Mockup frame = new Mockup();
            	    frame.setVisible(true);
            	} catch (Exception e) {
            	    e.printStackTrace();
            	}
            }
        });
        
       
        
    
       
    }


    public Mockup() {
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 



        JRootPane rootPane = getRootPane();
       
        rootPane.setWindowDecorationStyle(JRootPane.NONE);


        setLocationRelativeTo(null);
       
        // Create menu bar
        JMenuBar menuBar = new JMenuBar();


        setJMenuBar(menuBar);
        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        fileMenu.add(newItem);
        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        
        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        editMenu.add(cutItem);
        JMenuItem copyItem = new JMenuItem("Copy");
        editMenu.add(copyItem);
        JMenuItem pasteItem = new JMenuItem("Paste");
        editMenu.add(pasteItem);
        menuBar.add(editMenu);
        
        // View menu
        JMenu viewMenu = new JMenu("View");
        JMenuItem customerViewItem = new JMenuItem("Customer");
        viewMenu.add(customerViewItem);
        JMenuItem productViewItem = new JMenuItem("Product");
        viewMenu.add(productViewItem);
        JMenuItem orderViewItem = new JMenuItem("Order");
        viewMenu.add(orderViewItem);
        menuBar.add(viewMenu);
        
        // Reports menu
        JMenu reportsMenu = new JMenu("Reports");
        JMenuItem customerReportItem = new JMenuItem("Customer");
        reportsMenu.add(customerReportItem);
        JMenuItem productReportItem = new JMenuItem("Product");
        reportsMenu.add(productReportItem);
        JMenuItem orderReportItem = new JMenuItem("Order");
        reportsMenu.add(orderReportItem);
        menuBar.add(reportsMenu);
        
        // Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        // Create side bar
    
        JList<String> sideBar = new JList<String>(new AbstractListModel<String>() {
        
			private static final long serialVersionUID = 1L;
	
		
			String[] values = new String[] {"Dashboard","Business Status ", "Customers & Sales ", "Vendors & Purchases ", "Customer List", "Inventory"};
        	public int getSize() {
        		return values.length;
        	}
        	public String getElementAt(int index) {
        		return values[index];
        	}
        });
        sideBar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sideBar.setLayoutOrientation(JList.VERTICAL);
        sideBar.setFixedCellHeight(50);
        JScrollPane sideBarScrollPane = new JScrollPane(sideBar);
        getContentPane().add(sideBarScrollPane, BorderLayout.WEST);
        

        
       
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("Dashboard", new JPanel());
        tabbedPane.addTab("Dashboard Management", new JPanel());
        tabbedPane.setSelectedIndex(0);
      
        

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
        sideBar.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = sideBar.getSelectedIndex();
                    tabbedPane.removeAll();
                    tabbedPane.addTab((String) sideBar.getModel().getElementAt(selectedIndex), new JPanel());
                    tabbedPane.addTab((String) sideBar.getModel().getElementAt(selectedIndex) + " Management", new JPanel());
                }
            }
        });
        
       
       

       
        
        setVisible(true);

        
        
    	}
}
