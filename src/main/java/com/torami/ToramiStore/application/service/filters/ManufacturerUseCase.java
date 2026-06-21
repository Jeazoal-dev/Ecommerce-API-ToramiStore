package com.torami.ToramiStore.application.service;

import com.torami.ToramiStore.application.port.in.IManufacturerService;
import com.torami.ToramiStore.application.port.out.IManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ManufacturerUseCase implements IManufacturerService {
    private final IManufacturerRepository manufacturerRepository;
}
