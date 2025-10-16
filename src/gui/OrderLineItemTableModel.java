package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.OrderLineItem;

public class OrderLineItemTableModel extends AbstractTableModel{
	
	private List<OrderLineItem> orderLines;
    private String[] COL_NAMES = { "Id", "Name", "Type", "Quantity" };

    public OrderLineItemTableModel(List<OrderLineItem> orderLines) {
        orderLines = new ArrayList<>(orderLines);
    }

    @Override
    public int getRowCount() {
        return orderLines.size();
    }

    @Override
    public int getColumnCount() {
        return COL_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderLineItem orderLine = orderLines.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
        case 0:
            value = orderLine.getProduct().getProductId();
            break;
        case 1:
            value = orderLine.getProduct().getName();
            break;
        case 2:
            value = orderLine.getProduct().getProductType();
            break;
        case 3:
        	value = orderLine.getQty();
        }
        return value;
    }

    public String getColumnName(int column) {
        return COL_NAMES[column];
    }	
}
