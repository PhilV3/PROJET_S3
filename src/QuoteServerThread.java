import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;


public class QuoteServerThread extends Thread{
    DatagramSocket socket = null;
    BufferedReader in = null;
    boolean moreQuotes = true;
    public QuoteServerThread() throws IOException {
        this("QuoteServer");
    }
    ArrayList<PacketReseau> listPktR = new ArrayList<PacketReseau>();
    int j = 0;
    int v = 0;
    @Override
    public void run() {

        while (moreQuotes) {
            try {
                byte[] buf = new byte[200];

                // receive request
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                // figure out response
                String dString = null;
                if (in == null)
                    dString = new Date().toString();
                else
                    dString = getText();
                int k = dString.length();

                listPktR.add(new PacketReseau(j));
                for (int i = 0; i < k+100; i += 100){
                    if (i % 200 == 0 && i != 0){
                        dString.getBytes((j)*200,(j+1)*200,listPktR.get(j).spuReseau,0);
                        j++;
                        listPktR.add(new PacketReseau(j));
                    }
                }
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                    PacketReseau sd = listPktR.get(v);
                    packet = new DatagramPacket(sd.spuReseau, sd.spuReseau.length, address, port);
                    System.out.println(packet.toString());
                    v++;
                    socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                moreQuotes = false;
            }
        }
        socket.close();
    }
    private void loadNewFile(String name) {
        if (in != null){
            try {
                in.close();
                in = new BufferedReader(new FileReader(name));
            }catch (FileNotFoundException e){
                System.out.println("File not found");
                System.out.println(e.getMessage());
            }catch (IOException e){
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("comment");
            }

        }

    }
    private String getText(){

        String value = null;
        String returnValue = null;
        try {
            while ((value = in.readLine()) != null) {
                returnValue += value;
            }
            in.close();
        } catch (IOException e) {
            returnValue = "IOException occurred in server.";
        }

        return returnValue;
    }

    private String getNextQuote() {
        String returnValue = null;

        try {
            if ((returnValue = in.readLine()) == null) {
                in.close();
                moreQuotes = false;
                returnValue = "No more quotes. Goodbye.";
            }
        } catch (IOException e) {
            returnValue = "IOException occurred in server.";
        }
        return returnValue;
    }


    public QuoteServerThread(String name) throws IOException {
        super(name);
        socket = new DatagramSocket(25420);

        try {
            in = new BufferedReader(new FileReader("one-liners.txt"));
        }
        catch (FileNotFoundException e){
            System.err.println("Couldn't open quote file.  Serving time instead.");
        }
    }
}
