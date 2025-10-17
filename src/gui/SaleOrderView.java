package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctrl.SaleOrderCtrl;
import db.CustomerDB;
import db.OrderLineItemDB;
import db.ProductDB;
import db.SaleOrderDB;
import db.StockDB;
import model.Customer;
import model.Freight;
import model.OrderLineItem;
import model.SaleOrder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class SaleOrderView extends JFrame {

	private SaleOrderCtrl soCtrl;
	private OrderLineItemTableModel olm;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtCustomerId;
	private JTable olTable;
	private JTextField txtMethod;
	private JTextField txtDeliveryDate;
	private JTextField txtAddress;
	private JTextField txtTotalCost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleOrderView frame = new SaleOrderView(new SaleOrderCtrl(new CustomerDB(), new ProductDB(), new StockDB(), new SaleOrderDB(), new OrderLineItemDB()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SaleOrderView(SaleOrderCtrl soCtrl) {
		this.soCtrl = soCtrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Create sale order");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton addCusBtn = new JButton("Add Customer");
		addCusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomerClicked();
			}
		});
		GridBagConstraints gbc_addCusBtn = new GridBagConstraints();
		gbc_addCusBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_addCusBtn.insets = new Insets(0, 0, 5, 0);
		gbc_addCusBtn.gridx = 0;
		gbc_addCusBtn.gridy = 0;
		panel.add(addCusBtn, gbc_addCusBtn);
		
		JButton addProdBtn = new JButton("Add Product");
		addProdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProductClicked();
			}
		});
		GridBagConstraints gbc_addProdBtn = new GridBagConstraints();
		gbc_addProdBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_addProdBtn.insets = new Insets(0, 0, 5, 0);
		gbc_addProdBtn.gridx = 0;
		gbc_addProdBtn.gridy = 1;
		panel.add(addProdBtn, gbc_addProdBtn);
		
		JButton addFreightBtn = new JButton("Add Freight");
		addFreightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFreightClicked();
			}
		});
		GridBagConstraints gbc_addFreightBtn = new GridBagConstraints();
		gbc_addFreightBtn.insets = new Insets(0, 0, 5, 0);
		gbc_addFreightBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_addFreightBtn.gridx = 0;
		gbc_addFreightBtn.gridy = 2;
		panel.add(addFreightBtn, gbc_addFreightBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Total cost:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 12;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtTotalCost = new JTextField();
		GridBagConstraints gbc_txtTotalCost = new GridBagConstraints();
		gbc_txtTotalCost.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotalCost.gridx = 0;
		gbc_txtTotalCost.gridy = 13;
		panel.add(txtTotalCost, gbc_txtTotalCost);
		txtTotalCost.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel cusLbl = new JLabel("Customer");
		cusLbl.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_cusLbl = new GridBagConstraints();
		gbc_cusLbl.insets = new Insets(0, 0, 5, 0);
		gbc_cusLbl.gridx = 0;
		gbc_cusLbl.gridy = 0;
		panel_1.add(cusLbl, gbc_cusLbl);
		
		JLabel fNameLbl = new JLabel("First name:");
		GridBagConstraints gbc_fNameLbl = new GridBagConstraints();
		gbc_fNameLbl.anchor = GridBagConstraints.WEST;
		gbc_fNameLbl.insets = new Insets(0, 0, 5, 0);
		gbc_fNameLbl.gridx = 0;
		gbc_fNameLbl.gridy = 1;
		panel_1.add(fNameLbl, gbc_fNameLbl);
		
		txtFName = new JTextField();
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.insets = new Insets(0, 0, 5, 0);
		gbc_txtFName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFName.gridx = 0;
		gbc_txtFName.gridy = 2;
		panel_1.add(txtFName, gbc_txtFName);
		txtFName.setColumns(10);
		
		JLabel lNameLbl = new JLabel("Last name:");
		GridBagConstraints gbc_lNameLbl = new GridBagConstraints();
		gbc_lNameLbl.anchor = GridBagConstraints.WEST;
		gbc_lNameLbl.insets = new Insets(0, 0, 5, 0);
		gbc_lNameLbl.gridx = 0;
		gbc_lNameLbl.gridy = 3;
		panel_1.add(lNameLbl, gbc_lNameLbl);
		
		txtLName = new JTextField();
		GridBagConstraints gbc_txtLName = new GridBagConstraints();
		gbc_txtLName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLName.gridx = 0;
		gbc_txtLName.gridy = 4;
		panel_1.add(txtLName, gbc_txtLName);
		txtLName.setColumns(10);
		
		JLabel cusIdLbl = new JLabel("Customer Id:");
		GridBagConstraints gbc_cusIdLbl = new GridBagConstraints();
		gbc_cusIdLbl.anchor = GridBagConstraints.WEST;
		gbc_cusIdLbl.insets = new Insets(0, 0, 5, 0);
		gbc_cusIdLbl.gridx = 0;
		gbc_cusIdLbl.gridy = 5;
		panel_1.add(cusIdLbl, gbc_cusIdLbl);
		
		txtCustomerId = new JTextField();
		GridBagConstraints gbc_txtCustomerId = new GridBagConstraints();
		gbc_txtCustomerId.insets = new Insets(0, 0, 5, 0);
		gbc_txtCustomerId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerId.gridx = 0;
		gbc_txtCustomerId.gridy = 6;
		panel_1.add(txtCustomerId, gbc_txtCustomerId);
		txtCustomerId.setColumns(10);
		
		JLabel freightTitleLbl = new JLabel("Freight");
		GridBagConstraints gbc_freightTitleLbl = new GridBagConstraints();
		gbc_freightTitleLbl.insets = new Insets(0, 0, 5, 0);
		gbc_freightTitleLbl.gridx = 0;
		gbc_freightTitleLbl.gridy = 8;
		panel_1.add(freightTitleLbl, gbc_freightTitleLbl);
		freightTitleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		freightTitleLbl.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel methodLbl = new JLabel("Method:");
		GridBagConstraints gbc_methodLbl = new GridBagConstraints();
		gbc_methodLbl.insets = new Insets(0, 0, 5, 0);
		gbc_methodLbl.gridx = 0;
		gbc_methodLbl.gridy = 9;
		panel_1.add(methodLbl, gbc_methodLbl);
		
		txtMethod = new JTextField();
		GridBagConstraints gbc_txtMethod = new GridBagConstraints();
		gbc_txtMethod.insets = new Insets(0, 0, 5, 0);
		gbc_txtMethod.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMethod.gridx = 0;
		gbc_txtMethod.gridy = 10;
		panel_1.add(txtMethod, gbc_txtMethod);
		txtMethod.setColumns(10);
		
		JLabel DeliveryDateLbl = new JLabel("Delivery date:");
		GridBagConstraints gbc_DeliveryDateLbl = new GridBagConstraints();
		gbc_DeliveryDateLbl.insets = new Insets(0, 0, 5, 0);
		gbc_DeliveryDateLbl.gridx = 0;
		gbc_DeliveryDateLbl.gridy = 11;
		panel_1.add(DeliveryDateLbl, gbc_DeliveryDateLbl);
		
		txtDeliveryDate = new JTextField();
		GridBagConstraints gbc_txtDeliveryDate = new GridBagConstraints();
		gbc_txtDeliveryDate.insets = new Insets(0, 0, 5, 0);
		gbc_txtDeliveryDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDeliveryDate.gridx = 0;
		gbc_txtDeliveryDate.gridy = 12;
		panel_1.add(txtDeliveryDate, gbc_txtDeliveryDate);
		txtDeliveryDate.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 13;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtAddress = new JTextField();
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress.gridx = 0;
		gbc_txtAddress.gridy = 14;
		panel_1.add(txtAddress, gbc_txtAddress);
		txtAddress.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmClicked();
			}
		});
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.gridx = 0;
		gbc_btnConfirm.gridy = 16;
		panel_1.add(btnConfirm, gbc_btnConfirm);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		olTable = new JTable();
		olTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(olTable);

	}

/**	public void addCustomerClicked(int customerId) {
		AddCustomer ac = new AddCustomer(soCtrl);
		ac.setVisible(true);
		
		SaleOrder so = soCtrl.addCustomer(customerId);
		
		
		
		txtCustomerId.setText(String.valueOf(newCustomerId));
		txtFName.setText(firstName);
		txtLName.setText(lastName);
		
	} **/
	
	public void addCustomerClicked() {
		AddCustomer ac = new AddCustomer(soCtrl);
		ac.showDialog();
		
		SaleOrder so = soCtrl.getCurrentOrder();
		
		int customerId = so.getCustomer().getCustomerId();
		String firstName = so.getCustomer().getfName();
		String lastName = so.getCustomer().getlName();
		
		txtCustomerId.setText(String.valueOf(customerId));
		txtFName.setText(firstName);
		txtLName.setText(lastName);
	}
	
	public void addProductClicked() {
		
		AddProduct ap = new AddProduct(soCtrl);
		ap.showDialog();
		
		SaleOrder so = soCtrl.getCurrentOrder();
		
		displayOrderLines(so);
		updateDisplayPrice(so);
	}
	
	public void updateDisplayPrice(SaleOrder so) {
		List<OrderLineItem> orderLines = so.getOrderLines();
		double totalCost = 0;
		for(OrderLineItem ol : orderLines) {
			double price = ol.getProduct().getSalePrice();
			int qty = ol.getQty();
			totalCost += price * qty;
		}
		txtTotalCost.setText(Double.toString(totalCost));
	}
	
	public void displayOrderLines(SaleOrder so) {
		List<OrderLineItem> orderLines = so.getOrderLines();
		OrderLineItemTableModel olm = new OrderLineItemTableModel(orderLines);
		olTable.setModel(olm);
	}
	
	public void addFreightClicked() {

		AddFreight af = new AddFreight(soCtrl);
		af.showDialog();
		
		SaleOrder so = soCtrl.getCurrentOrder();
		Freight freight = so.getFreight();
		
		txtMethod.setText(freight.getMethod());
		txtDeliveryDate.setText(freight.getDeliveryDate().toString());
		txtAddress.setText(freight.getAddress());
		
	}
	
	public void confirmClicked() {
		boolean success = false;
		try {
			success = soCtrl.confirmSaleOrder();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (success) {
			dispose();
		} else {
			System.out.println("Order was not succesfully added, try again.");
		}
		
	}
}
