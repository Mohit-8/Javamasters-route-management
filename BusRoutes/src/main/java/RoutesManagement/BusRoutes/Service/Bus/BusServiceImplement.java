package RoutesManagement.BusRoutes.Service.Bus;

import RoutesManagement.BusRoutes.model.Bus;
import RoutesManagement.BusRoutes.dao.Bus.BusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BusServiceImplement implements BusService{

    @Autowired
    BusDao busDao;
    
    @Override
    public Bus getBus(String id) throws Exception {
        return busDao.getBus(id);
    }

    @Override
    public Bus addBus(Bus bus) throws Exception {
        busValidation(bus);
        return busDao.saveBus(bus);
    }

    @Override
    public Bus updateBus(String id, Bus bus) throws Exception {
        updateBusValidation(bus);
     return busDao.updateBus(bus);
    }

    @Override
    public  void deleteBus(String id) throws Exception {
        busDao.deleteBus(id);
    }

    private void busValidation(Bus bus) throws Exception {
        if(bus.getId()!=null && busDao.getBus(bus.getId())!=null)
        {
            throw new Exception("Bus with id : "+bus.getId()+" already exists");
        }
        if (busDao.findByBusNumber(bus.getBusNumber()).isPresent()) {
            throw new Exception("Bus with number : " + bus.getBusNumber() + " already exists");
        }
        if(!bus.getBusType().equals("ORDINARY") && !bus.getBusType().equals("DELUXE")){
            throw new Exception("Bus can either be ORDINARY or DELUXE");
        }
    }
    private void updateBusValidation(Bus bus) throws Exception {
        if (busDao.findByBusNumber(bus.getBusNumber()).isPresent() && !Objects.equals(busDao.findByBusNumber(bus.getBusNumber()).get().getId(), bus.getId())) {
            throw new Exception("Bus with number : " + bus.getBusNumber() + " already exists");
        }
        if(!bus.getBusType().equals("ORDINARY") && !bus.getBusType().equals("DELUXE")){
            throw new Exception("Bus can either be ORDINARY or DELUXE");
        }
    }


}
