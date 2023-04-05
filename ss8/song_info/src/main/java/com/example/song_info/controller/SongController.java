package com.example.song_info.controller;

import com.example.song_info.dto.SongDTO;
import com.example.song_info.model.Song;
import com.example.song_info.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("songList", songService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreationForm (Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "/create";
    }

    @PostMapping("/create")
    public String performCreate (@Valid @ModelAttribute(name = "songDTO") SongDTO songDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.creatSong(song);
        redirectAttributes.addFlashAttribute("msg", "msg.createSuccess");
        return "redirect:/song";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Integer id, Model model) {
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(songService.findById(id), songDTO);
        model.addAttribute("songDTO", songDTO);
        return "/edit";
    }

    @PostMapping("/edit")
    public String performEdit(@Valid @ModelAttribute(name = "songDTO") SongDTO songDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.updateSong(song);

        redirectAttributes.addFlashAttribute("message", "msg.editSuccess");
        return "redirect:/song";
    }
}
