
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerChat {
    ObjectOutputStream out;
	ObjectInputStream in;
	ServerSocket ss;
        Socket s;
        BufferedReader br;
       String serverMessage;
       String clientMessage;

    public ServerChat() {
        
        try{
            
            ss = new ServerSocket(8888);
            System.out.println("waiting to connect client at:"+ss.getLocalPort());
            s = ss.accept();
            System.out.println("Connected");
            out = new ObjectOutputStream(s.getOutputStream());
            in = new ObjectInputStream(s.getInputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                
                clientMessage = (String)in.readObject();
                System.out.println("Client==>"+clientMessage);
                System.out.println("Server==>"+serverMessage);
                serverMessage = br.readLine();
                out.writeObject(serverMessage);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
                
                
                
    }
       
       public static void main(String[] args){
           ServerChat sc = new ServerChat();
       }
        
    
    
}
