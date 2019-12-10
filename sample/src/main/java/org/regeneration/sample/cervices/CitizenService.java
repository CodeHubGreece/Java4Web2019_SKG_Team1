package org.regeneration.sample.cervices;

import org.regeneration.sample.Entities.Citizen;
import org.regeneration.sample.reps.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

   private CitizenRepository citizenRepository;

    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public Citizen getById(int id) {

        return new Citizen();
    }

    public List<Citizen> findAll() {

       return citizenRepository.findAll();
   }

  public Citizen saveOneCit(Citizen citizen){

        citizenRepository.save(citizen);
        return  citizen;
  }

}
