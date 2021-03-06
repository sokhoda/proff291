package web.dao;

import web.domain.Location;

import java.util.List;

/**
 * Created by lenchi on 06.03.16.
 */
public interface LocationDao {
    List<Location> findAll();
    List findByPortion(int page, int size);
}
