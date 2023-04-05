package com.example.song_info.service.impl;

import com.example.song_info.dto.SongDTO;
import com.example.song_info.model.Song;
import com.example.song_info.repository.ISongRepository;
import com.example.song_info.service.ISongService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService implements ISongService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<SongDTO> findAll() {
        List<Song> songList = songRepository.findAll();
        List<SongDTO> songDTOList = new ArrayList<>();
        SongDTO songDTO;
        for (Song song : songList) {
            songDTO = new SongDTO();
            BeanUtils.copyProperties(song, songDTO);
//            songDTO.setId(song.getId());
//            songDTO.setSongName(song.getSongName());
//            songDTO.setCategory(song.getCategory());
//            songDTO.setSinger(song.getSinger());
            songDTOList.add(songDTO);
        }
        return songDTOList;
//        return songList.stream().map(song -> mapper.map(song, SongDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void creatSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).get();
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }
}
