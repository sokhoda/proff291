package DeptsPage.departmemntsService;

import DeptsPage.departmentDao.DepartmentDao.DepartmentDao;
import DeptsPage.locationDao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пк2 on 06.03.2016.
 */
@Service
public class DeptsServiceImpl implements DeptsService {
    @Autowired
    private  DepartmentDao deptDao;
    @Autowired
    private  LocationDao locDao;
    private int start=0;
    private int max=10;

    @Override
    public List<Department> showDeptsList() {
        List<Department> depts=deptDao.findDepts(start,max);
        for(int i=0; i<depts.size();i++){
            Department dept=depts.get(i);
            Location loc=locDao.getLocationById(dept.getLocationId());
            deptDao.setDeptLocation(dept,loc);
        }
        return depts;
    }


//    @Autowired
//    private Manager managerDao;
//


//    @
}
