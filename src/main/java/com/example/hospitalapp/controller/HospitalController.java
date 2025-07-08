package com.example.hospitalapp.controller;

import com.example.hospitalapp.pojo.Hospital;
import com.example.hospitalapp.service.HospitalService;
import com.example.hospitalapp.service.WifiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Configuration
public class HospitalController {

    //@Autowired(required = true)
    private  HospitalService hospitalService;


    @Autowired
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService=hospitalService;
    }

    public void setHospitalService(HospitalService hospitalService){
        this.hospitalService=hospitalService;
    }

    @Autowired
    private WifiProperties wifiProperties;






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

    @GetMapping("/testwifi")
    public  void testWifi(){
        Map<String,String> days=wifiProperties.getDays();
        System.out.println(days);
    }
    @GetMapping("/healthCheck")
    public  String testHealth(){
        return "Welcome to the setup";
    }


}
