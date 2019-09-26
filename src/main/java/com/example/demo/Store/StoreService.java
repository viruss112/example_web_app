package com.example.demo.Store;

import com.example.demo.Salaries.SalaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public StoreService( StoreRepository storeRepository, ModelMapper modelMapper) {
        this.storeRepository = storeRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public StoreDTO create(StoreDTO storeDTO) {
        Store store = new Store();
        modelMapper.map(storeDTO,store);
        Store savedStore = storeRepository.save(store);
        StoreDTO storeDTO1 = new StoreDTO();
        modelMapper.map(savedStore,storeDTO1);
        return storeDTO;
    }
}
