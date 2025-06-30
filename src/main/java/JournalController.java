import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class JournalController {

    @Autowired
    private JournalEntryRepository repo;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("entries", repo.findAll());
        return "index";
    }

    @GetMapping("/entry/new")
    public String showForm(Model model) {
        model.addAttribute("entry", new JournalEntry());
        return "entry-form";
    }

    @PostMapping("/entry/save")
    public String saveEntry(@ModelAttribute JournalEntry entry) {
        entry.setDate(LocalDate.now());
        repo.save(entry);
        return "redirect:/";
    }
}
