package my_realisation_treemap;
/*
 * @author Bohdan Hnatusiv
 * 02.11.2020
 */

import java.util.*;
import java.util.function.Function;

public class MainRockStarTreeMap extends RockStarTreeMap {

    public MainRockStarTreeMap(Object key, Object value, Entry parent) {
        super(key, value, parent);
    }

    public static void main(String[] args) {
        //create objects of class RockStar
        RockStar davidCoverdale = new RockStar(1, "David", "Coverdale", 1951, 69);
        RockStar ozzyOsbourne = new RockStar(2, "Ozzy", "Osbourne", 1948, 72);
        RockStar robertPlant = new RockStar(3, "Robert", "Plant", 1948, 72);
        RockStar ianGillan = new RockStar(4, "Ian ", "Gillan", 1945, 75);
        RockStar davidGilmour = new RockStar(5, " David", "Gilmour", 1946, 74);
        RockStar freddieMercury = new RockStar(6, " Freddie", " Mercury", 1946, 45);
        RockStar paulMcCartney = new RockStar(7, "Paul McCartney", "McCartney", 1942, 78);


        // output hashcode of objects  and method equals()
        System.out.println("Hash code of object  davidCoverdale   is " + davidCoverdale.hashCode());
        System.out.println("Result of method equals() : " + ozzyOsbourne.equals(ozzyOsbourne));
        System.out.println("Result of method  equals() : " + ozzyOsbourne.equals(robertPlant));
        System.out.println("Hash code of object   ianGillan   is " + ianGillan.hashCode());
        System.out.println();


        //create collection rockStarMap(key: Integer)
        Map<Integer, RockStar> rockStarMap = new TreeMap<>();

        //use method put(Integer,RockStar)(key: id)
        rockStarMap.put(paulMcCartney.getId(), paulMcCartney);
        rockStarMap.put(freddieMercury.getId(), freddieMercury);
        rockStarMap.put(davidGilmour.getId(), davidGilmour);
        rockStarMap.put(ianGillan.id, ianGillan);
        rockStarMap.put(robertPlant.id, robertPlant);
        rockStarMap.put(ozzyOsbourne.getId(), ozzyOsbourne);
        rockStarMap.put(davidCoverdale.getId(), davidCoverdale);


        // use method .get(id)
        System.out.println("Object  at  id   " + 3 + " is " + rockStarMap.get(3));
        System.out.println("Object  at  id   " + 6 + " is " + rockStarMap.get(6));
        System.out.println("Object  at  id   " + 2 + " is " + rockStarMap.get(2));
        System.out.println("Object  at  id   " + 5 + " is " + rockStarMap.get(5));
        System.out.println();

        //use method for output all keys
        System.out.println(" All keys of map are  :    " + rockStarMap.keySet());
        System.out.println();
        //use method for output all values
        System.out.println(" All values of map are  :    " + rockStarMap.values());
        System.out.println();
        //use method for output all Nodes
        System.out.println("All nodes of map are  :   " + rockStarMap.entrySet());
        System.out.println();


        //use method containsKey for to determination of presence key
        System.out.println("Presence  key   " + 2 + " is    " + rockStarMap.containsKey(2));
        System.out.println("Presence  key   " + 7 + " is    " + rockStarMap.containsKey(7));
        System.out.println("Presence  key   " + 8 + " is    " + rockStarMap.containsKey(8));
        System.out.println();
        //use method containsValue for to determination of presence value
        System.out.println("Presence  value    davidCoverdale  is  " + rockStarMap.containsValue(davidCoverdale));
        System.out.println("Presence  value    paulMcCartney  is  " + rockStarMap.containsValue(paulMcCartney));
        System.out.println();

        //use method size for determination size of map
        System.out.println("Size of the map  = " + rockStarMap.size());
        System.out.println();
        // use method remove
        rockStarMap.remove(2, ozzyOsbourne);
        System.out.println("Size of the map  = " + rockStarMap.size());
        System.out.println("Presence  key   " + 2 + " is    " + rockStarMap.containsKey(2));
        System.out.println("Presence  value    ozzyOsbourne  is  " + rockStarMap.containsValue(ozzyOsbourne));
        System.out.println();

        //use method  for determination empty of map
        System.out.println("The  map  is empty  =  " + rockStarMap.isEmpty());
        System.out.println();

        // use method putIfAbsent (very useful method)
        System.out.println("Size of the map  = " + rockStarMap.size());
        rockStarMap.putIfAbsent(davidCoverdale.getId(), davidGilmour);//(very useful method)
        System.out.println("Size of the map  = " + rockStarMap.size());
        for (Map.Entry<Integer, RockStar> entry : rockStarMap.entrySet()) {
            System.out.println(entry);
        }
        rockStarMap.putIfAbsent(ozzyOsbourne.getId(), ozzyOsbourne);
        System.out.println("Size of the map  = " + rockStarMap.size());
        System.out.println("Scroll  all  nodes of the  map :");
        for (Map.Entry<Integer, RockStar> entry : rockStarMap.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();

        //use method .replace()
        System.out.println("After   3 methods     replace()");
        rockStarMap.replace(3, paulMcCartney);
        System.out.println("Size of the map  = " + rockStarMap.size());
        for (Map.Entry<Integer, RockStar> entry : rockStarMap.entrySet()) {
            System.out.println(entry);
        }
        rockStarMap.replace(2, robertPlant);
        System.out.println("Size of the map  = " + rockStarMap.size());
        for (Map.Entry<Integer, RockStar> entry : rockStarMap.entrySet()) {
            System.out.println(entry);
        }
        rockStarMap.replace(2, ozzyOsbourne);
        rockStarMap.replace(3, robertPlant);
        System.out.println("Size of the map  = " + rockStarMap.size());
        for (Map.Entry<Integer, RockStar> entry : rockStarMap.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();

        //use method getOrDefaultuse method getOrDefault
        System.out.println("After using the method getOrDefault");
        System.out.println("If key number 2 is empty then return the ianGillan" + rockStarMap.getOrDefault(2, ianGillan));
        System.out.println("If key number 8 is empty then return the ianGillan" + rockStarMap.getOrDefault(8, ianGillan));
        System.out.println("But the collection itself has not changed");
        System.out.println("Size of the map  = " + rockStarMap.size());
        for (Map.Entry<Integer, RockStar> entry : rockStarMap.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();

        //use of sorting in a similar way as a key
        System.out.println("Sort by age");
        Map<Integer, RockStar> integerRockStar = new TreeMap<>();
        integerRockStar.put(davidGilmour.getAge(), davidGilmour);
        integerRockStar.put(davidCoverdale.getAge(), davidCoverdale);
        integerRockStar.put(ozzyOsbourne.getAge(), ozzyOsbourne);
        integerRockStar.put(robertPlant.getAge(), robertPlant);
        integerRockStar.put(freddieMercury.getAge(), freddieMercury);
        integerRockStar.put(ianGillan.getAge(), ianGillan);
        integerRockStar.put(paulMcCartney.getAge(), paulMcCartney);

        for (Map.Entry<Integer, RockStar> entry : integerRockStar.entrySet()) {
            System.out.println(entry.getKey() + "  =  " + entry.getValue());
        }
        System.out.println();

        System.out.println("Sort by year Of birth ");
        Map<Integer, RockStar> yearOfBirth = new TreeMap<>();
        yearOfBirth.put(davidGilmour.getYearOfBirth(), davidGilmour);
        yearOfBirth.put(davidCoverdale.getYearOfBirth(), davidCoverdale);
        yearOfBirth.put(ozzyOsbourne.getYearOfBirth(), ozzyOsbourne);
        yearOfBirth.put(robertPlant.getYearOfBirth(), robertPlant);
        yearOfBirth.put(freddieMercury.getYearOfBirth(), freddieMercury);
        yearOfBirth.put(ianGillan.getYearOfBirth(), ianGillan);
        yearOfBirth.put(paulMcCartney.getYearOfBirth(), paulMcCartney);

        for (Map.Entry<Integer, RockStar> entry : yearOfBirth.entrySet()) {
            System.out.println(entry.getKey() + "  =  " + entry.getValue());
        }
        System.out.println();

        //create collection rockStarMap(key:String )
        Map<String, RockStar> rockStarRockStarMap = new TreeMap<>();


        //use method put(String,RockStar)
        System.out.println("Sort by Firstname");
        rockStarRockStarMap.put(davidGilmour.getFirstName(), davidGilmour);
        rockStarRockStarMap.put(ozzyOsbourne.getFirstName(), ozzyOsbourne);
        rockStarRockStarMap.put(robertPlant.getFirstName(), robertPlant);
        rockStarRockStarMap.put(paulMcCartney.getFirstName(), paulMcCartney);
        rockStarRockStarMap.put(davidCoverdale.getFirstName(), davidCoverdale);
        rockStarRockStarMap.put(freddieMercury.getFirstName(), freddieMercury);
        rockStarRockStarMap.put(ianGillan.getFirstName(), ianGillan);


        for (Map.Entry<String, RockStar> entry : rockStarRockStarMap.entrySet()) {
            System.out.println(entry.getKey() + " =  " + entry.getValue());
        }
        System.out.println();

        System.out.println("Sort by LastName");
        Map<String, RockStar> starMap = new TreeMap<>();

        starMap.put(paulMcCartney.getLastName(), paulMcCartney);
        starMap.put(freddieMercury.getLastName(), freddieMercury);
        starMap.put(davidGilmour.getLastName(), davidGilmour);
        starMap.put(ianGillan.getLastName(), ianGillan);
        starMap.put(robertPlant.getLastName(), robertPlant);
        starMap.put(ozzyOsbourne.getLastName(), ozzyOsbourne);
        starMap.put(davidCoverdale.getLastName(), davidCoverdale);


        for (Map.Entry<String, RockStar> entry : starMap.entrySet()) {
            System.out.println(entry.getKey() + " =  " + entry.getValue());
        }


    }


}
