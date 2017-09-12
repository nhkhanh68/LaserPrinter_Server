package laserprint.service;

import laserprint.DTO.PatientDTO;
import laserprint.DTO.QRCodeDTO;
import laserprint.model.HealthRecords;
import laserprint.model.Patient;
import laserprint.model.QRCode;
import laserprint.repository.HealthRecordsRepository;
import laserprint.repository.PatientRepository;
import laserprint.repository.QRCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final
    PatientRepository patientRepository;
    private final
    HealthRecordsRepository healthRecordsRepository;
    private final
    SimpMessagingTemplate simpMessagingTemplate;
    private final QRCodeRepository qrCodeRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, HealthRecordsRepository healthRecordsRepository,
                          SimpMessagingTemplate simpMessagingTemplate, QRCodeRepository qrCodeRepository) {
        this.patientRepository = patientRepository;
        this.healthRecordsRepository = healthRecordsRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.qrCodeRepository = qrCodeRepository;
    }

    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    public Patient createPatient(PatientDTO patientDTO){
        Patient patient = new Patient(patientDTO.getPatientCode(), patientDTO.getName(), patientDTO.getAddress(),
                patientDTO.getDateOfBirth(), patientDTO.getPhone(), patientDTO.getTieuSuBenh());
        return patientRepository.save(patient);
    }

    public Patient editPatient(PatientDTO patientDTO) throws Exception {
        Patient patient = patientRepository.findById(patientDTO.getPatientId());
        if(patient != null){
            patient.setAddress(patientDTO.getAddress());
            patient.setDateOfBirth(patientDTO.getDateOfBirth());
//            patient.setName(patientDTO.getName());
            patient.setPhone(patientDTO.getPhone());
            patient.setTieuSuBenh(patientDTO.getTieuSuBenh());
            return patientRepository.save(patient);
        } else {
            throw new Exception("Không tìm thấy bệnh nhân!");
        }
    }

    public void deletePatient(int id) throws Exception {
        Patient patient = patientRepository.findById(id);
        if(patient != null){
            patientRepository.delete(patient);
        } else {
            throw new Exception("Khong tim thay benh nhan");
        }
    }

    public List<HealthRecords> getAllHealthRecords(){
        return healthRecordsRepository.findAll();
    }

    public HealthRecords createHealthRecords(PatientDTO patientDTO) throws Exception {
        Patient patient = patientRepository.findById(patientDTO.getPatientId());
        if(patient != null){
            HealthRecords healthRecords = new HealthRecords(patient, patientDTO.getContent(), patientDTO.getDate(),
                    patientDTO.getLyDoKham(), patientDTO.getPpDieuTri(), patientDTO.getChiSoCoBan(),
                    patientDTO.getNgayKhamLai(), patientDTO.getNotice());
            return healthRecordsRepository.save(healthRecords);
        } else {
            throw new Exception("Khong tim thay benh nhan!");
        }
    }

    public void deleteHealth(int id) throws Exception {
        HealthRecords healthRecords = healthRecordsRepository.findOne(id);
        if(healthRecords!= null){
            healthRecordsRepository.delete(healthRecords);
        } else {
            throw new Exception("Khong tim thay!");
        }
    }

    public void readQrCodePatient(QRCodeDTO qrCodeDTO){
//        System.out.print(qrCodeDTO.getQrData());
        QRCode qrCode = new QRCode(qrCodeDTO.getReaderId(), qrCodeDTO.getReadTime(), qrCodeDTO.getQrData());
        qrCodeRepository.save(qrCode);
        Patient patient = patientRepository.findByPatientCode(qrCodeDTO.getQrData());
        if(patient!= null){
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setName(patient.getName());
            patientDTO.setDateOfBirth(patient.getDateOfBirth());
            patientDTO.setAddress(patient.getAddress());
            patientDTO.setPatientId(patient.getId());
            patientDTO.setPatient(patient);
            simpMessagingTemplate.convertAndSend("/user/patient/**", patientDTO);
        }
    }

    public List<HealthRecords> getALlHealthRecordsOfPatient(int patientId){
        return healthRecordsRepository.findByPatientId(patientId);
    }

}
