package laptopshop.service;

import laptopshop.domain.Laptop;

import java.util.List;

/**
 * Created by Pavel on 26.02.2016.
 */
public interface LaptopService {
    Long create(Laptop laptop);

    List<Laptop> findAll();
}
