package org.example.pruebas;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class PlaceholderTextField extends JTextField {

    private String placeholder;

    public PlaceholderTextField() {
    }

    public PlaceholderTextField(
            final Document pDoc,
            final String pText,
            final int pColumns)
    {
        super(pDoc, pText, pColumns);
    }

    public PlaceholderTextField(final int pColumns) {
        super(pColumns);
    }

    public PlaceholderTextField(final String pText) {
        super(pText);
    }

    public PlaceholderTextField(final String pText, final int pColumns) {
        super(pText, pColumns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder == null || placeholder.isEmpty() || !getText().isEmpty()) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        int textWidth = g.getFontMetrics().stringWidth(placeholder);
        int componentWidth = getWidth();
        int textHeight = g.getFontMetrics().getHeight();
        int componentHeight = getHeight();
        int y = (componentHeight - textHeight) / 2 + g.getFontMetrics().getAscent();
        int x = (componentWidth - textWidth) / 2;
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getDisabledTextColor());
        g.drawString(placeholder, x, y);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }

}
