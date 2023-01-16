package pl.edu.ug.ckwella.kolokwium.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ScarfService {

    public void learning() {
        System.out.println("WORKING");
    }
}
