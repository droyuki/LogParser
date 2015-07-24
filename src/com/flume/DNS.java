package com.flume;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WeiChen on 2015/7/22.
 */
public class DNS {
    public static final String GROUP1_DELIMITER = "=";
    public static final String COLON_SYMBOL = ":";
    public static final String TAB_PATTERN = "(\t)+";
    public static final String CR = "\r";
    public static final String LF = "\n";
    public static final String TAB = "\t";
    public static final String EMPTY_STRING = "";

    public static void main(String[] args) throws IOException {
        String raw = "7/15/2015 11:59:59 PM 106C PACKET  0000000002048020 UDP Snd 10.3.73.5       1fba R Q [9384 A  R NXDOMAIN] AAAA   (13)jp-cco-mtoda2(6)client(2)jp(8)trendnet(3)org(6)client(2)tw(8)trendnet(3)org(0)\nUDP response info at 0000000002048020\n  Socket = 336\n  Remote addr 10.3.73.5, port 56472\n  Time Query=321854, Queued=0, Expire=0\n  Buf length = 0x0fa0 (4000)\n  Msg length = 0x00a8 (168)\n  Message:\n    XID       0x1fba\n    Flags     0x8493\n      QR        1 (RESPONSE)\n      OPCODE    0 (QUERY)\n      AA        1\n      TC        0\n      RD        0\n      RA        1\n      Z         0\n      CD        1\n      AD        0\n      RCODE     3 (NXDOMAIN)\n    QCOUNT    1\n    ACOUNT    0\n    NSCOUNT   1\n    ARCOUNT   1\n    QUESTION SECTION:\n    Offset = 0x000c, RR count = 0\n    Name      \"(13)jp-cco-mtoda2(6)client(2)jp(8)trendnet(3)org(6)client(2)tw(8)trendnet(3)org(0)\"\n      QTYPE   AAAA (28)\n      QCLASS  1\n    ANSWER SECTION:\n      empty\n    AUTHORITY SECTION:\n    Offset = 0x004d, RR count = 0\n    Name      \"(6)client(2)tw(8)trendnet(3)org(0)\"\n      TYPE   SOA  (6)\n      CLASS  1\n      TTL    3600\n      DLEN   46\n      DATA   \n\t\tPrimaryServer: (11)twvmdcadc01[C054](2)tw(8)trendnet(3)org(0)\n\t\tAdministrator: (9)twntadmin[C054](2)tw(8)trendnet(3)org(0)\n\t\tSerialNo     = 6652303\n\t\tRefresh      = 900\n\t\tRetry        = 600\n\t\tExpire       = 86400\n\t\tMinimumTTL   = 3600\n    ADDITIONAL SECTION:\n    Offset = 0x009d, RR count = 0\n    Name      \"(0)\"\n      TYPE   OPT  (41)\n      CLASS  4000\n      TTL    32768\n      DLEN   0\n      DATA   \n\t\tBuffer Size  = 4000\n\t\tRcode Ext    = 0\n\t\tRcode Full   = 3\n\t\tVersion      = 0\n\t\tFlags        = 80 DO";
        String raw2 ="7/15/2015 11:59:59 PM 11A0 PACKET  00000000023B9BA0 UDP Snd 10.3.73.5       8c9d R Q [9384 A  R NXDOMAIN] AAAA   (14)JP-KKITAMURA01(2)tw(8)trendnet(3)org(0)\nUDP response info at 00000000023B9BA0\n  Socket = 336\n  Remote addr 10.3.73.5, port 56111\n  Time Query=321854, Queued=0, Expire=0\n  Buf length = 0x0fa0 (4000)\n  Msg length = 0x008c (140)\n  Message:\n    XID       0x8c9d\n    Flags     0x8493\n      QR        1 (RESPONSE)\n      OPCODE    0 (QUERY)\n      AA        1\n      TC        0\n      RD        0\n      RA        1\n      Z         0\n      CD        1\n      AD        0\n      RCODE     3 (NXDOMAIN)\n    QCOUNT    1\n    ACOUNT    0\n    NSCOUNT   1\n    ARCOUNT   1\n    QUESTION SECTION:\n    Offset = 0x000c, RR count = 0\n    Name      \"(14)JP-KKITAMURA01(2)tw(8)trendnet(3)org(0)\"\n      QTYPE   AAAA (28)\n      QCLASS  1\n    ANSWER SECTION:\n      empty\n    AUTHORITY SECTION:\n    Offset = 0x0030, RR count = 0\n    Name      \"(2)tw(8)trendnet(3)org(0)\"\n      TYPE   SOA  (6)\n      CLASS  1\n      TTL    3600\n      DLEN   54\n      DATA   \n\t\tPrimaryServer: (11)twvmdcadc01[C030](2)tw(8)trendnet(3)org(0)\n\t\tAdministrator: (5)admin(5)trend(3)com(2)tw(0)\n\t\tSerialNo     = 2455203\n\t\tRefresh      = 900\n\t\tRetry        = 600\n\t\tExpire       = 86400\n\t\tMinimumTTL   = 3600\n    ADDITIONAL SECTION:\n    Offset = 0x0081, RR count = 0\n    Name      \"(0)\"\n      TYPE   OPT  (41)\n      CLASS  4000\n      TTL    32768\n      DLEN   0\n      DATA   \n\t\tBuffer Size  = 4000\n\t\tRcode Ext    = 0\n\t\tRcode Full   = 3\n\t\tVersion      = 0\n\t\tFlags        = 80 DO";
        String raw3 ="7/15/2015 11:59:59 PM 11A0 PACKET  0000000002048020 UDP Snd 10.28.70.13     d951 R Q [8085 A DR  NOERROR] PTR    (3)100(2)42(2)45(2)10(7)in-addr(4)arpa(0)\nUDP response info at 0000000002048020\n  Socket = 336\n  Remote addr 10.28.70.13, port 65070\n  Time Query=321854, Queued=0, Expire=0\n  Buf length = 0x0200 (512)\n  Msg length = 0x0056 (86)\n  Message:\n    XID       0xd951\n    Flags     0x8580\n      QR        1 (RESPONSE)\n      OPCODE    0 (QUERY)\n      AA        1\n      TC        0\n      RD        1\n      RA        1\n      Z         0\n      CD        0\n      AD        0\n      RCODE     0 (NOERROR)\n    QCOUNT    1\n    ACOUNT    1\n    NSCOUNT   0\n    ARCOUNT   0\n    QUESTION SECTION:\n    Offset = 0x000c, RR count = 0\n    Name      \"(3)100(2)42(2)45(2)10(7)in-addr(4)arpa(0)\"\n      QTYPE   PTR (12)\n      QCLASS  1\n    ANSWER SECTION:\n    Offset = 0x002b, RR count = 0\n    Name      \"[C00C](3)100(2)42(2)45(2)10(7)in-addr(4)arpa(0)\"\n      TYPE   PTR  (12)\n      CLASS  1\n      TTL    1200\n      DLEN   31\n      DATA   (13)sjdc-mbdiydb1(2)us(8)trendnet(3)org(0)\n    AUTHORITY SECTION:\n      empty\n    ADDITIONAL SECTION:\n      empty";
        String raw4 ="";
        Map<String, String> bodyMap = new HashMap<String, String>();
        String[] data = raw.split(LF);
        String header = data[0];
        String body = raw.replace(header, "");
        Map<String, String> tmpMap = new HashMap<String, String>();
        tmpMap = parseHeader(header);
        bodyMap.putAll(tmpMap);
        tmpMap = parseBody(bodyMap, body);
        bodyMap.putAll(tmpMap);
        System.out.println("Result Map size: " + bodyMap.size());
//        System.out.println(body);
    }

    private static Map<String, String> parseBody(Map<String, String> bodyMap, String body) {
        String[] lines = body.split(LF);
        System.out.println("LINE: " + lines.length);
        boolean msgSectionFlag = false, qSectionFlag = false, ansSectionFlag = false, autSectionFlag = false, addSectionFlag = false;
        ArrayList<String> msgSetcion = new ArrayList<>();
        ArrayList<String> qSection = new ArrayList<>();
        ArrayList<String> ansSection = new ArrayList<>();
        ArrayList<String> autSection = new ArrayList<>();
        ArrayList<String> addSection = new ArrayList<>();
        for (String line : lines) {
            System.out.println("line:: " + line);
            if (line.contains("Message:")) {
                msgSectionFlag = true;
                continue;
            } else if (line.contains("QUESTION SECTION:")) {
                msgSectionFlag = false;
                qSectionFlag = true;
                continue;
            } else if (line.contains("ANSWER SECTION:")) {
                qSectionFlag = false;
                ansSectionFlag = true;
                continue;
            } else if (line.contains("AUTHORITY SECTION:")) {
                ansSectionFlag = false;
                autSectionFlag = true;
                continue;
            } else if (line.contains("ADDITIONAL SECTION:")) {
                autSectionFlag = false;
                addSectionFlag = true;
                continue;
            }
            if (msgSectionFlag)
                msgSetcion.add(line);
            if (qSectionFlag)
                qSection.add(line);
            if (ansSectionFlag)
                ansSection.add(line);
            if (autSectionFlag)
                autSection.add(line);
            if (addSectionFlag)
                addSection.add(line);
//                //get XID
//                String xid = line.split("XID")[1].replaceAll("\\s", "").trim();
//                bodyMap.put("MessageXID", xid);
//                System.out.println(bodyMap.get("MessageXID").replaceAll("[\\W_]+",""));

        }

        //parse msg section
        for (String msg : msgSetcion) {
            //replace strange char with ;
            String tmp = msg.replaceAll("([\\W]+)", ";");
            String key = tmp.split(";")[1];
            String value = tmp.split(";")[2];
            bodyMap.put(key, value);
            System.out.println("K: " + key + " V: " + value);
        }

        //parse ansert section
        for (String ans : ansSection) {

        }
//        System.out.println("Msg: " + msgSetcion.size() + "\nQues: " + qSection.size()  + "\nAns: " + ansSection.size() + "\nAut: " + autSection.size() + "\nAdd: " + addSection.size());
        return bodyMap;
    }

    private static Map<String, String> parseHeader(String body) {
        Map<String, String> bodyMap = new HashMap<String, String>();
        String[] dateTime = body.split("/");
        String month = dateTime[0];
        String date = dateTime[1];
        int dtLength = month.length() + date.length() + 18;

        //get DateTime
        String dt = (String) body.subSequence(0, dtLength);
        bodyMap.put("DateTime", dt);
        body = (String) body.subSequence(dtLength + 1, body.length());

        //get MsgID
        String msgId = (String) body.subSequence(0, 4);
        bodyMap.put("MsgID", msgId);
        body = (String) body.subSequence(5, body.length());

        //get Packet
        String pkg = (String) body.subSequence(8, 24);
        bodyMap.put("PACKET", pkg);
        body = (String) body.subSequence(25, body.length());


        //get protocol
        String protocol = (String) body.subSequence(0, 3);
        bodyMap.put("Protocol", protocol);
        body = (String) body.subSequence(4, body.length());

        //get direction
        String dir = (String) body.subSequence(0, 3);
        bodyMap.put("Direction", dir);
        body = (String) body.subSequence(4, body.length());

        //get request ip
        String[] ipArray = body.split("\\.");
        String ip = ipArray[0] + "." + ipArray[1] + "." + ipArray[2] + "." + ipArray[3].split(" ")[0];
        bodyMap.put("RequestIP", ip);
        body = (String) body.subSequence(ip.length(), body.length());

        //get I don't know 1
        String sth1 = (String) body.subSequence(7, 11);
        body = (String) body.substring(12, body.length());

        //get sth in []
        String sth2 = body.split("\\[")[1].split("\\]")[0];
        body = (String) body.subSequence(sth2.length() + 7, body.length());

        //get Record type
        String rcType = body.split("\\(")[0];
        bodyMap.put("RecordType", rcType.replaceAll("\\s", ""));
        body = (String) body.subSequence(rcType.length(), body.length());

        //get Domain
        String domain = domainAnalyzer(body, "");
        bodyMap.put("Domain", domain);

        return bodyMap;
    }

    //Analyze domain recursively
    private static String domainAnalyzer(String domain, String result) {
        String domainLength = domain.split("\\(")[1].split("\\)")[0];
        int dml = Integer.parseInt(domainLength);
        if (dml == 0) {
            return result;
        } else {
            String domainName = (String) domain.subSequence(domainLength.length() + 2, dml + 4);
            domain = (String) domain.substring(dml + domainLength.length() + 2, domain.length());
            return domainAnalyzer(domain, result + domainName.replaceAll("\\(", "") + ".");
        }
    }

    public static List<String> readTestData(String filePath) {
        List<String> stringList = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringList;
    }
}
