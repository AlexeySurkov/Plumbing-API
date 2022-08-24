package ru.company.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.company.data.SanitaryWareRepository;
import ru.company.entity.SanitaryWare;

@RestController
@RequestMapping(path="/sanitarywares", produces="application/json")
@CrossOrigin(origins="*")
public class SanitaryWareController {

  private SanitaryWareRepository repo;

  @Autowired
  public SanitaryWareController(SanitaryWareRepository repo) {
    this.repo = repo;
  }

  @GetMapping
  public Iterable<SanitaryWare> allSanitaryWares() {
    return repo.findAll();
  }
  
}
