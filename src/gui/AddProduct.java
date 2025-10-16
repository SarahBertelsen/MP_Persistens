package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctrl.SaleOrderCtrl;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class AddProduct extends JDialog {

	private SaleOrderCtrl soCtrl;
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddProduct dialog = new AddProduct(new SaleOrderCtrl());
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
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
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
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			contentPanel.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
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
			textField_2 = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 1;
			gbc_textField_2.gridy = 2;
			contentPanel.add(textField_2, gbc_textField_2);
			textField_2.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add product");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
