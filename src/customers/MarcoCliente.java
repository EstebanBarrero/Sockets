package customers;

import javax.swing.*;

public class MarcoCliente extends JFrame {

    public MarcoCliente(){

        setBounds(600,300,280,350);

        InterfaceMarcoCliente interfaceMarcoCliente = new InterfaceMarcoCliente();

        add(interfaceMarcoCliente);

        setVisible(true);
    }

}
