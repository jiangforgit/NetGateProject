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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class Main {

    public static final int PORT = 23023;

    public static void main(String[] args) {
        while (true){
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket socket = serverSocket.accept();
                Reader reader = new InputStreamReader(socket.getInputStream());
                char chars[] = new char[64];
                int len;
                StringBuilder sb = new StringBuilder();
                while ((len=reader.read(chars)) != -1) {
                    sb.append(new String(chars, 0, len));
                }
                System.out.println("server-receive:"+sb.toString());
                InetAddress inetAddress = socket.getInetAddress();

                PublicThreadPool.getPool().getCacheThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        insertClientUpsEntity(inetAddress.getHostAddress(),socket.getPort(),sb.toString());
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
