/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ips;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author Yasin Radi
 * @see Class Handles the generic IP attributes.
 */
public abstract class IP {

    // ArrayList of IP subdivision which save each IP fragment.
    protected ArrayList<IPSubdivision> values;
    // Size of each IP fragment.
    protected int divisionSize;
    // Number of fragments the IP has.
    protected int totalSize;
    
    /**
     * IP class constructor.
     * @param totalSize Number of fragments the IP has.
     * @param divisionSize Size of each IP fragment.
     */
    public IP(int totalSize, int divisionSize) {
        this.values = new ArrayList<>();
        this.setTotalSize(totalSize);
        this.setDivisionSize(divisionSize);
    }

    // IP attributes public properties.
    
    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getDivisionSize() {
        return divisionSize;
    }

    public void setDivisionSize(int divisionSize) {
        this.divisionSize = divisionSize;
    }
    
    public ArrayList<IPSubdivision> getValues() {
        return values;
    }

    public void setValues(ArrayList<IPSubdivision> values) {
        this.values = values;
    }
    
    public void addIpDivision(IPSubdivision ips){
        this.values.add(ips);
    }
    
    /**
     * Returns the IP as a binary string.
     * @return Each IP fragment as binary string, separated with spaces.
     */
    public String showBinary() {
        String s = "";
        for(IPSubdivision ips:this.getValues()){
            for(int i:ips.getIntValue())
                s += Integer.toString(i);
            s += " ";
        }
        return s.substring(0, s.length() - 1);
    }
    
    public abstract String showHex();
    
}
