/**
 * @author John
 */
package br.com.manicure.gui;

import javax.swing.DefaultButtonModel;

public class FixedButtonModel extends DefaultButtonModel {

    @Override
    public boolean isPressed() {
        return false;
    }

    @Override
    public boolean isRollover() {
        return false;
    }

    @Override
    public void setRollover(boolean b) {

    }
}
