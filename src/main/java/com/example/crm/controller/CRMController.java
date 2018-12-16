package com.example.crm.controller;

import com.example.crm.model.Contact;
import com.example.crm.model.Note;
import com.example.crm.model.UserInfo;
import com.example.crm.model.Utilities;
import com.example.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class CRMController {

    @Autowired
    IContactService contactService;

    @Autowired
    INoteService noteService;

    public String UserInfoCheck(String template) {
        String encrypted = Utilities.StringEncrypt("lEle");
        System.out.println("Krypteret "+encrypted);
        String decrypted = Utilities.StringDecrypt(encrypted);
        System.out.println("Dekrypteret "+decrypted);
        if (UserInfo.isLoggedIn) {
            return template;
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/")
    public String index(Model model) {
        System.out.println("I getmapping til /");
        if (UserInfo.isLoggedIn) {
            System.out.println("I getmapping til / + isLoggedId");

            model.addAttribute("contacts", contactService.fetchAllContacts());
            System.out.println("Efter servicekald til contactService.fetchAllContacts()");
            return UserInfoCheck("/crmforside");
        } else {
            model.addAttribute("loginError", UserInfo.loginError);
            return UserInfoCheck("/login");
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, String password, Model model) {
        System.out.println(username + " " + password);
        boolean login = UserInfo.checkLogin(username, password);
        if (login) {
            System.out.println("Login success");
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        UserInfo.logout();
        return "redirect:/";
    }

    @GetMapping("/custview/{custId}")
    public String custview(@PathVariable("custId") int custId, Model model) {
        model.addAttribute("customer", contactService.fetchOneContact(custId));
        model.addAttribute("numNotes", contactService.fetchOneContact(custId).getNotes().size());
        model.addAttribute("customFields", contactService.fetchOneContact(custId).getAllFields());
        return UserInfoCheck("/custsingleview");
    }

    @GetMapping("/editcust/{custId}")
    public String editCust(@PathVariable("custId") int custId, Model model) {
        model.addAttribute("customer", contactService.fetchOneContact(custId));
        model.addAttribute("customFields", contactService.fetchOneContact(custId).getAllFields());
        return UserInfoCheck("/editcontact");
    }

    @PostMapping("/editCust")
    public String editCust(@ModelAttribute Contact contact) {
        int CustomerId = 0;
        if (UserInfo.isLoggedIn) {
            CustomerId = contact.getId();
            contactService.updateContact(contact);
        }
        return "redirect:/custview/"+CustomerId;
    }

    @GetMapping("/deletecust/{custId}")
    public String deleteCust(@PathVariable("custId") int custId) {
        contactService.deleteContact(custId);
        return "redirect:/";
    }

    @GetMapping("/newnote/{custId}")
    public String newnote(@PathVariable("custId") int custId, Model model) {
        model.addAttribute("customer", contactService.fetchOneContact(custId));
        return UserInfoCheck("/newnote");
    }

    @PostMapping("/newnote/{id}")
    public String newnote(@PathVariable("id") int id, @ModelAttribute Note note, Model model) throws SQLException {
        if (UserInfo.isLoggedIn) {
            model.addAttribute(noteService.createNote(note));
        }
        return "redirect:/custview/" + id;
    }

    @GetMapping("/readnotes/{custId}")
    public String readnotes(@PathVariable("custId") int custId, Model model) {
        model.addAttribute("customer", contactService.fetchOneContact(custId));
        model.addAttribute("custNotes", contactService.fetchOneContact(custId).getNotes());
        return UserInfoCheck("/readnotes");
    }

    @GetMapping("/readnote/{id}")
    public String readnote(@PathVariable("id") int id, Model model) {
        model.addAttribute("note", noteService.readNote(id));
        model.addAttribute("customer", noteService.readNote(id).getOwner());
        return UserInfoCheck("/readnote");
    }

    @GetMapping("/editnote/{id}")
    public String editnote(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", noteService.readNote(id).getOwner());
        model.addAttribute("note", noteService.readNote(id));
        return UserInfoCheck("/editnote");
    }

    @PostMapping("/editnote/{id}")
    public String editnote_save(@PathVariable("id") int id, @ModelAttribute Note note, Model model) {
        int ownerID = 0;
        if (UserInfo.isLoggedIn) {
            ownerID = noteService.readNote(id).getOwner().getId();
            model.addAttribute(noteService.updateNote(note));
        }
        return "redirect:/readnotes/" + ownerID;
    }

    @GetMapping("/deletenote/{id}")
    public String deleteNote(@PathVariable("id") int id) {
        int CustomerId = 0;
        if (UserInfo.isLoggedIn) {
            CustomerId = noteService.readNote(id).getOwner().getId();
            noteService.deleteNote(id);
        }
        return "redirect:/readnotes/" + CustomerId;
    }

    @GetMapping("/newContact")
    public String createnew(Model model) {
        List<String> fieldsList = contactService.contactFields();
        fieldsList.remove("FirstName"); fieldsList.remove("LastName");
        model.addAttribute("fields", fieldsList);
        return UserInfoCheck("/newcontact");
    }

    @PostMapping("/newContact")
    public String createnew(@ModelAttribute Contact contact, Model model) {
        if (UserInfo.isLoggedIn) {
            model.addAttribute("contact", contact);
            contactService.createContact(contact);
            System.out.println("hej");
            System.out.println(contact.getFirstName() + " " + contact.getLastName());
        }
        return "redirect:/";
    }
}
