package server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Myserver extends JFrame {

	private JPanel contentPane;
	private static ServerSocket ss ;
	private static Socket s ;
	private static BufferedInputStream br ;
	private static InputStreamReader isr ;
	static byte data[] ;
	private static DataInputStream in;
	private static OutputStream out ;
	private static Thread t;
	private static BufferedReader str ;
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Myserver frame = new Myserver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 
		
		   t = new Thread(new Runnable() {
	            @Override
	            public void run() {
	            	try {
	            		ss = new ServerSocket(8000) ;
	            		s= ss.accept();
	    			//System.out.println("server0"+ss.isBound());
	    			//System.out.println("server open");
	    			
	    			//System.out.println("soc0 bound"+s.isBound());
	    			//System.out.println("soc0 connect"+s.isConnected());
	    			//s.setReuseAddress(false);
	    		//	System.out.println("server1"+ss.isBound());
	    			//isr = new InputStreamReader(s.getInputStream());
	    			
	    		//	in = new DataInputStream(s.getInputStream());
	    			//int count=in.readInt();
	    		//System.out.println(count);
	    		/*	while(true) {
	   
	    				if(count<=s.getReceiveBufferSize())
	    					break
	    				//System.out.println("data write");
	    				
	    				
	    			}*/
	    		//	br = new BufferedInputStream(s.getInputStream());
	    			System.out.println("hi");
	            		isr = new InputStreamReader(s.getInputStream());
	    			str = new BufferedReader(isr);
	    			/*System.out.println("input stream");
	    			System.out.println("soc1 bound"+s.isBound());
	    			System.out.println("soc1 connect"+s.isConnected());
	    			System.out.println("server2"+ss.isBound());
	    			System.out.println("soc2 bound"+s.isBound());
	    			System.out.println("soc2 connect"+s.isConnected());
	    			data = new byte[s.getReceiveBufferSize()];*/
	    			String m = str.readLine();
	    			System.out.println(m);
	    			 File picture_file = getOutputMediafile();
	    			   if (picture_file == null) {
	    	            	return;
	    	            }else {
	    	                try {
	    	                    FileOutputStream fos = new FileOutputStream(picture_file);
	    	                    fos.write(data);
	    	                    fos.close();

	    	                }catch (FileNotFoundException e) {
	    	                    e.printStackTrace();
	    	                }catch (IOException e) {
	    	                    e.printStackTrace();
	    	                }

	    	            }
	    	           //br.close();
	    	            //isr.close();
	    	         //  s.close();
	            	//	ss.close();

	   	    		
	    		}catch(IOException e) {
	                e.printStackTrace();
	            }
	            		
	    	
	            
	    	
	            }
	            });
		   t.start();
		  
		   }
		   private static File getOutputMediafile() {
               File folder_gui = new File("D:\\");
               if (!folder_gui.exists()) {
                   folder_gui.mkdirs();
               }
               File outputFile = new File(folder_gui, "temp.jpg");
              // path = new String(outputFile.getPath());
               return outputFile;
           }
               
           
		

	/**
	 * Create the frame.
	 */
	public Myserver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
	
