package goodrichtomassia.chap02;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actor implements PayLoad{
    public Actor(byte[] ar, byte[] buf, String ip, String port) {
        this.ar = ar;
        this.buf = buf;
        this.ip = ip;
        this.port = port;
    }

    private byte ar[] ;
    private byte buf[];
    private String ip;
    private String port;

    public DatagramPacket getDatagramPacket() {
        return datagramPacket;
    }

    private DatagramPacket datagramPacket;

    @Override
    public void setData(DatagramPacket packet) throws UnknownHostException {
        packet = new DatagramPacket(ar,ar.length, InetAddress.getByName(ip), Integer.parseInt(port));
        this.datagramPacket = packet;
    }
}
