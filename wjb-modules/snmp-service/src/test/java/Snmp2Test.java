import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author wjb
 * @create 2022/9/8
 * @since 1.0.0
 */
public class Snmp2Test {
    public static void main(String[] args) throws Exception {
        VariableBinding vb = null;

//        String temOid = "1.3.6.1.4.1.2011.6.3.4.1.3" ;
//        vb = send(temOid,PDU.GETNEXT);
//        System.out.println(vb);


//        String mOid = "1.3.6.1.4.1.2011.5.25.31.1.1.1.1.7"+".67108867" ;
//        vb = send(mOid,PDU.GETNEXT);
//        System.out.println(vb);
//        vb = send(vb.getOid().toString(),PDU.GETNEXT);
//        System.out.println(vb);

        //String vOid = "1.3.6.1.4.1.2011.5.25.123.1.11.1.6.65535";
        String vOid = "1.3.6.1.4.1.2011.5.25.123.1.11.1.9.65535";
        vb = send(vOid, PDU.GET);
        System.out.println(vb);

        //内存
        //String Oid = "1.3.6.1.4.1.2011.5.25.31.1.1.1.1.7.67108873";
        //温度
        //String Oid = "1.3.6.1.4.1.2011.5.25.31.1.1.1.1.5.67108873";
//        String oid = "1.3.6.1.4.1.2011.5.25.119.1.1.9.1.8";
//        String noid = oid;
//        while (true){
//            System.out.println(noid);
//            vb = send(noid,PDU.GETNEXT);
//            if (vb!=null){
//                noid = vb.getOid().toString();
//                System.out.println(vb);
//            }
////            if (!noid.startsWith(oid)){
////                break;
////            }
//        }
    }

    private static VariableBinding send(String oid, int type) {
        VariableBinding vb = null;
        TransportMapping transport = null;
        try {
            //设定CommunityTarget
            CommunityTarget myTarget = new CommunityTarget();
            //定义本机的地址
            Address localAdd = GenericAddress.parse("udp:172.18.1.2/161");
            //设定本地主机的地址
            myTarget.setAddress(localAdd);
            //设置snmp共同体
            myTarget.setCommunity(new OctetString("ChinEntropy"));
            //设置超时重试次数
            myTarget.setRetries(2);
            //设置超时的时间
            myTarget.setTimeout(5 * 60);
            //设置使用的snmp版本
            myTarget.setVersion(SnmpConstants.version2c);

            //设定采取的协议
            transport = new DefaultUdpTransportMapping();//设定传输协议为UDP
            //调用TransportMapping中的listen()方法，启动监听进程，接收消息，由于该监听进程是守护进程，最后应调用close()方法来释放该进程
            transport.listen();
            //创建SNMP对象，用于发送请求PDU
            Snmp protocol = new Snmp(transport);
            //创建请求pdu,获取mib
            PDU request = new PDU();
            //调用的add方法绑定要查询的OID

            request.add(new VariableBinding(new OID(oid)));
            //调用setType()方法来确定该pdu的类型
            request.setType(type);
            //调用 send(PDU pdu,Target target)发送pdu，返回一个ResponseEvent对象
            ResponseEvent responseEvent = protocol.send(request, myTarget);
            //通过ResponseEvent对象来获得SNMP请求的应答pdu，方法：public PDU getResponse()
            PDU response = responseEvent.getResponse();
            //输出
            if (response != null && response.size() > 0) {
                vb = response.get(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //调用close()方法释放该进程
            try {
                transport.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return vb;
    }
}
