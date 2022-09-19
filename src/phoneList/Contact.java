package phoneList;

/*
 * This contains info for a single contact
 * 
 * Parameters Needed to Store
 *   - Contact's Name
 *   - Contact's Phone Number
 *   
 * Needed Methods
 *   - Constructor(s)
 *   - getter methods
 *   - Setter methods not necessary unless Constructor
 *        initialize variables.
 *   - Override toString() so that Contact can
 *        be printed as part of a list.
 * 
 */



public class Contact {

    private String contactName;
    private long contactNumber;

    public Contact(String name, long number) {
        contactName = name;
        contactNumber = number;
    }

    public String getContactName() {
        return contactName;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return contactName + " " + contactNumber;
    }
}
