import com.db.entitys.ClientsUpsEntity;
import com.db.enums.EnumDeviceType;
import com.db.enums.EnumLocationType;
import com.db.factorys.ClientDbFactory;
import com.db.impls.AddClientUp;

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

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        insertClientUpsEntity(inetAddress.getHostAddress(),socket.getPort(),sb.toString());
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void insertClientUpsEntity(String clientip, int clientport, String msgcontent){
        ClientsUpsEntity entity = new ClientsUpsEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setAccount("110");
        entity.setClientIp(clientip);
        entity.setClientPort(clientport);
        entity.setCreateTime(new Timestamp(new Date().getTime()));
        entity.setDeviceType(EnumDeviceType.android.ordinal());
        entity.setDeviceName(EnumDeviceType.android.name());
        entity.setLocationType(EnumLocationType.baidu.ordinal());
        entity.setLocationLat("111");
        entity.setLocationLng("222");
        entity.setLocationAddr("福建");
        entity.setMsgContent(msgcontent);

        if(ClientDbFactory.addClientUp().addClientUp(entity)){
            System.out.println("添加成功");
        }
    }
}
