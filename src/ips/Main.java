/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ips;

/**
 * @version 1.0
 * @author YasinR
 * @see Class Contains main method and some usage examples.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        IPv4 ip = IPv4.ipInputDecimal("192.168.1.20");
//          IPv4 ip = IPv4.ipInputBinary("11000000 10101000 00000001 00010100");
        IPv4 ip2 = IPv4.ipInputDecimal("172.128.54.98");
        IPv4 mask = IPv4.ipInputDecimal("255.255.255.0");
        
        IPv4 net = ip.AND(mask);
//        IPv4 net = ip.AND("255.255.255.0");
        
        System.out.println("First IPv4 in decimal: " + ip.showDecimal());
        System.out.println("First IPv4 in binary: " + ip.showBinary());
        System.out.println("First IPv4 in hex: " + ip.showHex());
        System.out.println("Second IPv4 in decimal: " + ip2.showDecimal());
        System.out.println("Second IPv4 in binary: " + ip2.showBinary());
        System.out.println("Second IPv4 in hex: " + ip2.showHex());
        System.out.println("Net Mask in decimal: " + mask.showDecimal());
        System.out.println("Net Mask in binary: " + mask.showBinary());
        
        System.out.println("\nFirst IPv4 belongs to: " + net.showDecimal());
        System.out.println("First IPv4 belongs to: " + net.showBinary());
        
        System.out.println("Logic AND between First & Second IPv4: " + ip.AND(ip2).showBinary());
        System.out.println("Logic OR between First & Second IPv4: " + ip.OR(ip2).showBinary());

        IPv6 ip3 = IPv6.ipInputHex("2001:db8:85a3::1319:8a2e:370:7344");
        IPv6 ip4 = IPv6.ipInputHex("2607:f0d0:1002:51::::4");
        
        IPv6 mainNet = ip3.mainNetwork(32);
        
        System.out.println("\nFirst IPv6 in hex: " + ip3.showHex());
        System.out.println("First IPv6 in binary: \n" + ip3.showBinary());
        System.out.println("Second IPv6 in hex: " + ip4.showHex());   
        System.out.println("Second IPv6 in binary: \n" + ip4.showBinary());
        
        System.out.println("\nFirst IPv6 belongs to: " + mainNet.showHex());
        System.out.println("First IPv6 belongs to: \n" + mainNet.showBinary());
        
        System.out.println("\nLogic AND between First & Second IPv6: \n" + ip3.AND(ip4).showBinary());
        System.out.println("Logic OR between First & Second IPv6: \n" + ip3.OR(ip4).showBinary());    
       

    }
    
}
