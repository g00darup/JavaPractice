package goodrichtomassia.chap02;

import java.net.DatagramPacket;
import java.net.UnknownHostException;

public interface PayLoad {
    void setData(DatagramPacket packet) throws UnknownHostException;
}
