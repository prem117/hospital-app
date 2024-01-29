package com.example.hospitalapp.controller;

import com.example.hospitalapp.pojo.Hospital;
import com.example.hospitalapp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HospitalController {

    public HospitalController() {
    }

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @Autowired(required = true)
    private HospitalService hospitalService;


    @GetMapping("/getOne/{id}")
    public @ResponseBody Optional<Hospital> getHospital(@PathVariable("id") int id) throws  Exception{

        return  hospitalService.getHospital(id);
    }
    @GetMapping("/getall")
    public  @ResponseBody List<Hospital> getAllHospitalls() throws Exception{

        return  hospitalService.getAllHospitalls();
    }
    @PostMapping("/saveHospital")
    public ResponseEntity<String> addHospital(@RequestBody Hospital hospital){
       Hospital hospital1= hospitalService.addHospital(hospital);
        if (!hospital1.equals(null)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/updateHospital")
    public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital){
       Hospital h1 =  hospitalService.updateHospital(hospital);
       if (!h1.equals(null)){
           return new ResponseEntity<>(HttpStatus.FOUND);
       }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteRecord/{id}")
    public ResponseEntity<String> deleteHospital(@PathVariable int id){
               Optional<Hospital>  hos=hospitalService.getHospital(id);
                if (!hos.equals(null)){
                    hospitalService.deleteHospital(id);
                    return new ResponseEntity<>(HttpStatus.ACCEPTED);
                }
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
