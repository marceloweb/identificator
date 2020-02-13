package info.marceloweb.identificator.controller;

import info.marceloweb.identificator.exception.ResourceNotFoundException;
import info.marceloweb.identificator.model.Dna;
import info.marceloweb.identificator.repository.DnaRepository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class DefaultController {

  @Autowired
  private DnaRepository dnaRepository;

  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping("/stats")
  public Object getAllDna() {
	  Integer totalSpecies = dnaRepository.totalSpecies();
	  Integer totalSimian = dnaRepository.totalSimian();
	  
	  DecimalFormat decimal = new DecimalFormat("#.#");
	  
	  Integer countHuman = totalSpecies - totalSimian;
	  Double ratio = ((double)totalSimian * 100)/(double)countHuman;
	  
	  return "{\"count_simian_dna\":"+ totalSimian + 
			  ", \"count_human_dna\":"+ countHuman +
			  ", \"ratio\":" + decimal.format(ratio) +
			  "}";
  }

  /**
   * Save matrix of dna.
   *
   * @param matrix the matrix
   * @return the state
   */
  @PostMapping("/simian")
  public String createDna(@Valid @RequestBody String matrix) {
	  
    JSONObject all = new JSONObject(matrix);
    JSONArray bodyJson = all.getJSONArray("dna");
    Integer species = 1;
            
    String result = "{\"is_simian\":false}";

    Boolean findedLeft = Dna.leftDiagonalSearch(bodyJson);
    Boolean findedRight = Dna.rightDiagonalSearch(bodyJson);    
    Boolean findedHorizontal = Dna.horizontalSearch(bodyJson);
    Boolean findedVertical = Dna.verticalSearch(bodyJson);        
                  
    
    Integer simian = 0;
    if (findedVertical == true) { simian++; }  
    if (findedHorizontal == true) { simian++; } 
    if (findedLeft == true) { simian++; } 
    if (findedRight == true) { simian++; } 
    
    if (simian >= 2){
      species = 2;                                  
      result = "{\"is_simian\":true}";
    }

    Dna dna = new Dna();
    dna.setDna(matrix);
    dna.setSpecies(species);

    dnaRepository.save(dna);

    return result;
  }


}
