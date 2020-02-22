
/**
 * Abstract class Computer - write a description of the class here
 *
 * @author Johnnie Meredith
 * 
 * @version 1
 * 
 * @param manufacturer a computer manufacturer
 * @param processor a type of processor
 * @param ramsize a size of ram in GB
 * @param diskSize A size of hard drive in GB
 * @param processorSpeed A speed of a processor in GHz
 */
public abstract class Computer
{
    // instance variables 
   
    private String manufacturer;
    private String processor;
    private double ramSize;
    private int diskSize;
    private double processorSpeed;
    /**
     * Initializes a Computer object with all properties specified.
     * @param man The computer manufacturer
     * @param processor The processor type
     * @param ram The RAM size
     * @param disk The disk size
     * @param procSpeed The processor speed
     */
    public Computer(String man, String processor, double ram,
            int disk, double procSpeed) {
        manufacturer = man;
        this.processor = processor;
        ramSize = ram;
        diskSize = disk;
        processorSpeed = procSpeed;
    }
    //abstract method for assignment
    abstract public double costBenefit(double cost);
    
     public double computePower() {
        return ramSize * processorSpeed;
    }

    public double getRamSize() {
        return ramSize;
    }

    public double getProcessorSpeed() {
        return processorSpeed;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getProcessor() {
        return processor;
    }

    public void setManufacurer(String man) {
        manufacturer = man;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRamSize(int ram) {
        ramSize = ram;
    }

    public void setDiskSize(int disk) {
        diskSize = disk;
    }

    public void setProcessorSpeed(double procSpeed) {
        processorSpeed = procSpeed;
    }

        public String getRamSize(String s) {
        return Double.toString(ramSize);
    }

    @Override
    public String toString() {
        String result = "Manufacturer: " + manufacturer + "\nCPU: "
                + processor + "\nRAM: " + ramSize + " gigabytes"
                + "\nDisk: " + diskSize + " gigabytes"
                + "\nProcessor speed: " + processorSpeed + " gigahertz";

        return result;
    }

        /**
     * Compares power of this computer and it argument
     * computer
     *
     * @param aComputer The computer being compared to this computer
     *
     * @return -1 if this computer has less power, 0 if the same, and
     *         +1 if this computer has more power.
     */
    public int comparePower(Computer aComputer) {
        if (this.computePower() < aComputer.computePower()) {
            return -1;
        } else if (this.computePower() == aComputer.computePower()) {
            return 0;
        } else {
            return 1;
        }
    }
    
    /**
     * Determine if this Computer is equal to the other
     * object
     *
     * @param obj The object to compare this Computer to
     *
     * @return true If the other object is of type Computer and all
     *         data fields are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() == this.getClass()) {
            Computer other = (Computer) obj;

            return getManufacturer().equals(other.getManufacturer())
                    && getProcessor().equals(other.getProcessor())
                    && (getRamSize() == other.getRamSize())
                    && (getDiskSize() == other.getDiskSize())
                    && (getProcessorSpeed() == other.getProcessorSpeed());
        } else {
            return false;
        }
    }
}

