package laserprint.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="HealthRecords")
public class HealthRecords {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String date;
    @Column(name="content", length = 2800000)
    private String content;
    private String lyDoKham;
//    private String chuanDoanBenh;
    private String ppDieuTri;
    private String ngayKhamLai;
    public HealthRecords(){}

    public HealthRecords(Patient patient, String content, String date, String lyDoKham, String ppDieuTri, String ngayKhamLai){
        this.patient = patient;
        this.content = content;
        this.date = date;
        this.lyDoKham = lyDoKham;
        this.ppDieuTri = ppDieuTri;
        this.ngayKhamLai = ngayKhamLai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
