package session15;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by elenabugercuk on 21.02.16.
 */
@Lazy
@Scope("prototype")
@Component
public class Phone3 extends Phone {
    @Value("Bmw")
    private String name;

    @Value("23")
    private int age;



    public Phone3()  {

    }

    @Override
    public String toString() {
        return "Phone3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}



//quest = '';
//
//        quest = XQuery('for $_i in collaborators return $_i ');
//
//        for(_d in quest){
//
//        open = OpenDoc(UrlFromDocID(_d.id));
//        open.TopElem.access.web_banned=true;
//        open.Save();
//
//
//
//        }
//
//        _d=0;
//
//        for (_d in quest){
//        open = OpenDoc(UrlFromDocID(_d.id));
//        if (open.TopElem.lastname=='Иванов'){
//        open.TopElem.access.web_banned=false;
//        open.Save();
//        }
//        }