package Session16.Servise;

import Session16.Dao.EmployeeDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Пк2 on 21.02.2016.
 */
@Service("Service1")
public class EmplServiceImpl implements EmplService {

    @Autowired
    @Qualifier("emplDaoImpl")
    private EmployeeDao emplDao;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public List getSalaryByEmplName(String aFirstName, String aLastName) {
       return emplDao.getSalaryByEmplName(aFirstName,aLastName);
    }
}
