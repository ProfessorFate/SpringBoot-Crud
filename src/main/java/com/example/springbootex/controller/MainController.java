package com.example.springbootex.controller;
import com.example.springbootex.model.Contact;
import com.example.springbootex.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final ContactServiceImpl contactService;

    @Autowired
    public MainController(ContactServiceImpl contactServiceImpl) {
        this.contactService = contactServiceImpl;
    }

    @GetMapping("/contact")
    public String findAll(Model model) {
      model.addAttribute("contacts", contactService.list());
        return "contact";
    }

    @GetMapping("/newContact")
    public String createContact(Model model){
        Contact contact=new Contact();
        model.addAttribute("contact", contact);
        return "addContact";
    }

    @PostMapping("/newContact")
    public String addContact(@ModelAttribute("contact") Contact contact){
        contactService.save(contact);
        return "redirect:/contact";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,Model model){
        model.addAttribute("contact",contactService.get(id));
        return "editContact";
    }

    @PostMapping("/editContact")
    public String editContact(@ModelAttribute("contact")Contact contact){
        contactService.save(contact);
        return "redirect:/contact";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") int id){
        contactService.delete(id);
        return "redirect:/contact";
    }
}