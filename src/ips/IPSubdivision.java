/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ips;

/**
 * @version 1.0
 * @author YasinR
 * @see Class Handles each IP subdivision data and behaviour.
 */
public class IPSubdivision {
    
    // Array that contains the binary value of each IP subdivision.
    private int[] intValue;
    // IP subdivision length.
    private int size;

    /**
     * IPSubdivision constructor that also puts leading zeroes when value &lt; size
     * @param value Array that contains the binary value of each IP subdivision.
     * @param size IP subdivision length.
     */
    public IPSubdivision(int[] value, int size) {
        this.setSize(size);        
        this.setIntValue(new int[size]);
        for(int i = 0; i < this.getIntValue().length; i++){
            if(i + value.length < this.getIntValue().length){
                this.intValue[i] = 0;
            } else {
                this.intValue[i] = value[i - 
                        (this.getIntValue().length - value.length)];
            }
        }     
    }

    // Attributes public properties.
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    } 
    
    public int[] getIntValue() {
        return intValue;
    }

    public void setIntValue(int[] value) {
        this.intValue = value;
    }

    @Override
    public String toString() {
        return "IPSubdivision{" + "intValue=" + intValue + ", size=" + size + '}';
    }
    
}
