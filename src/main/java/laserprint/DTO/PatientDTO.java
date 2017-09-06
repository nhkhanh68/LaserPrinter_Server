package laserprint.DTO;

import laserprint.model.Patient;

public class PatientDTO {
    private int id;
    private String patientCode;
    private String name;
    private String address;
    private String dateOfBirth;
    private String lyDoKham;
    //    private String chuanDoanBenh;
    private String ppDieuTri;
    private String ngayKhamLai;

    private String phone;
    private String tieuSuBenh;

    private int patientId;

    private String date;
    private String content;
    private String chiSoCoBan;
    private String notice;
    private Patient patient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLyDoKham() {
        return lyDoKham;
    }

    public void setLyDoKham(String lyDoKham) {
        this.lyDoKham = lyDoKham;
    }

    public String getPpDieuTri() {
        return ppDieuTri;
    }

    public void setPpDieuTri(String ppDieuTri) {
        this.ppDieuTri = ppDieuTri;
    }

    public String getNgayKhamLai() {
        return ngayKhamLai;
    }

    public void setNgayKhamLai(String ngayKhamLai) {
        this.ngayKhamLai = ngayKhamLai;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTieuSuBenh() {
        return tieuSuBenh;
    }

    public void setTieuSuBenh(String tieuSuBenh) {
        this.tieuSuBenh = tieuSuBenh;
    }

    public String getChiSoCoBan() {
        return chiSoCoBan;
    }

    public void setChiSoCoBan(String chiSoCoBan) {
        this.chiSoCoBan = chiSoCoBan;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
