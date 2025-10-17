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

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AddFreight extends JDialog {

	private SaleOrderCtrl soCtrl;
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMethod;
	private JTextField txtDeliveryDate;
	private JTextField txtAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddFreight dialog = new AddFreight(new SaleOrderCtrl(new CustomerDB(), new ProductDB(), new StockDB(), new SaleOrderDB(), new OrderLineItemDB()));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddFreight(SaleOrderCtrl soCtrl) {
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
			JLabel methodLbl = new JLabel("Insert method:");
			GridBagConstraints gbc_methodLbl = new GridBagConstraints();
			gbc_methodLbl.anchor = GridBagConstraints.EAST;
			gbc_methodLbl.insets = new Insets(0, 0, 5, 5);
			gbc_methodLbl.gridx = 0;
			gbc_methodLbl.gridy = 0;
			contentPanel.add(methodLbl, gbc_methodLbl);
		}
		{
			txtMethod = new JTextField();
			GridBagConstraints gbc_txtMethod = new GridBagConstraints();
			gbc_txtMethod.insets = new Insets(0, 0, 5, 0);
			gbc_txtMethod.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtMethod.gridx = 1;
			gbc_txtMethod.gridy = 0;
			contentPanel.add(txtMethod, gbc_txtMethod);
			txtMethod.setColumns(10);
		}
		{
			JLabel dateLbl = new JLabel("Insert delivery date:");
			GridBagConstraints gbc_dateLbl = new GridBagConstraints();
			gbc_dateLbl.anchor = GridBagConstraints.EAST;
			gbc_dateLbl.insets = new Insets(0, 0, 5, 5);
			gbc_dateLbl.gridx = 0;
			gbc_dateLbl.gridy = 1;
			contentPanel.add(dateLbl, gbc_dateLbl);
		}
		{
			txtDeliveryDate = new JTextField();
			GridBagConstraints gbc_txtDeliveryDate = new GridBagConstraints();
			gbc_txtDeliveryDate.insets = new Insets(0, 0, 5, 0);
			gbc_txtDeliveryDate.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDeliveryDate.gridx = 1;
			gbc_txtDeliveryDate.gridy = 1;
			contentPanel.add(txtDeliveryDate, gbc_txtDeliveryDate);
			txtDeliveryDate.setColumns(10);
		}
		{
			JLabel addressLbl = new JLabel("Insert address:");
			GridBagConstraints gbc_addressLbl = new GridBagConstraints();
			gbc_addressLbl.anchor = GridBagConstraints.EAST;
			gbc_addressLbl.insets = new Insets(0, 0, 0, 5);
			gbc_addressLbl.gridx = 0;
			gbc_addressLbl.gridy = 2;
			contentPanel.add(addressLbl, gbc_addressLbl);
		}
		{
			txtAddress = new JTextField();
			GridBagConstraints gbc_txtAddress = new GridBagConstraints();
			gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAddress.gridx = 1;
			gbc_txtAddress.gridy = 2;
			contentPanel.add(txtAddress, gbc_txtAddress);
			txtAddress.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addFreightBtn = new JButton("Add freight");
				addFreightBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addFreightClicked();
					}
				});
				addFreightBtn.setActionCommand("OK");
				buttonPane.add(addFreightBtn);
				getRootPane().setDefaultButton(addFreightBtn);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public String getAddedMethod() {
		return txtMethod.getText();
	}
	
	public LocalDate getAddedDeliveryDate() {
		String dateString = txtDeliveryDate.getText();
		LocalDate date = LocalDate.parse(dateString);
		return date;
	}
	
	public String getAddedAddress() {
		return txtAddress.getText();
	}
	
	public void addFreightClicked() {
		SaleOrderView sov = new SaleOrderView(soCtrl);
		sov.addFreightClicked();
		sov.setVisible(true);
	}
}
