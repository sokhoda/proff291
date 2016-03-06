package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.LocationDao;
import web.domain.Location;

import java.util.List;

/**
 * Created by erede on 06.03.2016.
 */
public class LocationServiceImpl  implements LocationService{
    @Autowired
    private LocationDao locationDao;

    private static int pageCounter = -1;

    @Override
    @Transactional(readOnly = true)
    public List<Location> findAll() {
        return locationDao.findAll();
    }

    @Override


    @Transactional (readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Location> showLocationByPortion(int portionSize) {
        if (portionSize == 0) {
            pageCounter = -1;
            return null;
        } if (portionSize < 0) {
            if (pageCounter > 0) pageCounter--;
        } else {
            pageCounter++;
        }
        return locationDao.findByPortion(pageCounter, Math.abs(portionSize));
    }
}
