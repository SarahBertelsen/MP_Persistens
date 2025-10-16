package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import ctrl.CustomerCtrl;
import ctrl.SaleOrderCtrl;
import model.SaleOrder;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontPageView {

	private SaleOrderCtrl soCtrl;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPageView window = new FrontPageView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrontPageView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		soCtr = new SaleOrderCtrl();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel companyNameLabel = new JLabel("Western Style Ltd");
		companyNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(companyNameLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Employee Id:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Employee name:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JButton createOrderBtn = new JButton("Create new sale order");
		createOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createOrderClicked();
			}
		});
		
		GridBagConstraints gbc_createOrderBtn = new GridBagConstraints();
		gbc_createOrderBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_createOrderBtn.insets = new Insets(0, 0, 5, 5);
		gbc_createOrderBtn.gridx = 8;
		gbc_createOrderBtn.gridy = 2;
		panel_1.add(createOrderBtn, gbc_createOrderBtn);
		
		JButton stockBtn = new JButton("Stock");
		GridBagConstraints gbc_stockBtn = new GridBagConstraints();
		gbc_stockBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_stockBtn.insets = new Insets(0, 0, 5, 5);
		gbc_stockBtn.gridx = 8;
		gbc_stockBtn.gridy = 3;
		panel_1.add(stockBtn, gbc_stockBtn);
		
		JButton saleOrdersBtn = new JButton("Sale orders");
		GridBagConstraints gbc_saleOrdersBtn = new GridBagConstraints();
		gbc_saleOrdersBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_saleOrdersBtn.insets = new Insets(0, 0, 5, 5);
		gbc_saleOrdersBtn.gridx = 8;
		gbc_saleOrdersBtn.gridy = 4;
		panel_1.add(saleOrdersBtn, gbc_saleOrdersBtn);
		
		JButton customersBtn = new JButton("Customers");
		GridBagConstraints gbc_customersBtn = new GridBagConstraints();
		gbc_customersBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_customersBtn.insets = new Insets(0, 0, 5, 5);
		gbc_customersBtn.gridx = 8;
		gbc_customersBtn.gridy = 5;
		panel_1.add(customersBtn, gbc_customersBtn);
		
		JButton employeesBtn = new JButton("Employees");
		GridBagConstraints gbc_employeesBtn = new GridBagConstraints();
		gbc_employeesBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_employeesBtn.insets = new Insets(0, 0, 5, 5);
		gbc_employeesBtn.gridx = 8;
		gbc_employeesBtn.gridy = 6;
		panel_1.add(employeesBtn, gbc_employeesBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Log Out");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.gridx = 18;
		gbc_lblNewLabel_2.gridy = 8;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("  ...  ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.gridx = 18;
		gbc_lblNewLabel_1.gridy = 9;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}
	
	private void createOrderClicked(){
		SaleOrderView sov = new SaleOrderView(soCtrl);
		soCtrl.createSaleOrder();
		sov.setVisible(true);
		
	}
	

}
