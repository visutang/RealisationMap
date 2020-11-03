package my_realisation_hashmap;
/*
 * author Bohdan Hnatusiv
 * 28.10.2020
 */
import java.util.Objects;

public class RockMusic {

    int id;
    String nameBand;
    String nameSong;

    public RockMusic(int id, String nameBand, String nameSong) {
        this.id = id;
        this.nameBand = nameBand;
        this.nameSong = nameSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBand() {
        return nameBand;
    }

    public void setNameBand(String nameBand) {
        this.nameBand = nameBand;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    @Override
    public String toString() {
        return "RockMusic{" +
                "id=" + id +
                ", nameBand : '" + nameBand + '\'' +
                ", nameSong :  '" + nameSong + '\'' +
                '}';
    }
   //create method .equals()
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RockMusic rockMusic = (RockMusic) object;
        return id == rockMusic.id &&
                Objects.equals(nameBand, rockMusic.nameBand) &&
                Objects.equals(nameSong, rockMusic.nameSong);
    }


     //create method hashCode()
     // @Override
    public int hashCode(Objects[] objects) {
        if (objects==null)
            return 0;
        int result=31;
          for (Objects element :objects)
              result = 31*result* (element == null? 0 : element.hashCode());
        return result;

    }

}
