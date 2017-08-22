package laserprint.DTO;

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

    private int patientId;

    private String date;
    private String content;

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
}
