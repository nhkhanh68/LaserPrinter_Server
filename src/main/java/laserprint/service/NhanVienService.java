package laserprint.service;

import laserprint.DTO.QRCodeDTO;
import laserprint.model.CheckIn;
import laserprint.model.NhanVien;
import laserprint.model.QRCode;
import laserprint.repository.CheckInRepository;
import laserprint.repository.NhanVienRepository;
import laserprint.repository.QRCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class NhanVienService {
    private final NhanVienRepository nhanVienRepository;
    private final CheckInRepository checkInRepository;
    private final QRCodeRepository qrCodeRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public NhanVienService(NhanVienRepository nhanVienRepository, CheckInRepository checkInRepository,
                           QRCodeRepository qrCodeRepository, SimpMessagingTemplate simpMessagingTemplate) {
        this.nhanVienRepository = nhanVienRepository;
        this.checkInRepository = checkInRepository;
        this.qrCodeRepository = qrCodeRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public NhanVien addNhanVien(NhanVien nhanVien) throws Exception {
        System.out.print(nhanVien);
        NhanVien nhanVien1 = nhanVienRepository.findByMaNhanVien(nhanVien.getMaNhanVien());
        if(nhanVien1 == null){
            NhanVien nhanVien2 = new NhanVien(nhanVien.getFullName(), nhanVien.getBirthday(), nhanVien.getPhoneNumber(),
                    nhanVien.getAddress(), nhanVien.getDesire(), nhanVien.getMaNhanVien());
            int i;
            nhanVienRepository.save(nhanVien2);
            for(i =4 ; i<=30; i++){
                CheckIn checkIn = new CheckIn(nhanVien2, String.valueOf(i)+ "-9", String.valueOf(i));
                checkInRepository.save(checkIn);
            }
            return nhanVien2;
        } else {
            throw new Exception("Mã nhan vien trùng");
        }

    }

    public void deleteNhanVien(int NhanVienId) throws Exception {
        NhanVien nhanVien = nhanVienRepository.findById(NhanVienId);
        if(nhanVien != null){
            checkInRepository.delete(nhanVien.getCheckIns());
            nhanVienRepository.delete(nhanVien);
        } else {
            throw new Exception("Không tìm thấy nhan vien");
        }
    }

    public void checkin(QRCodeDTO qrCodeDTO) throws Exception {
        if(qrCodeDTO.getQrData() != null && qrCodeDTO.getReaderId()!= null && qrCodeDTO.getReadTime() != null){
            QRCode qrCode = new QRCode(qrCodeDTO.getReaderId(), qrCodeDTO.getReadTime(), qrCodeDTO.getQrData());
            qrCodeRepository.save(qrCode);
            NhanVien nhanVien = nhanVienRepository.findByMaNhanVien(qrCode.getQrData());
            NhanVien nhanVien1 = new NhanVien();
            if(nhanVien == null){
//                nhanVien1.setFullName("Không tìm nhan vien viên");
                simpMessagingTemplate.convertAndSend("/user/nhanvien/**", "Không tìm nhan vien viên");
            } else {
                Calendar cal = Calendar.getInstance();
                int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
                String dayOfMonthStr = String.valueOf(dayOfMonth);
                CheckIn checkIn = checkInRepository.findByNhanVienIdAndNgay(nhanVien.getId(), dayOfMonthStr);
                if(checkIn.getCheckin() == null){
                    checkIn.setCheckin(qrCodeDTO.getReadTime());
                    checkInRepository.save(checkIn);
                    System.out.print("\n" + checkIn.getCheckin().getHours() + "\n");
                    if(checkIn.getCheckin().getHours() > 8){
                        checkIn.setStatus("Muộn");
                        checkInRepository.save(checkIn);
                    }
                    simpMessagingTemplate.convertAndSend("/user/nhanvien/**", "Cam on!");
                } else {
                    if(checkIn.getCheckout() == null){
                        checkIn.setCheckout(new Date());
                        checkInRepository.save(checkIn);
//                        checkIn.getCheckout().getHours();
//                        String[] part = String.valueOf(checkout).split(" ");
////                        System.out.print(part[3]);
//                        String[] time = part[3].split(":");
//                        if()
                        simpMessagingTemplate.convertAndSend("/user/nhanvien/**", "Chao tam biet!");
                    }
                }
            }
        } else {
            throw new Exception("Thiếu dữ liệu!");
        }
    }

    public List<NhanVien> getAllNhanVien(){
        return (List<NhanVien>) nhanVienRepository.findAll();
    }

    public List<CheckIn> getAllCheckInOfNhanVien(int id){
        return checkInRepository.findByNhanVienId(id);
    }

    public List<CheckIn> getCheckInTheoNgay(String ngay){
        return checkInRepository.findByNgay(ngay);
    }
}
