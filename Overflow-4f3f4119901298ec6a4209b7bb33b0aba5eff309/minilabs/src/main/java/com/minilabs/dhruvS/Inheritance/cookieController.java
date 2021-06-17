package com.minilabs.dhruvS.Inheritance;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class cookieController {

    @GetMapping("/dhruvSInheritance")
    public String mnmCookie(@RequestParam(name = "chocChipNum", required = true, defaultValue = "10") int chocChipNum,
                                        @RequestParam(name = "cookieDiameter", required = true, defaultValue = "6") int cookieDiameter, Model model){

        model.addAttribute("chocChipNum", chocChipNum);
        model.addAttribute("cookieDiameter", cookieDiameter);

        int ChocChipNum = chocChipNum;
        int CookieDiameter = cookieDiameter;

        Cookie.mnmCookie cookie = new Cookie.mnmCookie(ChocChipNum, CookieDiameter, 10);



        model.addAttribute("newMnMCount", cookie.toString());

        return "DhruvSMiniLab/dhruvSInheritance";
    }
}