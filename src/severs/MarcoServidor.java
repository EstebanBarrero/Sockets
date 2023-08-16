package severs;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MarcoServidor extends JFrame implements Runnable{

    public MarcoServidor(){

        setBounds(1200,300,280,350);

        JPanel jPanel= new JPanel();

        jPanel.setLayout(new BorderLayout());

        areatexto=new JTextArea();

        jPanel.add(areatexto,BorderLayout.CENTER);

        add(jPanel);

        setVisible(true);


        Thread myHilo = new Thread(this);
        myHilo.start();

    }



    @Override
    public void run() {
        try {

            ServerSocket serverSocket = new ServerSocket(7777);

            while (true) {
                Socket mySocket = serverSocket.accept();
                DataInputStream flowInput = new DataInputStream(mySocket.getInputStream());                                    //Informacion de entrada

                String message_text = flowInput.readUTF();

                areatexto.append("\n" + message_text);

                mySocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private	JTextArea areatexto;
}
