package session16;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Solyk on 21.02.2016.
 */
@Lazy
//@Scope("prototype")
@Scope
@Component
public class MrBean {
    @Value("fieldName")//${...}
    private String field;

    @Autowired(required = true)
    private SessionFactory sf;


}
