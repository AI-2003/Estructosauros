/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author marie
 */
public class ControladorCalculadora extends InterfazCalculadora {
    private String operaciones;

    public class Borrar implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            operaciones = " ";
            pantallaTxt.setText(operaciones);
        }
    }

    public class EditarBt implements ActionListener {
        private String editar;

        public EditarBt(String caracter) {
            editar = caracter;
        }

        public void actionPerformed(ActionEvent ae) {
            operaciones += editar;
            pantallaTxt.setText(operaciones);
        }
    }

    public class BorrarTodo implements ActionListener {
        private String borrarTodo = " ";

        public void actionPerformed(ActionEvent ae) {
            pantallaTxt.setText(borrarTodo);
        }
    }

    public ControladorCalculadora() {
        ceroBt.addActionListener(new EditarBt("0"));
        unoBt1.addActionListener(new EditarBt("1"));
        dosBt.addActionListener(new EditarBt("2"));
        tresBt.addActionListener(new EditarBt("3"));
        cuatroBt.addActionListener(new EditarBt("4"));
        cincoBt.addActionListener(new EditarBt("5"));
        seisBt.addActionListener(new EditarBt("6"));
        sieteBt.addActionListener(new EditarBt("7"));
        ochoBt.addActionListener(new EditarBt("8"));
        nueveBt.addActionListener(new EditarBt("9"));
        sumaBt.addActionListener(new EditarBt("+"));
        menosBt.addActionListener(new EditarBt("-"));
        divisionBt1.addActionListener(new EditarBt("/"));
        multiplicacionBt.addActionListener(new EditarBt("*"));
        puntoBt.addActionListener(new EditarBt("."));
        parentesisAbiertoBt1.addActionListener(new EditarBt("("));
        parentesisCerradoBt.addActionListener(new EditarBt(")"));
        //enterBt.addActionListener(new EditarBt("5"));

        //borrarACBt.addActionListener(new EditarBt("5"));
        //delBt.addActionListener(new EditarBt("5"));
    }

}
