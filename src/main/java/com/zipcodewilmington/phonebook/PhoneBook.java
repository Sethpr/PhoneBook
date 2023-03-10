package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> s = new ArrayList<>();
        s.add(phoneNumber);
        this.phonebook.put(name, s);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(phoneNumbers));
        this.phonebook.put(name, numbers);
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        Iterator<Map.Entry<String, List<String>>> i = this.phonebook.entrySet().iterator(); //make phonebook iterator
        while(i.hasNext()){
            Map.Entry<String, List<String>> entry = i.next();//pull a specific entry
            if(entry.getValue().contains(phoneNumber)){//check if entry's value has phoneNumber
                return entry.getKey();
            }

            //i.next();
        }
        return null;
    }

    public List<String> getAllContactNames() {
        /*Iterator<Map.Entry<String, List<String>>> i = this.phonebook.entrySet().iterator(); //make phonebook iterator
        ArrayList<String> list = new ArrayList<>();
        while(i.hasNext()){
            Map.Entry<String, List<String>> entry = i.next();//pull a specific entry
            list.add(entry.getKey());
        }*/
        return new ArrayList<>(this.phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
