package laserprint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String patientCode;
    private String name;
    private String address;
    private String dateOfBirth;
    private String phone;
    private String tieuSuBenh;
    private String gioiTinh;
    private String noiSinh;
    private String cmnd;
    private String danToc;
    private String quocTich;
    private String hktt;
    private String email;
    private String deThuong;
    private String deMo;
    private String deThieuThang;
    private String canNangLucDe;
    private String diTatBamSinh;
    private String biNgatLucDe;
    @Column(name="diUngThuoc", length = 2800000)
    private String diUngThuoc;
    @Column(name="diUngHoaChat", length = 2800000)
    private String diUngHoaChat;
    @Column(name="diUngThucPham", length = 2800000)
    private String diUngThucPham;
    @Column(name="diUngKhac", length = 2800000)
    private String diUngKhac;
    private String henSuyen;
    private String benhPhoiManTinh;
    private String benhTimMach;
    private String daiThaoDuong;
    private String benhDaDay;
    private String benhBuouCo;
    private String viemGam;
    private String tamThan;
    private String dongKinh;
    private String tuKi;
    private String thinhLuc;
    private String thiLuc;
    private String tay;
    private String chan;
    private String cotSong;
    private String khuyetTatKhac;
    private String tieuSuPhauThuat;
    private String tsgdDiUngThuoc;
    private String tsgdDiUngHoaChat;
    private String tsgdDiUngThucPham;
    private String tsgdDiUngKhac;
    private String tsgdHenSuyen;
    private String tsgdBenhPhoiManTinh;
    private String tsgdBenhTimMach;
    private String tsgdViemGan;
    private String tsgdTamThan;
    private String tsgdBuouCo;
    private String tsgdTuKi;
    private String tsgdBenhDaDay;
    private String tuoiCoKinh;
    private String tuoiManKinh;
    private String tuoiQuanHe;
    private String bienPhapTranhThai;
    private String soLanCoThai;
    private String soLanSayThai;
    private String soLanPhaThai;
    private String soLanSinhDe;
    private String tsspDeKho;
    private String tsspDeThuong;
    private String tsspDeDuThang;
    private String tsspSoConSong;
    private String tsspBenhPhuKhoa;
    private String tsspBenhKhac;


    public Patient(String patientCode, String name, String address, String dateOfBirth, String phone, String tieuSuBenh,
                   String gioiTinh, String cmnd, String danToc, String quocTich, String hktt, String email,
                   String deThieuThang, String deThuong, String deMo, String canNangLucDe, String diTatBamSinh,
                   String diUngThuoc, String diUngHoaChat, String diUngThucPham, String diUngKhac, String noiSinh,
                   String biNgatLucDe, String henSuyen, String benhPhoiManTinh, String benhTimMach, String daiThaoDuong,
                   String benhDaDay, String benhBuouCo, String viemGam, String tamThan, String thinhLuc, String thiLuc,
                   String tay, String chan, String cotSong, String khuyetTatKhac, String tieuSuPhauThuat, String tsgdDiUngThuoc,
                   String tsgdDiUngHoaChat, String tsgdDiUngThucPham, String tsgdDiUngKhac, String tsgdHenSuyen,
                   String tsgdBenhPhoiManTinh, String tsgdBenhTimMach, String tsgdViemGan, String tsgdTamThan, String tsgdBuouCo,
                   String tsgdTuKi, String tsgdBenhDaDay, String tuoiCoKinh, String tuoiManKinh, String tuoiQuanHe,
                   String bienPhapTranhThai, String soLanCoThai, String soLanSayThai, String soLanPhaThai, String soLanSinhDe,
                   String tsspDeKho, String tsspDeThuong, String tsspDeDuThang, String tsspSoConSong, String tsspBenhPhuKhoa,
                   String tsspBenhKhac, String tuKi) {
        this.tuKi = tuKi;
        this.patientCode = patientCode;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.tieuSuBenh = tieuSuBenh;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.danToc = danToc;
        this.quocTich = quocTich;
        this.hktt = hktt;
        this.email = email;
        this.deThieuThang = deThieuThang;
        this.deMo = deMo;
        this.deThuong = deThuong;
        this.canNangLucDe = canNangLucDe;
        this.diTatBamSinh = diTatBamSinh;
        this.diUngThucPham = diUngThucPham;
        this.diUngHoaChat = diUngHoaChat;
        this.diUngThuoc = diUngThuoc;
        this.diUngKhac = diUngKhac;
        this.noiSinh = noiSinh;
        this.biNgatLucDe = biNgatLucDe;
        this.henSuyen = henSuyen;
        this.benhPhoiManTinh = benhPhoiManTinh;
        this.benhTimMach = benhTimMach;
        this.daiThaoDuong = daiThaoDuong;
        this.benhDaDay = benhDaDay;
        this.benhBuouCo = benhBuouCo;
        this.viemGam = viemGam;
        this.tamThan = tamThan;
        this.thinhLuc = thinhLuc;
        this.thiLuc = thiLuc;
        this.tay = tay;
        this.chan = chan;
        this.cotSong = cotSong;
        this.khuyetTatKhac = khuyetTatKhac;
        this.tieuSuPhauThuat = tieuSuPhauThuat;
        this.tsgdDiUngThuoc = tsgdDiUngThuoc;
        this.tsgdDiUngHoaChat = tsgdDiUngHoaChat;
        this.tsgdDiUngThucPham = tsgdDiUngThucPham;
        this.tsgdDiUngKhac = tsgdDiUngKhac;
        this.tsgdHenSuyen = tsgdHenSuyen;
        this.tsgdBenhPhoiManTinh = tsgdBenhPhoiManTinh;
        this.tsgdBenhTimMach = tsgdBenhTimMach;
        this.tsgdViemGan = tsgdViemGan;
        this.tsgdTamThan = tsgdTamThan;
        this.tsgdBuouCo = tsgdBuouCo;
        this.tsgdTuKi = tsgdTuKi;
        this.tsgdBenhDaDay = tsgdBenhDaDay;
        this.tuoiCoKinh = tuoiCoKinh;
        this.tuoiManKinh = tuoiManKinh;
        this.tuoiQuanHe = tuoiQuanHe;
        this.bienPhapTranhThai = bienPhapTranhThai;
        this.soLanCoThai = soLanCoThai;
        this.soLanSayThai = soLanSayThai;
        this.soLanPhaThai = soLanPhaThai;
        this.soLanSinhDe = soLanSinhDe;
        this.tsspDeKho = tsspDeKho;
        this.tsspDeThuong = tsspDeThuong;
        this.tsspDeDuThang = tsspDeDuThang;
        this.tsspSoConSong = tsspSoConSong;
        this.tsspBenhPhuKhoa = tsspBenhPhuKhoa;
        this.tsspBenhKhac =tsspBenhKhac;
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

    public String getBenhTimMach() {
        return benhTimMach;
    }

    public void setBenhTimMach(String benhTimMach) {
        this.benhTimMach = benhTimMach;
    }

    public String getDaiThaoDuong() {
        return daiThaoDuong;
    }

    public void setDaiThaoDuong(String daiThaoDuong) {
        this.daiThaoDuong = daiThaoDuong;
    }

    public String getBenhDaDay() {
        return benhDaDay;
    }

    public void setBenhDaDay(String benhDaDay) {
        this.benhDaDay = benhDaDay;
    }

    public String getBenhBuouCo() {
        return benhBuouCo;
    }

    public void setBenhBuouCo(String benhBuouCo) {
        this.benhBuouCo = benhBuouCo;
    }

    public String getViemGam() {
        return viemGam;
    }

    public void setViemGam(String viemGam) {
        this.viemGam = viemGam;
    }

    public String getTamThan() {
        return tamThan;
    }

    public void setTamThan(String tamThan) {
        this.tamThan = tamThan;
    }

    public String getThinhLuc() {
        return thinhLuc;
    }

    public void setThinhLuc(String thinhLuc) {
        this.thinhLuc = thinhLuc;
    }

    public String getThiLuc() {
        return thiLuc;
    }

    public void setThiLuc(String thiLuc) {
        this.thiLuc = thiLuc;
    }

    public String getTay() {
        return tay;
    }

    public void setTay(String tay) {
        this.tay = tay;
    }

    public String getChan() {
        return chan;
    }

    public void setChan(String chan) {
        this.chan = chan;
    }

    public String getCotSong() {
        return cotSong;
    }

    public void setCotSong(String cotSong) {
        this.cotSong = cotSong;
    }

    public String getKhuyetTatKhac() {
        return khuyetTatKhac;
    }

    public void setKhuyetTatKhac(String khuyetTatKhac) {
        this.khuyetTatKhac = khuyetTatKhac;
    }

    public String getTieuSuPhauThuat() {
        return tieuSuPhauThuat;
    }

    public void setTieuSuPhauThuat(String tieuSuPhauThuat) {
        this.tieuSuPhauThuat = tieuSuPhauThuat;
    }

    public String getTsgdDiUngThuoc() {
        return tsgdDiUngThuoc;
    }

    public void setTsgdDiUngThuoc(String tsgdDiUngThuoc) {
        this.tsgdDiUngThuoc = tsgdDiUngThuoc;
    }

    public String getTsgdDiUngHoaChat() {
        return tsgdDiUngHoaChat;
    }

    public void setTsgdDiUngHoaChat(String tsgdDiUngHoaChat) {
        this.tsgdDiUngHoaChat = tsgdDiUngHoaChat;
    }

    public String getTsgdDiUngThucPham() {
        return tsgdDiUngThucPham;
    }

    public void setTsgdDiUngThucPham(String tsgdDiUngThucPham) {
        this.tsgdDiUngThucPham = tsgdDiUngThucPham;
    }

    public String getTsgdDiUngKhac() {
        return tsgdDiUngKhac;
    }

    public void setTsgdDiUngKhac(String tsgdDiUngKhac) {
        this.tsgdDiUngKhac = tsgdDiUngKhac;
    }

    public String getTsgdHenSuyen() {
        return tsgdHenSuyen;
    }

    public void setTsgdHenSuyen(String tsgdHenSuyen) {
        this.tsgdHenSuyen = tsgdHenSuyen;
    }

    public String getTsgdBenhPhoiManTinh() {
        return tsgdBenhPhoiManTinh;
    }

    public void setTsgdBenhPhoiManTinh(String tsgdBenhPhoiManTinh) {
        this.tsgdBenhPhoiManTinh = tsgdBenhPhoiManTinh;
    }

    public String getTsgdBenhTimMach() {
        return tsgdBenhTimMach;
    }

    public void setTsgdBenhTimMach(String tsgdBenhTimMach) {
        this.tsgdBenhTimMach = tsgdBenhTimMach;
    }

    public String getTsgdViemGan() {
        return tsgdViemGan;
    }

    public void setTsgdViemGan(String tsgdViemGan) {
        this.tsgdViemGan = tsgdViemGan;
    }

    public String getTsgdTamThan() {
        return tsgdTamThan;
    }

    public void setTsgdTamThan(String tsgdTamThan) {
        this.tsgdTamThan = tsgdTamThan;
    }

    public String getTsgdBuouCo() {
        return tsgdBuouCo;
    }

    public void setTsgdBuouCo(String tsgdBuouCo) {
        this.tsgdBuouCo = tsgdBuouCo;
    }

    public String getTsgdTuKi() {
        return tsgdTuKi;
    }

    public void setTsgdTuKi(String tsgdTuKi) {
        this.tsgdTuKi = tsgdTuKi;
    }

    public String getTsgdBenhDaDay() {
        return tsgdBenhDaDay;
    }

    public void setTsgdBenhDaDay(String tsgdBenhDaDay) {
        this.tsgdBenhDaDay = tsgdBenhDaDay;
    }

    public String getTuoiCoKinh() {
        return tuoiCoKinh;
    }

    public void setTuoiCoKinh(String tuoiCoKinh) {
        this.tuoiCoKinh = tuoiCoKinh;
    }

    public String getTuoiManKinh() {
        return tuoiManKinh;
    }

    public void setTuoiManKinh(String tuoiManKinh) {
        this.tuoiManKinh = tuoiManKinh;
    }

    public String getTuoiQuanHe() {
        return tuoiQuanHe;
    }

    public void setTuoiQuanHe(String tuoiQuanHe) {
        this.tuoiQuanHe = tuoiQuanHe;
    }

    public String getBienPhapTranhThai() {
        return bienPhapTranhThai;
    }

    public void setBienPhapTranhThai(String bienPhapTranhThai) {
        this.bienPhapTranhThai = bienPhapTranhThai;
    }

    public String getSoLanCoThai() {
        return soLanCoThai;
    }

    public void setSoLanCoThai(String soLanCoThai) {
        this.soLanCoThai = soLanCoThai;
    }

    public String getSoLanSayThai() {
        return soLanSayThai;
    }

    public void setSoLanSayThai(String soLanSayThai) {
        this.soLanSayThai = soLanSayThai;
    }

    public String getSoLanPhaThai() {
        return soLanPhaThai;
    }

    public void setSoLanPhaThai(String soLanPhaThai) {
        this.soLanPhaThai = soLanPhaThai;
    }

    public String getSoLanSinhDe() {
        return soLanSinhDe;
    }

    public void setSoLanSinhDe(String soLanSinhDe) {
        this.soLanSinhDe = soLanSinhDe;
    }

    public String getTsspDeKho() {
        return tsspDeKho;
    }

    public void setTsspDeKho(String tsspDeKho) {
        this.tsspDeKho = tsspDeKho;
    }

    public String getTsspDeThuong() {
        return tsspDeThuong;
    }

    public void setTsspDeThuong(String tsspDeThuong) {
        this.tsspDeThuong = tsspDeThuong;
    }

    public String getTsspDeDuThang() {
        return tsspDeDuThang;
    }

    public void setTsspDeDuThang(String tsspDeDuThang) {
        this.tsspDeDuThang = tsspDeDuThang;
    }

    public String getTsspSoConSong() {
        return tsspSoConSong;
    }

    public void setTsspSoConSong(String tsspSoConSong) {
        this.tsspSoConSong = tsspSoConSong;
    }

    public String getTsspBenhPhuKhoa() {
        return tsspBenhPhuKhoa;
    }

    public void setTsspBenhPhuKhoa(String tsspBenhPhuKhoa) {
        this.tsspBenhPhuKhoa = tsspBenhPhuKhoa;
    }

    public String getTsspBenhKhac() {
        return tsspBenhKhac;
    }

    public void setTsspBenhKhac(String tsspBenhKhac) {
        this.tsspBenhKhac = tsspBenhKhac;
    }

    public Patient() {
    }



    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<HealthRecords> healthRecords;

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


    public List<HealthRecords> getHealthRecords() {
        return healthRecords;
    }

    public void setHealthRecords(List<HealthRecords> healthRecords) {
        this.healthRecords = healthRecords;
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getHktt() {
        return hktt;
    }

    public void setHktt(String hktt) {
        this.hktt = hktt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDeThuong() {
        return deThuong;
    }

    public void setDeThuong(String deThuong) {
        this.deThuong = deThuong;
    }

    public String getDeMo() {
        return deMo;
    }

    public void setDeMo(String deMo) {
        this.deMo = deMo;
    }

    public String getDeThieuThang() {
        return deThieuThang;
    }

    public void setDeThieuThang(String deThieuThang) {
        this.deThieuThang = deThieuThang;
    }

    public String getCanNangLucDe() {
        return canNangLucDe;
    }

    public void setCanNangLucDe(String canNangLucDe) {
        this.canNangLucDe = canNangLucDe;
    }

    public String getDiUngThuoc() {
        return diUngThuoc;
    }

    public void setDiUngThuoc(String diUngThuoc) {
        this.diUngThuoc = diUngThuoc;
    }

    public String getDiUngHoaChat() {
        return diUngHoaChat;
    }

    public void setDiUngHoaChat(String diUngHoaChat) {
        this.diUngHoaChat = diUngHoaChat;
    }

    public String getDiUngThucPham() {
        return diUngThucPham;
    }

    public void setDiUngThucPham(String diUngThucPham) {
        this.diUngThucPham = diUngThucPham;
    }

    public String getDiUngKhac() {
        return diUngKhac;
    }

    public void setDiUngKhac(String diUngKhac) {
        this.diUngKhac = diUngKhac;
    }

    public String getDiTatBamSinh() {
        return diTatBamSinh;
    }

    public void setDiTatBamSinh(String diTatBamSinh) {
        this.diTatBamSinh = diTatBamSinh;
    }

    public String getBiNgatLucDe() {
        return biNgatLucDe;
    }

    public void setBiNgatLucDe(String biNgatLucDe) {
        this.biNgatLucDe = biNgatLucDe;
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
}
