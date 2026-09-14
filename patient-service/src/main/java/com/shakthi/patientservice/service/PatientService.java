package com.shakthi.patientservice.service;

import com.shakthi.patientservice.dto.PatientRequestDTO;
import com.shakthi.patientservice.dto.PatientResponseDTO;
import com.shakthi.patientservice.mapper.PatientMapper;
import com.shakthi.patientservice.model.Patient;
import com.shakthi.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().
                map(PatientMapper::toDTO).toList();
    }
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(patient);
    }
}
