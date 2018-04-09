import com.db.entitys.ClientsUpsEntity;
import com.db.enums.EnumDeviceType;
import com.db.enums.EnumLocationType;
import com.db.enums.EnumPackType;
import com.db.factorys.ClientDbFactory;
import com.entitys.ReceiveData;
import com.factorys.AnalysReceiveFoctory;
import com.threadpool.PublicThreadPool;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class Main {

    public static final int PORT = 23023;
    public static DatagramSocket socket;

    public static void main(String[] args) {
        try{
            socket = new DatagramSocket(PORT);
        }catch (SocketException se){
            se.printStackTrace();
        }
        while (true){
            try {
                byte[] data = new byte[1024];
                DatagramPacket packet = new DatagramPacket(data, data.length);
                InetAddress address = InetAddress.getLocalHost();
                String addr = address.getHostAddress();
                System.out.println("addr="+addr);
                System.out.println("before receive");
                socket.receive(packet);
                String responseStr = new String(data, 0, packet.getLength());
                System.out.println("receive str = "+responseStr);
                PublicThreadPool.getPool().getCacheThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        insertClientUpsEntity(packet.getAddress().getHostAddress(),socket.getPort(),responseStr);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void insertClientUpsEntity(String clientip, int clientport, String msgcontent){
        Object receiveData = AnalysReceiveFoctory.getAnalysor().analyseReceivedStr(msgcontent);
        if(null != receiveData){
            if(receiveData instanceof ReceiveData){
                ReceiveData data = (ReceiveData)receiveData;
                ClientsUpsEntity entity = new ClientsUpsEntity();
                entity.setId(UUID.randomUUID().toString());
                entity.setPackid(data.getPid());
                entity.setAccount(data.getAcount());
                entity.setClientIp(clientip);
                entity.setClientPort(clientport);
                entity.setCreateTime(new Timestamp(new Date().getTime()));
                int deviceType = EnumDeviceType.android.ordinal();
                try{
                    deviceType = Integer.parseInt(data.getDt());
                }catch (Exception e){
                    e.printStackTrace();
                }
                entity.setDeviceType(deviceType);
                entity.setDeviceName(data.getDn());
                int locationType = EnumLocationType.baidu.ordinal();
                try{
                    locationType = Integer.parseInt(data.getLt());
                }catch (Exception e){
                    e.printStackTrace();
                }
                entity.setLocationType(locationType);
                entity.setLocationLat(data.getLat());
                entity.setLocationLng(data.getLng());
                entity.setLocationAddr(data.getAddr());
                int packType = EnumPackType.HeartBeat.ordinal();
                try {
                    packType = Integer.parseInt(data.getT());
                }catch (Exception e){
                    e.printStackTrace();
                }
                entity.setPackType(packType);
                entity.setMsgContent(msgcontent);
//                entity.setPackTime(new Timestamp()data.getTime());
                entity.setAgent(data.getA());
                if(ClientDbFactory.addClientUp().addClientUp(entity)){
                    System.out.println("添加成功");
                }
            }
        }
    }
}
