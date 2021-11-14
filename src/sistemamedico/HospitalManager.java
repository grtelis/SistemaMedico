package sistemamedico;

/**
 *
 * @author Carlos Hernández
 */
public class HospitalManager {
    
    HospitalDatabase hospitalDatabase = new HospitalDatabase();
    
    void createHospital(String name, String type) {
        hospitalDatabase.createHospital(name, type);
    }
    
    void fetchHospital(String withName) {
        hospitalDatabase.fetchHospital(withName);
    }
    
    void updateHospital(int hospitalId, String name, String type) {
        hospitalDatabase.updateHospital(hospitalId, name, type);
    }
    
    void deleteHospital(int hospitalId) {
        hospitalDatabase.deleteHospital(hospitalId);
    }
}
