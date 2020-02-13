package info.marceloweb.identificator.model;

import org.json.JSONArray;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "dna")
@EntityListeners(AuditingEntityListener.class)
public class Dna {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "dna", nullable = false)
    private String dna;

    @Column(name = "species", nullable = false)
    private Integer species;

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
        return id;
    }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
        this.id = id;
    }

  /**
   * Gets dna.
   *
   * @return the dna
   */
  public String getDna() {
        return dna;
    }

  /**
   * Sets dna.
   *
   * @param dna the dna
   */
  public void setDna(String dna) {
        this.dna = dna;
    }
    
  /**
   * Gets species.
   *
   * @return the species
   */
  public Integer getSpecies() {
        return species;
    }

  /**
  * Sets species.
  *
  * @param species the species
  */
  public void setSpecies(Integer species) {
        this.species = species;
    }  
  
  /**
   * 
   * @param matrix
   * @return
   */
  public static Boolean leftDiagonalSearch(JSONArray matrix) {

	    JSONArray result = new JSONArray();
	    String dnas[][] = new String[6][6];

	    for (int i = 0; i < matrix.length(); i++) {
	      result = (JSONArray)matrix.get(i);
	      for (int x = 0; x < result.length(); x++) {
	        dnas[i][x] = result.get(x).toString();
	        if ((i > 2 && x > 1) && (dnas[i][x].equals(dnas[i-1][x-1]) 
	                                && dnas[i-1][x-1].equals(dnas[i-2][x-2])
	                                && dnas[i-2][x-2].equals(dnas[i-3][x-3]))) {
	                                  
	          return true;
	        }
	      }      
	    }	    		    

	    return false;
	  }

  /**
   * 
   * @param matrix
   * @return
   */
  public static Boolean rightDiagonalSearch(JSONArray matrix) {

    JSONArray result = new JSONArray();
    String dnas[][] = new String[6][6];

    for (int i = 0; i < matrix.length(); i++) {
      result = (JSONArray)matrix.get(i);
      for (int x = 0; x < result.length(); x++) {
        dnas[i][x] = result.get(x).toString();
        if (x+3 < result.length()) {

          if ((i > 2) && (dnas[i][x].equals(dnas[i-1][x+1]) 
                        && dnas[i-1][x+1].equals(dnas[i-2][x+2])
                        && dnas[i-2][x+2].equals(dnas[i-3][x+3]))) {
            return true;
          }

        }
      }
      
    }	    		    

    return false;    
  }

  /**
   * 
   * @param matrix
   * @return
   */
  public static Boolean horizontalSearch(JSONArray matrix) {

    JSONArray result = new JSONArray();
    String dnas[][] = new String[6][6];

    for (int i = 0; i < matrix.length(); i++) {
      result = (JSONArray)matrix.get(i);
      for (int x = 0; x < result.length(); x++) {
        dnas[i][x] = result.get(x).toString();
          if ((x > 2) && (dnas[i][x].equals(dnas[i][x-1]) 
                        && dnas[i][x].equals(dnas[i][x-2])
                        && dnas[i][x].equals(dnas[i][x-3]))) {
            return true;
          }
      }
      
    }	    		    

    return false;    
  }

  /**
   * 
   * @param matrix
   * @return
   */
  public static Boolean verticalSearch(JSONArray matrix) {

    JSONArray result = new JSONArray();
    String dnas[][] = new String[6][6];

    for (int i = 0; i < matrix.length(); i++) {
      result = (JSONArray)matrix.get(i);
      for (int x = 0; x < result.length(); x++) {
        dnas[i][x] = result.get(x).toString();
          if ((i > 2) && (dnas[i][x].equals(dnas[i-1][x]) 
                        && dnas[i][x].equals(dnas[i-2][x])
                        && dnas[i][x].equals(dnas[i-3][x]))) {
            return true;
          }
      }      
    }	    		    

    return false;    
  }

}
