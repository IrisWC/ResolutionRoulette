package utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class PesonalComboBoxUI extends BasicComboBoxUI {

	private Font font;
    private Color background, foreground;
    
    public PesonalComboBoxUI(Font f, Color background, Color foreground) {
    	super();
    	font = f;
    	this.background = background;
    	this.foreground = foreground;
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        comboBox.setFont(font);
        comboBox.setBackground(background);
        comboBox.setForeground(foreground);
        comboBox.setBorder(UIManager.getBorder("ComboBox.border"));
        comboBox.setLightWeightPopupEnabled(true);
        comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBox.setFocusable(UIManager.getBoolean("ComboBox.focusable"));
    }

    @Override
    protected ListCellRenderer createRenderer() {
        return new PersonalCellRenderer();
    }

    public class PersonalCellRenderer extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//            System.out.println("***");
            setBorder((UIManager.getBorder("ComboBox.borderItems")));
            if (isSelected) {
                setForeground(UIManager.getColor("ComboBox[item].selectionForeground"));
            } else {
                setForeground(foreground);
            }
            setBackground(isSelected || cellHasFocus
                    ? UIManager.getColor("ComboBox.selectedInDropDownBackground")
                    : background);

            return this;
        }

    }
}