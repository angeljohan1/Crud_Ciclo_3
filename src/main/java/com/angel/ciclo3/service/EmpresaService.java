package com.angel.ciclo3.service;

import com.angel.ciclo3.modelos.Empresa;
import com.angel.ciclo3.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // ---------------------------------------- retorna la lista de empresas
    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }
    // ---------------------------------------- retorna una empresa por Id
    public Empresa getEmpresaById(Integer id) {
        return empresaRepository.findById(id).get();
    }

    // ---------------------------------------- guarda o actualiza una empresa
    public boolean saveOrUpdateEmpresa(Empresa empresa) {
        Empresa emp = empresaRepository.save(empresa);
        if (empresaRepository.findById(emp.getId())!=null) {
            return true;
        }
        return false;
    }

    // ---------------------------------------- borra una empresa por id
    public boolean deleteEmpresa(Integer id){
        empresaRepository.deleteById(id);
        if (getEmpresaById(id)!=null) {
            return false;
        }
        return true;
    }

}
