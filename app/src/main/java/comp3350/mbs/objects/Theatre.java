package comp3350.mbs.objects;

public class Theatre{
    private String name;
    private String address;
    //needed an empty constructor when implementing Parcelable interface in the ParcelableTheatre class.
    public Theatre(){}
    /**
     * Constructor of Theatre class.
     *
     * @param name is the name of the theatre.
     * @param address is the address of the theatre.
     */
    public Theatre(String name, String address) {
        this.name = name;
        this.address = address;
    }//end Constructor


    //================================================================
    //Getter methods
    public String getName() {
        return name;
    }//end getName

    public String getAddress() {
        return address;
    }//end getAddress

    //================================================================
    //Setter methods
    public void setName(String name) {
        this.name = name;
    }//end setName

    public void setAddress(String address) {
        this.address = address;
    }//end setAddress

    /**
     * equals - a method that determines if the given object (Theatre) has the same theatre name as the instance name.
     *
     * @param object is the object that will be compared to the instance's name.
     * @return it will return true if the given object's name is the same as the instance's name.
     * Otherwise, it will return false.
     */
    public boolean equals(Object object) {
        boolean result = false;

        if (object instanceof Theatre) {
            Theatre theatreItem = (Theatre) object;//cast the object to Theatre

            if (((theatreItem.getName() == null) && (name == null)) ||
                    (theatreItem.getName().equals(name))) {
                result = true;
            }//end nested if

        }//end if

        return result;

    }//end equals

}//end Theatre
