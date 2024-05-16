package lapnt.DuAn.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lapnt.DuAn.Models.SanPham;
import lapnt.DuAn.Services.SanPhamService;
import java.util.List;

@Controller
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    // Hiển thị danh sách sản phẩm
    @GetMapping("/sanpham")
    public String listSanPham(Model model) {
        List<SanPham> listSanPham = sanPhamService.getAllSanPham();
        model.addAttribute("listSanPham", listSanPham);
        return "list_sanpham";
    }

    // Form thêm/sửa sản phẩm
    @PostMapping("/sanpham/save")
    public String saveSanPham(@ModelAttribute("sanPham") SanPham sanPham) {
        sanPhamService.saveSanPham(sanPham);
        return "redirect:/sanpham";
    }

    // Form sửa sản phẩm
    @GetMapping("/sanpham/edit/{id}")
    public String editSanPhamForm(@PathVariable("id") int id, Model model) {
        SanPham sanPham = sanPhamService.getSanPhamById(id);
        model.addAttribute("sanPham", sanPham);
        return "edit_sanpham";
    }

    // Xóa sản phẩm
    @GetMapping("/sanpham/delete/{id}")
    public String deleteSanPham(@PathVariable("id") int id) {
        sanPhamService.deleteSanPham(id);
        return "redirect:/sanpham";
    }
    
    
    
}

