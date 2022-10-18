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
public class SnmpTest {
    public static void main(String[] args) throws Exception {

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
            TransportMapping transport = new DefaultUdpTransportMapping();//设定传输协议为UDP
            //调用TransportMapping中的listen()方法，启动监听进程，接收消息，由于该监听进程是守护进程，最后应调用close()方法来释放该进程
            transport.listen();
            //创建SNMP对象，用于发送请求PDU
            Snmp protocol = new Snmp(transport);
            //创建请求pdu,获取mib
            PDU request = new PDU();
            //调用的add方法绑定要查询的OID
            //mac
            //request.add(new VariableBinding(new OID("1.3.6.1.2.1.15.4")));
            //cpu阈值
            //request.add(new VariableBinding(new OID("1.3.6.1.4.1.2011.6.10.1.3.4")));
            //cpu使用率
            //request.add(new VariableBinding(new OID("1.3.6.1.4.1.2011.6.3.4.1.3")));
            //request.add(new VariableBinding(new OID("1.3.6.1.2.1.47.1.1.1.1.1")));
            //request.add(new VariableBinding(new OID("1.3.6.1.4.1.2011.5.25.31.1.1.1.1.5.67108869")));
            //风扇运行状态
            //request.add(new VariableBinding(new OID("1.3.6.1.4.1.2011.5.25.31.1.1.10.1.7")));

            //内存使用率
            //request.add(new VariableBinding(new OID("1.3.6.1.4.1.2011.5.25.311.5.2.1.34")));
            //AS的内存利用率
            //request.add(new VariableBinding(new OID("1.3.6.1.4.1.2011.5.25.327.2.1.1.15")));
            //request.add(new VariableBinding(new OID("1.3.6.1.4.1.2011.5.25.31.1.1.10.1.7")));
            //TODO 温度获取的值都是0
            request.add(new VariableBinding(new OID("1.3.6.1.2.1.47.1.1.1.1.1")));
            request.add(new VariableBinding(new OID("1.3.6.1.2.1.47.1.1.1.1.7")));
            request.add(new VariableBinding(new OID("1.3.6.1.4.1.2011.5.25.31.1.1.1.1.11.67108869")));
            //调用setType()方法来确定该pdu的类型
            request.setType(PDU.GETNEXT);
            //调用 send(PDU pdu,Target target)发送pdu，返回一个ResponseEvent对象
            ResponseEvent responseEvent = protocol.send(request, myTarget);
            //通过ResponseEvent对象来获得SNMP请求的应答pdu，方法：public PDU getResponse()
            PDU response = responseEvent.getResponse();
            //输出
            if (response != null) {
                System.out.println("request.size()=" + request.size());
                System.out.println("response.size()=" + response.size());
                for (int i = 0; i < response.size(); i++) {
                    //通过应答pdu获得mib信息（之前绑定的OID的值），方法：VaribleBinding get(int index)
                    VariableBinding vb = response.get(i);
                    System.out.println(vb);
                }

                //调用close()方法释放该进程
                transport.close();

                /**
                 * 输出结果：
                 * request.size()=2
                 response.size()=2
                 1.3.6.1.2.1.1.1.0 = Hardware: x86 Family 6 Model 58 Stepping 9 AT/AT COMPATIBLE - Software: Windows 2000 Version 5.1 (Build 2600 Multiprocessor Free)
                 1.3.6.1.2.1.1.2.0 = 1.3.6.1.4.1.311.1.1.3.1.1

                 */
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
