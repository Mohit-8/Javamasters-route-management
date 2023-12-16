package RoutesManagement.BusRoutes.dao.Bus;

import RoutesManagement.BusRoutes.model.Bus;
import RoutesManagement.BusRoutes.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusDaoImplement implements BusDao {
    @Autowired
    BusRepository busRepository;

    @Override
    public Bus getBus(String id) throws Exception {
        return busRepository.findById(id).orElseThrow(() -> new Exception("Bus not found"));
    }

    @Override
    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Bus updateBus(Bus bus) throws Exception {
        getBus(bus.getId());
        return busRepository.save(bus);
    }

    @Override
    public void deleteBus(String id) throws Exception {
        getBus(id);
        busRepository.deleteById(id);
    }

    @Override
    public Optional<Bus> findByBusNumber(String busNumber) {
        return busRepository.findByBusNumber(busNumber);
    }



}
