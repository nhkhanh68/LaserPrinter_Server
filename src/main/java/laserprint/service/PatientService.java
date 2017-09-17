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

    public Patient createPatient(Patient patientDTO){
//        Patient patient = new Patient(patientDTO.getPatientCode(), patientDTO.getName(), patientDTO.getAddress(),
//                patientDTO.getDateOfBirth(), patientDTO.getPhone(), patientDTO.getTieuSuBenh(), patientDTO.getGioiTinh(),
//                patientDTO.getCmnd(), patientDTO.getDanToc(), patientDTO.getQuocTich(), patientDTO.getHktt(),
//                patientDTO.getEmail(), patientDTO.getDeThieuThang(), patientDTO.getDeThuong(),patientDTO.getDeMo(),
//                patientDTO.getCanNangLucDe(), patientDTO.getDiTatBamSinh(), patientDTO.getDiUngThuoc(), patientDTO.getDiUngHoaChat(),
//                patientDTO.getDiUngThucPham(), patientDTO.getDiUngKhac(), patientDTO.getNoiSinh(), patientDTO.getBiNgatLucDe());
//        Patient patient = patientDTO;
        return patientRepository.save(patientDTO);
    }

    public Patient editPatient(PatientDTO patientDTO) throws Exception {
        Patient patient = patientRepository.findById(patientDTO.getPatientId());
        if(patient != null){
            patient.setAddress(patientDTO.getAddress());
            patient.setDateOfBirth(patientDTO.getDateOfBirth());
            patient.setPhone(patientDTO.getPhone());
            patient.setTieuSuBenh(patientDTO.getTieuSuBenh());
            patient.setGioiTinh(patientDTO.getGioiTinh());
            patient.setCmnd(patientDTO.getCmnd());
            patient.setDanToc(patientDTO.getDanToc());
            patient.setQuocTich(patientDTO.getQuocTich());
            patient.setHktt(patientDTO.getHktt());
            patient.setEmail(patientDTO.getEmail());
            patient.setDeThieuThang(patientDTO.getDeThieuThang());
            patient.setDeThuong(patientDTO.getDeThuong());
            patient.setDeMo(patientDTO.getDeMo());
            patient.setCanNangLucDe(patientDTO.getCanNangLucDe());
            patient.setDiTatBamSinh(patientDTO.getDiTatBamSinh());
            patient.setDiUngHoaChat(patientDTO.getDiUngHoaChat());
            patient.setDiUngThucPham(patientDTO.getDiUngThucPham());
            patient.setDiUngThuoc(patientDTO.getDiUngThuoc());
            patient.setDiUngKhac(patientDTO.getDiUngKhac());
            patient.setNoiSinh(patientDTO.getNoiSinh());
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

    public HealthRecords createHealthRecords(HealthRecords healthRecords, int patientId) throws Exception {
        Patient patient = patientRepository.findById(patientId);
        if(patient != null){
//            HealthRecords healthRecords = patientDTO;
            healthRecords.setPatient(patient);
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
