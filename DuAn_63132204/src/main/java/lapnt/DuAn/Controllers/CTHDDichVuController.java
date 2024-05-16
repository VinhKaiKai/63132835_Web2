package lapnt.DuAn.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lapnt.DuAn.Models.CTHDDichVu;
import lapnt.DuAn.Services.CTHDDichVuService;

import java.util.List;

@Controller
public class CTHDDichVuController {

    @Autowired
    private CTHDDichVuService cthdDichVuService;

    // Hiển thị danh sách chi tiết hóa đơn dịch vụ
    @GetMapping("/cthddichvu")
    public String listCTHDDichVu(Model model) {
        List<CTHDDichVu> listCTHDDichVu = cthdDichVuService.getAllCTHDDichVu();
        model.addAttribute("listCTHDDichVu", listCTHDDichVu);
        return "list_cthddichvu";
    }

    // Form thêm/sửa chi tiết hóa đơn dịch vụ
    @PostMapping("/cthddichvu/save")
    public String saveCTHDDichVu(@ModelAttribute("cthdDichVu") CTHDDichVu cthdDichVu) {
        cthdDichVuService.saveCTHDDichVu(cthdDichVu);
        return "redirect:/cthddichvu";
    }

    // Form sửa chi tiết hóa đơn dịch vụ
    @GetMapping("/cthddichvu/edit/{id}")
    public String editCTHDDichVuForm(@PathVariable("id") int id, Model model) {
        CTHDDichVu cthdDichVu = cthdDichVuService.getCTHDDichVuById(id);
        model.addAttribute("cthdDichVu", cthdDichVu);
        return "edit_cthddichvu";
    }

    // Xóa chi tiết hóa đơn dịch vụ
    @GetMapping("/cthddichvu/delete/{id}")
    public String deleteCTHDDichVu(@PathVariable("id") int id) {
        cthdDichVuService.deleteCTHDDichVu(id);
        return "redirect:/cthddichvu";
    }
    
    
}
