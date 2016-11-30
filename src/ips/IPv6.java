/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ips;

/**
 * @version 1.0
 * @author Yasin Radi
 * @see Class Handles v6 IP's behaviour.
 */
public class IPv6 extends IP {

    /**
     * Class constructor that has defined number of subdivisions and 
     * Subdivision length by default.
     */
    public IPv6() {
        super(8, 16);
    }

    /**
     * Converts a IPv6 to a hex string.
     * @return Hex IPv6 string.
     */
    @Override
    public String showHex(){
        String s = "";
        String[] sub = new String[4];
        String[] str = this.showBinary().split(" ");
        for(String strNum:str){
            sub[0] = strNum.substring(0, 4);
            sub[1] = strNum.substring(4, 8);
            sub[2] = strNum.substring(8, 12);
            sub[3] = strNum.substring(12, 16);
            for(String subN:sub){
                if(Parser.binaryToHex(subN).equals(Integer.toHexString(0)))
                    s += "";
                else
                    s += Parser.binaryToHex(subN);
            }
            s += ":";
        }
        s = s.substring(0, s.length() - 1);
        return s;
    }
    
    /**
     * Enables the user to input a binary v6 IP string separated with 
     * whitespaces and get a IPv6 object.
     * @param binaryIPv6 Binary IPv6 string.
     * @return IPv6 object.
     */
    public static IPv6 ipInputBinary(String binaryIPv6) {
        IPv6 ip = new IPv6();
        String[] str = binaryIPv6.split(" ");
        for (String s : str) {
            ip.values.add(new IPSubdivision(Parser.stringToBinary(s),
                    ip.getDivisionSize()));
        }
        return ip;
    }

    /**
     * Enables the user to input a decimal v6 IP string separated with 
     * '.' and get a IPv6 object.
     * @param decimalIPv6 Decimal IPv6 string.
     * @return IPv6 object.
     */
    public static IPv6 ipInputDecimal(String decimalIPv6) {
        IPv6 ip = new IPv6();
        String[] str = decimalIPv6.split("\\.");
        for (String s : str) {
            if (Parser.isNumeric(s)) {
                ip.values.add(new IPSubdivision(Parser
                        .stringToDecimalToBinary(s),
                        ip.getDivisionSize()));
            }
        }
        return ip;
    }

    /**
     * Enables the user to input a hex v4 IP string separated with ':' and get 
     * a IPv4 object.
     * @param hexIPv6 Hex IPv6 string.
     * @return IPv6 object.
     */
    public static IPv6 ipInputHex(String hexIPv6) {
        IPv6 ip = new IPv6();
        String[] str = hexIPv6.split(":");
        for (String s : str) {
            if (!s.isEmpty()) {
                ip.values.add(new IPSubdivision(Parser.stringToHexToBin(s),
                        ip.getDivisionSize()));
            } else {
                ip.values.add(new IPSubdivision(
                        Parser.stringToHexToBin("0000"),
                        ip.getDivisionSize()));
            }
        }
        return ip;
    }

    /**
     * Does a binary AND between the IPv6 that calls the method and a IPv6 
     * hex string.
     * @param hexIP IPv6 hex string.
     * @return IPv6 object result from the binary AND.
     */
    public IPv6 AND(String hexIP) {
        IPv6 res = new IPv6();
        IPv6 ip = IPv6.ipInputHex(hexIP);
        for (int i = 0; i < this.getValues().size(); i++) {
            for (int j = 0; j
                    < this.getValues().get(i).getIntValue().length; j++) {
                res.getValues().get(i).getIntValue()[i]
                        = this.getValues().get(i).getIntValue()[j]
                        * ip.getValues().get(i).getIntValue()[j];
            }
        }
        return res;
    }

    /**
     * Does a binary OR between the IPv6 that calls the method and a IPv6 
     * hex string.
     * @param hexIP IPv6 hex string.
     * @return IPv6 object result from the binary OR.
     */
    public IPv6 OR(String hexIP) {
        IPv6 res = new IPv6();
        IPv6 ip = IPv6.ipInputHex(hexIP);
        for (int i = 0; i < this.getValues().size(); i++) {
            for (int j = 0; j
                    < this.getValues().get(i).getIntValue().length; j++) {
                if (this.getValues().get(i).getIntValue()[j]
                        + ip.getValues().get(i).getIntValue()[j] > 0) {
                    res.getValues().get(i).getIntValue()[i] = 1;
                } else {
                    res.getValues().get(i).getIntValue()[i] = 0;
                }
            }
        }
        return res;
    }

    /**
     * Does a binary AND between the IPv6 that calls the method and another 
     * IPv6 object.
     * @param ip IPv6 object.
     * @return IPv6 object result from the binary AND.
     */
    public IPv6 AND(IPv6 ip) {
        IPv6 res = IPv6.ipInputHex("0:0:0:0:0:0:0:0");
        for (int i = 0; i < this.getValues().size(); i++) {
            for (int j = 0; j
                    < this.getValues().get(i).getIntValue().length; j++) {
                res.getValues().get(i).getIntValue()[j]
                        = this.getValues().get(i).getIntValue()[j]
                        * ip.getValues().get(i).getIntValue()[j];
            }
        }
        return res;
    }

    /**
     * Does a binary OR between the IPv6 that calls the method and another 
     * IPv6 object.
     * @param ip IPv6 object.
     * @return IPv6 object result from the binary OR.
     */
    public IPv6 OR(IPv6 ip) {
        IPv6 res = IPv6.ipInputHex("0:0:0:0:0:0:0:0");
        for (int i = 0; i < this.getValues().size(); i++) {
            for (int j = 0; j
                    < this.getValues().get(i).getIntValue().length; j++) {
                if (this.getValues().get(i).getIntValue()[j]
                        + ip.getValues().get(i).getIntValue()[j] > 0) {
                    res.getValues().get(i).getIntValue()[i] = 1;
                } else {
                    res.getValues().get(i).getIntValue()[i] = 0;
                }
            }
        }
        return res;
    }

    /**
     * Gets the main network IP which the IPv6 that calls the method belongs to 
     * using a netmask represented by the number of bits that are unchanged on
     * the IP.
     * @param maskBitsNum Number of bits unchanged.
     * @return Main network IPv6 object.
     */
    public IPv6 mainNetwork(int maskBitsNum) {
        IPv6 net;
        int ix = 0, ind = 0;
        String[] sA = new String[8];
        char[] c = new char[128];
        for (int i = 0; i < c.length; i++) {
            if (i < maskBitsNum) {
                c[i] = '1';
            } else {
                c[i] = '0';
            }
        }
        String str = new String(c);
        for (int i = 0; i < sA.length; i++) {
            ix += 16 - 1;
            if (i > 0) {
                ind = i * 16 - 1;
            }
            sA[i] = str.substring(ind, ix);
        }
        String bin = "";
        for (String s : sA) {
            bin += s + " ";
        }
        bin = bin.substring(0, bin.length() - 1);
        net = IPv6.ipInputBinary(bin);
        return this.AND(net);
    }
}
