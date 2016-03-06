package web.service;

import web.domain.Location;

import java.util.List;

/**
 * Created by erede on 06.03.2016.
 */
public interface LocationService {
    List<Location> findAll();
    List showLocationByPortion(int portionSize);
}
