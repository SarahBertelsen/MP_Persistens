package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctrl.SaleOrderCtrl;
import db.CustomerDB;
import db.OrderLineItemDB;
import db.ProductDB;
import db.SaleOrderDB;
import db.StockDB;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProduct extends JDialog {

	private SaleOrderCtrl soCtrl;
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtQty;
	private JTextField txtWarehouseId;
	private JTextField txtProdId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddProduct dialog = new AddProduct(new SaleOrderCtrl(new CustomerDB(), new ProductDB(), new StockDB(), new SaleOrderDB(), new OrderLineItemDB()));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddProduct(SaleOrderCtrl soCtrl) {
		this.soCtrl = soCtrl;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel prodIdLbl = new JLabel("Insert product id:");
			GridBagConstraints gbc_prodIdLbl = new GridBagConstraints();
			gbc_prodIdLbl.fill = GridBagConstraints.HORIZONTAL;
			gbc_prodIdLbl.insets = new Insets(0, 0, 5, 5);
			gbc_prodIdLbl.gridx = 0;
			gbc_prodIdLbl.gridy = 0;
			contentPanel.add(prodIdLbl, gbc_prodIdLbl);
		}
		{
			txtProdId = new JTextField();
			GridBagConstraints gbc_txtProdId = new GridBagConstraints();
			gbc_txtProdId.insets = new Insets(0, 0, 5, 0);
			gbc_txtProdId.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtProdId.gridx = 1;
			gbc_txtProdId.gridy = 0;
			contentPanel.add(txtProdId, gbc_txtProdId);
			txtProdId.setColumns(10);
		}
		{
			JLabel qtyLbl = new JLabel("Insert qty:");
			GridBagConstraints gbc_qtyLbl = new GridBagConstraints();
			gbc_qtyLbl.fill = GridBagConstraints.HORIZONTAL;
			gbc_qtyLbl.insets = new Insets(0, 0, 5, 5);
			gbc_qtyLbl.gridx = 0;
			gbc_qtyLbl.gridy = 1;
			contentPanel.add(qtyLbl, gbc_qtyLbl);
		}
		{
			txtQty = new JTextField();
			GridBagConstraints gbc_txtQty = new GridBagConstraints();
			gbc_txtQty.insets = new Insets(0, 0, 5, 0);
			gbc_txtQty.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtQty.gridx = 1;
			gbc_txtQty.gridy = 1;
			contentPanel.add(txtQty, gbc_txtQty);
			txtQty.setColumns(10);
		}
		{
			JLabel warehouseLbl = new JLabel("Insert warehouse id:");
			GridBagConstraints gbc_warehouseLbl = new GridBagConstraints();
			gbc_warehouseLbl.fill = GridBagConstraints.HORIZONTAL;
			gbc_warehouseLbl.insets = new Insets(0, 0, 0, 5);
			gbc_warehouseLbl.gridx = 0;
			gbc_warehouseLbl.gridy = 2;
			contentPanel.add(warehouseLbl, gbc_warehouseLbl);
		}
		{
			txtWarehouseId = new JTextField();
			GridBagConstraints gbc_txtWarehouseId = new GridBagConstraints();
			gbc_txtWarehouseId.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWarehouseId.gridx = 1;
			gbc_txtWarehouseId.gridy = 2;
			contentPanel.add(txtWarehouseId, gbc_txtWarehouseId);
			txtWarehouseId.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addProductBtn = new JButton("Add product");
				addProductBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addProductClicked();
					}
				});
				addProductBtn.setActionCommand("OK");
				buttonPane.add(addProductBtn);
				getRootPane().setDefaultButton(addProductBtn);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public int getAddedProductId() {
		String txtProdIdString = txtProdId.getText(); //get String from textfield
		int txtProdIdInt = Integer.parseInt(txtProdIdString); //parse to int
		return txtProdIdInt;
		
	}
	
	public int getAddedQty() {
		String txtQtyString = txtQty.getText(); //get String from textfield
		int txtQtyInt = Integer.parseInt(txtQtyString); //parse to int
		return txtQtyInt;
	}
	
	public int getAddedWarehouseId() {
		String txtWarehouseIdString = txtWarehouseId.getText(); //get String from textfield
		int txtWarehouseIdInt = Integer.parseInt(txtWarehouseIdString); //parse to int
		return txtWarehouseIdInt;
	}
	
	public void addProductClicked(){
		SaleOrderView sov = new SaleOrderView(soCtrl); //create new SaleOrderView
		sov.addProductClicked(); //calls addProduct method in SaleOrderView
		sov.setVisible(true); //opens SaleOrderView
	}
}
