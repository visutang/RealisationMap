package my_realisation_hashmap;
/*
 * author Bohdan Hnatusiv
 * 28.10.2020
 */

import java.util.Map;
import java.util.function.BiConsumer;

public class MainRockMusicHashMap extends RockMusicHashMap {
    public static void main(String[] args) {
        //create object RockMusic
        RockMusic nightwish = new RockMusic(1, "Nightwish", "Bless The Child");
        RockMusic beatles = new RockMusic(2, "The Beatles", "Let it Be");
        RockMusic scorpions = new RockMusic(3, "Scorpions", "The Good Die Young");
        RockMusic deepPurple = new RockMusic(4, "Deep Purple", "Fireball");
        RockMusic evergrey = new RockMusic(5, "Evergrey", "In orbit");
        RockMusic rainbow = new RockMusic(6, "Rainbow", "All night long");
        RockMusic helloween = new RockMusic(7, " Helloween", "Forever and one");


        // output hashcode of objects  and method equals()
        System.out.println("Hash code of object  nightwish  is " + nightwish.hashCode());
        System.out.println("Result of method equals() : " + nightwish.equals(nightwish));
        System.out.println("Result of method  equals() : " + nightwish.equals(scorpions));
        System.out.println("Hash code of object  scorpions  is " + scorpions.hashCode());

        //create HashMap rockMusicHashMap
        Map<Integer, RockMusic> rockMusicHashMap = new RockMusicHashMap<>();

        //use method .put()
        rockMusicHashMap.put(nightwish.getId(), nightwish);
        rockMusicHashMap.put(evergrey.getId(), evergrey);
        rockMusicHashMap.put(scorpions.getId(), scorpions);
        rockMusicHashMap.put(rainbow.getId(), rainbow);
        rockMusicHashMap.put(beatles.getId(), beatles);
        rockMusicHashMap.put(deepPurple.getId(), deepPurple);

        // use method .get(id)
        System.out.println("Object  at  id   " + 3 + " is " + rockMusicHashMap.get(3));
        System.out.println("Object  at  id   " + 6 + " is " + rockMusicHashMap.get(6));
        System.out.println("Object  at  id   " + 2 + " is " + rockMusicHashMap.get(2));
        System.out.println("Object  at  id   " + 5 + " is " + rockMusicHashMap.get(5));

        //use method for output all keys
        System.out.println(" All keys of map are  :    " + rockMusicHashMap.keySet());
        //use method for output all values
        System.out.println(" All values of map are  :    " + rockMusicHashMap.values());
        //use method for output all Nodes
        System.out.println("All nodes of map are  :   " + rockMusicHashMap.entrySet());


        // use method foreach for iteration
        System.out.println(" Name all  bands  of the  map  :");
        for (RockMusic rockMusic : rockMusicHashMap.values()) {
            System.out.println(rockMusic.nameBand + " ;  ");
        }
        System.out.println();
        System.out.println(" Name all songs of the  map  :");
        for (RockMusic rockMusic : rockMusicHashMap.values()) {
            System.out.println(rockMusic.nameSong + " ;  ");
        }
        System.out.println();

        // use method foreach for iteration  of nodes
        System.out.println("Scroll  all  nodes of the  map :");
        for (Map.Entry<Integer, RockMusic> entry : rockMusicHashMap.entrySet()) {
            System.out.println(entry);
        }

        //or a little differently
        System.out.println("Scroll  all  nodes of the  map :");
        for (Map.Entry<Integer, RockMusic> entry : rockMusicHashMap.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }


        //use method containsKey for to determination of presence key
        System.out.println("Presence  key   " + 1 + " is    " + rockMusicHashMap.containsKey(2));
        System.out.println("Presence  key   " + 7 + " is    " + rockMusicHashMap.containsKey(7));


        //use method containsValue for to determination of presence value
        System.out.println("Presence  value    Evergrey  is  " + rockMusicHashMap.containsValue(evergrey));
        System.out.println("Presence  value    Helloween  is  " + rockMusicHashMap.containsValue(helloween));


        //use method size for determination size of map
        System.out.println("Size of the map  = " + rockMusicHashMap.size());


        //use method  for determination empty of map
        System.out.println("The  map  is empty  =  " + rockMusicHashMap.isEmpty());


        // use method putIfAbsent (very useful method)
        System.out.println("Size of the map  = " + rockMusicHashMap.size());
        rockMusicHashMap.putIfAbsent(evergrey.getId(), evergrey);//(very useful method)
        System.out.println("Size of the map  = " + rockMusicHashMap.size());
        rockMusicHashMap.putIfAbsent(helloween.getId(), helloween);
        System.out.println("Size of the map  = " + rockMusicHashMap.size());
        System.out.println("Scroll  all  nodes of the  map :");
        for (Map.Entry<Integer, RockMusic> entry : rockMusicHashMap.entrySet()) {
            System.out.println(entry);
        }
        //use method getOrDefault
        System.out.println("If key number 2 is empty then return the rainbow" + rockMusicHashMap.getOrDefault(2, rainbow));
        System.out.println("If key number 8 is empty then return the rainbow" + rockMusicHashMap.getOrDefault(8, rainbow));


        //use method remove
        System.out.println("Size of the map  = " + rockMusicHashMap.size());
        rockMusicHashMap.remove(3);
        System.out.println("Size of the map  = " + rockMusicHashMap.size());
        for (Entry<Integer, RockMusic> entry : rockMusicHashMap.entrySet()) {
            System.out.println(entry);
        }
        rockMusicHashMap.remove(4, deepPurple);
        System.out.println("Size of the map  = " + rockMusicHashMap.size());
        for (Entry<Integer, RockMusic> entry : rockMusicHashMap.entrySet()) {
            System.out.println(entry);
        }

        //use method .replace()
        rockMusicHashMap.replace(2, rainbow);
        System.out.println("Size of the map  = " + rockMusicHashMap.size());
        for (Entry<Integer, RockMusic> entry : rockMusicHashMap.entrySet()) {
            System.out.println(entry);
        }
        rockMusicHashMap.replace(2, beatles);
        System.out.println("Size of the map  = " + rockMusicHashMap.size());
        for (Entry<Integer, RockMusic> entry : rockMusicHashMap.entrySet()) {
            System.out.println(entry);
        }

    }
}

