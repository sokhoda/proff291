package JAXB.User.exp;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;
 
public class MarshUnmarsh {
 
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(EmpList.class);
 
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
        List<Emp> l = new LinkedList<Emp>();
        for (int i = 0; i < 10; i++) {
            l.add(new Emp("a" + i, new Address("city" + i, "street" + i)));
        }
        EmpList el = new EmpList(l);
//        File file = new File("D:\\my_filee.xml");
        StringWriter sw = new StringWriter();
        m.marshal(el, sw);
//        m.marshal(el, file);

        Unmarshaller um = context.createUnmarshaller();
        String s = sw.toString();
 
        System.out.println(s);
 
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
 
//        UserList el2 = (UserList) um.unmarshal(file);
//        System.out.println(el2);
 
        System.out.println("FINISH ;)");
 
    }
 
    @XmlRootElement(name="братва")
    @XmlAccessorType(XmlAccessType.NONE)

    static class EmpList {
 
        public EmpList() {
        }
 
        public EmpList(List<Emp> el) {
            dude = el;
        }
        
//      @XmlElement(name="чувак")
        private List<Emp> dude;
 
        public List<Emp> getDude() {
            return dude;
        }
        
        @XmlElement(name="чувак")
        public void setDude(List<Emp> dude) {
            this.dude = dude;
        }
 
        @Override
        public String toString() {
            return "UserList [dude=" + dude + "]";
        }
 
    }
    
    
    static class Emp {
 
        public Emp() {
        }
 
        public Emp(String name, Address address) {
            this.name = name;
            this.address = address;
        }
        
        
        private String name;
        
        
 
        private Address address;
 
        @XmlElement(name="погоняло")
        public String getName() {
            return name;
        }
 
        public void setName(String name) {
            this.name = name;
        }
        
        
        public Address getAddress() {
            return address;
        }
 
        @XmlElement(name="кича")
        public void setAddress(Address address) {
            this.address = address;
        }
 
        @Override
        public String toString() {
            return "User [name=" + name + ", address=" + address + "]";
        }
 
    }
 
    static class Address {
 
        public Address() {
        }
 
        public Address(String city, String street) {
            super();
            this.city = city;
            this.street = street;
        }
 
        private String city;
        private String street;
 
        public String getCity() {
            return city;
        }
 
        @XmlElement(name="село")
        public void setCity(String city) {
            this.city = city;
        }
 
        public String getStreet() {
            return street;
        }
        @XmlElement(name="проулок")
        public void setStreet(String street) {
            this.street = street;
        }
 
        @Override
        public String toString() {
            return "Address [city=" + city + ", street=" + street + "]";
        }
 
    }
 
}