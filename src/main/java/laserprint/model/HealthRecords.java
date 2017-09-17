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
    private String chiSoCoBan;
    private String notice;
    private String benhSu;
    private String henSuyen;
    private String benhPhoiManTinh;
    private String benhTimmach;
    private String viemGan;
    private String tamThan;
    private String buouCo;
    private String dongKinh;
    private String tuKi;
    private String benhDaDay;
    private String da;
    private String niemMac;
    private String lamSangKhac;
    private String timMach;
    private String tietNieu;
    private String tieuHoa;
    private String hohap;
    private String taiMuiHong;
    private String rangHamMat;
    private String mat;
    private String coXuongKhop;
    private String dinhDuong;
    private String noiTiet;
    private String coQuanThanhKinh;
    private String coQuanKhac;
    private String huyetHoc;
    private String sinhHocMau;
    private String xQuang;
    private String sieuAm;
    private String xetNghiemKhac;
    private String chuanDoanKetLuan;
    private String tenThuoc1;
    private String soLuong1;
    private String lieuDung1;
    private String tenThuoc2;
    private String soLuong2;
    private String lieuDung2;
    private String tenThuoc3;
    private String soLuong3;
    private String lieuDung3;;
    private String tuVan;

    public String getBenhSu() {
        return benhSu;
    }

    public void setBenhSu(String benhSu) {
        this.benhSu = benhSu;
    }

    public String getHenSuyen() {
        return henSuyen;
    }

    public void setHenSuyen(String henSuyen) {
        this.henSuyen = henSuyen;
    }

    public String getBenhPhoiManTinh() {
        return benhPhoiManTinh;
    }

    public void setBenhPhoiManTinh(String benhPhoiManTinh) {
        this.benhPhoiManTinh = benhPhoiManTinh;
    }

    public String getBenhTimmach() {
        return benhTimmach;
    }

    public void setBenhTimmach(String benhTimmach) {
        this.benhTimmach = benhTimmach;
    }

    public String getViemGan() {
        return viemGan;
    }

    public void setViemGan(String viemGan) {
        this.viemGan = viemGan;
    }

    public String getTamThan() {
        return tamThan;
    }

    public void setTamThan(String tamThan) {
        this.tamThan = tamThan;
    }

    public String getBuouCo() {
        return buouCo;
    }

    public void setBuouCo(String buouCo) {
        this.buouCo = buouCo;
    }

    public String getDongKinh() {
        return dongKinh;
    }

    public void setDongKinh(String dongKinh) {
        this.dongKinh = dongKinh;
    }

    public String getTuKi() {
        return tuKi;
    }

    public void setTuKi(String tuKi) {
        this.tuKi = tuKi;
    }

    public String getBenhDaDay() {
        return benhDaDay;
    }

    public void setBenhDaDay(String benhDaDay) {
        this.benhDaDay = benhDaDay;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public String getNiemMac() {
        return niemMac;
    }

    public void setNiemMac(String niemMac) {
        this.niemMac = niemMac;
    }

    public String getLamSangKhac() {
        return lamSangKhac;
    }

    public void setLamSangKhac(String lamSangKhac) {
        this.lamSangKhac = lamSangKhac;
    }

    public String getTimMach() {
        return timMach;
    }

    public void setTimMach(String timMach) {
        this.timMach = timMach;
    }

    public String getTietNieu() {
        return tietNieu;
    }

    public void setTietNieu(String tietNieu) {
        this.tietNieu = tietNieu;
    }

    public String getTieuHoa() {
        return tieuHoa;
    }

    public void setTieuHoa(String tieuHoa) {
        this.tieuHoa = tieuHoa;
    }

    public String getHohap() {
        return hohap;
    }

    public void setHohap(String hohap) {
        this.hohap = hohap;
    }

    public String getTaiMuiHong() {
        return taiMuiHong;
    }

    public void setTaiMuiHong(String taiMuiHong) {
        this.taiMuiHong = taiMuiHong;
    }

    public String getRangHamMat() {
        return rangHamMat;
    }

    public void setRangHamMat(String rangHamMat) {
        this.rangHamMat = rangHamMat;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getCoXuongKhop() {
        return coXuongKhop;
    }

    public void setCoXuongKhop(String coXuongKhop) {
        this.coXuongKhop = coXuongKhop;
    }

    public String getDinhDuong() {
        return dinhDuong;
    }

    public void setDinhDuong(String dinhDuong) {
        this.dinhDuong = dinhDuong;
    }

    public String getNoiTiet() {
        return noiTiet;
    }

    public void setNoiTiet(String noiTiet) {
        this.noiTiet = noiTiet;
    }

    public String getCoQuanThanhKinh() {
        return coQuanThanhKinh;
    }

    public void setCoQuanThanhKinh(String coQuanThanhKinh) {
        this.coQuanThanhKinh = coQuanThanhKinh;
    }

    public String getCoQuanKhac() {
        return coQuanKhac;
    }

    public void setCoQuanKhac(String coQuanKhac) {
        this.coQuanKhac = coQuanKhac;
    }

    public String getHuyetHoc() {
        return huyetHoc;
    }

    public void setHuyetHoc(String huyetHoc) {
        this.huyetHoc = huyetHoc;
    }

    public String getSinhHocMau() {
        return sinhHocMau;
    }

    public void setSinhHocMau(String sinhHocMau) {
        this.sinhHocMau = sinhHocMau;
    }

    public String getxQuang() {
        return xQuang;
    }

    public void setxQuang(String xQuang) {
        this.xQuang = xQuang;
    }

    public String getSieuAm() {
        return sieuAm;
    }

    public void setSieuAm(String sieuAm) {
        this.sieuAm = sieuAm;
    }

    public String getXetNghiemKhac() {
        return xetNghiemKhac;
    }

    public void setXetNghiemKhac(String xetNghiemKhac) {
        this.xetNghiemKhac = xetNghiemKhac;
    }

    public String getChuanDoanKetLuan() {
        return chuanDoanKetLuan;
    }

    public void setChuanDoanKetLuan(String chuanDoanKetLuan) {
        this.chuanDoanKetLuan = chuanDoanKetLuan;
    }

    public String getTenThuoc1() {
        return tenThuoc1;
    }

    public void setTenThuoc1(String tenThuoc1) {
        this.tenThuoc1 = tenThuoc1;
    }

    public String getSoLuong1() {
        return soLuong1;
    }

    public void setSoLuong1(String soLuong1) {
        this.soLuong1 = soLuong1;
    }

    public String getLieuDung1() {
        return lieuDung1;
    }

    public void setLieuDung1(String lieuDung1) {
        this.lieuDung1 = lieuDung1;
    }

    public String getTenThuoc2() {
        return tenThuoc2;
    }

    public void setTenThuoc2(String tenThuoc2) {
        this.tenThuoc2 = tenThuoc2;
    }

    public String getSoLuong2() {
        return soLuong2;
    }

    public void setSoLuong2(String soLuong2) {
        this.soLuong2 = soLuong2;
    }

    public String getLieuDung2() {
        return lieuDung2;
    }

    public void setLieuDung2(String lieuDung2) {
        this.lieuDung2 = lieuDung2;
    }

    public String getTenThuoc3() {
        return tenThuoc3;
    }

    public void setTenThuoc3(String tenThuoc3) {
        this.tenThuoc3 = tenThuoc3;
    }

    public String getSoLuong3() {
        return soLuong3;
    }

    public void setSoLuong3(String soLuong3) {
        this.soLuong3 = soLuong3;
    }

    public String getLieuDung3() {
        return lieuDung3;
    }

    public void setLieuDung3(String lieuDung3) {
        this.lieuDung3 = lieuDung3;
    }

    public String getTuVan() {
        return tuVan;
    }

    public void setTuVan(String tuVan) {
        this.tuVan = tuVan;
    }

    public HealthRecords(){}



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
}
