package laserprint.controller;

import laserprint.DTO.PatientDTO;
import laserprint.DTO.QRCodeDTO;
import laserprint.model.HealthRecords;
import laserprint.model.Patient;
import laserprint.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    private final
    PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(value = "qrcode/patient", method = RequestMethod.POST)
    public void readQrCodePatient(@RequestBody QRCodeDTO qrCodeDTO){
        patientService.readQrCodePatient(qrCodeDTO);
    }


    @RequestMapping(value = "patient", method = RequestMethod.GET)
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    @RequestMapping(value = "patient/create", method = RequestMethod.POST)
    public Patient createPatient(@RequestBody PatientDTO patientDTO){
        return patientService.createPatient(patientDTO);
    }

    @RequestMapping(value = "patient/edit", method = RequestMethod.POST)
    public Patient editPatient(@RequestBody PatientDTO patientDTO) throws Exception {
        return patientService.editPatient(patientDTO);
    }

    @RequestMapping(value = "patient/{patientId}/delete", method = RequestMethod.DELETE)
    public void deletePatient(@PathVariable("patientId") int patientId) throws Exception {
        patientService.deletePatient(patientId);
    }

    @RequestMapping(value = "healthRecords", method = RequestMethod.GET)
    public List<HealthRecords> getAllHealth(){
        return patientService.getAllHealthRecords();
    }

    @RequestMapping(value = "healthRecords/create", method = RequestMethod.POST)
    public HealthRecords createHealthRecords(@RequestBody PatientDTO patientDTO) throws Exception {
        return patientService.createHealthRecords(patientDTO);
    }

    @RequestMapping(value = "healthrecords/{id}/delete", method = RequestMethod.DELETE)
    public void deleteHealthRecords(@PathVariable("id") int id) throws Exception {
        patientService.deleteHealth(id);
    }

    //get all healthRecords of patient
    @RequestMapping(value = "healthRecords/{id}", method = RequestMethod.GET)
    public List<HealthRecords> getAllHealthRecordsOfPatient(@PathVariable("id") int id){
        return patientService.getALlHealthRecordsOfPatient(id);
    }
}
