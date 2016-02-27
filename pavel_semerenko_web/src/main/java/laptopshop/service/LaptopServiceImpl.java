package laptopshop.service;

import laptopshop.dao.LaptopDao;
import laptopshop.domain.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavel on 26.02.2016.
 */
@Scope("singleton")
@Service
@Transactional
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopDao laptopDaoImpl;

    public LaptopServiceImpl() {
    }

    @Override
    public Long create(Laptop laptop) {
        if (laptop == null) return 0L;
        return laptopDaoImpl.create(laptop);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Laptop> findAll() {
        return laptopDaoImpl.findAll();
    }
}
