package com.example.library.service.Impl;

import com.example.library.dto.CreateReaderDto;
import com.example.library.dto.response.ReaderResponse;
import com.example.library.entity.Reader;
import com.example.library.exception.AlreadyExistsException;
import com.example.library.mapper.ReaderMapper;
import com.example.library.repository.ReaderRepository;
import com.example.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;
    private final ReaderMapper readerMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ReaderResponse createReader(CreateReaderDto createReaderDto) {

        if (readerRepository.existsByEmail(createReaderDto.getEmail())) {
            throw new AlreadyExistsException("Email already exists");
        }

        Reader reader = readerMapper.toEntity(createReaderDto);

        reader.setPassword(passwordEncoder.encode(createReaderDto.getPassword()));

        readerRepository.save(reader);

        return readerMapper.toResponse(reader);
    }

    @Override
    public List<ReaderResponse> getAllReaders() {
        return readerRepository.findAll()
                .stream()
                .map(readerMapper::toResponse)
                .toList();
    }
}
