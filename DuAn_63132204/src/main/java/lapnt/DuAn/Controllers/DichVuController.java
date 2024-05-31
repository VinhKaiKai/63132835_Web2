package lapnt.DuAn.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lapnt.DuAn.Models.DichVu;
import lapnt.DuAn.Services.DichVuService;

import java.util.List;

@Controller
public class DichVuController {

    @Autowired
    private DichVuService dichVuService;

    // Hiển thị danh sách dịch vụ
    @GetMapping("/dichvu")
    public String listDichVu(Model model) {
        List<DichVu> listDichVu = dichVuService.getAllDichVu();
        model.addAttribute("listDichVu", listDichVu);
        return "list_dichvu";
    }

    // Form thêm/sửa dịch vụ
    @PostMapping("/dichvu/save")
    public String saveDichVu(@ModelAttribute("dichVu") DichVu dichVu) {
        dichVuService.saveDichVu(dichVu);
        return "redirect:/dichvu";
    }

    // Form sửa dịch vụ
    @GetMapping("/dichvu/edit/{id}")
    public String editDichVuForm(@PathVariable("id") int id, Model model) {
        DichVu dichVu = dichVuService.getDichVuById(id);
        model.addAttribute("dichVu", dichVu);
        return "edit_dichvu";
    }

    // Xóa dịch vụ
    @GetMapping("/dichvu/delete/{id}")
    public String deleteDichVu(@PathVariable("id") int id) {
        dichVuService.deleteDichVu(id);
        return "redirect:/dichvu";
    }
    
    
}
