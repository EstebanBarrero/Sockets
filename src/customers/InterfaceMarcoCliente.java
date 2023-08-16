package customers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class InterfaceMarcoCliente extends JPanel {

    public InterfaceMarcoCliente(){

        JLabel texto = new JLabel("CLIENTE");

        add(texto);

        campo1 = new JTextField(20);

        add(campo1);

        miboton = new JButton("Enviar");

        sendText miEvento = new sendText();
        miboton.addActionListener(miEvento);

        add(miboton);

    }

    private class sendText implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Socket mySocket = new Socket("192.168.20.108",7777);

                DataOutputStream flowOutput = new DataOutputStream(mySocket.getOutputStream());							//Flujo de Salida de datos
                flowOutput.writeUTF(campo1.getText());																	//Escribe en el Flujo lo que hay en el campo1
                flowOutput.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            }
        }
    }

    private JTextField campo1;

    private JButton miboton;

}
