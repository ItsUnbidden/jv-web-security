package taxi.service;

import java.util.List;
import java.util.NoSuchElementException;
import taxi.dao.DriverDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return driverDao.get(id).orElseThrow(() ->
            new NoSuchElementException("Can't get driver by id: " + id)
        );
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return driverDao.delete(id);
    }

    @Override
    public Driver findByLogin(String login) {
        return driverDao.findByLogin(login).orElseThrow(() -> 
            new NoSuchElementException("There is no driver with login: " + login)
        );
    }
}
