 /*
 * DoublePair.java is a class which stores two doubles and 
 * implements the Writable interface. It can be used as a 
 * custom value for Hadoop. To use this as a key, you can
 * choose to implement the WritableComparable interface,
 * although that is not necessary for credit.
 */

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class DoublePair implements Writable {

    // Declare any variables here
    private double d1;
    private double d2;

    /**
     * Constructs a DoublePair with both doubles set to zero.
     */
    public DoublePair() {
        this.d1 = 0;
        this.d2 = 0;
        // YOUR CODE HERE

    }

    /**
     * Constructs a DoublePair containing double1 and double2.
     */ 
    public DoublePair(double double1, double double2) {
        this.d1 = double1;
        this.d2 = double2;
        // YOUR CODE HERE

    }

    /**
     * Returns the value of the first double.
     */
    public double getDouble1() {
        return d1;
    	// YOUR CODE HERE
        
    }

    /**
     * Returns the value of the second double.
     */
    public double getDouble2() {
       return d2;
    	// YOUR CODE HERE
        
    }

    /**
     * Sets the first double to val.
     */
    public void setDouble1(double val) {
        this.d1 = val;
    	// YOUR CODE HERE

    }

    /**
     * Sets the second double to val.
     */
    public void setDouble2(double val) {
        this.d2 = val;
    	// YOUR CODE HERE

    }

    /**
     * write() is required for implementing Writable.
     */
    public void write(DataOutput out) throws IOException {
        out.writeDouble(this.d1);
        out.writeDouble(this.d2);
    	// YOUR CODE HERE

    }

    /**
     * readFields() is required for implementing Writable.
     */
    public void readFields(DataInput in) throws IOException {
        this.d1 = in.readDouble();
        this.d2 = in.readDouble();
    	// YOUR CODE HERE

    }
    
    public int compareTo(Object doub) {
    	DoublePair pair = (DoublePair) doub;
        if (pair.d1 != this.d1) {
        	return (pair.d1 < this.d1 ? 1 : -1);
        } else {
        	return Double.compare(this.d2, pair.d2);
        }
    }

    public int hashCode() {
        return Double.valueOf(d1 + d2).hashCode();
    }
    
    public static void main(String[] args) {
    	DoublePair dou1 = new DoublePair();
    	System.out.println(dou1.d1);
    	System.out.println(dou1.d2);
    	dou1.setDouble1(1);
    	dou1.setDouble2(2);
    	System.out.println(dou1.getDouble2());
    }
}


