package laserprint.controller;

import laserprint.DTO.QRCodeDTO;
import laserprint.model.CheckIn;
import laserprint.model.NhanVien;
import laserprint.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class NhanVienController {
    private final NhanVienService nhanVienService;

    @Autowired
    public NhanVienController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @RequestMapping(value = "nhanvien/add", method = RequestMethod.POST)
    public NhanVien addNhanVien(@RequestBody NhanVien nhanVien) throws Exception {
        return nhanVienService.addNhanVien(nhanVien);
    }

//    @RequestMapping(value = "nhanvien/delete", method = RequestMethod.DELETE)
//    public void deleteNhanVien()

    //init data checkin nhan vien
    @RequestMapping(value = "initdata", method = RequestMethod.POST)
    public void initData() throws ParseException {
        nhanVienService.initDataCheckinNhanVien();
    }

    @RequestMapping(value = "nhanvien/checkin", method = RequestMethod.POST)
    public void checkInNhanVien(@RequestBody QRCodeDTO qrCodeDTO) throws Exception {
        nhanVienService.checkin(qrCodeDTO);
    }

    @RequestMapping(value = "nhanvien", method = RequestMethod.GET)
    public List<NhanVien> getAllNhanVien(){
        return nhanVienService.getAllNhanVien();
    }

    @RequestMapping(value = "checkIn/nhanvien/{id}", method = RequestMethod.GET)
    public List<CheckIn> getAllCheckInOfNhanVien(@PathVariable("id") int id){
        return nhanVienService.getAllCheckInOfNhanVien(id);
    }

    @RequestMapping(value = "checkIn/nhanvien/ngay/{ngay}", method = RequestMethod.GET)
    public List<CheckIn> getCheckInTheoNgay(@PathVariable("ngay") String ngay){
        return nhanVienService.getCheckInTheoNgay(ngay);
    }

    @RequestMapping(value = "deleteNhanVien/{id}", method = RequestMethod.DELETE)
    public void deleteNhanVien(@PathVariable("id") int id) throws Exception {
        nhanVienService.deleteNhanVien(id);
    }
}
