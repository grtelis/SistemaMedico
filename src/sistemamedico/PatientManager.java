package sistemamedico;

/**
 *
 * @author Carlos Hernández
 */
public class PatientManager {
    
    PatientDatabase patientDatabase = new PatientDatabase();
    PersonDatabase personDatabase = new PersonDatabase();
    
    
    void createPatient(
            int age, 
            float weight, 
            float size, 
            String suffering,  
            String name, 
            String lastNames,
            String phoneNumber
    ) {
        
        //FIRST CREATE PERSON AND GET HIS ID
        personDatabase.createPerson(name, lastNames, phoneNumber);
        
        //CREATE PATIENT 
        patientDatabase.createPatient(age, weight, size, suffering, 1);
    }
    
    void fetchPatient(String withName) {
        patientDatabase.fetchPatient(withName);
    }
    
    void updatePatient(
            int patientId, 
            int age, 
            float weight, 
            float size, 
            String suffering, 
            String name,
            String lastNames, 
            String phoneNumber
    ) {
        //FIRST GET PERSON ID FROM PATIENT
        patientDatabase.fetchPatientById(patientId);
        
        //UPDATE PERSON 
        personDatabase.updatePerson(1, suffering, suffering, suffering);
        
        //UPDATE PATIENT 
        patientDatabase.updatePatient(patientId, age, weight, size, suffering);        
    }
    
    void deletePatient(int patientId) {
        patientDatabase.deletePatient(patientId);
    }
    
}
