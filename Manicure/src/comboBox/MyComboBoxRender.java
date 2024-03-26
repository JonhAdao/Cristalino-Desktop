/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comboBox;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author John
 */
public class MyComboBoxRender extends DefaultComboBoxModel {

    DefaultComboBoxModel box = new DefaultComboBoxModel();
  

    public DefaultComboBoxModel getBox() {
        return box;
    }


}
