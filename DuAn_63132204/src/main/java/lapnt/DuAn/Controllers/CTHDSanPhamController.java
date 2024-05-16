package lapnt.DuAn.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lapnt.DuAn.Models.CTHDSanPham;
import lapnt.DuAn.Services.CTHDSanPhamService;

import java.util.List;

@Controller
public class CTHDSanPhamController {

    @Autowired
    private CTHDSanPhamService cthdSanPhamService;

    // Hiển thị danh sách chi tiết hóa đơn sản phẩm
    @GetMapping("/cthdsanpham")
    public String listCTHDSanPham(Model model) {
        List<CTHDSanPham> listCTHDSanPham = cthdSanPhamService.getAllCTHDSanPham();
        model.addAttribute("listCTHDSanPham", listCTHDSanPham);
        return "list_cthdsanpham";
    }

    // Form thêm/sửa chi tiết hóa đơn sản phẩm
    @PostMapping("/cthdsanpham/save")
    public String saveCTHDSanPham(@ModelAttribute("cthdSanPham") CTHDSanPham cthdSanPham) {
        cthdSanPhamService.saveCTHDSanPham(cthdSanPham);
        return "redirect:/cthdsanpham";
    }

    // Form sửa chi tiết hóa đơn sản phẩm
    @GetMapping("/cthdsanpham/edit/{id}")
    public String editCTHDSanPhamForm(@PathVariable("id") int id, Model model) {
        CTHDSanPham cthdSanPham = cthdSanPhamService.getCTHDSanPhamById(id);
        model.addAttribute("cthdSanPham", cthdSanPham);
        return "edit_cthdsanpham";
    }

    // Xóa chi tiết hóa đơn sản phẩm
    @GetMapping("/cthdsanpham/delete/{id}")
    public String deleteCTHDSanPham(@PathVariable("id") int id) {
        cthdSanPhamService.deleteCTHDSanPham(id);
        return "redirect:/cthdsanpham";
    }
    
    
}
