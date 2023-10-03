package ma.easybanking.main.java.model.DTO;

public class Agency {
    private int code;
    private String name;
    private String address;
    private String phoneNumber;

    public Agency(){

    }

    public Agency(String name,String address,String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Code : "+this.code+"\n"+"Nom : "+this.name+"\n"+"Adresse : "+this.address+"\n"+"N° Tél : "+this.phoneNumber+"\n";
    }
}
