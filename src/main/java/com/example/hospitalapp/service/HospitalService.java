package com.example.hospitalapp.service;

import com.example.hospitalapp.pojo.Hospital;
import com.example.hospitalapp.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {


    @Autowired(required = true)
    private HospitalRepository hospitalRepository;


    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalService() {
    }

    public Hospital addHospital(Hospital hospital){
       Hospital hospital1= hospitalRepository.save(hospital);
       return hospital1;
    }

    public Hospital updateHospital(Hospital hospital){
        Optional<Hospital> hospital1=hospitalRepository.findById(hospital.getId());
        if (hospital1.equals(null)){
            return  new Hospital();
        }
        return hospitalRepository.save(hospital);
    }
    public List<Hospital> getAllHospitalls(){
        return hospitalRepository.findAll();
    }
    public void deleteHospital(int id){
        hospitalRepository.deleteById(id);
    }
    public Optional<Hospital> getHospital(int id){
        return hospitalRepository.findById(id);
    }
}
