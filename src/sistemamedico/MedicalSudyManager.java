package sistemamedico;

/**
 *
 * @author Carlos Hernández
 */
public class MedicalSudyManager {
    
    MedicalStudyDatabase medicalStudyDatabase = new MedicalStudyDatabase();

    void createMedicalStudy(String medicalStudyType, String date, int personId) {
        medicalStudyDatabase.createMedicalStudy(medicalStudyType, date, personId);
    }
    
    void fetchMedicalStudy(String medicalStudyType) {
        medicalStudyDatabase.fetchMedicalStudy(medicalStudyType);
    }
    
    void updateMedicalStudy(
            int medicalStudyId, 
            String medicalStudyType,
            String date, 
            int personId
    ) {                
        medicalStudyDatabase.updateMedicalStudy(medicalStudyId, medicalStudyType, date, personId);
    }
        
    void deleteMedicalStudy(int medicalStudyId) {
        medicalStudyDatabase.deleteMedicalStudy(medicalStudyId);
    }
}
