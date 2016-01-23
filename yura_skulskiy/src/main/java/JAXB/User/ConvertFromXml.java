package JAXB.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Юра on 21.01.2016.
 */
public class ConvertFromXml {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
        Unmarshaller unmarshaller= jaxbContext.createUnmarshaller();
//        File file = new File("D:\\users_list.xml");
        File file = new File(FilePath.XML_FILE_PATH);
       UserList usersList = (UserList) unmarshaller.unmarshal(file);
        usersList.printMe();







    }
}
