package server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class server2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server2 frame = new server2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	        class PrimeThread extends Thread {
	        	ServerSocket serverSocket; 
	        
	        
	        	 public void run() {
	        		 while(true) {
	        	try {
	        serverSocket = new ServerSocket(7000);       
			System.out.println("Reading: " + System.currentTimeMillis());
	        Socket socket = serverSocket.accept();
	        byte[] sizeAr = new byte[4];
	        InputStream inputStream =socket.getInputStream();
	        inputStream.read(sizeAr);
	        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
	        System.out.print("size of image :");
	        System.out.print(size);
	        byte[] imageAr = new byte[size];
	        int i =inputStream.read(imageAr);
	        while(i<size)
	        {
	        	i+=inputStream.read(imageAr, i, size-i);
	        }
	        System.out.println();
	        System.out.print("retrun :");
	        System.out.print(i);
	        
	        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

	        System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ":\n " + System.currentTimeMillis());
	        File folder_gui = new File("D:\\");
            if (!folder_gui.exists()) {
                folder_gui.mkdirs();
            }
            File outputFile = new File(folder_gui, "temp.jpg");
	        ImageIO.write(image, "jpg",outputFile );
	        PrintWriter printwriter = new PrintWriter(socket.getOutputStream());
	       printwriter.println("My name mohamed ");
	        printwriter.flush();
	        System.out.println("done");
	       socket.close();
	       serverSocket.close();
	        
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

		}
    }}
	        
		        PrimeThread  t = new PrimeThread();
		        t.start();
			
	        
	        
	    }	

	/**
	 * Create the frame.
	 */
	public server2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
