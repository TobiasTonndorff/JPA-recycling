package dao;

import model.Driver;
import model.Truck;

import java.util.List;

public interface IWasteTruckDAO {

    int saveWasteTruck(String brand, String registrationNumber, int capacity);
    Truck getWasteTruckById(int id);
    void setWasteTruckAvailable(Truck wasteTruck, boolean available);
    void deleteWasteTruck(int id);
    void addDriverToWasteTruck(Truck wasteTruck, Driver driver);
    void removeDriverFromWasteTruck(Truck wasteTruck, String id);
    List<Truck> getAllAvailableTrucks();
}
