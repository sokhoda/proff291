package JAXB.User;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Юра on 21.01.2016.
 */
public class ConverterToXML {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
//        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Marshaller marshaler = jaxbContext.createMarshaller();
        marshaler.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        List<User> users = new LinkedList<User>();

        User userOne = new User("Sara111","123",19,"Abdiralkina","Sara");

        users.add(new User("Sara111","123",19,"Abdiralkina","Sara"));
        users.add(new User("UliashaQQ","qwe",23,"Ubigashka","Yulia"));
        users.add(new User("SexyGirl","iddqd",49,"Abdulaev","Vasiliy"));
        users.add(new User("Ups-Ups","bebebe",19,"Bekas","Varvara"));
        UserList userlist = new UserList(users);
        File file = new File(FilePath.XML_FILE_PATH);
        StringWriter sw = new StringWriter();
             marshaler.marshal(userlist,  file);
            marshaler.marshal(userlist,System.out);
        System.out.println("...................");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//        List<User> FromXml = new ArrayList<>();
        UserList userFromXml = (UserList) unmarshaller.unmarshal(file);
        userFromXml.printMe();
//        UserList usersList = new UserList(FromXml);
//         usersList = (UserList) unmarshaller.unmarshal(file);
//        usersList.printMe();


    }
}
