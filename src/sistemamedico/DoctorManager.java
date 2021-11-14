package sistemamedico;

/**
 *
 * @author Carlos Hernández
 */
public class DoctorManager {
    
    DoctorDatabase doctorDatabase = new DoctorDatabase();
    PersonDatabase personDatabase = new PersonDatabase();
    
    void createDoctor(
            String identificationCard, 
            String name, 
            String lastNames,
            String phoneNumber,
            int hospitalId            
    ) {
        
        //FIRST CREATE PERSON AND GET HIS ID
        personDatabase.createPerson(name, lastNames, phoneNumber);
        
        //CREATE DOCTOR 
        doctorDatabase.insertDoctor(identificationCard, 1, hospitalId);
    }
    
    void fetchDoctor(String withName) {
        doctorDatabase.fetchDoctor(withName);
    }
    
    void updateDoctor(
            int doctorId,
            String identificationCard, 
            String name, 
            String lastNames,
            String phoneNumber,
            int hospitalId
    ) {
        //GET PERSON ID FROM DOCTOR                 
        doctorDatabase.fetchDoctorById(doctorId);
        
        //UPDATE PERSON FIRST
        personDatabase.updatePerson(1, name, lastNames, phoneNumber);
        
        //UPDATE DOCTOR 
        doctorDatabase.updateDoctor(doctorId, identificationCard, hospitalId);
    }
    
    void deleteDoctor(int doctorId) {
        doctorDatabase.deleteDoctor(doctorId);
    }
}
