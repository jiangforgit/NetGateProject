package com.impls;

import com.abstracts.AbstractReceiveData;
import com.entitys.ReceiveData;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * Created by caijiang.chen on 2017/10/24.
 * <p>
 *     <h>
 *         <pid>packid</pid>
 *         <a>系统代理编码</a>
 *         <v>1.0</v>
 *         <t>包type</t>
 *         <acount>账号</acount>
 *         <dt>device type</dt>
 *         <dn>device name</dn>
 *         <did>device id</did>
 *         <time>time</time>
 *     </h>
 *     <b>
 *         <msg>
 *             <![CADATA[内容]]>
 *         </msg>
 *         <loc>
*              <lt> 高德/百度</lt>
 *             <lat></lat>
 *             <lng></lng>
 *             <addr></addr>
 *         </loc>
 *     </b>
 * </p>
 */

public class XMLReceivedAnalysor extends AbstractReceiveData {

    @Override
    public ReceiveData analyse(String str) {
        ReceiveData receiveData = null;
        try {
            Document document = DocumentHelper.parseText(str);
            Element root = document.getRootElement();
            receiveData = new ReceiveData();
            Element hElement = root.element("h");
            receiveData.setPid(hElement.elementText("pid"));
            receiveData.setA(hElement.elementText("a"));
            receiveData.setV(hElement.elementText("v"));
            receiveData.setT(hElement.elementText("t"));
            receiveData.setAcount(hElement.elementText("acount"));
            receiveData.setDt(hElement.elementText("dt"));
            receiveData.setDn(hElement.elementText("dn"));
            receiveData.setDid(hElement.elementText("did"));
            receiveData.setTime(hElement.elementText("time"));
            Element bElement = root.element("b");
            receiveData.setMsg(bElement.elementText("msg"));
            Element locElement = bElement.element("loc");
            receiveData.setLt(locElement.elementText("lt"));
            receiveData.setLat(locElement.elementText("lat"));
            receiveData.setLng(locElement.elementText("lng"));
            receiveData.setAddr(locElement.elementText("addr"));
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return receiveData;
    }

}
