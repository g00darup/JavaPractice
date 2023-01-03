package goodrichtomassia.chap02;

import java.net.DatagramPacket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class SimulateDataTransfer {
    public void run() throws UnknownHostException {
        byte ar[] = { 2, 3, 5, 6 };
        byte buf[] = { 5, 6, 7, 8, 9 };
        String ip = "localhost";
        String port ="22";
        Actor A = new Actor(ar,buf, ip,port);
        DatagramPacket pack = null;
        A.setData(pack);
        System.out.println(Arrays.toString(A.getDatagramPacket().getData()));

    }
    public static void main(String[] args) throws UnknownHostException {
        new SimulateDataTransfer().run();
    }
}
