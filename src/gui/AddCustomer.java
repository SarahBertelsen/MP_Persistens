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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;

public class AddCustomer extends JDialog {

	private SaleOrderCtrl soCtrl;
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCustomerId;

	/**
	 * Launch the application.
	 */
	
	/**
	public static void main(String[] args) {
		try {
			AddCustomer dialog = new AddCustomer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} **/

	/**
	 * Create the dialog.
	 */
	public AddCustomer(SaleOrderCtrl soCtrl) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		this.soCtrl = soCtrl;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel cusIdLbl = new JLabel("Insert customer id:");
			contentPanel.add(cusIdLbl);
		}
		{
			txtCustomerId = new JTextField();
			contentPanel.add(txtCustomerId);
			txtCustomerId.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addCustomerBtn = new JButton("Add customer");
				addCustomerBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addCustomerClicked();
					}
				});
				addCustomerBtn.setActionCommand("OK");
				buttonPane.add(addCustomerBtn);
				getRootPane().setDefaultButton(addCustomerBtn);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void showDialog() {
		this.setModal(true);
		this.setVisible(true);
	}
	
	public int getAddedCustomerId() {
		String idString = txtCustomerId.getText();
		return Integer.parseInt(idString);
	}
	
	public void addCustomerClicked() {
		int customerId = getAddedCustomerId();
		soCtrl.addCustomer(customerId);
		this.setVisible(false);
		this.dispose();
	}

}
