package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.transaction.annotation.Transactional;
import web.dao.LocationDao;

import java.util.List;

/**
 * Created by erede on 06.03.2016.
 */
public class LocationServiceImpl  implements LocationService{
    @Autowired
    private LocationDao locationDao;

    @Override
    @Transactional(readOnly = true)
    public List<Location> findAll() {
        return locationDao.findAll();
    }
}
