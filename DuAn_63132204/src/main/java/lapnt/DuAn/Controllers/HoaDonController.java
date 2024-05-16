package lapnt.DuAn.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lapnt.DuAn.Models.DichVu;
import lapnt.DuAn.Models.HoaDon;
import lapnt.DuAn.Models.KhachHang;
import lapnt.DuAn.Models.NhanVien;
import lapnt.DuAn.Models.SanPham;
import lapnt.DuAn.Services.DichVuService;
import lapnt.DuAn.Services.HoaDonService;
import lapnt.DuAn.Services.KhachHangService;
import lapnt.DuAn.Services.NhanVienService;
import lapnt.DuAn.Services.SanPhamService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private DichVuService dichVuService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private NhanVienService nhanVienService;
//    @Autowired
//    private CTHDDichVuService cthdDichVuService;
//    @Autowired
//    private CTHDSanPhamService cthdSanPhamService;
    
 // Hiển thị danh sách hóa đơn
    @GetMapping("/hoadon")
    public String listHoaDon(Model model) {
        List<HoaDon> listHoaDon = hoaDonService.getAllHoaDon();
        model.addAttribute("listHoaDon", listHoaDon);
        return "list_hoadon";
    }

    // Form thêm/sửa hóa đơn
    @PostMapping("/hoadon/save")
    public String saveHoaDon(@ModelAttribute("hoaDon") HoaDon hoaDon) {
        hoaDonService.saveHoaDon(hoaDon);
        return "redirect:/hoadon";
    }

    // Form sửa hóa đơn
    @GetMapping("/hoadon/edit/{id}")
    public String editHoaDonForm(@PathVariable("id") int id, Model model) {
        HoaDon hoaDon = hoaDonService.getHoaDonById(id);
        model.addAttribute("hoaDon", hoaDon);
        return "edit_hoadon";
    }

    // Xóa hóa đơn
    @GetMapping("/hoadon/delete/{id}")
    public String deleteHoaDon(@PathVariable("id") int id) {
        hoaDonService.deleteHoaDon(id);
        return "redirect:/hoadon";
    }
    
	@GetMapping("/thongke")
    public String getInvoices(@RequestParam(name = "start-date", required = false)
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                              @RequestParam(name = "end-date", required = false)
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                              Model model) {
        List<HoaDon> hoadon;

        if (startDate != null && endDate != null) {
            hoadon = hoaDonService.getHoaDonByDateRange(startDate, endDate);
        } else {
            hoadon = hoaDonService.getAllHoaDon();
        }

        double tongTienHD=0;
        for (HoaDon hd : hoadon) {
        	tongTienHD = tongTienHD + hd.getTonghd();
        }
        int tongSLHD = hoaDonService.countTongHD(hoadon);

        model.addAttribute("hoaDons", hoadon);
        model.addAttribute("tongTien", tongTienHD);
        model.addAttribute("tongSL", tongSLHD);

        return "thongke";
    }
	
	public List<SanPham> lsSP = new ArrayList<SanPham>();
	public List<DichVu> lsDV =  new ArrayList<DichVu>();
	
	@GetMapping("/hoadonkhachhang")
	public String HoaDonKhachHang(Model model) {
		List<KhachHang> listKhachHang = khachHangService.getAllKhachHang();
		List<NhanVien> listNhanVien = nhanVienService.getAllNhanVien();
		
		model.addAttribute("listKhachHang", listKhachHang);
        model.addAttribute("listNhanVien", listNhanVien);
		model.addAttribute("lsSP",lsSP);
		model.addAttribute("lsDV",lsDV);
		
		return "hoadon";
	}
	
	
	@GetMapping("/hoadonSP/{id}")
    public String selectSanPham(@PathVariable("id") int id) {
    	lsSP.add(sanPhamService.getSanPhamById(id));
    	return "redirect:/sanpham";
    }

	@GetMapping("/hoadonDV/{id}")
    public String selectDichVu(@PathVariable("id") int id) {
    	lsDV.add(dichVuService.getDichVuById(id));
    	return "redirect:/dichvu";
    }

	
//	//chi tiết hóa đơn
//	@GetMapping("/cthd/{id}")
//    public String cthd(@PathVariable("id") int idhd, Model model) {
//		List<CTHDDichVu> cthdDichVuList = cthdDichVuService.findByHoaDonId(idhd);
//        model.addAttribute("cthdDichVuList", cthdDichVuList);
//        List<CTHDSanPham> cthdSanPhamList = cthdSanPhamService.findByHoaDonId(idhd);
//        model.addAttribute("cthdSanPhamList", cthdSanPhamList);
//    	return "cthd";
//    }
    
}

