

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Person implements Comparable<Person> {
        int age;
        String name;
        int rank;
        public Person(int age, String name, int rank) {
            this.age = age;
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Person o) {
            if(this.age == o.age) return this.rank - o.rank;
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(br.readLine());
        List<Person> lst = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            Person person = new Person(Integer.parseInt(s[0]), s[1], i);
            lst.add(person);
        }

        Collections.sort(lst);
        for(Person p : lst) {
            System.out.println(p.age + " "  + p.name);
        }
    }


}

