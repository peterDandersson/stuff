package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> peoples = Arrays.asList(new Person(Gender.WOMAN,"Lisa"),new Person(Gender.MAN,"Olle"),new Person(Gender.MAN,"Kalle"),new Person(Gender.WOMAN,"Anna"));
        Map<Gender,List<Person>> peoplesMap = new HashMap();

        Collections.sort(peoples,new SortByName());

        peoplesMap.put(Gender.WOMAN, peoples.stream().filter(p -> p.getGender() == Gender.WOMAN).collect(Collectors.toList()));
        peoplesMap.put(Gender.MAN, peoples.stream().filter(p -> p.getGender() == Gender.MAN).collect(Collectors.toList()));

        System.out.print(peoplesMap.toString());
    }

    public static class Person {
        private Gender gender;
        private String name;

        public Person(Gender gender, String name) {
            this.gender = gender;
            this.name = name;
        }

        public Gender getGender() {
            return gender;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum Gender{
        MAN,WOMAN, OTHER
    }

    static class SortByName implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
