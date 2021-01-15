package com.controller;

import com.entity.Book;
import com.entity.User;
import com.service.impl.BookServiceImpl;
import com.service.impl.UserServiceImpl;
import com.service.model.BookContext;
import com.service.model.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/frontend/user")
public class FrontEndUserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BookServiceImpl bookService;

//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    private String deleteBook(@RequestParam Long id,Model model){
//        bookService.deleteBook(id);
//        model.addAttribute("book",bookService.getAllBook());
//        return "/pages/thyme_books_list";
//    }

    //when push save button at list page
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getUserLoginPage( Model model){
        model.addAttribute("context",new UserContext());
        return "pages/thyme_user_login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String LoginUser(@ModelAttribute UserContext context,Model model){
        boolean loginState=userService.loginControl(context);
        if(loginState)
        {
            model.addAttribute("book",bookService.getAllBook());

            return "pages/thyme_books_list";
        }
      else
            return "pages/thyme_user_login";
    }

}
