package Model;


import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PlaceHolder extends JTextField {
    private String placeholder;

    public PlaceHolder(String placeholder) {
        this.placeholder = placeholder;
        setOpaque(true);
        setForeground(Color.GRAY);

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(placeholder);
                    setForeground(Color.GRAY);
                }
            }
        });

        setText(placeholder);
    }

	public Object getPlaceHolder() {
		// TODO Auto-generated method stub
		return null;
	}
}
