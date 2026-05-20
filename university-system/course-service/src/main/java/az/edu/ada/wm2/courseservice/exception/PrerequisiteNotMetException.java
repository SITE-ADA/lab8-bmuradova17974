package az.edu.ada.wm2.courseservice.exception;

public class PrerequisiteNotMetException extends RuntimeException {
    public PrerequisiteNotMetException(Long studentId, Long prerequisiteCourseId){
        super("Telebe (ID: " + studentId + ") ilkin sert kursuna (ID: " + prerequisiteCourseId + ") qeydiyyatdan kecmeyib.");
    }
}
