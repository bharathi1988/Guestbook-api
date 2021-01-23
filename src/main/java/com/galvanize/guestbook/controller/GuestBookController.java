package com.galvanize.guestbook.controller;

import com.galvanize.guestbook.model.GuestBook;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("guestbooks")
public class GuestBookController {

    private List<GuestBook> guestBookList = new ArrayList<>();

    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public GuestBook addComments(@RequestBody GuestBook guestBook){
        guestBook.setId(UUID.randomUUID().toString());
        guestBookList.add(guestBook);
        return guestBook;
    }
}
