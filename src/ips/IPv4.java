/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ips;

/**
 * @version 1.0
 * @author Yasin Radi
 * @see Class Handles v4 IP's behaviour.
 */
public class IPv4 extends IP {

    /**
     * Class constructor that has defined number of subdivisions and 
     * Subdivision length by default.
     */
    public IPv4() {
        super(4, 8);
    }

    /**
     * Converts a IPv4 to a decimal string.
     * @return Decimal IP string.
     */
    public String showDecimal() {
        String s = "";
        String[] str = this.showBinary().split(" ");
        for (String strNum : str) {
            s += Parser.binaryStringToDecimal(strNum) + ".";
        }
        s = s.substring(0, s.length() - 1);
        return s;
    }
    
    /**
     * Converts a IPv4 to a hex string.
     * @return Hex IPv4 string.
     */
    @Override
    public String showHex() {
        String s = "";
        String[] str = this.showBinary().split(" ");
        for (String strNum : str) {
            s += Parser.binaryToHex(Integer.parseInt(strNum, 2));
        }
        s = "0x" + s.toUpperCase();
        return s;
    }

    /**
     * Enables the user to input a binary v4 IP string separated with 
     * whitespaces and get a IPv4 object.
     * @param binaryIPv4 Binary IPv4 string.
     * @return IPv4 object.
     */
    public static IPv4 ipInputBinary(String binaryIPv4) {
        IPv4 ip = new IPv4();
        String[] str = binaryIPv4.split(" ");
        for (String s : str) {
            if (Parser.isNumeric(s)) {
                ip.addIpDivision(new IPSubdivision(
                        Parser.stringToBinary(s), ip.getDivisionSize()));
            }
        }
        return ip;
    }

    /**
     * Enables the user to input a decimal v4 IP string separated with '.' and 
     * get a IPv4 object.
     * @param decimalIPv4 Decimal IPv4 string.
     * @return IPv4 object.
     */
    public static IPv4 ipInputDecimal(String decimalIPv4) {
        IPv4 ip = new IPv4();
        String[] str = decimalIPv4.split("\\.");
        for (String s : str) {
            ip.addIpDivision(new IPSubdivision(
                    Parser.stringToDecimalToBinary(s), ip.getDivisionSize()));

        }
        return ip;
    }

    /**
     * Enables the user to input a hex v4 IP string separated with ':' and get 
     * a IPv4 object.
     * @param hexIPv4 Hex IPv4 string
     * @return IPv4 object.
     */
    public static IPv4 ipInputHex(String hexIPv4) {
        IPv4 ip = new IPv4();
        String[] str = hexIPv4.split(":");
        for (String s : str) {
            ip.addIpDivision(new IPSubdivision(
                    Parser.stringToHexToBin(s), ip.getDivisionSize()));
        }
        return ip;
    }

    /**
     * Does a binary AND between the IPv4 that calls the method and a IPv4 
     * decimal string.
     * @param decimalIPv4 IPv4 decimal string.
     * @return IPv4 object result from the binary AND.
     */
    public IPv4 AND(String decimalIPv4) {
        IPv4 ip = IPv4.ipInputDecimal(decimalIPv4);
        IPv4 res = IPv4.ipInputDecimal("0.0.0.0");
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
     * Does a binary OR between the IPv4 that calls the method and a IPv4 
     * decimal string.
     * @param decimalIPv4 IPv4 decimal string.
     * @return IPv4 object result from the binary OR.
     */
    public IPv4 OR(String decimalIPv4) {
        IPv4 ip = IPv4.ipInputDecimal(decimalIPv4);
        return this.OR(ip);
    }

    /**
     * Does a binary AND between the IPv4 that calls the method and another 
     * IPv4 object.
     * @param ip IPv4 object.
     * @return IPv4 object result from the binary AND.
     */
    public IPv4 AND(IPv4 ip) {
        IPv4 res = IPv4.ipInputDecimal("0.0.0.0");
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
     * Does a binary OR between the IPv4 that calls the method and another 
     * IPv4 object.
     * @param ip IPv4 object.
     * @return IPv4 object result from the binary OR.
     */
    public IPv4 OR(IPv4 ip) {
        IPv4 res = IPv4.ipInputDecimal("0.0.0.0");
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
     * Gets the main network IP which the IP that calls the method belongs to 
     * using a net mask IPv4 object.
     * @param netMask IPv4 net mask object.
     * @return IPv4 main network object.
     */
    public IPv4 mainNetwork(IPv4 netMask) {
        return this.AND(netMask);
    }
    
    /**
     * Gets the main network IP which the IP that calls the method belongs to using 
     * a net mask decimal IPv4 string.
     * @param decimalNetMask Net mask IPv4 string.
     * @return Main network IPv4 object.
     */
    public IPv4 mainNetwork(String decimalNetMask) {
        return this.AND(decimalNetMask);
    }

}
