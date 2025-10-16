package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctrl.SaleOrderCtrl;
import model.OrderLineItem;
import model.SaleOrder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class SaleOrderView extends JFrame {

	private SaleOrderCtrl soCtrl;
	private OrderLineItemTableModel olm;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtCusId;
	private JTable olTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleOrderView frame = new SaleOrderView();
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
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton addCusBtn = new JButton("Add Customer");
		GridBagConstraints gbc_addCusBtn = new GridBagConstraints();
		gbc_addCusBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_addCusBtn.insets = new Insets(0, 0, 5, 0);
		gbc_addCusBtn.gridx = 0;
		gbc_addCusBtn.gridy = 0;
		panel.add(addCusBtn, gbc_addCusBtn);
		
		JButton addProdBtn = new JButton("Add Product");
		GridBagConstraints gbc_addProdBtn = new GridBagConstraints();
		gbc_addProdBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_addProdBtn.insets = new Insets(0, 0, 5, 0);
		gbc_addProdBtn.gridx = 0;
		gbc_addProdBtn.gridy = 1;
		panel.add(addProdBtn, gbc_addProdBtn);
		
		JButton addFreightBtn = new JButton("Add Freight");
		GridBagConstraints gbc_addFreightBtn = new GridBagConstraints();
		gbc_addFreightBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_addFreightBtn.gridx = 0;
		gbc_addFreightBtn.gridy = 2;
		panel.add(addFreightBtn, gbc_addFreightBtn);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		txtCusId = new JTextField();
		GridBagConstraints gbc_txtCusId = new GridBagConstraints();
		gbc_txtCusId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCusId.gridx = 0;
		gbc_txtCusId.gridy = 6;
		panel_1.add(txtCusId, gbc_txtCusId);
		txtCusId.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		olTable = new JTable();
		olTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(olTable);

	}

	private void addCustomerClicked() {
		AddCustomer ac = new AddCustomer(soCtrl);
		
	}
	
	private void addProductClicked() {
		AddProduct ap = new AddProduct(soCtrl);
		ap.setVisible(true);
		int productId = txtProdId.getText();
		int qty = txtQty.getText();
		int warehouseId = txtWarehouseId.getText();
		
		SaleOrder so = soCtrl.addProductToSaleOrder(productId, qty, warehouseId);
		displayOrderLine(so);
	}
	
	private void displayOrderLine(SaleOrder so) {
		List<OrderLineItem> orderLines = so.getOrderLines();
		OrderLineItemTableModel olm = new OrderLineItemTableModel(orderLines);
		olTable.setModel(olm);
	}
	
	private void confirmClicked() {
		SaleOrder so = new SaleOrder();
		so.setCustomer(txtCusId.getText());
		so.setFreight(txtFreight.getText());
		so.setDiscount(null); //ved ikke lige hvordan...
		soCtrl.confirmOrder(so);
	}
}
